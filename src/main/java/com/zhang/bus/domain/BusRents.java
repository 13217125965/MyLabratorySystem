package com.zhang.bus.domain;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * (BusRents)实体类
 *
 * @author makejava
 * @since 2021-04-19 19:48:37
 */
@Data
public class BusRents implements Serializable {
    private static final long serialVersionUID = 126206029553643840L;
    /**
     * 使用后生成
     */
    private String rentid;
    /**
     * 借出时间
     */
    private Date begintime;
    /**
     * 归还时间
     */
    private Date returntime;
    /**
     * 1:已归还。0：未归还
     */
    private Integer rentflag;
    /**
     * 学号
     */
    private String studentid;
    /**
     * 实验室编号
     */
    private String roomnumber;
    /**
     * 当前操作人
     */
    private String admin;

    /**
     * 创建时间
     */

    private Date createtime;
}
