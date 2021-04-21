package com.zhang.sys.vo;

import com.zhang.sys.domain.SysMenu;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
//@EqualsAndHashCode(callSuper = false)
public class MenuVo extends SysMenu {
    private Integer page;
    private Integer limit;
}
