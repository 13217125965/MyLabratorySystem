package com.zhang.sys.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysLogLogin)实体类
 *
 * @author makejava
 * @since 2021-04-14 21:12:19
 */

public class SysLogLogin implements Serializable {
    private static final long serialVersionUID = -28405401506473163L;

    private Integer id;

    private String loginname;

    private String loginip;

    private Date logintime;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

}