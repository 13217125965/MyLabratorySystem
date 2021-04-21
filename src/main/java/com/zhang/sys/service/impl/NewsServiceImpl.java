package com.zhang.sys.service.impl;

import com.zhang.sys.domain.SysUser;
import com.zhang.sys.mapper.NewsMapper;
import com.zhang.sys.domain.SysNews;
import com.zhang.sys.service.INewsService;
import com.zhang.sys.utils.WebUtils;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.NewsVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 系统公告表服务实现类
 *
 * @author makejava
 * @since 2020-08-24 18:56:34
 */
@Service("newsService")
public class NewsServiceImpl implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询所有系统公告 搜索 及 分页功能
     *
     * @param vo
     * @return
     */
    @Override
    public DataGripView queryAll(NewsVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
        List<SysNews> sysNews = newsMapper.queryAll(vo);
        return new DataGripView(page.getTotal(), sysNews);
    }

    /**
     * 根据ID删除公告
     *
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        newsMapper.deleteById(id);
    }

    /**
     * 添加公告
     *
     * @param newsVo
     */
    @Override
    public void addNews(NewsVo newsVo) {
        //session获取 发布公告 当前操作人
        SysUser user = (SysUser) WebUtils.getHttpSession().getAttribute("user");
        newsVo.setOpername(user.getUsername());
        newsMapper.insert(newsVo);
    }

    /**
     * 修改公告
     *
     * @param newsVo
     */
    @Override
    public void updateNews(NewsVo newsVo) {
        //获取修改公告当前操作人
        SysUser user = (SysUser) WebUtils.getHttpSession().getAttribute("user");
        newsVo.setOpername(user.getUsername());
        newsVo.setCreatetime(new Date());
        newsMapper.updateNews(newsVo);
    }

    /**
     * 根据ID查询系统公告
     *
     * @param id
     * @return
     */
    @Override
    public SysNews findNewsById(Integer id) {
        return newsMapper.findNewsById(id);
    }
}