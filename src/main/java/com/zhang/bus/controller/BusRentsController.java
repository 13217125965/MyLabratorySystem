package com.zhang.bus.controller;

import com.zhang.bus.domain.BusRents;
import com.zhang.bus.service.BusRentsService;
import com.zhang.bus.utils.ExportRentUtils;
import com.zhang.bus.vo.RentsVo;
import com.zhang.message.domain.BusStudent;
import com.zhang.message.service.IStuService;
import com.zhang.sys.vo.DataGripView;
import com.zhang.sys.vo.ResultObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


/**
 * (BusRents)表控制层
 *
 * @author makejava
 * @since 2021-04-19 19:52:39
 */
@RestController
@RequestMapping("busRents")
public class BusRentsController {
    /**
     * 服务对象
     */
    @Autowired
    private BusRentsService busRentsService;

    @Autowired
    private IStuService iStuService;

    /**
     * 新增实验室借出单
     * @param rentsVo
     * @return
     */
    @RequestMapping("addRent")
    public ResultObject addRent(RentsVo rentsVo){
        try {
            busRentsService.addRent(rentsVo);
            return ResultObject.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.ADD_ERROR;
        }
    }

    /**
     * 查询所有借出单 条件查询, 及分页功能
     * @param rentsVo
     * @return
     */
    @RequestMapping("queryAllRent")
    public DataGripView queryAllRent(RentsVo rentsVo){
        DataGripView view = busRentsService.queryAllRent(rentsVo);
        return view;
    }

    /**
     * 修改借出单信息
     * @param rentsVo
     * @return
     */
    @RequestMapping("updateRent")
    public ResultObject updateRent(RentsVo rentsVo){
        try {
            busRentsService.updateRent(rentsVo);
            return ResultObject.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.UPDATE_ERROR;
        }
    }

    /**
     * 根据ID查询借出单
     * @param rentid
     * @return
     */
    @RequestMapping("queryRentId")
    public BusRents queryRentId(String rentid){
//        System.out.println(rentid);
        return busRentsService.queryById(rentid);
    }

    /**
     * 删除借出单信息
     * @param rentid
     * @return
     */
    @RequestMapping("deleteRentById")
    public ResultObject deleteRentById(String rentid){
        try {
            busRentsService.deleteById(rentid);
            return ResultObject.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObject.DELETE_ERROR;
        }
    }



    /**
     * 打印借出表Excel表格
     * @param rentsVo
     * @param response
     * @return
     */
    @RequestMapping("exportRent")
    public ResponseEntity<Object> exportCustomer(RentsVo rentsVo, HttpServletResponse response) {
//         查询学生信息
        BusStudent busStudent = iStuService.queryByStudentId(rentsVo.getStudentid());
//        查询借出表表信息
        BusRents busRents = busRentsService.queryById(rentsVo.getRentid());
//        使用工具类 将数据转换到流中准备后续输出
        ByteArrayOutputStream outputStream = ExportRentUtils.exportRent(busRents,busStudent,"借出单信息表");
//        设置文件名称
        String filename = "借出单信息表.xls";
        try {
//            设置表格编码 防止中文乱码
            filename = URLEncoder.encode(filename, "UTF-8");
//            设置下载表格 响应头名称
            HttpHeaders headers = new HttpHeaders();
//            封装响应内容
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//            设置文件的名称
            headers.setContentDispositionFormData("attachment", filename);
//            使用流将文件发送出去
            return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.CREATED);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
