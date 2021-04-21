package com.zhang.sys.vo;

import com.zhang.sys.constast.SysConstast;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.Data;

/**
 * 作用于返回消息
 */
@Data
public class ResultObject {

    private Integer code;
    private String msg;


    public ResultObject() {
    }

    public ResultObject(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultObject(Integer code) {
        this.code = code;
    }

    public ResultObject(String msg) {
        this.msg = msg;
    }

    //添加
    public static final ResultObject ADD_SUCCESS = new ResultObject(SysConstast.CODE_SUCCESS, SysConstast.ADD_SUCCESS);
    public static final ResultObject ADD_ERROR = new ResultObject(SysConstast.CODE_ERROR, SysConstast.ADD_ERROR);
    //修改
    public static final ResultObject UPDATE_SUCCESS = new ResultObject(SysConstast.CODE_SUCCESS, SysConstast.UPDATE_SUCCESS);
    public static final ResultObject UPDATE_ERROR = new ResultObject(SysConstast.CODE_ERROR, SysConstast.UPDATE_ERROR);
    //删除
    public static final ResultObject DELETE_SUCCESS = new ResultObject(SysConstast.CODE_SUCCESS, SysConstast.DELETE_SUCCESS);
    public static final ResultObject DELETE_ERROR = new ResultObject(SysConstast.CODE_ERROR, SysConstast.DELETE_ERROR);
    //查询
    public static final ResultObject SELECT_SUCCESS = new ResultObject(SysConstast.CODE_SUCCESS,SysConstast.SELECT_SUCCESS);
    public static final ResultObject SELECT_ERROR = new ResultObject(SysConstast.CODE_ERROR,SysConstast.SELECT_ERROR);

    //操作
    public static final ResultObject STATUS_TRUE = new ResultObject(SysConstast.CODE_SUCCESS);
    public static final ResultObject STATUS_ERROR = new ResultObject(SysConstast.CODE_ERROR);

    //分配成功
    public static final ResultObject ASSIGNMENT_SUCCESS = new ResultObject(SysConstast.CODE_SUCCESS, SysConstast.ASSIGNMENT_SUCCESS);
    //分配失败
    public static final ResultObject ASSIGNMENT_ERROR = new ResultObject(SysConstast.CODE_ERROR, SysConstast.ASSIGNMENT_ERROR);


}
