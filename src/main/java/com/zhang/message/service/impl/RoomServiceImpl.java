package com.zhang.message.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.message.domain.BusRoom;
import com.zhang.message.mapper.RoomMapper;
import com.zhang.message.service.IRoomService;
import com.zhang.message.vo.RoomVo;
import com.zhang.sys.vo.DataGripView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 实验室表实现层
 */
@Service("roomService")
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public DataGripView queryAll(RoomVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
        List<RoomVo> busRoom = roomMapper.queryAll(vo);
        return new DataGripView(page.getTotal(),busRoom);
    }

    @Override
    public DataGripView queryByType(RoomVo vo) {
        vo.setIsusing(0);
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
        List<RoomVo> roomVoList = roomMapper.queryByType(vo);
        return new DataGripView(page.getTotal(),roomVoList);
    }

    @Override
    public BusRoom queryRoomByRoomNum(String roomNumber) {
        return roomMapper.queryRoomByRoomNum(roomNumber);
    }

    @Override
    public void update(RoomVo vo) {
        roomMapper.update(vo);
    }

    @Override
    public void delete(String roomNumber) {
        roomMapper.delete(roomNumber);
    }

    @Override
    public void addRoom(RoomVo vo) {
        vo.setIsusing(0);
        roomMapper.insert(vo);
    }

    @Override
    public void deleteRoomBatch(RoomVo vo) {
        String[] roomNumbers = vo.getRoomnumbers();
        for (String roomNumber : roomNumbers) {
            roomMapper.delete(roomNumber);
        }
    }
}
