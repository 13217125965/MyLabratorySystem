package com.zhang.stat.service;

import com.zhang.stat.domain.AddressSex;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentSexService {
    /**
     * 查询不同地区顾客男女比例
     * @return
     */
    List<AddressSex> selectAddressSex(String address);

}
