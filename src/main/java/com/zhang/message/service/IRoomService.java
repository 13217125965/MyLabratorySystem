package com.zhang.message.service;

import com.zhang.message.domain.BusRoom;
import com.zhang.message.vo.RoomVo;
import com.zhang.sys.vo.DataGripView;


/**
 * 实验室表服务接口
 */
public interface IRoomService {
    /**
     * 查询所有实验室
     * @param vo
     * @return
     */
    DataGripView queryAll(RoomVo vo);

    /**
     * 查询是否可用
     * @param vo
     * @return
     */
    DataGripView queryByType(RoomVo vo);

    /**
     * 根据实验室编号查询
     * @param roomNumber
     * @return
     */
    BusRoom queryRoomByRoomNum(String roomNumber);

    /**
     * 修改实验室信息
     * @param vo
     */
    void update(RoomVo vo);

    /**
     * 根据实验室编号删除实验室信息
     * @param roomNumber
     */
    void delete(String roomNumber);

    /**
     * 添加一条实验室信息
     * @param vo
     */
    void addRoom(RoomVo vo);

    /**
     * 批量删除实验室
     * @param vo
     */
    void deleteRoomBatch(RoomVo vo);

}
