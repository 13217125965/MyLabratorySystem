package com.zhang.bus.utils;

import com.zhang.message.domain.BusStudent;
import com.zhang.message.utils.ExportHSSFCellStyle;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 客户数据库导出
 */
public class ExportStudentUtils {

    /**
     * 导出客户数据
     *
     * @param students
     * @param sheetName
     * @return
     */
    public static ByteArrayOutputStream exportStudent(List<BusStudent> students, String sheetName) {

        //1.组装excel文档
        //1.1创建工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();
        //1.2创建样式
        HSSFCellStyle baseStyle = ExportHSSFCellStyle.createBaseStyle(workbook);
        HSSFCellStyle subTitleStyle = ExportHSSFCellStyle.createSubTitleStyle(workbook);
        HSSFCellStyle tableTitleStyle = ExportHSSFCellStyle.createTableTitleStyle(workbook);
        HSSFCellStyle titleStyle = ExportHSSFCellStyle.createTitleStyle(workbook);
        //1.3在工作簿创建sheet
        HSSFSheet sheet = workbook.createSheet(sheetName);
        //1.4设置sheet
        sheet.setDefaultColumnWidth(25);
        //1.5合并
        CellRangeAddress region1 = new CellRangeAddress(0, 0, 0, 6);
        CellRangeAddress region2 = new CellRangeAddress(1, 1, 0, 6);
        sheet.addMergedRegion(region1);
        sheet.addMergedRegion(region2);
        //1.6.1创建第一行
        int index = 0;
        HSSFRow row1 = sheet.createRow(index);
        //1.6.2在第一行里面创建一个单元格
        HSSFCell row1_cell1 = row1.createCell(0);
        //1.6.3设置标题样式
        row1_cell1.setCellStyle(titleStyle);
        //1.6.4设置单元格内容
        row1_cell1.setCellValue("学生数据列表");

        //1.7.1第二行
        index++;
        HSSFRow row2 = sheet.createRow(index);
        //1.7.2在第一行里面创建一个单元格
        HSSFCell row2_cell1 = row2.createCell(0);
        //1.7.3设置标题样式
        row2_cell1.setCellStyle(subTitleStyle);
        //1.7.4设置单元格内容
        row2_cell1.setCellValue("总条数：" + students.size() + "   导出时间：" + new Date().toLocaleString());

        //1.8.1第三行
        String[] titles = {"学号", "姓名", "班级代号", "所属院系", "性别", "录入时间"};
        index++;
        HSSFRow row3 = sheet.createRow(index);
        for (int i = 0; i < titles.length; i++) {
            HSSFCell row3_cell = row3.createCell(i);
            row3_cell.setCellStyle(tableTitleStyle);
            row3_cell.setCellValue(titles[i]);
        }

        //1.9第四行
        for (int i = 0; i < students.size(); i++) {
            index++;
            BusStudent student = students.get(i);
            HSSFRow row = sheet.createRow(index);
            //1.9.1创建列学号
            HSSFCell row_identity = row.createCell(0);
            row_identity.setCellStyle(baseStyle);
            row_identity.setCellValue(student.getStudentid());
            //1.9.1创建列学生姓名
            HSSFCell row_custname = row.createCell(1);
            row_custname.setCellStyle(baseStyle);
            row_custname.setCellValue(student.getStuname());
            //1.9.1创建学生班级代号
            HSSFCell row_phone = row.createCell(2);
            row_phone.setCellStyle(baseStyle);
            row_phone.setCellValue(student.getStuclassid());
            //1.9.1创建学生所在院系
            HSSFCell row_address = row.createCell(3);
            row_address.setCellStyle(baseStyle);
            row_address.setCellValue(student.getDepartment());
            //1.9.1创建列客户性别
            HSSFCell row_sex = row.createCell(4);
            row_sex.setCellStyle(baseStyle);
            row_sex.setCellValue(student.getStusex() == 1 ? "男" : "女");
            //1.9.1创建列客户录入时间
            HSSFCell row_createtime = row.createCell(5);
            row_createtime.setCellStyle(baseStyle);
            row_createtime.setCellValue(student.getCreatetime().toLocaleString());
        }
        //到此excel组装完毕

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //把workbook里面的数据写到outputStream

        try {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return outputStream;

    }
}
