package com.ft.backend.work.client.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huanghongyi on 2016/12/3.
 */
public class UserVo implements Serializable{

    public static final Integer STATUS_NORMAL=1;
    public static final Integer STATUS_FORBIDD=2;
    public static final Integer STATUS_DELETED=3;


    /**
     * 自增编号
     */
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户状态 1：正常  2：禁用   3：已删除
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}
