package com.zhang.bus.domain;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (BusChecks)实体类
 *
 * @author makejava
 * @since 2021-04-19 19:49:06
 */
@Data
public class BusChecks implements Serializable {
    private static final long serialVersionUID = 932752961704635365L;
    /**
     * 检查单号
     */
    private String checkid;
    /**
     * 检查时间
     */
    private Date checkdate;
    /**
     * 检查描述
     */
    private String checkdesc;
    /**
     * 存在问题
     */
    private String checkproblem;
    /**
     * 操作者
     */
    private String admin;
    /**
     * 借出单号
     */
    private String rentid;
    /**
     * 创建时间
     */
    private String createtime;



}
