package com.ft.backend.task;

import com.taobao.pamirs.schedule.strategy.ScheduleStrategy;
import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import com.taobao.pamirs.schedule.taskmanager.ScheduleTaskType;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;


/**
 * Created by huanghongyi on 2017/6/24.
 */
//@Component("scheduleManage")
public class ScheduleManage {

    private static Logger logger = LogManager.getLogger(ScheduleManage.class);
    private static final long HEART_BEAT_INTERVAL = 5000;
    private static final long HEART_JUDGE_DEAD_INTERVAL = 30000;
    private static final int FETCH_DATA_NUMBER = 500;
    private static final int MAX_THREAD_NUMBER_OF_TASK = 10;
    private static final int ASSIGN_NUM = 10;

    @Resource
    private TBScheduleManagerFactory scheduleManagerFactory;

    @Value(value = "${prop.zookeeper.rootPath}")
    private String rootPath;


    @PostConstruct
    public void init() {
        try {
            initSingleScheduleByRule("accountingrule");
        }
        catch (Exception e){
            logger.error("init - error:{}", e);
        }
    }

    private void initSingleScheduleByRule(String rule) throws Exception  {


        initSingleSchedulePath();

        initScheduleTaskType(rule);
        initScheduleStrategy(rule);

    }

    private void initSingleSchedulePath()
    {

        try {

            ZooKeeper zk = scheduleManagerFactory.getZkManager().getZooKeeper();
            if(zk==null){
                return;
            }

            List<String> s=new ArrayList<String>();

            String path=rootPath+"/strategy";
            if(zk.exists(path,false) !=null) {
                s = zk.getChildren(path, false);
                for (String child : s) {

                    doDeletePathNode(path + "/" + child);
                }
            }

            path=rootPath+"/schedule/strategy";
            if(zk.exists(path,false) !=null) {
                s = zk.getChildren(path, false);
                for (String child : s) {
                    doDeletePathNode(path + "/" + child);
                }
            }

            path=rootPath+"/baseTaskType";
            if(zk.exists(path,false) !=null) {
                s = zk.getChildren(path, false);
                for (String child : s) {
                    doDeletePathNode(path + "/" + child);
                }
            }

            path=rootPath+"/schedule/baseTaskType";
            if(zk.exists(path,false) !=null) {
                s = zk.getChildren(path, false);
                for (String child : s) {
                    doDeletePathNode(path + "/" + child);
                }
            }

            Thread.sleep(10000);
        }
        catch (Exception e){
            logger.error("initSingleSchedulePath - error:{}", e);
        }
        logger.error("initSingleSchedulePath - end.");
    }


    private void initScheduleTaskType(String accountingRule){

        logger.info("initScheduleTaskType - begin, accountingRule:{}", accountingRule);

        String taskTypeName = getTaskTypeName(accountingRule);
        String ruleJson = accountingRule;
        String permitRunStartTime =getAccountingRegularTimeCronFromAccountingRule(accountingRule);

        logger.info("--------------------time:"+permitRunStartTime);

        ScheduleTaskType taskType = new ScheduleTaskType();
        taskType.setBaseTaskType(taskTypeName);
        taskType.setDealBeanName("scheduleTask");
        taskType.setHeartBeatRate(HEART_BEAT_INTERVAL);
        taskType.setJudgeDeadInterval(HEART_JUDGE_DEAD_INTERVAL);
        taskType.setTaskParameter(ruleJson);
        taskType.setTaskItems(ScheduleTaskType.splitTaskItem(
                "0:{\"mod\":10,\"quotient\":0},"
                        + "1:{\"mod\":10,\"quotient\":1},"
                        + "2:{\"mod\":10,\"quotient\":2},"
                        + "3:{\"mod\":10,\"quotient\":3},"
                        + "4:{\"mod\":10,\"quotient\":4},"
                        + "5:{\"mod\":10,\"quotient\":5},"
                        + "6:{\"mod\":10,\"quotient\":6},"
                        + "7:{\"mod\":10,\"quotient\":7},"
                        + "8:{\"mod\":10,\"quotient\":8},"
                        + "9:{\"mod\":10,\"quotient\":9}"
        ));
        taskType.setFetchDataNumber(FETCH_DATA_NUMBER);
        taskType.setThreadNumber(MAX_THREAD_NUMBER_OF_TASK);
        taskType.setPermitRunStartTime(permitRunStartTime);
        //taskType.setProcessorType("NOTSLEEP");
        //taskType.setProcessorType("SLEEP");

        logger.info("");
        try {
            try {
                scheduleManagerFactory.getScheduleDataManager().deleteTaskType(taskTypeName);
                //Thread.sleep(5000);
            } catch(KeeperException.NoNodeException e){
                logger.info("ignore noNodeException!");
            } catch (Exception e) {
                logger.error("initScheduleTaskType - error:{}", e);
                throw new RuntimeException("initScheduleTaskType - error, taskTypeName:" +taskTypeName);
            }

            //scheduleManagerFactory.getScheduleDataManager().deleteTaskType(taskTypeName);
            scheduleManagerFactory.getScheduleDataManager().createBaseTaskType(taskType);

        } catch (Exception e) {

            logger.error("initScheduleTaskType - error:{}", e);
            throw new RuntimeException("initScheduleTaskType - error, taskTypeName:" + taskTypeName);
        }

        logger.info("initScheduleTaskType - end");
    }

