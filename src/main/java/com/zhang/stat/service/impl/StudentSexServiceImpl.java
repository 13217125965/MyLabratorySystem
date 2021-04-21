package com.zhang.stat.service.impl;

import com.zhang.stat.domain.AddressSex;
import com.zhang.stat.mapper.StudentSexMapper;
import com.zhang.stat.service.StudentSexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("studentSexService")
public class StudentSexServiceImpl implements StudentSexService {

    @Autowired
    private StudentSexMapper studentSexMapper;


    @Override
    public List<AddressSex> selectAddressSex(String address) {
        return studentSexMapper.selectAddressSex(address);
    }
}
