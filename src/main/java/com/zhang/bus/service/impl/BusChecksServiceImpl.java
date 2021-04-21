package com.zhang.bus.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.bus.domain.BusChecks;
import com.zhang.bus.domain.BusRents;
import com.zhang.bus.mapper.BusChecksMapper;
import com.zhang.bus.mapper.BusRentsMapper;
import com.zhang.bus.service.BusChecksService;
import com.zhang.bus.vo.CRYVo;
import com.zhang.bus.vo.ChecksVo;
import com.zhang.bus.vo.RentsVo;
import com.zhang.message.domain.BusRoom;
import com.zhang.message.domain.BusStudent;
import com.zhang.message.mapper.RoomMapper;
import com.zhang.message.mapper.StuMapper;
import com.zhang.message.vo.RoomVo;
import com.zhang.sys.vo.DataGripView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (BusChecks)表服务实现类
 *
 * @author makejava
 * @since 2021-04-19 19:56:34
 */
@Service("busChecksService")
public class BusChecksServiceImpl implements BusChecksService {
    @Autowired
    private BusChecksMapper busChecksMapper;
    @Autowired
    private BusRentsMapper busRentsMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private StuMapper stuMapper;

    /**
     * 添加检查单数据信息
     * @param checksVo
     */
    @Override
    public void addCheck(ChecksVo checksVo) {
        checksVo.setCreateTime(new Date());
        //修改实验室状态: 已归还 1
        RentsVo rentsVo = new RentsVo();
        rentsVo.setRentflag(1);  //定义归还状态
        rentsVo.setRentid(checksVo.getRentid()); //获取借出单单号
        busRentsMapper.update(rentsVo);//根据出租单单号修改归还状态
        //修改实验室的出租状态
        RoomVo roomVo = new RoomVo();
        roomVo.setIsusing(0);//设置汽车出租状态    0未出租
        roomVo.setRoomnumber(checksVo.getRoomnumber());//获取实验室编号
        roomMapper.update(roomVo);//根据实验室编号修改实验室使用状态
        //添加检查单信息
        busChecksMapper.insert(checksVo);
    }
    /**
     * 查询封装 车辆信息   出租单信息   客户信息
     *   回显给页面
     * @param rentid
     * @return
     */
    @Override
    public CRYVo crydomain(String rentid) {
        //获取出租单信息
        BusRents busRents = busRentsMapper.queryById(rentid);
//        查询汽车信息
        BusRoom busRoom = roomMapper.queryRoomByRoomNum(busRents.getRoomnumber());
//        查询客户信息
        BusStudent busStudent = stuMapper.queryByStudentId(busRents.getStudentid());
//        将三个对象数据封装到一个对象中
        CRYVo cryVo = new CRYVo(busStudent,busRents,busRoom);
        return cryVo;
    }

    /**
     * 查询检查单数据
     * @param checksVo
     * @return
     */
    @Override
    public DataGripView queryCheck(ChecksVo checksVo) {
        Page<Object> page = PageHelper.startPage(checksVo.getPage(),checksVo.getLimit());
        List<BusChecks> busChecks = busChecksMapper.queryAll(checksVo);
        return new DataGripView(page.getTotal(),busChecks);
    }

    /**
     * 修改数据
     *
     * @param checksVo 实例对象
     * @return 实例对象
     */
    @Override
    public void updateCheck(ChecksVo checksVo) {
        busChecksMapper.update(checksVo);

    }

    /**
     * 通过主键删除数据
     *
     * @param checkid 主键
     * @return 是否成功
     */
    @Override
    public void deleteCheckById(String checkid) {
        busChecksMapper.deleteById(checkid);
    }

    /**
     * 根据检查单单号批量删除检查单
     * @param checksVo
     */
    @Override
    public void deleteByBath(ChecksVo checksVo) {
        String[] checkids = checksVo.getCheckids();
        for (String checkid : checkids) {
            busChecksMapper.deleteById(checkid);
        }
    }
}
