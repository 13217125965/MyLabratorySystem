package com.zhang.bus.mapper;

import com.zhang.bus.domain.BusRents;
import com.zhang.bus.vo.RentsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * (BusRents)表数据库访问层
 *
 * @author makejava
 * @since 2021-04-19 20:05:03
 */
@Repository("busRentsMapper")
public interface BusRentsMapper {
    /**
     * 通过ID查询单条数据
     *
     * @param rentid 主键
     * @return 实例对象
     */
    BusRents queryById(String rentid);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param rentsVo 实例对象
     * @return 对象列表
     */
    List<BusRents> queryAll(RentsVo rentsVo);

    /**
     * 新增数据
     *
     * @param rentsVo 实例对象
     * @return 影响行数
     */
    int insert(RentsVo rentsVo);

    /**
     * 修改数据
     *
     * @param rentsVo 实例对象
     * @return 影响行数
     */
    int update(RentsVo rentsVo);

    /**
     * 通过主键删除数据
     *
     * @param rentid 主键
     * @return 影响行数
     */
    int deleteById(String rentid);

}
