package com.zhang.sys.service.impl;

import com.zhang.sys.constast.SysConstast;
import com.zhang.sys.domain.SysMenu;
import com.zhang.sys.mapper.MenuMapper;
import com.zhang.sys.mapper.RoleMapper;
import com.zhang.sys.domain.SysRole;
import com.zhang.sys.service.ISysRoleService;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.MenuVo;
import com.zhang.sys.vo.RoleVo;
import com.zhang.sys.vo.TreeNode;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 角色表服务实现类
 *
 * @author makejava
 * @since 2020-08-20 15:20:04
 */
@Service("sysRoleService")
public class RoleServiceImpl implements ISysRoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    @Override
    public SysRole queryById(Integer roleid) {
        return this.roleMapper.queryById(roleid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRole> queryAllByLimit(int offset, int limit) {
        return this.roleMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole addRole(SysRole sysRole) {
        this.roleMapper.addRole(sysRole);
        return sysRole;
    }

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysRole updateRole(SysRole sysRole) {
        this.roleMapper.updateRole(sysRole);
        return this.queryById(sysRole.getRoleid());
    }

    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer roleid) {
        //删除角色用户关联表
        this.roleMapper.deleteRoleUserByRoid(roleid);
        //删除角色菜单关联表
        this.roleMapper.deleteRoleMenuByRoid(roleid);
        return this.roleMapper.deleteById(roleid) > 0;
    }

    /**
     * 通过主键批量删除
     *
     * @param vo 主键
     * @return 是否成功
     */
    @Override
    public void deleteRoleBath(RoleVo vo) {
        Integer[] ids = vo.getIds();
        for (Integer id : ids) {
            //删除角色用户关联表
            this.roleMapper.deleteRoleUserByRoid(id);
            //删除角色菜单关联表
            this.roleMapper.deleteRoleMenuByRoid(id);
            this.roleMapper.deleteById(id);
        }

    }

    /**
     * 查询所有角色
     *
     * @param vo 实例对象
     * @return
     */
    @Override
    public DataGripView queryAll(RoleVo vo) {
        System.out.println(vo);
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
        List<SysRole> allRole = roleMapper.queryAll(vo);
        System.out.println(allRole);
        return new DataGripView(page.getTotal(), allRole);
    }

    /**
     * 分配菜单时,勾选该角色已分配的菜单
     *
     * @param vo
     * @return
     */
    @Override
    public DataGripView findMenuForRole(RoleVo vo) {
        //查出所有菜单
        List<SysMenu> menus = menuMapper.findAllMenu(new MenuVo());
        //筛选出已经分配的菜单
        List<SysMenu> roleMenu = menuMapper.findMenuByRoleId(vo.getRoleid());
        List<TreeNode> treeNodes = new ArrayList<>();
        for (SysMenu menu : menus) {
            String checkArr = SysConstast.CODE_ZERO + "";
            for (SysMenu menu2 : roleMenu) {
                if (menu2.getId() == menu.getId()) {
                    checkArr = SysConstast.CODE_ONE + "";
                    break;
                }
            }
            treeNodes.add(new TreeNode(menu.getId(), menu.getPid(), menu.getTitle(),
                    menu.getHref(), menu.getSpread() == SysConstast.SPREAD_TRUE ? true : false, menu.getTarget(), menu.getIcon(), checkArr));
        }
        return new DataGripView(treeNodes);
    }

    /**
     * 分配菜单
     *
     * @param vo
     */
    @Override
    public void addRoleMenu(RoleVo vo) {
        //先清空 role 相关的所有菜单信息
        roleMapper.deleteRoleMenuByRoid(vo.getRoleid());
        //再添加菜单
        for (Integer mid : vo.getIds()) {
            roleMapper.addRoleMenu(vo.getRoleid(), mid);
        }
    }
}