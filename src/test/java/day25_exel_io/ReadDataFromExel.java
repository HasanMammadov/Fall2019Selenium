package day25_exel_io;

import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ReadDataFromExel {

    @Test
    public void readExcelFileTest() throws Exception{
        //we need to get a file as an object
        File file = new File("VytrackTestUsers.xlsx");
        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();

        String secondCellValue = firstRow.getCell(1).getStringCellValue();


        System.out.println(value);
        System.out.println(secondCellValue);
        System.out.println("#########################");

        int lastCell = firstRow.getLastCellNum();

        for (int i = 0; i <lastCell ; i++) {
            System.out.print(firstRow.getCell(i)+" | ");
        }

        System.out.println();
        //index of last row
        int indexOfLastRow = workSheet.getLastRowNum();
        System.out.println("indexOfLastRow = " + indexOfLastRow);
        //total how many rows
        int numberOfRows = workSheet.getPhysicalNumberOfRows();
        System.out.println("numberOfRows = " + numberOfRows);


        for (int row = 0; row < workSheet.getPhysicalNumberOfRows(); row++) {
            for (int cell = 0; cell < workSheet.getRow(row).getLastCellNum(); cell++) {
                String cellValue = workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue + " | ");
            }
            System.out.println();
        }

    }
    @Test
    public void exelUtilityTest(){
        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-all";
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);

       // excelUtil.getDataList().forEach(System.out::println);

        for (Map<String, String>record:excelUtil.getDataList()) {
            System.out.println(record);
        }

    }

    @Test
    public void getColumnNamesTest(){

        String path = "VytrackTestUsers.xlsx";
        String spreadSheet = "QA1-short";
        ExcelUtil excelUtil = new ExcelUtil(path,spreadSheet);

        System.out.println(excelUtil.getColumnsNames());
    }
}
