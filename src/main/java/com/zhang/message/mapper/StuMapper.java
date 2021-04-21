package com.zhang.message.mapper;

import com.zhang.message.domain.BusStudent;
import com.zhang.message.vo.StudentVo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学生表数据访问层
 */
@Repository("studentMapper")
@Component
public interface StuMapper {
    /**
     * 查询所有的学生信息  分页  和  搜索功能
     * @param vo
     * @return
     */
    List<BusStudent> queryAll(StudentVo vo);

    /**
     * 添加学生信息
     * @param vo
     */
    void insert(StudentVo vo);

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
     * 根据学号查询学生信息
     * @param studentId
     * @return
     */
    BusStudent queryByStudentId(String studentId);

}
