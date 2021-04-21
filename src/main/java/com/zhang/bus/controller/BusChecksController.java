package com.zhang.bus.controller;

import com.zhang.bus.domain.BusChecks;
import com.zhang.bus.service.BusChecksService;
import com.zhang.bus.vo.CRYVo;
import com.zhang.bus.vo.ChecksVo;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.ResultObject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BusChecks)表控制层
 *
 * @author makejava
 * @since 2021-04-19 19:52:26
 */
@RestController
@RequestMapping("busChecks")
public class BusChecksController {
    /**
     * 服务对象
     */
    @Resource
    private BusChecksService busChecksService;

    /**
     * 查询检查单数据
     * @param checksVo
     * @return
     */
    @GetMapping("queryCheck")
    public DataGripView queryCheck(ChecksVo checksVo){
        return busChecksService.queryCheck(checksVo);
    }

    /**
     * 查询封装 实验室信息   借出单信息   学生信息
     *   回显给页面
     * @param rentid
     * @return
     */
    @GetMapping("crydomain")
    public CRYVo crydomain(String rentid){
        return busChecksService.crydomain(rentid);
    }


    /**
     * 添加检查单数据
     * @param checksVo
     * @return
     */
    @PostMapping("addCheck")
    public ResultObject addCheck(ChecksVo checksVo){
        try {
            busChecksService.addCheck(checksVo);
            return ResultObject.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.ADD_ERROR;
        }
    }

    /**
     * 修改检查单的数据
     * @param checksVo
     * @return
     */
    @PostMapping("updateCheck")
    public ResultObject updateCheck(ChecksVo checksVo){
        try {
            busChecksService.updateCheck(checksVo);
            return ResultObject.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.UPDATE_ERROR;
        }
    }

    /**
     * 根据检查单单号删除检查单
     * @param checkid
     */
    @PostMapping("deleteCheckById")
    public ResultObject deleteCheckById(String checkid){
        try {
            busChecksService.deleteCheckById(checkid);
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 根据检查单单号批量删除检查单
     * @param checksVo
     */
    @PostMapping("deleteByBatch")
    public ResultObject deleteByBath(ChecksVo checksVo){
        try {
            busChecksService.deleteByBath(checksVo);
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

}
