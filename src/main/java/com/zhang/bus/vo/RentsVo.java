package com.zhang.bus.vo;

import com.zhang.bus.domain.BusRents;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class RentsVo extends BusRents{
    private Integer page;

    private Integer limit;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date begintime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date returntime;
}
