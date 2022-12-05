package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.*;

public class ExcelReaderUtils {

    public static List<Map<String,String>> readSheet(String sheetName){
        List<Map<String ,String>> mapList = new ArrayList<>();
        try {
            FileInputStream file = new FileInputStream(PropertiesReaderUtils.getFieldValue("dataproviderlocation")+"/"+PropertiesReaderUtils.getFieldValue("dataproviderfile"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            Row headingRow = sheet.getRow(0);
            for (Row row : sheet) {
                Map<String,String> map = new HashMap<>();
                for (int cn = 0; cn < row.getLastCellNum(); cn++) {
                    Cell cell = row.getCell(cn, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String cellValue="";
                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.printf("%-50s", cell.getNumericCellValue());
                            cellValue = String.valueOf(cell.getNumericCellValue());
                            break;
                        case STRING:
                        case BLANK:
                            System.out.printf("%-50s", cell.getStringCellValue());
                            cellValue = cell.getStringCellValue();
                            break;
                    }
                    if(!row.equals(headingRow)){
                        map.put(headingRow.getCell(cn,Row.MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue().trim(),cellValue.trim());
                    }
                }
                System.out.println("");
                if(!map.isEmpty()) mapList.add(map);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapList;
    }
}
