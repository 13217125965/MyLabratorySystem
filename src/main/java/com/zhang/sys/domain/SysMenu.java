package com.zhang.sys.domain;

import java.io.Serializable;

/**
 * (SysMenu)实体类
 *
 * @author makejava
 * @since 2021-04-15 14:19:18
 */
public class SysMenu implements Serializable {
    private static final long serialVersionUID = -11956516278151746L;

    private Integer id;

    private Integer pid;

    private String title;

    private String href;
    /**
     * 0不展开1展开
     */
    private Integer spread;

    private String target;

    private String icon;
    /**
     * 0不可用1可用
     */
    private Integer available;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getSpread() {
        return spread;
    }

    public void setSpread(Integer spread) {
        this.spread = spread;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

}
