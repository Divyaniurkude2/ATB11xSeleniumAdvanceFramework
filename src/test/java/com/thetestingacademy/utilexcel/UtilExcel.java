package com.thetestingacademy.utilexcel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel {

    static Workbook book;
    static Sheet sheet;

    public static String SHEET_PATH = System.getProperty("user.dir") + "/src/test/java/resources/TestData.xlsx" ;

    public static Object[][] gettestDataFromExcel(String sheetName) {
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(SHEET_PATH);
            book = WorkbookFactory.create(fileInputStream);
            sheet = book.getSheet(sheetName);
        } catch (IOException e) {
            System.out.println("Either file not found! or workbook not created!");
        }

        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

        for (int i =0 ; i< sheet.getLastRowNum(); i++) {
            for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        return data;
    }
}
