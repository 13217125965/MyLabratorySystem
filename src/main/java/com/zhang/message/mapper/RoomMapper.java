package com.zhang.message.mapper;

import com.zhang.message.domain.BusRoom;
import com.zhang.message.vo.RoomVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 实验室表数据访问层
 */

@Repository("roomMapper")
public interface RoomMapper {
    /**
     * 查询所有实验室
     * @param vo
     * @return
     */
    List<RoomVo> queryAll(RoomVo vo);

    /**
     * 查询是否可用
     * @param vo
     * @return
     */
    List<RoomVo> queryByType(RoomVo vo);

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
    void insert(RoomVo vo);


}
