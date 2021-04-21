package com.zhang.sys.controller;

import com.zhang.sys.constast.SysConstast;
import com.zhang.sys.domain.SysRole;
import com.zhang.sys.service.ISysRoleService;
import com.zhang.sys.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * (SysRole)表控制层
 *
 * @author makejava
 * @since 2020-08-20 15:20:05
 */
@RestController
@RequestMapping("sysRole")
public class SysRoleController {
    /**
     * 服务对象
     */
    @Autowired
    private ISysRoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SysRole selectOne(Integer id) {
        return this.roleService.queryById(id);
    }

    /**
     * 查询所有角色信息 及搜索功能
     *
     * @param vo
     * @return
     */
    @GetMapping("findAllRole")
    public DataGripView findAllRole(RoleVo vo) {
        System.out.println(vo.getPage());
        System.out.println(vo.getLimit());
        return roleService.queryAll(vo);
    }


    /**
     * 添加角色
     *
     * @param sysRole
     */
    @PostMapping("saveRole")
    public ResultObject addRole(SysRole sysRole) {
        try {
            roleService.addRole(sysRole);
            //添加成功
            return ResultObject.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            //添加失败
            return ResultObject.ADD_ERROR;
        }
    }

    /**
     * 修改角色信息
     *
     * @param sysRole
     * @return
     */
    @PostMapping("updateRole")
    public ResultObject updataRole(SysRole sysRole) {

        try {
            roleService.updateRole(sysRole);
            //添加成功
            return ResultObject.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            //添加失败
            return ResultObject.UPDATE_ERROR;
        }
    }


    @PostMapping("deleteRole")
    public ResultObject deleteRoleById(Integer roleid) {
        try {
            roleService.deleteById(roleid);
            //添加成功
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            //添加失败
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     *
     * @param vo
     * @return
     */
    @PostMapping("deleteRoleBath")
    public ResultObject deleteRoleBath(RoleVo vo) {
        try {
            Integer[] ids = vo.getIds();
            for (Integer id : ids) {
                roleService.deleteRoleBath(vo);
            }
            //添加成功
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            //添加失败
            return ResultObject.DELETE_ERROR;
        }
    }


    //查询分配菜单列表
    @RequestMapping("findMenuForRole")
    public DataGripView findMenuForRole(RoleVo vo) {
        return roleService.findMenuForRole(vo);
    }

    /**
     * 添加菜单
     *
     * @param vo
     * @return
     */
    @PostMapping("assignmentMenu")
    public ResultObject assignmentMenu(RoleVo vo) {
        Integer[] ids = vo.getIds();
        System.out.println(Arrays.toString(ids));
        try {
            roleService.addRoleMenu(vo);
            return new ResultObject(SysConstast.CODE_SUCCESS, SysConstast.ASSIGNMENT_SUCCESS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultObject(SysConstast.CODE_ERROR, SysConstast.ASSIGNMENT_ERROR);
        } finally {
        }
    }


}