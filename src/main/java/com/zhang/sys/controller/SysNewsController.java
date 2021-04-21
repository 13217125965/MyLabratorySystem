package com.zhang.sys.controller;

import com.zhang.sys.domain.SysNews;
import com.zhang.sys.service.INewsService;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.NewsVo;
import com.zhang.sys.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sysNews")
public class SysNewsController {


    @Autowired
    private INewsService newsService;


    /**
     * 查询所有系统公告 搜索 及 分页功能
     *
     * @param vo
     * @return
     */
    @RequestMapping("findAllNews")
    public DataGripView findAllNews(NewsVo vo) {
//        System.out.println("时间: " + vo.getStartTime());
        return newsService.queryAll(vo);
    }

    /**
     * 根据ID删除公告
     *
     * @param id
     * @return
     */
    @RequestMapping("deleteNewsById")
    public ResultObject deleteNewsById(Integer id) {
        try {
            newsService.deleteById(id);
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 批量删除公告
     *
     * @param vo
     * @return
     */
    @RequestMapping("deleteNewsBatch")
    public ResultObject deleteNewsBatch(NewsVo vo) {
        try {
            for (Integer id : vo.getIds()) {
                newsService.deleteById(id);
            }
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 新增公告
     *
     * @param newsVo
     */
    @RequestMapping("addNews")
    public ResultObject addNews(NewsVo newsVo) {
        System.out.println(newsVo.getContent() + newsVo.getTitle());
        try {
            System.out.println("内容:" + newsVo.getContent());
            newsService.addNews(newsVo);
            return ResultObject.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.ADD_ERROR;
        }
    }

    /**
     * 修改公告
     *
     * @param newsVo
     */
    @RequestMapping("updateNews")
    public ResultObject updateNews(NewsVo newsVo) {
        try {
            System.out.println("内容:" + newsVo.getContent());
            newsService.updateNews(newsVo);
            return ResultObject.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.UPDATE_ERROR;
        }
    }

    /**
     * 根据ID查询系统公告
     *
     * @param id
     * @return
     */
    @GetMapping("findNewsById")
    public SysNews findNewsById(Integer id) {
        return newsService.findNewsById(id);
    }


}
