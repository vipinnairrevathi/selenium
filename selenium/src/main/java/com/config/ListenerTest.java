package com.config;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener{
	
	public static Log log;
	
	
public ListenerTest() {
	log = new  Log();
}
			

public void onTestStart(ITestResult result) {
		
	log.entry("New "+result.getName()+" test started" );
		
	}
	
	public void onTestSuccess(ITestResult result) {
		
		log.entry(result.getName() +" test Successfully Finished ");
		
	}
 
	public void onTestFailure(ITestResult result) {
		log.entry("Test Failed " +result.getName());
		
	}
 
	public void onTestSkipped(ITestResult result) {
		log.entry("Test Skipped " +result.getName());
		
	}
 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.entry("Test Failed but within success percentage " +result.getName());
		
	}
 
	public void onStart(ITestContext context) {
		//log = VscBase.log;
		
	}
 
	public void onFinish(ITestContext context) {
	//	log.entry("This is on Finish method " +context.getPassedTests());
	}
}