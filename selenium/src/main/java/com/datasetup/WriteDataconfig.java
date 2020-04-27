package com.datasetup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataconfig {
	
	public static void main(String...strings) throws IOException{
		WriteDataconfig x = new WriteDataconfig();
		x.readexcel();

    }	
	
	public Map<String, String> readexcel() throws IOException{
		WriteDataconfig config = new WriteDataconfig();
		  File f =    new File(config.filepath());
		    FileInputStream inputStream = new FileInputStream(f);
		    Workbook Workbook = null;
		    String fileExtensionName = config.filepath().substring(config.filepath().indexOf("."));
		    if(fileExtensionName.equals(".xlsx"))
		    {
		    	Workbook = new XSSFWorkbook(inputStream);
		    }
		    	else if(fileExtensionName.equals(".xls"))
		    {
		        Workbook = new HSSFWorkbook(inputStream);
		    }
			Map<String, String> testCases =new HashedMap<>();
		    Sheet Sheet = Workbook.getSheet("LoginScenario");
		    int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum();
		    Row row;
		
		    Map<String, Row> testCasesName =new HashedMap<>();
		    
			  for (int i =1; i <= rowCount; i++) {
			        row = Sheet.getRow(i);	
			        DataFormatter formatter = new DataFormatter();
		        	String testcaseName = formatter.formatCellValue(row.getCell(0));
		        	String rows ;
		        	testCasesName.put(testcaseName, row); 
			        
			        
			        
			        
			        
			        
//			        for (int j = 0; j < row.getLastCellNum(); j++) {
//			        	DataFormatter formatter = new DataFormatter();
//			        	String key = formatter.formatCellValue(Sheet.getRow(0).getCell(j));
//			        	String value = formatter.formatCellValue(row.getCell(j));
//			        	testCases.put(key, value);
//			        }
			  }
			  for (Entry<String, Row> entry : testCasesName.entrySet())  
	                 System.out.println("Key = " + entry.getKey() + 
	                                  ", Value = " + entry.getValue());
			  
		return testCases;
	}

	 public String filepath() {
		    String filePath = System.getProperty("user.dir")+"\\datafile\\";
		    String fileName = "amazon.xlsx";
		    String sheetname = "LoginScenario";
		    String file =    filePath+"\\"+fileName;
		     return file ;
		   
	}
	 
	 
}
