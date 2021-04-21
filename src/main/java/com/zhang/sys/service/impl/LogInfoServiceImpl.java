package com.zhang.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.sys.domain.SysLogLogin;
import com.zhang.sys.mapper.LogInfoMapper;
import com.zhang.sys.service.ILogInfoService;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.LogInfoVo;
import com.zhang.sys.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service("logInfoService")
public class LogInfoServiceImpl implements ILogInfoService {
    @Autowired
    private LogInfoMapper logInfoMapper;

    /*
    添加一条日志信息
     */
    @Override
    public void addLogInfo(LogInfoVo vo) {
        logInfoMapper.insert(vo);
    }

    /**
     * 删除当前日志信息
     *
     * @param id
     */
    @Override
    public void deleteLogById(Integer id) {
        logInfoMapper.deleteLogById(id);
    }

    /**
     * 查询所有日志及搜索和分页功能
     *
     * @param vo
     * @return
     */
    @Override
    public DataGripView findAllLog(LogInfoVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
        List<SysLogLogin> logList = logInfoMapper.queryAll(vo);
        return new DataGripView(page.getTotal(), logList);
    }

}
