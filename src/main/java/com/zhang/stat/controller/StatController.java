package com.zhang.stat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("stat")
public class StatController {

    //学生地区统计
    @RequestMapping("toStudentAreaStat")
    public String toCustomerAreaStat() {
        return "/pages/stat/studentAreaStat";
    }

    //学生性别统计
    @RequestMapping("toStudentSexStat")
    public String toCustomerAreaSexStat() {
        return "/pages/stat/studentAndSex/studentSexStat";
    }

    //管理员性别分布
    @RequestMapping("toOpernameYearGradeStat")
    public String toOpernameYearGradeStat() {
        return "/pages/stat/amdinYearGradeStat";
    }


    //系统实验室所在院系
    @RequestMapping("toCompanyYearGradeStat")
    public String toCompanyYearGradeStat() {
        return "/pages/stat/companyYearGradeStat";
    }

}
