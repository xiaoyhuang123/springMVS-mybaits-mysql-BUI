package com.ft.backend.work.client.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huanghongyi on 2016/11/8.
 */
public class WorkshopVo implements Serializable{

    private Long id;

    private String workshopName;

    private String workshopBriefIntroduction;

    private String workshopRemarks;

    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkshopName() {
        return workshopName;
    }

    public void setWorkshopName(String workshopName) {
        this.workshopName = workshopName;
    }

    public String getWorkshopBriefIntroduction() {
        return workshopBriefIntroduction;
    }

    public void setWorkshopBriefIntroduction(String workshopBriefIntroduction) {
        this.workshopBriefIntroduction = workshopBriefIntroduction;
    }

    public String getWorkshopRemarks() {
        return workshopRemarks;
    }

    public void setWorkshopRemarks(String workshopRemarks) {
        this.workshopRemarks = workshopRemarks;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "WorkshopVo{" +
                "id=" + id +
                ", workshopName='" + workshopName + '\'' +
                ", workshopBriefIntroduction='" + workshopBriefIntroduction + '\'' +
                ", workshopRemarks='" + workshopRemarks + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
