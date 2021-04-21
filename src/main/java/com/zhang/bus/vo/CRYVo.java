package com.zhang.bus.vo;

import com.zhang.bus.domain.BusRents;
import com.zhang.message.domain.BusRoom;
import com.zhang.message.domain.BusStudent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CRYVo {
    private BusStudent customer;
    private BusRents rent;
    private BusRoom car;
}
