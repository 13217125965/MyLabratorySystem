package com.zhang.message.vo;

import com.zhang.message.domain.BusStudent;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Data
public class StudentVo extends BusStudent {

    private Integer page;

    private  Integer limit;

    private String[] studentids;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;
}
