package com.ft.backend.work.client.common;

import java.io.Serializable;

/**
 * Created by huanghongyi on 2016/11/8.
 */
public class PageCondition implements Serializable{

    private static final long serialVersionUID = 1L;
    /**
     * 当前页序号，从1开始
     */
    private Integer pageIndex = 1;
    /**
     * 每页结果数量
     */
    private Integer pageSize = 10;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 计算mysql中的偏移量
     */
    public int getOffset() {
        return (pageIndex - 1) * pageSize;
    }
}
