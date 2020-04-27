package com.datasetup;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	Workbook Wb;
	Sheet sheet1;


	public ExcelDataConfig(String fileName)    {
		String filePath = System.getProperty("user.dir")+"\\datafile\\";
		String file =    filePath+"\\"+fileName;
		File f =    new File(file);
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(f);
			String fileExtensionName = fileName.substring(fileName.indexOf("."));
			if(fileExtensionName.equals(".xlsx")){
				Wb = new XSSFWorkbook(inputStream);}
			else if(fileExtensionName.equals(".xls")){
				Wb = new HSSFWorkbook(inputStream);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getData(int sheetno,int rowno , int columno) {

		sheet1 = Wb.getSheetAt(sheetno);
		DataFormatter formatter = new DataFormatter();

		String data = formatter.formatCellValue(sheet1.getRow(rowno).getCell(columno));
		
		return data;

	}

	public String getData(String sheetname,int rowno , int columno) {

		sheet1 = Wb.getSheet(sheetname);
		DataFormatter formatter = new DataFormatter();

		String data = formatter.formatCellValue(sheet1.getRow(rowno).getCell(columno));
		return data;

	}


	public int rowcount(int sheetIndex) {

		int row = Wb.getSheetAt(sheetIndex).getLastRowNum();
		return row;
	}

	public int rowcount(String sheetName) {

		int row = Wb.getSheet(sheetName).getLastRowNum();
		return row;
	}

	public int lastcellno(int sheetno,int rowno) {
		sheet1 = Wb.getSheetAt(sheetno);
		int lastCellNum = sheet1.getRow(rowno).getLastCellNum();
		return lastCellNum;
	}

	public int lastcellno(String sheetName,int rowno) {
		sheet1 = Wb.getSheet(sheetName);
		int lastCellNum = sheet1.getRow(rowno).getLastCellNum();
		return lastCellNum;
	}

	//This method is used to identify row number of testcase.
	public  Map<Integer, Integer> getrowNo(int sheetNo,String testcaseName) {

		Map<Integer, Integer> datamap = new HashMap<>();
		int Totalrowcount = Wb.getSheetAt(sheetNo).getLastRowNum();
		int key =0;
		sheet1 = Wb.getSheetAt(sheetNo);

		for (int i = 0; i < Totalrowcount; i++) {

			DataFormatter formatter = new DataFormatter();

			String ExcelTestName = formatter.formatCellValue(sheet1.getRow(i+1).getCell(0));
			if(ExcelTestName.equalsIgnoreCase(testcaseName)) 
			{
				int value = i+1;
				datamap.put(key, value);
				key=key+1;
			}
		}

		return datamap;

	}

	//This method is used to identify row number of testcase.
	public  Map<Integer, Integer> getrowNo(String sheetName,String testcaseName) {

		Map<Integer, Integer> rowdata = new HashMap<>();
		sheet1 = Wb.getSheet(sheetName);
		int Totalrowcount = sheet1.getLastRowNum();
		int key =0;

		for (int i = 0; i < Totalrowcount; i++) {

			DataFormatter formatter = new DataFormatter();

			String ExcelTestName = formatter.formatCellValue(sheet1.getRow(i+1).getCell(0));

			if(ExcelTestName.equalsIgnoreCase(testcaseName)) 
			{
				int value = i+1;
				rowdata.put(key, value);
				key=key+1;
			}
		}

		return rowdata;

	}


}
