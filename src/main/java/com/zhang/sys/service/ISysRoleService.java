package com.zhang.sys.service;

import com.zhang.sys.domain.SysMenu;
import com.zhang.sys.domain.SysRole;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.MenuVo;
import com.zhang.sys.vo.RoleVo;

import java.util.List;

/**
 * (SysRole)表服务接口
 *
 * @author makejava
 * @since 2020-08-20 15:20:03
 */
public interface ISysRoleService {

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    SysRole queryById(Integer roleid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole addRole(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    SysRole updateRole(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer roleid);

    /**
     * 通过主键 批量删除
     *
     * @param vo 主键
     * @return 是否成功
     */
    void deleteRoleBath(RoleVo vo);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param vo 实例对象
     * @return 对象列表
     */
    DataGripView queryAll(RoleVo vo);

    /**
     * 分配菜单时,勾选该角色已分配的菜单
     *
     * @param vo
     * @return
     */
    DataGripView findMenuForRole(RoleVo vo);

    /**
     * 分配菜单
     *
     * @param vo
     */
    void addRoleMenu(RoleVo vo);
}