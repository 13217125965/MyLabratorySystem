package com.zhang.sys.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysNews)实体类
 *
 * @author makejava
 * @since 2021-04-15 14:19:17
 */
public class SysNews implements Serializable {
    private static final long serialVersionUID = 543123696131439545L;

    private Integer id;

    private String title;

    private String content;

    private Date createtime;

    private String opername;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getOpername() {
        return opername;
    }

    public void setOpername(String opername) {
        this.opername = opername;
    }

}
