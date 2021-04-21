package com.zhang.sys.service;

import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.LogInfoVo;
import com.zhang.sys.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 日志服务接口
 */
@Repository
@RequestMapping("sysLogInfo")
public interface ILogInfoService {

    /**
     * 添加日志信息
     */
    void addLogInfo(LogInfoVo vo);

    /**
     * 删除当前日志信息
     *
     * @param id
     */
    void deleteLogById(Integer id);

    /**
     * 查询所有日志 及分页 和 搜索功能
     *
     * @param vo
     * @return
     */
    DataGripView findAllLog(LogInfoVo vo);
}
