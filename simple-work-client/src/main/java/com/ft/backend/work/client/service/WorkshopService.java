package com.ft.backend.work.client.service;

import com.ft.backend.work.client.QueryCondition.WorkshopQueryCondition;
import com.ft.backend.work.client.common.ReturnResult;
import com.ft.backend.work.client.vo.WorkshopVo;

import java.util.List;

/**
 * Created by huanghongyi on 2016/11/8.
 */
public interface WorkshopService {

    ReturnResult<WorkshopVo> add(WorkshopVo workshopVo);

    ReturnResult<Boolean> deleteById(Long id);

    ReturnResult<Boolean> update(WorkshopVo workshopVo);

    ReturnResult<WorkshopVo> selectById(Long id);

    ReturnResult<List<WorkshopVo>> selectByCondition(WorkshopQueryCondition condition);

    List<WorkshopVo> selectByCondition1(WorkshopQueryCondition condition);

    int countByCondition(WorkshopQueryCondition condition);
}
