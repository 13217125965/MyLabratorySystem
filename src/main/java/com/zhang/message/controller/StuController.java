package com.zhang.message.controller;

import com.zhang.message.domain.BusStudent;
import com.zhang.message.service.IStuService;
import com.zhang.message.utils.ExportStudentUtils;
import com.zhang.message.vo.StudentVo;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * 学生控制层
 */
@RestController
@RequestMapping("messStudent")
public class StuController {
    /**
     * 服务对象
     */
    @Autowired
    private IStuService stuService;

    /**
     * 查询所有的学生信息  分页  和  搜索功能
     * @param vo
     * @return
     */
    @RequestMapping("findAllStudent")
    public DataGripView findAllStudent(StudentVo vo){
        return stuService.queryAll(vo);
    }

    /**
     * 根据学号查询学生信息
     * @param studentId
     * @return
     */
    @GetMapping("findByStudentId")
    public ResultObject queryByStudentId(String studentId){
        BusStudent busStudent = stuService.queryByStudentId(studentId);
        if (busStudent != null){
            return ResultObject.SELECT_SUCCESS;
        }else{
            return ResultObject.SELECT_ERROR;
        }
    }

    /**
     * 添加学生信息
     * @param vo
     */
    @RequestMapping("saveStudent")
    public ResultObject saveStudent(StudentVo vo){
        try {
            stuService.addStudent(vo);
            return ResultObject.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.ADD_ERROR;
        }
    }
    /**
     * 根据学号删除对应学生信息
     * @param studentId
     */
    @RequestMapping("deleteStudent")
    public ResultObject deleteByStudentId(String studentId){
        try {
            if (studentId != null) {
                stuService.deleteByStuId(studentId);
                return ResultObject.DELETE_SUCCESS;
            }else{
                return ResultObject.DELETE_ERROR;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 批量删除
     * @param vo
     * @return
     */
    @RequestMapping("deleteStudentBatch")
    public ResultObject deleteStudentBatch(StudentVo vo){
        try{
            for (String studentId : vo.getStudentids()) {
                stuService.deleteByStuId(studentId);
            }
            return ResultObject.DELETE_SUCCESS;
        }catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }

    /**
     * 修改学生信息
     * @param vo
     * @return
     */
    @PostMapping("updateStudent")
    public ResultObject updateStudent(StudentVo vo){
        System.out.println(vo);
        try {
            stuService.updateStudent(vo);
            return ResultObject.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.UPDATE_ERROR;
        }
    }

    /**
     * 导出学生列表
     * @param vo
     * @param response
     * @return
     */
    @RequestMapping("exportStudent")
    public ResponseEntity<Object> exportStudent(StudentVo vo, HttpServletResponse response){
        //查询学生列表信息
        List<BusStudent> allStudents = stuService.findAllStudents(vo);
        //实用工具类将数据装换到流中准备后续输出
        ByteArrayOutputStream outputStream = ExportStudentUtils.exportStudent(allStudents, "学生信息表");
        //设置文件名称
        String fileName = "学生信息表.xls";
        try{
//            设置表格编码 防止中文乱码
            fileName = URLEncoder.encode(fileName,"UTF-8");
//            设置下载表格 响应头名称
            HttpHeaders headers = new HttpHeaders();
//            封装响应内容
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//            设置文件的名称
            headers.setContentDispositionFormData("attachment", fileName);
//            使用流将文件发送出去
            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.CREATED);

        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return null;
    }

}
