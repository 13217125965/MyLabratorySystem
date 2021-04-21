package com.zhang.message.vo;

import com.zhang.message.domain.BusRoom;
import lombok.Data;

@Data
public class RoomVo extends BusRoom {
    private Integer page;
    private Integer limit;
    private String[] roomnumbers;
}
