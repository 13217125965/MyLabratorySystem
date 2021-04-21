package com.zhang.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
负责Sys的页面跳转
 */
@Controller
@RequestMapping("sys")
public class SysController {
    /**
     * 跳转系统的主页面
     */
    @RequestMapping("/toMain")
    public String toMain(){
        return "/pages/sys/main/main";
    }
    /**
     * 跳转菜单管理页面
     *
     * @return
     */
    @RequestMapping("toMenuManager")
    public String toMenuManager() {
        return "/pages/sys/menu/menuManager";
    }

    /**
     * 跳转右侧列表菜单
     *
     * @return
     */
    @RequestMapping("toRightMenu")
    public String toRightMenu() {
        return "/pages/sys/menu/rightMenu";
    }


    /**
     * 跳转左侧树状菜单
     *
     * @return
     */
    @RequestMapping("toLeftMenu")
    public String toLeftMenu() {
        return "/pages/sys/menu/leftMenu";
    }

    /**
     * 跳转到角色管理页面
     *
     * @return
     */
    @RequestMapping("toRoleManager")
    public String roleManager() {
        return "/pages/sys/role/roleManager";
    }

    /**
     * 跳转到角色管理页面
     *
     * @return
     */
    @RequestMapping("toUserManager")
    public String userManager() {
        return "/pages/sys/user/userManager";
    }

    /**
     * 跳转到日志管理模块
     *
     * @return
     */
    @RequestMapping("toLogInfoManager")
    public String toLogInfoManager() {
        return "/pages/sys/log/userLog";
    }

    /**
     * 跳转到系统公告界面
     *
     * @return
     */
    @RequestMapping("toNewsManager")
    public String toNewsManager() {
        return "/pages/sys/news/news";
    }
}
