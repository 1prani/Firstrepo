package com.actitime.genricLib;

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileLibb1 {

	public String readExcelData(String excelPath, String sheetName, int row, int cell) throws Throwable {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);

		String excelValue = wb.getSheet(sheetName).getRow(row).getCell(cell).toString();

		return excelValue;

	}

	public int getRowCount(String excelPath, String sheetName) throws Throwable {

		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		return rowCount;

	}

	public void writeExcelData(String excelPath, String sheetName, int row, int cell, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(data);

		FileOutputStream fos = new FileOutputStream(excelPath);
		wb.write(fos);

	}

	public String readPropertyData(String propPath, String key) throws Throwable {
		FileInputStream fis = new FileInputStream(propPath);
		Properties prop = new Properties();
		prop.load(fis);

		String propValue = prop.getProperty(key, "Incorrect Key");
		return propValue;

	}

}
