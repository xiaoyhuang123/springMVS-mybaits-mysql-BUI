package com.ft.backend.work.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ft.backend.work.client.QueryCondition.WorkshopQueryCondition;
import com.ft.backend.work.client.common.ReturnResult;
import com.ft.backend.work.client.service.WorkshopService;
import com.ft.backend.work.client.vo.WorkshopVo;

import com.ft.backend.work.common.JsonValueProcessorImplTest;
import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.convert.TypeConverters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by huanghongyi on 2016/11/8.
 */
@Controller
@RequestMapping("/workshop")
public class WorkshopController {

    private Logger logger = LogManager.getLogger(WorkshopController.class);

    @Autowired
    private WorkshopService workshopService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public JSONObject listWorkshop(HttpServletRequest request){

        List<WorkshopVo> result=null;
        int pageIndex=1;
        int pageSize=10;

        String currentPage=request.getParameter("pageIndex");
        String limit = request.getParameter("limit");
        String pageSizeStr = request.getParameter("pageSize");

        if(null!=currentPage && null !=limit && ""!=currentPage && ""!=limit){
            pageIndex= Integer.parseInt(currentPage)+1;
            pageSize = Integer.parseInt(limit);
        }

        JSONObject jsonFromBean=null;

        try {
            String workshopName=null;
            if(request.getParameter("workshopName")!=null) {
                 workshopName = new String(
                        request.getParameter("workshopName").trim().getBytes("iso-8859-1"),
                        "utf-8");
            }

            WorkshopQueryCondition condition=new WorkshopQueryCondition();
            condition.setPageIndex(pageIndex);
            condition.setPageSize(pageSize);
            condition.setWorkshopName(workshopName);

            result=workshopService.selectByCondition1(condition);

            int totals=workshopService.countByCondition(condition);

            Map<String,Object> t=new HashedMap();
            t.put("rows",result);
            t.put("results",totals);

            //注册date类型的转化方式
            JsonConfig jsonConfig = new JsonConfig();
            jsonConfig.registerJsonValueProcessor(java.util.Date.class, new JsonValueProcessorImplTest());

            jsonFromBean = JSONObject.fromObject(t,jsonConfig);
        }catch (Exception e){

        }
        return jsonFromBean;
    }


    @RequestMapping(value = "/delete",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public JSONObject delete(HttpServletRequest request,HttpServletResponse response){
        ReturnResult<Boolean> result=null;

        String[] idList=request.getParameterValues("ids");
        List<Long> ids=new ArrayList<>();
        for(String item:idList){
            Long id=Long.parseLong(item);
            ids.add(id);
            workshopService.deleteById(id);
        }
        JSONObject outData = new JSONObject();
        outData.put("successed","true");

        return outData;
    }


    @RequestMapping(value = "/detail",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ReturnResult<WorkshopVo> workshopDetail(HttpServletRequest request,HttpServletResponse response){
        ReturnResult<WorkshopVo> result=null;

        String item=request.getParameter("id");

        Long id=Long.parseLong(item);

       result = workshopService.selectById(id);
        return result;
    }


    @RequestMapping(value = "/update",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public ReturnResult<Boolean> workshopUpdate(HttpServletRequest request,HttpServletResponse response) {
        ReturnResult<Boolean> result=null;
        try {
            String id_str=request.getParameter("id");

            String wname = new String(
                    request.getParameter("workshopName").getBytes("iso-8859-1"),
                    "utf-8");
            String winterduction=new String(
                    request.getParameter("bfIntroduction").getBytes("iso-8859-1"),
                    "utf-8");
            String wcomment=new String(
                    request.getParameter("remarks").getBytes("iso-8859-1"),
                    "utf-8");

            WorkshopVo workshopVo = new WorkshopVo();

            workshopVo.setWorkshopName(wname);
            workshopVo.setWorkshopBriefIntroduction(winterduction);
            workshopVo.setWorkshopRemarks(wcomment);
            if(null!=id_str && ""!=id_str){
                Long id=Long.parseLong(id_str);
                workshopVo.setId(id);
                workshopService.update(workshopVo);
            }
            else{
                workshopService.add(workshopVo);
            }
            result = ReturnResult.getNewSuccessedInstance(true);
        }
        catch (Exception e) {
            result = ReturnResult.getNewFailedInstance();
        }
        return result;
    }
}
