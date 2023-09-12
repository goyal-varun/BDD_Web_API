package com.hcl.baseframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	// Constructor to connect to the Excel with sheetname and Path
	/*
	 * public ExcelUtils(String Path, String SheetName) throws IOException {
	 * 
	 * 
	 * }
	 */
	public static String getExcelData(String SheetName, String WarningMessage) throws IOException {

		FileInputStream ExcelFile = new FileInputStream("WarningMessages.xlsx");

		// Access the required test data sheet
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		XSSFSheet ExcelWSheet = ExcelWBook.getSheet(SheetName);
		//System.out.println(ExcelWSheet.getPhysicalNumberOfRows());
		//int rowcount = ExcelWSheet.getPhysicalNumberOfRows();
		String warningMessageValue = null;
		Iterator<Row> rows = ExcelWSheet.iterator(); // sheet is collection of rows
		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();// row is collection of cells
			while (cells.hasNext()) {
				Cell value = cells.next();
				if (value.getStringCellValue().trim().equalsIgnoreCase(WarningMessage)) {
					value = cells.next();
					warningMessageValue =  value.getStringCellValue();
				}
			}
		}
		ExcelWBook.close();
		return warningMessageValue;

	}
}
