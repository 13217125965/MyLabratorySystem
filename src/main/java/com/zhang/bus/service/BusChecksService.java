package com.zhang.bus.service;

import com.zhang.bus.domain.BusChecks;
import com.zhang.bus.vo.CRYVo;
import com.zhang.bus.vo.ChecksVo;
import com.zhang.sys.vo.DataGripView;

import java.util.List;

/**
 * (BusChecks)表服务接口
 *
 * @author makejava
 * @since 2021-04-19 19:56:33
 */
public interface BusChecksService {

    /**
     * 新增数据
     *
     * @param checksVo 实例对象
     * @return 实例对象
     */
    void addCheck(ChecksVo checksVo);

    /**
     * 查询封装 实验室信息   借出单信息   学生信息
     *   回显给页面
     * @param rentid
     * @return
     */
    CRYVo crydomain(String rentid);

    /**
     * 查询检查单数据
     * @param checksVo
     * @return
     */
    DataGripView queryCheck(ChecksVo checksVo);

    /**
     * 修改数据
     *
     * @param checksVo 实例对象
     * @return 实例对象
     */
    void  updateCheck(ChecksVo checksVo);


    /**
     * 通过主键删除数据
     *
     * @param checkid 主键
     * @return 是否成功
     */
    void deleteCheckById(String checkid);

    /**
     * 根据检查单单号批量删除检查单
     * @param checksVo
     */
    void deleteByBath(ChecksVo checksVo);
}
