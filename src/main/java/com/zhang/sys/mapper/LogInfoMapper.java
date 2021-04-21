package com.zhang.sys.mapper;

import com.zhang.sys.domain.SysLogLogin;
import com.zhang.sys.vo.LogInfoVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据库访问层
 */
@Repository("logInfoMapper")
public interface LogInfoMapper {
    /*
    添加日志
     */
    void insert(LogInfoVo vo);

    /**
     * 查询所有日志及分页搜索功能
     *
     * @param vo
     * @return
     */
    List<SysLogLogin> queryAll(LogInfoVo vo);

    /**
     * 删除当前日志信息
     *
     * @param id
     */
    void deleteLogById(Integer id);
}
