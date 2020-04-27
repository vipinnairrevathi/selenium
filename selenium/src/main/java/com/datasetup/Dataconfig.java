package com.datasetup;



import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class Dataconfig {



	//This method return all the testdata details from the given sheet
	@DataProvider(name = "LoginTest")
	public Object[][] dataSupplier()  {
		String datafile = "amazon.xlsx";
		String sheetName = "LoginScenario";
		ExcelDataConfig dataconfig = new ExcelDataConfig(datafile);
		int lastRowNum = dataconfig.rowcount(sheetName);
		int lastCellNum = dataconfig.lastcellno(0,0);
		Object[][] obj = new Object[lastRowNum-1][1];
		for (int i = 1; i < lastRowNum; i++) {
			Map<Object, Object> datamap = new HashMap<>();
			for (int j = 0; j < lastCellNum; j++) {
				datamap.put( dataconfig.getData(sheetName, 0, j), dataconfig.getData(sheetName, i, j));
			}
			obj[i-1][0] = datamap;
		}
		return  obj;

	}




	public Object[][] datsetup(String datafile,String sheetName,String TestcaseName)  {

		ExcelDataConfig dataConfig = new ExcelDataConfig(datafile);
		Map<Integer, Integer> rowdetails = new HashMap<>();
		rowdetails = dataConfig.getrowNo(sheetName, TestcaseName);
		Object[][] obj = new Object[rowdetails.size()][1];
		int lastCellNum = dataConfig.lastcellno(sheetName,0);
		for (int i = 0; i < rowdetails.size(); i++) 
		{
			Map<Object, Object> datamap = new HashMap<>();
			for (int j = 0; j < lastCellNum; j++) {
				datamap.put( dataConfig.getData(sheetName, 0, j), dataConfig.getData(sheetName, rowdetails.get(i), j));
			}
			obj[i][0] = datamap;
		}
		return  obj;

	}

	public int datasize(String datafile,String sheetName,String TestcaseName) {

		ExcelDataConfig dataConfig = new ExcelDataConfig(datafile);
		Map<Integer, Integer> rowdetails = new HashMap<>();
		rowdetails = dataConfig.getrowNo(sheetName, TestcaseName);

		return rowdetails.size();

	}


	public Object[][] datsetup(String datafile,String sheetName)  {
		ExcelDataConfig dataconfig = new ExcelDataConfig(datafile);
		int lastRowNum = dataconfig.rowcount(sheetName);
		int lastCellNum = dataconfig.lastcellno(0,0);
		Object[][] obj = new Object[lastRowNum-1][1];
		for (int i = 1; i < lastRowNum; i++) {
			Map<Object, Object> datamap = new HashMap<>();
			for (int j = 0; j < lastCellNum; j++) {
				datamap.put( dataconfig.getData(sheetName, 0, j), dataconfig.getData(sheetName, i, j));
			}
			obj[i-1][0] = datamap;
		}
		return  obj;


	}

	public int datasize(String datafile,String sheetName) {

		ExcelDataConfig dataconfig = new ExcelDataConfig(datafile);
		int lastRowNum = dataconfig.rowcount(sheetName);
		lastRowNum = lastRowNum-1;

		return lastRowNum;

	}


	public Object[][] datsetup(String datafile,String sheetName,int slno){
		ExcelDataConfig dataconfig = new ExcelDataConfig(datafile);
		// update serial number of testcase
		Object[][] obj = new Object[1][1];
		int lastCellNum = dataconfig.lastcellno(0,0);
		Map<Object, Object> datamap = new HashMap<>();
		for (int j = 0; j < lastCellNum; j++) {
			datamap.put( dataconfig.getData(sheetName, 0, j), dataconfig.getData(sheetName,slno-1 , j));
		}
		obj[0][0] = datamap;
		return  obj;
	}
}














