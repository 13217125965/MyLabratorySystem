package com.zhang.sys.mapper;

import com.zhang.sys.domain.SysRole;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.MenuVo;
import com.zhang.sys.vo.RoleVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * (SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-20 15:20:03
 */
@Repository("roleMapper")
public interface RoleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param roleid 主键
     * @return 实例对象
     */
    SysRole queryById(Integer roleid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param vo 实例对象
     * @return 对象列表
     */
    List<SysRole> queryAll(RoleVo vo);

    /**
     * 新增数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    int addRole(SysRole sysRole);

    /**
     * 修改数据
     *
     * @param sysRole 实例对象
     * @return 影响行数
     */
    int updateRole(SysRole sysRole);

    /**
     * 通过主键删除数据
     *
     * @param roleid 主键
     * @return 影响行数
     */
    int deleteById(Integer roleid);

    //根据roleid删除sys_role_user表中的数据
    void deleteRoleUserByRoid(Integer roleid);

    //根据roleid删除sys_role_menu表中的数据
    void deleteRoleMenuByRoid(Integer roleid);

    //添加数据到sys_role_menu表
    void addRoleMenu(@Param("roleid") Integer roleid, @Param("mid") Integer mid);

    /**
     * 根据用户ID查询角色信息
     *
     * @param userid
     * @return
     */
    List<SysRole> queryAllByUserId(@Param("userid") Integer userid, @Param("available") Integer available);
}