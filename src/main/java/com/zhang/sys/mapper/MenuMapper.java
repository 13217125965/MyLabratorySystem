package com.zhang.sys.mapper;

import com.zhang.sys.domain.SysMenu;
import com.zhang.sys.vo.MenuVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SysMenu)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-18 15:40:23
 */
@Repository("menuMapper")
public interface MenuMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysMenu queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysMenu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param sysMenu 实例对象
     * @return 对象列表
     */
    List<SysMenu> queryAll(SysMenu sysMenu);

    /**
     * 新增数据
     *
     * @param sysMenu 实例对象
     * @return 影响行数
     */
    int insert(SysMenu sysMenu);

    /**
     * 修改数据
     *
     * @param sysMenu 实例对象
     * @return 影响行数
     */
    int update(SysMenu sysMenu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 查询所有菜列表(  当用户为admin时,查询所有菜单   )
     *
     * @param vo
     * @return
     */
    List<SysMenu> findAllMenu(MenuVo vo);

    /**
     * 插入信息
     * @param vo
     * @return
     */
    int insert(MenuVo vo);

    /**
     * 统计pid的菜单个数
     *
     * @param pid
     * @return
     */
    Integer countMenuNumber(Integer pid);

    /**
     * 通过角色ID查询对应的菜单
     *
     * @param roleid
     * @return
     */
    List<SysMenu> findMenuByRoleId(Integer roleid);

    /**
     * 通过用户id查询对应的可用菜单
     *
     * @param vo
     * @param userId
     * @return
     */
    List<SysMenu> findAllMenuByUserId(@Param("vo") MenuVo vo, @Param("userId") Integer userId);
}