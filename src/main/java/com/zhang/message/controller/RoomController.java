package com.zhang.message.controller;


import com.zhang.message.service.IRoomService;
import com.zhang.message.vo.RoomVo;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实验室控制层
 */
@RestController
@RequestMapping("messRoom")
public class RoomController {

    /**
     * 服务对象
     */
    @Autowired
    private IRoomService roomService;

    /**
     * 查询所有实验室信息
     * @param vo
     * @return
     */
    @GetMapping("loadRoomList")
    public DataGripView loadRoomList(RoomVo vo){
        return roomService.queryAll(vo);
    }

    /**
     * 查询实验室是否可用
     * @param vo
     * @return
     */
    @GetMapping("queryRoomByType")
    public DataGripView queryRoomByType(RoomVo vo){
        return roomService.queryByType(vo);
    }

    /**
     * 修改实验室信息
     * @param vo
     * @return
     */
    @PostMapping("updateRoom")
    public ResultObject updateRoom(RoomVo vo){
        try {
            roomService.update(vo);
            return ResultObject.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.UPDATE_ERROR;
        }
    }

    /**
     * 根据实验室编号删除该实验室信息
     * @param roomnumber
     * @return
     */
    @PostMapping("deleteRoom")
    public ResultObject deleteRoom(String roomnumber){
        try {
            roomService.delete(roomnumber);
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 批量删除实验室信息
     * @param vo
     * @return
     */
    @PostMapping("deleteRoomBatch")
    public ResultObject deleteRoomBatch(RoomVo vo){
        try {
            for (String roomNumber : vo.getRoomnumbers()) {
                roomService.delete(roomNumber);
            }
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 添加实验室信息
     * @param vo
     * @return
     */
    @PostMapping("addRoom")
    public ResultObject addRoom(RoomVo vo){
        try {
            roomService.addRoom(vo);
            return ResultObject.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.ADD_ERROR;
        }


    }





}
