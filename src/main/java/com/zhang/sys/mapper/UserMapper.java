package com.zhang.sys.mapper;

import com.zhang.sys.domain.SysUser;
import com.zhang.sys.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户服务
 */
@Repository("userMapper")
public interface UserMapper {
    /*
    用户登录方法
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
    List<SysUser> queryAll(UserVo vo);

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
     * @return
     */
    int updateUser(SysUser user);

    /**
     * 根据ID删除用户
     *
     * @param userid
     * @return
     */
    int deleteUserById(Integer userid);


    /**
     * 分配角色
     *
     * @param uid 用户的id
     * @param rid 角色的id
     * @return
     */
    int addUserRole(@Param("uid") Integer uid, @Param("rid") Integer rid);

    /**
     * 根据ID删除用户对应的角色信息
     *
     * @param userid
     */
    void deleteRoleUserById(Integer userid);

    /**
     * 根据身份证查询用户
     * @param identity
     * @return
     */
    SysUser queryUserByEntity(String identity);
}
