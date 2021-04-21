package com.zhang.sys.controller;

import com.zhang.sys.constast.SysConstast;
import com.zhang.sys.domain.SysUser;
import com.zhang.sys.service.ILogInfoService;
import com.zhang.sys.service.IUserService;
import com.zhang.sys.utils.WebUtils;
import com.zhang.sys.vo.LogInfoVo;
import com.zhang.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/*
系统登录控制
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IUserService userService;
    @Autowired
    private ILogInfoService logInfoService;

    /**
     * 跳转到登录页面
     */

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "/pages/sys/main/login";
    }

    /**
     * 登录操作
     * @param vo
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(UserVo vo, Model model){
        SysUser user = userService.login(vo);
        if (vo != null){
//            登录信息不为空  并将值存入Session中
            WebUtils.getHttpSession().setAttribute("user",user);
//            将登录信息存入到登录日志中
            LogInfoVo logInfoVo = new LogInfoVo();
            logInfoVo.setLoginname(user.getUsername());
            logInfoVo.setLoginip(WebUtils.getHttpServletRequest().getRemoteAddr());
            logInfoService.addLogInfo(logInfoVo);
            return "/pages/sys/main/index";
        }else{
//            登录失败
            model.addAttribute("msg",SysConstast.USER_LOGIN_ERROR_MSG);
            return "/pages/sys/main/login";


        }
    }
    /*
    退出登录
     */
    @RequestMapping("/outLogin")
    public String outLogin(){
        WebUtils.getHttpSession().invalidate();
        return "/pages/sys/main/login";
    }
}
