package com.qa.utils;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelUtility {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	public static void setExcelFile(String Path, String SheetName) throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {
			throw (e);
		}
	}

	public static String getCellData(int rowNum, int colNum) throws Exception {
		String cellData = "";
		try {
			Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
			if (Cell.getStringCellValue() != "")
				cellData = Cell.getStringCellValue();
			return cellData;
		} catch (Exception e) {

			return "";

		}
	}
}