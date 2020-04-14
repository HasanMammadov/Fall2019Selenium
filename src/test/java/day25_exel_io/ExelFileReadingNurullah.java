package day25_exel_io;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExelFileReadingNurullah {

@Test
    public void testCase() throws IOException {
        // bize exel fyl path lazimdi. hansi fayli oxumaq isteyirik
        String filePath ="Countries.xlsx";
        FileInputStream byteCodeExelFile = new FileInputStream(filePath);
        //2. we need our workbook. exel file ile work booku elaqelendririk
        Workbook workbook =  WorkbookFactory.create(byteCodeExelFile);

        // exeldeki sheet lazimdi bize.
        Sheet workSheet = workbook.getSheet("Countries");


        Cell cell;
        cell = workSheet.getRow(0).getCell(0);
        System.out.println(cell.toString());

        Cell cell2 =  workSheet.getRow(0).getCell(1);

    System.out.println(cell2.toString());
    }

}
