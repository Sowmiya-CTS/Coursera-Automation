package util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static String[] value=new String[3];

    public String[] readExcelData() throws IOException {
        
        FileInputStream file = new FileInputStream("data.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        XSSFRow row = sheet.getRow(1);

        for (int col = 0; col < 3; col++) {
            XSSFCell cell= row.getCell(col);
            value[col] = cell.toString();
            
        } 
            
        wb.close();
        file.close();

        return value;
    }

    
}
