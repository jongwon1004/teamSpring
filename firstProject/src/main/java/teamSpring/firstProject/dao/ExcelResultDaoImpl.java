package teamSpring.firstProject.dao;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import teamSpring.firstProject.domain.ExcelResult;

import java.io.FileOutputStream;
import java.util.List;

public class ExcelResultDaoImpl {

    public void createExcel(List<ExcelResult> excelResultList) throws Exception {
        System.out.println("excelResultList = " + excelResultList);

        Workbook wb = new XSSFWorkbook();
        Sheet departmentSheet = wb.createSheet("ExcelResult");

        // 셀 스타일 생성 - 컬럼명 스타일
        CellStyle columnCellStyle = wb.createCellStyle();
        columnCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        columnCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font columnFont = wb.createFont();
        columnFont.setBold(true);


        Row departmentHeader = departmentSheet.createRow(0);
        departmentHeader.createCell(0).setCellValue("authority");
        departmentHeader.createCell(1).setCellValue("employeeId");
        departmentHeader.createCell(2).setCellValue("employeeName");
        departmentHeader.createCell(3).setCellValue("safety");
        departmentHeader.createCell(4).setCellValue("reportDate");
        departmentHeader.createCell(5).setCellValue("disasterId");
        departmentHeader.createCell(6).setCellValue("injury");
        departmentHeader.createCell(7).setCellValue("work");
        departmentHeader.createCell(8).setCellValue("otherInfo");
        departmentHeader.createCell(9).setCellValue("cellphone");
        int ExcelResultRowCount = 1;
        for (ExcelResult excelResult : excelResultList) {
            Row row = departmentSheet.createRow(ExcelResultRowCount++);
            row.createCell(0).setCellValue(excelResult.getAuthority());
            row.createCell(1).setCellValue(excelResult.getEmployeeId() != null ? excelResult.getEmployeeId() : 0);
            row.createCell(2).setCellValue(excelResult.getEmployeeName());
            row.createCell(3).setCellValue(excelResult.getSafety() == null? "未登録" : (excelResult.getSafety().equals("o")) ? "安全" :"危険");
            row.createCell(4).setCellValue(String.valueOf((excelResult.getReportDate() != null ? excelResult.getReportDate() : "null")));
            row.createCell(5).setCellValue(excelResult.getDisasterId() != null ? excelResult.getDisasterId() : 0);
            row.createCell(6).setCellValue(excelResult.getInjury());
            row.createCell(7).setCellValue(excelResult.getWork());
            row.createCell(8).setCellValue(excelResult.getOtherInfo());
            row.createCell(9).setCellValue(excelResult.getCellphone());
        }

        for (int columnIndex = 0; columnIndex < departmentHeader.getLastCellNum(); columnIndex++) {
            Cell cell = departmentHeader.getCell(columnIndex);
            cell.setCellStyle(columnCellStyle);
        }


        for (int columnIndex = 0; columnIndex < departmentHeader.getLastCellNum(); columnIndex++) {
            departmentSheet.autoSizeColumn(columnIndex);
        }



        // excelファイルをセーブする
        FileOutputStream fileOut = new FileOutputStream("output.xlsx");
        wb.write(fileOut);
        fileOut.close();
        wb.close();
    }
}
