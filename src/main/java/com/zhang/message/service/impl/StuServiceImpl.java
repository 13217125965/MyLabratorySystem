package com.zhang.message.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zhang.message.domain.BusStudent;
import com.zhang.message.mapper.StuMapper;
import com.zhang.message.service.IStuService;
import com.zhang.message.vo.StudentVo;
import com.zhang.sys.vo.DataGripView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 学生表实现层
 */
@Service("studentService")
public class StuServiceImpl implements IStuService{
    @Autowired
    private StuMapper stuMapper;

    @Override
    public DataGripView queryAll(StudentVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getLimit());
        List<BusStudent> busStudents = stuMapper.queryAll(vo);
        return new DataGripView(page.getTotal(),busStudents);
    }

    @Override
    public void addStudent(StudentVo vo) {
        stuMapper.insert(vo);
    }

    @Override
    public void deleteByStuId(String studentId) {
        stuMapper.deleteByStuId(studentId);
    }

    @Override
    public void updateStudent(StudentVo vo) {
        vo.setStartTime(new Date());
        stuMapper.updateStudent(vo);
    }

    @Override
    public List<BusStudent> findAllStudents(StudentVo vo) {
        return stuMapper.queryAll(vo);
    }

    @Override
    public BusStudent queryByStudentId(String studentId) {
        return stuMapper.queryByStudentId(studentId);
    }
}
