package com.zhang.sys.vo;

import com.zhang.sys.domain.SysLogLogin;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LogInfoVo extends SysLogLogin {
    private Integer page;
    private Integer limit;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;//结束时间

    private Integer[] ids;


}
