package com.zhang.sys.mapper;

import com.zhang.sys.domain.SysNews;
import com.zhang.sys.vo.NewsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 系统公告数据库访问层
 *
 * @author makejava
 * @since 2020-08-24 18:56:33
 */
@Repository("newsMapper")
public interface NewsMapper {

    /**
     * 查询所有系统公告 搜索 及 分页功能
     *
     * @param vo
     * @return
     */
    List<SysNews> queryAll(NewsVo vo);

    /**
     * 根据ID删除公告
     *
     * @param id
     */
    void deleteById(Integer id);


    /**
     * 修改公告
     *
     * @param newsVo
     */
    void updateNews(NewsVo newsVo);

    /**
     * 添加公告
     *
     * @param newsVo
     */
    void insert(NewsVo newsVo);


    /**
     * 根据ID查询系统公告
     *
     * @param id
     * @return
     */
    SysNews findNewsById(Integer id);
}