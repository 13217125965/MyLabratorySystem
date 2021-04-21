package com.zhang.stat.controller;

import com.zhang.stat.domain.AddressSex;
import com.zhang.stat.domain.CharData;
import com.zhang.stat.service.StudentSexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("char")
public class StudentSexController {
    @Autowired
    private StudentSexService studentSexService;

    //饼图 地区男女性别
    @RequestMapping("addressSexCharData")
    public List<CharData> addressSexCharData(String address){
        System.out.println(address);
        List<AddressSex> list = studentSexService.selectAddressSex(address);
        List<CharData> data = new ArrayList<>();
        for (AddressSex addressSex : list) {
            if (addressSex.getStusex() == 1){
                data.add(new CharData(addressSex.getCount(),"男"));
            }else{
                data.add(new CharData(addressSex.getCount(),"女"));
            }
        }
        return data;
    }
}
