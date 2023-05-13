package teamSpring.firstProject.dao;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import teamSpring.firstProject.domain.ExcelResult;

import java.io.FileOutputStream;
import java.util.List;

public class ExcelResultDaoImpl {

    public void createExcel(List<ExcelResult> excelResultList) throws Exception {
        System.out.println("excelResultList = " + excelResultList);

        Workbook wb = new XSSFWorkbook();

        Sheet departmentSheet = wb.createSheet("ExcelResult");
        Row departmentHeader = departmentSheet.createRow(0);
        departmentHeader.createCell(0).setCellValue("authority");
        departmentHeader.createCell(1).setCellValue("employeeId");
        departmentHeader.createCell(2).setCellValue("employeeName");
        departmentHeader.createCell(3).setCellValue("safety");
        departmentHeader.createCell(4).setCellValue("reportDate");
        departmentHeader.createCell(5).setCellValue("disasterId");
        int ExcelResultRowCount = 1;
        for (ExcelResult excelResult : excelResultList) {
            Row row = departmentSheet.createRow(ExcelResultRowCount++);
            row.createCell(0).setCellValue(excelResult.getAuthority());
            row.createCell(1).setCellValue(excelResult.getEmployeeId() != null ? excelResult.getEmployeeId() : 0);
            row.createCell(2).setCellValue(excelResult.getEmployeeName());
            row.createCell(3).setCellValue(excelResult.getSafety());
            row.createCell(4).setCellValue(String.valueOf((excelResult.getReportDate() != null ? excelResult.getReportDate() : "null")));
            row.createCell(5).setCellValue(excelResult.getDisasterId() != null ? excelResult.getDisasterId() : 0);
        }


        // excelファイルをセーブする
        FileOutputStream fileOut = new FileOutputStream("output.xlsx");
        wb.write(fileOut);
        fileOut.close();
        wb.close();
    }
}
