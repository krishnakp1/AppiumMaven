package utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelDataProvider {

    XSSFWorkbook wb;
    public ExcelDataProvider() {
        File src = new File("./TestData/Data.xlsx");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println("Unable to read excel file "+e.getMessage());
        }
    }

    public String getStringData(int sheetIndex, int row, int column) {
        return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
    }

    public String getStringData(String sheetName, int row, int column) {
        return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
    }

    public double getStringNumericData(String sheetName, int row, int column) {
        return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
    }
}
