package com.zhang.sys.service;

import com.zhang.sys.domain.SysUser;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.UserVo;

public interface IUserService {
    /**
     * 登录方法
     */
    SysUser login(UserVo vo);


    /**
     * 根据ID查询数据
     *
     * @param id
     * @return
     */
    SysUser queryById(Integer id);

    /**
     * 查询用户列表及搜索功能
     *
     * @param vo
     * @return
     */
    DataGripView queryAll(UserVo vo);

    /**
     * 添加一个用户信息
     *
     * @param user
     */
    int addUser(SysUser user);

    /**
     * 修改用户信息
     *
     * @param user
     */
    SysUser updateUser(SysUser user);

    /**
     * 根据ID删除用户
     *
     * @param userid
     * @return
     */
    boolean deleteUserById(Integer userid);

    /**
     * 分配角色
     *
     * @param vo
     * @return
     */
    void addUserRole(UserVo vo);

    /**
     * 根据用户的id查询角色列表信息
     *
     * @return
     */
    DataGripView findUserRoleByUserId(UserVo vo);

    /**
     * 根据身份证查询用户
     * @param identity
     * @return
     */
    SysUser queryUserByEntity(String identity);
}
