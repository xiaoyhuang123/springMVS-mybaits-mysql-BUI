package com.ft.work.web.test;

import com.ft.backend.work.client.QueryCondition.WorkshopQueryCondition;
import com.ft.backend.work.client.common.ReturnResult;
import com.ft.backend.work.client.service.WorkshopService;
import com.ft.backend.work.client.vo.WorkshopVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;

import java.util.List;


/**
 * Created by huanghongyi on 2016/11/8.
 */
public class WorkshopServiceTest extends BaseTest{

    private Logger logger= LogManager.getLogger(WorkshopServiceTest.class);

    @Autowired
    private WorkshopService workshopService;

    @Test
    public void add(){

        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
        WorkshopVo workshopVo=new WorkshopVo();
        workshopVo.setWorkshopName("云平台事业部");
        workshopVo.setWorkshopBriefIntroduction("简介");
        workshopVo.setWorkshopRemarks("reamrks");

        ReturnResult<WorkshopVo> result=workshopService.add(workshopVo);

        stopWatch.stop();
        logger.info("return result={}",result);
        System.out.println("-------------stopWatch:"+stopWatch.prettyPrint());
    }

    @Test
    public void delete(){
        Long id=2L;
        ReturnResult<Boolean> result=null;
        result=workshopService.deleteById(id);
        logger.info("result=",result);
    }

    @Test
    public void selectById(){
       Long id=2L;
        ReturnResult<WorkshopVo> result=null;
        result=workshopService.selectById(id);

        logger.info("result=",result);
    }

    @Test
    public void selectByCondition(){
        WorkshopQueryCondition condition=new WorkshopQueryCondition();
        condition.setWorkshopName("部");

        ReturnResult<List<WorkshopVo>> result=null;
        result=workshopService.selectByCondition(condition);

        logger.info("result=",result);
    }


    @Test
    public void encode(){
        String str="[{\"gw_mac\":\"40:a5:ef:51:34:ac\",\"cpu\":\"2\",\"memory\":\"76\",\"wanip\":\"172.29.255.29\",\"upflow\":\"432441\",\"downflow\":\"19387610\",\"wan_down_drop\":\"18231\",\"netsta\":\"total:5/fail:0/max:7/min:5/avg:6\"}]";

        System.out.println("-----------------------------------------------------");
        char[] keyData = "11223344556677889900aabbccddeeff1f2c3de5".toCharArray(); // 密钥
        char[] charArray = str.toCharArray();
        int bit=0;

        System.out.println("-------"+charArray.length);
        System.out.println("-------"+keyData.length);

        for(int i = 0; i < charArray.length; i++){
            if (bit >= keyData.length){
                bit = 0;
            }
            charArray[i] = (char) (charArray[i] ^ keyData[bit++]);
            System.out.print((int)charArray[i]+"-");
        }

         bit=0;
        for(int i = 0; i < charArray.length; i++){
            if (bit >= keyData.length){
                bit = 0;
            }
            charArray[i] = (char) (charArray[i] ^ keyData[bit++]);
            System.out.print(charArray[i]+"-");
        }


        System.out.println("-----------------------------------------------------");

    }



}
