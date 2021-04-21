package com.zhang.sys.vo;

import com.zhang.sys.domain.SysUser;
import lombok.Data;

@Data
public class UserVo extends SysUser {
    //当前页
    private Integer page;
    //每页显示条数
    private Integer limit;
    private Integer uid;
    private Integer[] ids;


}
