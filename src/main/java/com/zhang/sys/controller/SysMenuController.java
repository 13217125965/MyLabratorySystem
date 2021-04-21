package com.zhang.sys.controller;

import com.zhang.sys.constast.SysConstast;
import com.zhang.sys.domain.SysMenu;
import com.zhang.sys.domain.SysUser;
import com.zhang.sys.service.IMenuService;
import com.zhang.sys.utils.TreeNodeUtils;
import com.zhang.sys.utils.WebUtils;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.MenuVo;
import com.zhang.sys.vo.ResultObject;
import com.zhang.sys.vo.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("sysMenu")
public class SysMenuController {
    /**
     * 服务对象
     */
    @Autowired
    private IMenuService menuService;

    /**
     * 查询菜单列表
     *
     * @return
     */
    //查询菜单列表
    @RequestMapping("loadMainMenu")
    public List<TreeNode> findAllMenu(MenuVo vo) {
//        1.获取登录用户的相关信息
        SysUser user = (SysUser) WebUtils.getHttpSession().getAttribute("user");
        List<SysMenu> allMenu;
//        3.加载菜单（判断是否是管理员账号）
        if (user.getType() == SysConstast.USER_TYPE_ADMIN) {
            allMenu = menuService.findAllMenu(vo);
        } else {
            //普通用户登录
            allMenu = menuService.findMenuByUserId(vo, user.getUserid());
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        for (SysMenu menu : allMenu) {
            TreeNode treeNode = new TreeNode();
            treeNode.setId(menu.getId());
            treeNode.setTitle(menu.getTitle());
            treeNode.setIcon(menu.getIcon());
            treeNode.setHref(menu.getHref());
            treeNode.setTarget(menu.getTarget());
            treeNode.setPid(menu.getPid());
            treeNode.setSpread(menu.getSpread() == SysConstast.SPREAD_TRUE ? true : false);
            treeNodes.add(treeNode);
        }
        List<TreeNode> list = TreeNodeUtils.buildTreeNode(treeNodes, 1);
        return list;
    }

    /**
     * 加载左侧树状菜单
     *
     * @param vo
     * @return
     */
    @RequestMapping("loadLeftTree")
    public DataGripView findAllMenuForTree(MenuVo vo) {
        List<SysMenu> allMenu = menuService.findAllMenu(vo);
        List<TreeNode> treeNodes = new ArrayList<>();
        for (SysMenu menu : allMenu) {
            treeNodes.add(new TreeNode(menu.getId(), menu.getPid(), menu.getTitle(),
                    menu.getHref(), menu.getSpread() == SysConstast.SPREAD_TRUE ? true : false, menu.getTarget(), menu.getIcon()));
        }
        return new DataGripView(treeNodes);
    }

    /**
     * 加载右侧菜单列表
     *
     * @return
     */
    @RequestMapping("findAllMenuList")
    public DataGripView findAllMenuRight(MenuVo vo) {
        System.out.println(vo.getPage());
        System.out.println(vo.getLimit());
        System.out.println(vo.getTitle());
        return menuService.findAllMenuList(vo);
    }

    /**
     * 添加菜单
     *
     * @param vo
     */
    @PostMapping("saveMenu")
    public ResultObject addMenu(MenuVo vo) {
        try {
            menuService.saveMenu(vo);
            //添加成功
            return ResultObject.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            //添加失败
            return ResultObject.ADD_ERROR;
        }
    }

    /**
     * 修改菜单信息
     *
     * @param menu
     * @return
     */
    @PostMapping("updateMenu")
    public ResultObject updateMenu(SysMenu menu) {
        try {
            menuService.update(menu);
            return ResultObject.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.UPDATE_ERROR;
        }
    }

    /**
     * 检查当前菜单是否为一个父级菜单
     *
     * @param id
     * @return
     */
    @PostMapping("getMenuIsParentMenu")
    public ResultObject checkMenuIsParentMenu(Integer id) {
        Integer total = menuService.getMenuIsParentMenu(id);
        if (total > 0) {
            return ResultObject.DELETE_SUCCESS;
        } else {
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 删除菜单方法
     *
     * @param id
     * @return
     */
    @PostMapping("deleteMenu")
    public ResultObject deleteMenu(Integer id) {
        try {
            menuService.deleteById(id);
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }
}
