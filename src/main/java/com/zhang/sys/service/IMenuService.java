package com.zhang.sys.service;

import com.zhang.sys.domain.SysMenu;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.MenuVo;

import java.util.List;

public interface IMenuService {
    /**
     * 系统管理员查询所有菜单
     * @param vo
     * @return
     */
    List<SysMenu> findAllMenu(MenuVo vo);

    /**
     * 查询多条数据
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return  对象列表
     */
    List<SysMenu> queryAllByLimit(int offset, int limit);

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    SysMenu queryById(Integer id);
    /**
     * 新增数据
     * @return
     */
    SysMenu insert(SysMenu sysMenu);

    /**
     * 业务管理员通过ID查询自己的菜单权限
     * @param vo
     * @param userid
     * @return
     */
    List<SysMenu> findMenuByUserId(MenuVo vo, Integer userid);
    /**
     * 根据ID删除
     * @param id
     * @return  是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询菜单列表和搜索分页
     * @param vo
     * @return
     */
    DataGripView findAllMenuList(MenuVo vo);

    /**
     * 添加菜单
     * @param vo
     */
    void saveMenu(MenuVo vo);

    /**
     * 判断当前菜单是否为父级菜单
     * @param id
     * @return
     */
    Integer getMenuIsParentMenu(Integer id);

    /**
     * 修改菜单数据
     * @param sysMenu
     * @return
     */
    SysMenu update(SysMenu sysMenu);


}
