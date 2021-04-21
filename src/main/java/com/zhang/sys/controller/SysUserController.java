package com.zhang.sys.controller;


import com.zhang.sys.constast.SysConstast;
import com.zhang.sys.domain.SysUser;
import com.zhang.sys.service.IUserService;
import com.zhang.sys.utils.WebUtils;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.ResultObject;
import com.zhang.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sysUser")
public class SysUserController {
    @Autowired
    private IUserService userService;

    /**
     * 查询用户列表及搜索功能
     *
     * @param vo
     * @return
     */
    @GetMapping("findAllUser")
    public DataGripView findAllUser(UserVo vo) {
        return userService.queryAll(vo);
    }

    /**
     * 根据身份证号查询用户
     *
     * @param identity
     * @return
     */
    @GetMapping("findUserByEntity")
    public ResultObject findUserByEntity(String identity) {
        SysUser sysUser = userService.queryUserByEntity(identity);
        if (sysUser != null){
            //不为空返回 查询成功
            return ResultObject.SELECT_SUCCESS;
        }else {
            // 为空返回 查询失败
            return ResultObject.SELECT_ERROR;
        }

    }


    /**
     * 添加一个用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("saveUser")
    public ResultObject saveUser(SysUser user) {
        try {
            userService.addUser(user);
            return new ResultObject(SysConstast.CODE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultObject(SysConstast.CODE_ERROR);
        }
    }

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @PostMapping("updateUser")
    public ResultObject updateUser(SysUser user) {
        try {
            userService.updateUser(user);
            return new ResultObject(SysConstast.CODE_SUCCESS, SysConstast.UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultObject(SysConstast.CODE_ERROR, SysConstast.UPDATE_ERROR);
        }
    }

    /**
     * 根据ID删除用户信息
     *
     * @param userid
     * @return
     */
    @PostMapping("deleteUserById")
    public ResultObject deleteUserById(Integer userid) {
        try {
            userService.deleteUserById(userid);
            return new ResultObject(SysConstast.CODE_SUCCESS, SysConstast.DELETE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultObject(SysConstast.CODE_ERROR, SysConstast.DELETE_ERROR);
        }
    }

    /**
     * 批量删除用户
     *
     * @param vo
     * @return
     */
    @PostMapping("deleteUserBath")
    public ResultObject deleteUserBath(UserVo vo) {
        try {
            //获取页面传来的多个id值
            Integer[] ids = vo.getIds();
            //遍历id,循环调用根据ID删除的方法
            for (Integer userid : ids) {
                userService.deleteUserById(userid);
            }
            //添加成功
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            //添加失败
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 重置用户密码
     *
     * @param user
     * @return
     */
    @PostMapping("respwd")
    public ResultObject respwd(SysUser user) {
        try {
            //重置密码为 加密后的 666666 ,
            String pwd = DigestUtils.md5DigestAsHex(("zhang" + 666666 + "zhen").getBytes());
            user.setPassword(pwd);
            userService.updateUser(user);
            return new ResultObject(SysConstast.CODE_SUCCESS, SysConstast.UPDATE_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultObject(SysConstast.CODE_ERROR, SysConstast.UPDATE_ERROR);
        }
    }

    /**
     * 分配角色
     *
     * @param vo
     * @return
     */
    @PostMapping("assignRole")
    public ResultObject assignRole(UserVo vo) {
        try {
            userService.addUserRole(vo);
            return new ResultObject(SysConstast.CODE_SUCCESS, SysConstast.ASSIGNMENT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultObject(SysConstast.CODE_ERROR, SysConstast.ASSIGNMENT_ERROR);
        }
    }

    /**
     * 根据用户的id查询角色列表信息
     *
     * @return
     */
    @RequestMapping("findUserRoleByUserId")
    public DataGripView findUserRoleByUserId(UserVo vo) {
        return userService.findUserRoleByUserId(vo);
    }

    /**
     * 个人资料显示
     * 根据ID查询用户个人信息
     *
     * @return
     */
    @RequestMapping("queryUserById")
    public SysUser queryUserById() {
        SysUser user = (SysUser) WebUtils.getHttpSession().getAttribute("user");
        SysUser sysUser = userService.queryById(user.getUserid());
        return sysUser;
    }



}
