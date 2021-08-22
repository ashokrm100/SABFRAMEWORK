package com.SAB.GenerUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	static FileInputStream fis;
	static XSSFWorkbook excel;
	static XSSFSheet sheet;
	String path;
	
	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRow(String sheetName) throws Exception {

		fis = new FileInputStream(path);
		excel = new XSSFWorkbook(fis);
		sheet = excel.getSheet(sheetName);
		int rownum = sheet.getLastRowNum();
		excel.close();
		fis.close();
		return rownum;
	}

	public int getColNum(String sheetName, int rownum) throws Exception {
		fis = new FileInputStream(path);
		excel = new XSSFWorkbook(fis);
		sheet = excel.getSheet(sheetName);
		int colnum = sheet.getRow(rownum).getLastCellNum();
		excel.close();
		fis.close();
		return colnum;
	}

	public String getCellData(String sheetName, int rowcnt, int colcnt) throws Exception {
		fis = new FileInputStream(path);
		excel = new XSSFWorkbook(fis);
		sheet = excel.getSheet(sheetName);
		String data = sheet.getRow(rowcnt).getCell(colcnt).toString();
		excel.close();
		fis.close();
		return data;

	}

}
