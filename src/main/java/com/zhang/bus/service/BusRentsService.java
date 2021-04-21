package com.zhang.bus.service;

import com.zhang.bus.domain.BusRents;
import com.zhang.bus.vo.RentsVo;
import com.zhang.sys.vo.DataGripView;

import java.util.List;

/**
 * (BusRents)表服务接口
 *
 * @author makejava
 * @since 2021-04-19 19:56:50
 */
public interface BusRentsService {

    /**
     * 新增数据
     *
     * @param rentsVo 实例对象
     * @return 实例对象
     */
    void addRent(RentsVo rentsVo);

    /**
     * 查询所有借出单 条件查询, 及分页功能
     * @param rentsVo
     * @return
     */
    DataGripView queryAllRent(RentsVo rentsVo);

    /**
     * 修改数据
     *
     * @param rentsVo 实例对象
     * @return 实例对象
     */
    void updateRent(RentsVo rentsVo);

    /**
     * 通过ID查询单条数据
     *
     * @param rentid 主键
     * @return 实例对象
     */
    BusRents queryById(String rentid);

    /**
     * 通过主键删除数据
     *
     * @param rentid 主键
     * @return 是否成功
     */
    void deleteById(String rentid);

}
