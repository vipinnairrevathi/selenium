package vsc.testData;

import org.testng.annotations.DataProvider;

import com.datasetup.Dataconfig;

public class LoginData extends Dataconfig {
	
	
	@DataProvider(name = "LoginTcName")
	public Object[][] LoginTcName()  {
		
		String datafile = "amazon.xlsx";
		String sheetName = "LoginScenario";
		String TestcaseName = "Login";
		Dataconfig dataconfig = new Dataconfig();
		int dataSize = dataconfig.datasize(datafile, sheetName, TestcaseName);
		Object[][] data = new Object[dataSize][1];
		data = dataconfig.datsetup(datafile, sheetName, TestcaseName);
	
	return data;
	}
	
	@DataProvider(name = "LoginAllData")
	public Object[][] LoginAllData()  {
		
		String datafile = "amazon.xlsx";
		String sheetName = "LoginScenario";
		Dataconfig dataconfig = new Dataconfig();
		int dataSize = dataconfig.datasize(datafile, sheetName);
		Object[][] data = new Object[dataSize][1];
		data = dataconfig.datsetup(datafile, sheetName);
	
	return data;
	}

	@DataProvider(name = "Loginslno")
	public Object[][] Loginslno()  {
		
		String datafile = "amazon.xlsx";
		String sheetName = "LoginScenario";
		int rowslno = 3;
		Dataconfig dataconfig = new Dataconfig();
		
		Object[][] data = new Object[1][1];
		data = dataconfig.datsetup(datafile, sheetName,rowslno);
	
	return data;
	}

}
