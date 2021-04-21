package com.zhang.sys.controller;

import com.zhang.sys.service.ILogInfoService;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.LogInfoVo;
import com.zhang.sys.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 日志管理控制层
 *
 * @author makejava
 * @since 2020-08-24 15:23:50
 */
@RestController
@RequestMapping("sysLogInfo")
public class LogInfoController {
    /**
     * 服务对象
     */
    @Autowired
    private ILogInfoService logInfoService;


    /**
     * 查询所有日志及分页功能
     *
     * @param vo
     * @return
     */
    @RequestMapping("loadLogList")
    public DataGripView findAllLog(LogInfoVo vo) {
        return logInfoService.findAllLog(vo);
    }

    /**
     * 删除当前日志信息
     *
     * @param id
     * @return
     */
    @PostMapping("deleteLogById")
    public ResultObject deleteLogById(Integer id) {
        try {
            logInfoService.deleteLogById(id);
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 批量删除日志信息
     *
     * @param vo
     * @return
     */
    @PostMapping("deleteLogBatch")
    public ResultObject deleteLogBatch(LogInfoVo vo) {
        try {
            for (Integer id : vo.getIds()) {
                logInfoService.deleteLogById(id);
            }
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

}