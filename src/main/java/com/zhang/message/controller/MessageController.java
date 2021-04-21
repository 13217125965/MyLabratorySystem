package com.zhang.message.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 信息页面跳转控制
 */
@Controller
@RequestMapping("mess")
public class MessageController {


    /**
     * 跳转到学生管理界面
     * @return
     */
    @RequestMapping("toStuManager")
    public String toStuManager(){
        return "/pages/message/student/StudentManager";
    }


    /**
     * 跳转到实验室管理界面
     * @return
     */
    @RequestMapping("toRoomManager")
    public String toRoomManager(){
        return "/pages/message/room/RoomManager";
    }


}
