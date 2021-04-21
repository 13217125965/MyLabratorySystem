package com.zhang.sys.vo;

import com.zhang.sys.domain.SysNews;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class NewsVo extends SysNews {

    //当前页
    private Integer page;
    //每页显示条数
    private Integer limit;

    private Integer[] ids;

    //时间转换
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime; //开始时间

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
