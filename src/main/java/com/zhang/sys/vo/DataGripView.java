package com.zhang.sys.vo;

/**
 * 封装树状结构的实体类
 */
public class DataGripView {

    private Integer code = 0;
    private String msg = "";
    private Long count;
    private Object data;

    public DataGripView() {
    }

    public DataGripView(Object data) {
        this.data = data;
    }

    public DataGripView(Long count, Object data) {
        this.data = data;
        this.count = count;
    }


    public DataGripView(Integer code, String msg, Long count, Object data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
