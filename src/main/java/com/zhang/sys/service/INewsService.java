package com.zhang.sys.service;

import com.zhang.sys.domain.SysNews;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.NewsVo;

import java.util.List;

/**
 * (SysNews)表服务接口
 *
 * @author makejava
 * @since 2020-08-24 18:56:34
 */
public interface INewsService {

    /**
     * 查询所有系统公告 搜索 及 分页功能
     *
     * @param vo
     * @return
     */
    DataGripView queryAll(NewsVo vo);


    /**
     * 根据ID删除公告
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 新增一个公告
     *
     * @param newsVo
     */
    void addNews(NewsVo newsVo);

    /**
     * 修改公告
     *
     * @param newsVo
     */
    void updateNews(NewsVo newsVo);

    /**
     * 根据ID查询系统公告
     *
     * @param id
     * @return
     */
    SysNews findNewsById(Integer id);
}