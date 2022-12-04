package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ReadExcelDemo {


    public static void main(String[] args) {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/dataprovider/TestData.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(PropertiesReaderUtils.getFieldValue("sheetName"));

            for (Row row : sheet) {
                for (int cn = 0; cn < row.getLastCellNum(); cn++) {
                    Cell cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.printf("%-50s", cell.getNumericCellValue());
                            break;
                        case STRING:
                        case BLANK:
                            System.out.printf("%-50s", cell.getStringCellValue());
                            break;
                    }
                }
                System.out.println("");
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

