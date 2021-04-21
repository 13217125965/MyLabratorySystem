package com.zhang.sys.constast;
/**
 * 存放常量的接口
 */
public interface SysConstast {
    /**
     * 登录失败提示信息
     */
    String USER_LOGIN_ERROR_MSG = "用户名或密码错误";

    /**
     * 确定用户身份信息
     */
    Integer USER_TYPE_ADMIN = 1;
    Integer USER_TYPE_NOMARL = 2;

    /**
     * 设置菜单是否展开
     */
    Integer SPREAD_TRUE = 1;
    Integer SPREAD_FALSE = 0;

    String ADD_SUCCESS = "添加成功";
    String ADD_ERROR = "添加失败";

    String UPDATE_SUCCESS = "修改成功";
    String UPDATE_ERROR = "修改失败";

    String DELETE_SUCCESS = "删除成功";
    String DELETE_ERROR = "删除失败";

    String ASSIGNMENT_SUCCESS = "分配菜单成功";
    String ASSIGNMENT_ERROR = "分配菜单失败";

    String SELECT_SUCCESS = "查询成功";
    String SELECT_ERROR = "查询失败";

    /**
     * 操作  成功: 0  失败 -1
     */
    Integer CODE_SUCCESS = 1;
    Integer CODE_ERROR = -1;

    /**
     * 公用状态码
     */
    Integer CODE_ZERO = 0;
    Integer CODE_ONE = 1;
    Integer CODE_TWO = 2;
    Integer CODE_THREE = 3;
}
