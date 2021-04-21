package com.zhang.bus.vo;

import com.zhang.bus.domain.BusChecks;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class ChecksVo extends BusChecks{
    private Integer page;

    private Integer limit;

    private String roomnumber;

    private String[] checkids;

    //开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date checkTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
