package com.zhang.stat.mapper;

import com.zhang.stat.domain.AddressSex;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentSexMapper{
    /**
     * 查询不同地区顾客男女比例
     * @return
     */
    List<AddressSex> selectAddressSex(String address);
}
