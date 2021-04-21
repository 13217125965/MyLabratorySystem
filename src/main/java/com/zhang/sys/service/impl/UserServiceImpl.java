package com.zhang.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.sys.constast.SysConstast;
import com.zhang.sys.domain.SysRole;
import com.zhang.sys.domain.SysUser;
import com.zhang.sys.mapper.RoleMapper;
import com.zhang.sys.mapper.UserMapper;
import com.zhang.sys.service.IUserService;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.RoleVo;
import com.zhang.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户服务
 */
@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    /*
    登录方法
     */
    @Override
    public SysUser login(UserVo vo) {
        //MD5加密
        vo.setPassword(DigestUtils.md5DigestAsHex(("zhang"+vo.getPassword()+"zhen").getBytes()));
        return userMapper.login(vo);
    }

    /**
     * 根据id查询数用户信息
     *
     * @param id
     * @return
     */
    @Override
    public SysUser queryById(Integer id) {
        return userMapper.queryById(id);
    }

    /**
     * 查询用户列表及搜索功能
     *
     * @param vo
     * @return
     */
    @Override
    public DataGripView queryAll(UserVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
        List<SysUser> sysUsers = userMapper.queryAll(vo);
        // 参数一位查询数据的总条数, 参数二为 数据实体
        return new DataGripView(page.getTotal(), sysUsers);
    }

    /**
     * 添加一个用户信息
     *
     * @param user
     */
    @Override
    public int addUser(SysUser user) {
        //添加用户时初始化密码,默认密码为666666 , 加密一下
        String pwd = DigestUtils.md5DigestAsHex(("Handsome" + 666666 + "Tom").getBytes());
        user.setType(2);
        //将加密的密码添加到user对象中
        user.setPassword(pwd);
        return userMapper.addUser(user);
    }

    /**
     * 修改用户信息
     *
     * @param user
     */
    @Override
    public SysUser updateUser(SysUser user) {
        userMapper.updateUser(user);
        return this.queryById(user.getUserid());
    }

    /**
     * 根据ID删除用户
     *
     * @param userid
     * @return
     */
    @Override
    public boolean deleteUserById(Integer userid) {
        return this.userMapper.deleteUserById(userid) > 0;
    }

    /**
     * 分配角色
     *
     * @param vo 用户的id
     * @return
     */
    @Override
    public void addUserRole(UserVo vo) {
        //先删除用户已有的角色
        userMapper.deleteRoleUserById(vo.getUserid());
        //在循环添加用户角色信息, 放置数据重复
        for (Integer rid : vo.getIds()) {
            userMapper.addUserRole(vo.getUserid(), rid);
        }

    }

    /**
     * 根据用户的id查询角色列表信息
     * 点击分配角色时 默认勾选已分配的角色
     *
     * @return
     */
    @Override
    public DataGripView findUserRoleByUserId(UserVo userVo) {
        RoleVo roleVo = new RoleVo();
        roleVo.setAvailable(SysConstast.CODE_ONE);
        List<SysRole> roleList = roleMapper.queryAll(roleVo);
        List<SysRole> roles = roleMapper.queryAllByUserId(userVo.getUserid(), SysConstast.CODE_ONE);
        List<Map<String, Object>> data = new ArrayList<>();
//        组装数据 LAY_CHECKED:true/false  true:被选中 false:未勾选
        for (SysRole r1 : roleList) {
            Boolean LAY_CHECKED = false;
            for (SysRole r2 : roles) {
                if (r2.getRoleid() == r1.getRoleid()) {
                    LAY_CHECKED = true;
                    break;
                }
            }
            Map<String, Object> userRoleInfo = new HashMap<>();
            userRoleInfo.put("roleid", r1.getRoleid());
            userRoleInfo.put("rolename", r1.getRolename());
            userRoleInfo.put("roledesc", r1.getRoledesc());
            userRoleInfo.put("LAY_CHECKED", LAY_CHECKED);
            data.add(userRoleInfo);
        }
        return new DataGripView(data);
    }

    /**
     * 根据身份证查询用户
     * @param identity
     * @return
     */
    @Override
    public SysUser queryUserByEntity(String identity) {
        return userMapper.queryUserByEntity(identity);
    }
}
