package com.zhang.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.bus.domain.BusRents;
import com.zhang.bus.mapper.BusRentsMapper;
import com.zhang.bus.service.BusRentsService;
import com.zhang.bus.vo.RentsVo;
import com.zhang.message.mapper.RoomMapper;
import com.zhang.message.vo.RoomVo;
import com.zhang.sys.vo.DataGripView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (BusRents)表服务实现类
 *
 * @author makejava
 * @since 2021-04-19 19:56:50
 */
@Service("busRentsService")
public class BusRentsServiceImpl implements BusRentsService {
    @Autowired
    private BusRentsMapper busRentsMapper;
    @Autowired
    private RoomMapper roomMapper;


    /**
     * 新增数据
     *
     * @param rentsVo 实例对象
     * @return 实例对象
     */
    @Override
    public void addRent(RentsVo rentsVo) {
        //修改实验室状态
        RoomVo roomVo = new RoomVo();
        roomVo.setIsusing(1);
        roomVo.setRoomnumber(rentsVo.getRoomnumber());
        roomMapper.update(roomVo);
        //设置 是否归还实验室
        rentsVo.setRentflag(0);
        //设置订单生成时间
        rentsVo.setBegintime(new Date());
        busRentsMapper.insert(rentsVo);
    }

    /**
     * 查询所有出租单 条件查询, 及分页功能
     * @param rentsVo
     * @return
     */
    @Override
    public DataGripView queryAllRent(RentsVo rentsVo) {
        Page<Object> page = PageHelper.startPage(rentsVo.getPage(),rentsVo.getLimit());
        List<BusRents> rents = busRentsMapper.queryAll(rentsVo);
        return new DataGripView(page.getTotal(),rents);
    }
    /**
     * 修改数据
     *
     * @param rentsVo 实例对象
     * @return 实例对象
     */
    @Override
    public void updateRent(RentsVo rentsVo) {
        busRentsMapper.update(rentsVo);
    }

    /**
     * 通过ID查询单条数据
     *
     * @param rentid 主键
     * @return 实例对象
     */
    @Override
    public BusRents queryById(String rentid) {
        return busRentsMapper.queryById(rentid);
    }

    /**
     * 通过主键删除数据
     *
     * @param rentid 主键
     * @return 是否成功
     */
    @Override
    public void deleteById(String rentid) {
        busRentsMapper.deleteById(rentid);
    }
}
