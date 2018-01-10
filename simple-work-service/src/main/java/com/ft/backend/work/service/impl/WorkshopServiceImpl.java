package com.ft.backend.work.service.impl;

import com.ft.backend.work.client.QueryCondition.WorkshopQueryCondition;
import com.ft.backend.work.client.common.ReturnResult;
import com.ft.backend.work.client.service.WorkshopService;
import com.ft.backend.work.client.vo.WorkshopVo;
import com.ft.backend.work.dao.WorkshopMapper;
import com.ft.backend.work.model.Workshop;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huanghongyi on 2016/11/8.
 */
@Service("workshopService")
public class WorkshopServiceImpl implements WorkshopService{

    private Logger logger=LogManager.getLogger(WorkshopServiceImpl.class);

    @Autowired
    private WorkshopMapper workshopMapper;

    @Override
    public ReturnResult<WorkshopVo> add(WorkshopVo workshopVo) {

        logger.info("add workshop begin, workshopVo={}",workshopVo);

        ReturnResult<WorkshopVo> result=null;
        try {
            Workshop workshop=new Workshop();
            BeanUtils.copyProperties(workshopVo,workshop);

            workshopMapper.insert(workshop);
            workshopVo.setId(workshop.getId());

            result = ReturnResult.getNewSuccessedInstance(workshopVo);
        }
        catch (Exception e){
            logger.info("add workshop by id error ",e);
            result = ReturnResult.getNewFailedInstance();
        }

        logger.info("add workshop end, result={}",result);
        return result;
    }

    @Override
    public ReturnResult<Boolean> deleteById(Long id) {
        logger.info("delete workshop  by id begin, id={}",id);
        ReturnResult<Boolean> result=null;
        try {
            workshopMapper.deleteById(id);
            result = ReturnResult.getNewSuccessedInstance(true);
        }
        catch (Exception e){
            logger.info("delete workshop by id error ",e);
            result = ReturnResult.getNewFailedInstance();
        }

        logger.info("delete workshop by id end, result={}",result);
        return result;
    }

    @Override
    public ReturnResult<Boolean> update(WorkshopVo workshopVo) {
        logger.info("update workshop begin, workshopVo={}",workshopVo);
        ReturnResult<Boolean> result=null;
        try {
            Workshop workshop=new Workshop();
            BeanUtils.copyProperties(workshopVo,workshop);
            workshopMapper.updateWorkshop(workshop);
            result = ReturnResult.getNewSuccessedInstance(true);
        }
        catch (Exception e){
            logger.info("update workshop by id error ",e);
            result = ReturnResult.getNewFailedInstance();
        }

        logger.info("update workshop end, result={}",result);
        return result;
    }

    @Override
    public ReturnResult<WorkshopVo> selectById(Long id) {
        logger.info("select workshop by id begin, id={}",id);
        ReturnResult<WorkshopVo> result=null;
        try {
            Workshop workshop=workshopMapper.selectById(id);
            WorkshopVo workshopVo=new WorkshopVo();
            BeanUtils.copyProperties(workshop,workshopVo);
            result = ReturnResult.getNewSuccessedInstance(workshopVo);
        }
        catch (Exception e){
            logger.info("select workshop by id error ",e);
            result = ReturnResult.getNewFailedInstance();
        }
        logger.info("select workshop end, result={}",result);
        return result;
    }

    @Override
    public ReturnResult<List<WorkshopVo>> selectByCondition(WorkshopQueryCondition condition) {

        logger.info("selectByCondition workshop begin, condition={}",condition);
        ReturnResult<List<WorkshopVo>> result=null;

        try {
            List<WorkshopVo> workshopVoList=new ArrayList<>();

            List<Workshop> workshopList=workshopMapper.selectByCondition(condition);
            for(Workshop workshop: workshopList){
                WorkshopVo workshopVo=new WorkshopVo();
                BeanUtils.copyProperties(workshop,workshopVo);
                workshopVoList.add(workshopVo);
            }
            result = ReturnResult.getNewSuccessedInstance(workshopVoList);
        }
        catch (Exception e){
            logger.info("selectByCondition workshop error ",e);
            result = ReturnResult.getNewFailedInstance();
        }
        logger.info("selectByCondition workshop end, result={}",result);
        return result;
    }

    @Override
    public List<WorkshopVo> selectByCondition1(WorkshopQueryCondition condition) {

        logger.info("selectByCondition workshop begin, condition={}",condition);
        List<WorkshopVo> result=new ArrayList<>();

        try {
            List<WorkshopVo> workshopVoList=new ArrayList<>();

            List<Workshop> workshopList=workshopMapper.selectByCondition(condition);
            for(Workshop workshop: workshopList){
                WorkshopVo workshopVo=new WorkshopVo();
                BeanUtils.copyProperties(workshop,workshopVo);
                workshopVoList.add(workshopVo);
            }
            result = workshopVoList;
        }
        catch (Exception e){
            logger.info("selectByCondition1 workshop error ",e);
        }
        logger.info("selectByCondition1 workshop end, result={}",result);
        return result;
    }

    @Override
    public int countByCondition(WorkshopQueryCondition condition) {
        int n=0;
        n=workshopMapper.countByCondition(condition);
        return n;
    }
}
