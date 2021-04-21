package com.zhang.sys.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.sys.constast.SysConstast;
import com.zhang.sys.domain.SysMenu;
import com.zhang.sys.mapper.MenuMapper;
import com.zhang.sys.service.IMenuService;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 系统菜单
 */
import java.util.List;
@Service("menuService")
public class MenuServiceImpl implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询所有菜单列表
     * @param vo
     * @return
     */
    @Override
    public List<SysMenu> findAllMenu(MenuVo vo) {
        return menuMapper.findAllMenu(vo);

    }

    @Override
    public List<SysMenu> queryAllByLimit(int offset, int limit) {
        return menuMapper.queryAllByLimit(offset,limit);
    }

    @Override
    public SysMenu queryById(Integer id) {
        return menuMapper.queryById(id);
    }

    @Override
    public SysMenu insert(SysMenu sysMenu) {
        menuMapper.insert(sysMenu);
        return sysMenu;
    }

    @Override
    public List<SysMenu> findMenuByUserId(MenuVo vo,Integer userid) {
        vo.setAvailable(SysConstast.CODE_ONE);
        return menuMapper.findAllMenuByUserId(vo,userid);
    }

    @Override
    public boolean deleteById(Integer id) {
        return menuMapper.deleteById(id)>0;
    }

    @Override
    public DataGripView findAllMenuList(MenuVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(),vo.getLimit());
        List<SysMenu> allMenu = menuMapper.findAllMenu(vo);
        return new DataGripView(page.getTotal(),allMenu);
    }

    @Override
    public void saveMenu(MenuVo vo) {
        menuMapper.insert(vo);
    }

    @Override
    public Integer getMenuIsParentMenu(Integer id) {
        return menuMapper.countMenuNumber(id);
    }

    @Override
    public SysMenu update(SysMenu sysMenu) {
        menuMapper.update(sysMenu);
        return menuMapper.queryById(sysMenu.getId());
    }
}
