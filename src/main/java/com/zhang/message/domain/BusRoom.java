package com.zhang.message.domain;

import java.io.Serializable;

/**
 * (BusRoom)实体类
 *
 * @author makejava
 * @since 2021-04-19 15:18:14
 */
public class BusRoom implements Serializable {
    private static final long serialVersionUID = -31080045944762755L;
    /**
     * 序号
     */
    private Integer roomid;

    private String roomnumber;
    /**
     * 实验室名称
     */
    private String roomname;
    /**
     * 实验室类型
     */
    private String roomtype;
    /**
     * 所属单位
     */
    private String department;
    /**
     * 实验室地址
     */
    private String roomaddress;
    /**
     * 是否使用  1:使用中。0：空闲
     */
    private Integer isusing;
    /**
     * 实验室预览图
     */
    private String roomimg;
    /**
     * 实验室描述
     */
    private String description;
    /**
     * 负责人姓名
     */
    private String admin;
    /**
     * 负责人联系方式
     */
    private String adminphone;


    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(String roomnumber) {
        this.roomnumber = roomnumber;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public String getRoomtype() {
        return roomtype;
    }

    public void setRoomtype(String roomtype) {
        this.roomtype = roomtype;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRoomaddress() {
        return roomaddress;
    }

    public void setRoomaddress(String roomaddress) {
        this.roomaddress = roomaddress;
    }

    public Integer getIsusing() {
        return isusing;
    }

    public void setIsusing(Integer isusing) {
        this.isusing = isusing;
    }

    public String getRoomimg() {
        return roomimg;
    }

    public void setRoomimg(String roomimg) {
        this.roomimg = roomimg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getAdminphone() {
        return adminphone;
    }

    public void setAdminphone(String adminphone) {
        this.adminphone = adminphone;
    }

}
