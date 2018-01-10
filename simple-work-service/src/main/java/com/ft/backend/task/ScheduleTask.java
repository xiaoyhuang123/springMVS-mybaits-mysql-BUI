package com.ft.backend.task;

import com.taobao.pamirs.schedule.IScheduleTaskDealSingle;
import com.taobao.pamirs.schedule.TaskItemDefine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;

/**
 * Created by huanghongyi on 2017/6/24.
 */
//@Component("scheduleTask")
@Scope("prototype")
public class ScheduleTask implements IScheduleTaskDealSingle<TaskItemDefine> {
    private static Logger logger = LogManager.getLogger(ScheduleTask.class);

    @Override
    public boolean execute(TaskItemDefine taskItemDefine, String s) throws Exception {

        logger.info("selectTasks - start, taskItemDefine:{}, s:{}", taskItemDefine, s);
        return false;
    }

    @Override
    public List<TaskItemDefine> selectTasks(String s, String s1, int i, List<TaskItemDefine> list, int i1) throws Exception {


        logger.info("selectTasks - start, s:{}, i:{}, list:{}, i1:{}", s,s1,i,list, i1);
        return null;
    }

    @Override
    public Comparator<TaskItemDefine> getComparator() {

        return null;
    }
}
