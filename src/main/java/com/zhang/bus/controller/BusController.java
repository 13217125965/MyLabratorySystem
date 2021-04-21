package com.zhang.bus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 业务层跳转
 */
@Controller
@RequestMapping("bus")
public class BusController {
    /**
     * 跳转到实验室借出页面
     *
     * @return
     */
    @RequestMapping("toRentRoomManager")
    public String toRentRoomManager() {
        return "/pages/bus/rent/renRoomManager";
    }

    /**
     * 跳转到借出单单管理页面
     */
    @RequestMapping("toRentManager")
    public String toRentManager() {
        return "/pages/bus/rent/rentManager";
    }

    /**
     * 跳转到实验室归还页面
     *
     */
    @RequestMapping("toCheckRoomManager")
    public String toCheckRoomManager(){
        return "/pages/bus/check/checkRoomManager";
    }

    /**
     * 跳转到检查单管理页面
     *
     */
    @RequestMapping("toCheckManager")
    public String toCheckManager(){
        return "/pages/bus/check/checkManager";
    }
}
