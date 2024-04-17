package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class ReadExcelFile {
	
	public static FileInputStream fileinputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String fileName, String sheetName){
		
		try {
			fileinputstream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			workbook = new XSSFWorkbook(fileinputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sheet = workbook.getSheet(sheetName);
		
		int totalRowCount = sheet.getLastRowNum()+1;
		
		return totalRowCount;
		
		
	}
	
	
	public static int getColumnCount(String fileName, String sheetName) {
		
		try {
			fileinputstream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			workbook = new XSSFWorkbook(fileinputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sheet = workbook.getSheet(sheetName);
		
		int totalColumncount = sheet.getRow(0).getLastCellNum();
		
		return totalColumncount;
		
		
	}
	
	
	public static String getCellValue(String fileName, String sheetName, int rowCount, int columnCount) {
		
		
		try {
			fileinputstream = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			workbook = new XSSFWorkbook(fileinputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		cell = sheet.getRow(rowCount).getCell(columnCount);
		
		return "";
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
