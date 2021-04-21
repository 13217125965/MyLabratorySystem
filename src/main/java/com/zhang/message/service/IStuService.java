package com.zhang.message.service;

import com.zhang.message.domain.BusStudent;
import com.zhang.message.vo.StudentVo;
import com.zhang.sys.vo.DataGripView;

import java.util.List;

/**
 * 学生表服务接口
 */
public interface IStuService {
    /**
     * 查询所有的学生信息  分页  和  搜索功能
     * @param vo
     * @return
     */
    DataGripView queryAll(StudentVo vo);
    /**
     * 添加学生信息
     * @param vo
     */
    void addStudent(StudentVo vo);
    /**
     * 根据学号删除对应学生信息
     * @param studentId
     */
    void deleteByStuId(String studentId);

    /**
     * 修改学生信息
     * @param vo
     */
    void  updateStudent(StudentVo vo);

    /**
     * 查询所有学生信息 返回list集合
      */
    List<BusStudent> findAllStudents(StudentVo vo);

    /**
     * 根据学号查询学生信息
     * @param studentId
     * @return
     */
    BusStudent queryByStudentId(String studentId);





}
