package com.ft.backend.work.dao;

import com.ft.backend.work.client.QueryCondition.WorkshopQueryCondition;
import com.ft.backend.work.model.Workshop;

import java.util.List;

/**
 * Created by huanghongyi on 2016/11/8.
 */
public interface WorkshopMapper {

    Long insert(Workshop workshop);

    Long deleteById(Long id);

    int updateWorkshop(Workshop workshop);

    Workshop selectById(Long id);

    List<Workshop> selectByCondition(WorkshopQueryCondition condition);

    int countByCondition(WorkshopQueryCondition condition);
}
