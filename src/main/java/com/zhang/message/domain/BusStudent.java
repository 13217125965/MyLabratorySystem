package com.zhang.message.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (BusStudent)实体类
 *
 * @author makejava
 * @since 2021-04-16 17:57:30
 */
public class BusStudent implements Serializable {
    private static final long serialVersionUID = 254007613840947563L;
    /**
     * 序号
     */
    private Integer stuid;
    /**
     * 学号
     */
    private String studentid;
    /**
     * 姓名
     */
    private String stuname;
    /**
     * 班级代号
     */
    private String stuclassid;
    /**
     * 1:男  0：女
     */
    private Integer stusex;
    /**
     * 院系
     */
    private String department;
    /**
     * 创建时间
     */
    private Date createtime;


    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuclassid() {
        return stuclassid;
    }

    public void setStuclassid(String stuclassid) {
        this.stuclassid = stuclassid;
    }

    public Integer getStusex() {
        return stusex;
    }

    public void setStusex(Integer stusex) {
        this.stusex = stusex;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

}