    private void initScheduleStrategy(String accountingRule){
        logger.info("initScheduleStrategy - begin, accountingRule:{}"+accountingRule);

        String strategyName = getScheduleStrategyName(accountingRule);
        String taskTypeName = getTaskTypeName(accountingRule);
        String ruleJson = accountingRule;

        ScheduleStrategy strategy = new ScheduleStrategy();
        strategy.setStrategyName(strategyName);
        strategy.setKind(ScheduleStrategy.Kind.Schedule);
        strategy.setTaskName(taskTypeName);
        strategy.setTaskParameter(ruleJson);
        strategy.setNumOfSingleServer(2);
        strategy.setAssignNum(ASSIGN_NUM);
        strategy.setIPList("127.0.0.1".split(","));// 127.0.0.1 means all nodes is TaskNodes


        try {
            strategy.setIPList(null);// 127.0.0.1 means all nodes is TaskNodes
            scheduleManagerFactory.getScheduleStrategyManager().updateScheduleStrategy(strategy);
            //Thread.sleep(5000);
            scheduleManagerFactory.getScheduleStrategyManager().deleteMachineStrategy(strategyName, false);
            //Thread.sleep(5000);

        } catch(KeeperException.NoNodeException e){
            logger.info("ignore noNodeException!");
        } catch (Exception e) {
            logger.error("initScheduleStrategy - error:{}", e);
            throw new RuntimeException("initScheduleStrategy - error, taskTypeName:" + taskTypeName);
        }


        try {
            strategy.setIPList("127.0.0.1".split(","));
            scheduleManagerFactory.getScheduleStrategyManager().createScheduleStrategy(strategy);
           // Thread.sleep(5000);

        } catch (Exception e) {
            logger.error("initScheduleStrategy - error:{}", e);
            throw new RuntimeException("initScheduleStrategy - error, taskTypeName:" + taskTypeName);
        }

        logger.info("initScheduleStrategy - end");
    }

    private String getTaskTypeName(String rule){

        StringBuffer sb = new StringBuffer();

        int site = 0;
        int targetType=1;
        String pin = "hhy";
        String appCode = "jcloud";
        String serviceCode = "vm";
        int outAccountType=1;

        sb.append("accountingrule").append("-");
        sb.append(1).append("-");
        sb.append(site).append("-");
        sb.append(targetType).append("-");
        if(!StringUtils.isBlank(pin)){
            sb.append(pin).append("-");
        }
        if(!StringUtils.isBlank(serviceCode)){
            sb.append(appCode).append("-").append(serviceCode).append("-");
        }
        sb.append(outAccountType);
        return sb.toString();
    }

    private String getScheduleStrategyName(String rule){
        return getTaskTypeName(rule).concat("-Strategy");
    }

    private String getAccountingRegularTimeCronFromAccountingRule(String rule){
        if(rule!=null){
            StringBuilder sb=new StringBuilder();
            sb.append("0 ").append(20).append(" ")
                    .append(15).append(" ").
                    append(24).append(" ")
                    .append("* ?");
            //return sb.toString();
            return "0 * * * * ?";
        }
        return null;

    }


    private void doDeletePathNode( String path){
        logger.info("------------------doDeletePathNode -start, path:{}"+path);
        try {
            ZooKeeper zk = scheduleManagerFactory.getZkManager().getZooKeeper();

            while(true){
                if(zk.exists(path,false)==null){
                    break;
                }

                Queue<String> pathQueue=new LinkedList<String>();
                pathQueue.offer(path);
                while (pathQueue.size()>0){
                    String tempPath=pathQueue.poll();

                    if(zk.exists(path,false)==null){
                        break;
                    }

                    List<String> childrens= zk.getChildren(tempPath,false);
                    if(childrens.size()==0){
                        logger.info("$$$$$$$$$$$$$$$$$$$$$$$$$$$:{}",tempPath);

                        zk.setData(tempPath,null,1);
                        zk.delete(tempPath,-1);
                    }
                    else{
                        for(String item: childrens){
                            pathQueue.offer(tempPath+"/"+item);
                        }
                    }
                }
            }
        }
        catch (Exception e){

        }
    }


}
