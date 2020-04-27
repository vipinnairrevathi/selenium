package com.config;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.utilities.Utility;



public class Action {

	public static WebDriver driver;
	public static Utility screenshot ;
	public static Log log;
	ConfigSuppoter cs = new ConfigSuppoter("config.properties");


	public Action() {

		driver = VscBase.driver;
		log = VscBase.log;
	}

	public String screenshot()
	{
		screenshot = new Utility();	 
		return screenshot.getscreenshot(driver);
	}

	public void navigateToApplication() {

		String url = cs.getproperty("url");
		try {
			driver.get(url);
			log.entry("Navigate to the url: "+url);
			VscBase.childTest.pass("Sucessfully launched"+url);
		}catch(Exception e){
			VscBase.childTest.fail("Unable to navigate to the application"+ url);

		}
	}

	public void click(By locator, String eleName) throws Exception   
	{
		try {
			driver.findElement(locator).click();
			log.entry("Perform click action on "+eleName);
			VscBase.childTest.pass("Performed click action on : " +eleName);
		}catch( Exception e) {
			VscBase.childTest.fail("Unable to perform click action on : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			VscBase.childTest.info(e);
			throw e;
		}
	}

	public void type(By locator, String eleName,String testdata) throws Exception   
	{
		try {
			driver.findElement(locator).sendKeys(testdata);
			log.entry("Performed a type action on : " +eleName+ " as "+testdata);
			VscBase.childTest.pass("Performed a type action on : " +eleName+" as "+testdata);
		}catch( Exception e) {

			VscBase.childTest.fail("Unable to perform type action on : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			VscBase.childTest.info("Error Log :"+e);
			throw e;
		}
	}

	public void clear(By locator, String eleName) throws Exception   
	{
		try {
			driver.findElement(locator).clear();
			log.entry("Removed content from the Text field : " +eleName);
			VscBase.childTest.pass("Removed content from the Text field : " +eleName);
		}catch( Exception e) {

			VscBase.childTest.fail("Unable to remove content from the Text field : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			VscBase.childTest.info(e);
			throw e;
		}
	}

	public void submit(By locator, String eleName) throws Exception   
	{
		try {
			driver.findElement(locator).submit();
			log.entry("Perform submit action on the element " +eleName);
			VscBase.childTest.pass("Perform submit action on the element " +eleName);
		}catch( Exception e) {

			VscBase.childTest.fail("Unable to perform submit action on the element : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			VscBase.childTest.info(e);
			throw e;
		}
	}


	public String getText(By locator, String eleName) throws Exception   
	{
		String text = null;
		try {
			text = driver.findElement(locator).getText();
			log.entry("Read text value of element : " +eleName);
			VscBase.childTest.pass("Read text value of element : " +eleName);

		}catch( Exception e) {
			VscBase.childTest.fail("Unable to read text value of element : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}
		return text;
	}

	public boolean displayed(By locator, String eleName) throws Exception   
	{
		try {
			if(driver.findElement(locator).isDisplayed()){
			log.entry(eleName + ": is displaying on the page " );
			VscBase.childTest.pass(eleName + ": is displaying on the page " );
			return true;
		}else {
//			log.entry(eleName + ": is displaying on the page " );
//			VscBase.childTest.pass(eleName + ": is not displayed on the page " );
			return false;
		}
		}catch( Exception e) {
			//VscBase.childTest.fail(eleName + ": is not displayed on the page " , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			return false;

		}
       
	}

	public boolean enabled(By locator, String eleName) throws Exception   
	{
		try {
			driver.findElement(locator).isEnabled();
			VscBase.childTest.pass(eleName + ": element is Enabled on the page " );
			return true;
		}catch( Exception e) {
			VscBase.childTest.fail(eleName + ": element is not Enabled on the page " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			return false;
		}


	}

	public boolean selected(By locator, String eleName) throws Exception   
	{
		try {
			driver.findElement(locator).isSelected();
			VscBase.childTest.pass(eleName + ": element is selected on the page " );
			return true;
		}catch(Exception e){
			VscBase.childTest.fail(eleName + ": element is not Enabled on the page " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
			return false;

		}

	}
	public void doubleclick(By locator, String eleName) throws Exception   
	{
		try {
			WebElement element = driver.findElement(locator);
			Actions action = new Actions(driver);
			action.doubleClick(element).build().perform();
			VscBase.childTest.pass("Perform double click action on element : " + eleName);

		}catch(Exception e){
			VscBase.childTest.fail("Unable to Perform double click action on element : " + eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());


		}

	}

	public void rightclick(By locator, String eleName) throws Exception   
	{
		try {
			WebElement element = driver.findElement(locator);
			Actions action = new Actions(driver);
			action.contextClick(element).build().perform();
			VscBase.childTest.pass("Perform right click action on element : " + eleName);

		}catch(Exception e){
			VscBase.childTest.fail("Unable to Perform right click action on element : " + eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());


		}

	}

	public void moveToElement(By locator, String eleName) throws Exception   
	{
		try {
			WebElement element = driver.findElement(locator);
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			VscBase.childTest.pass("Perform move to element action on  : " + eleName);

		}catch(Exception e){
			VscBase.childTest.fail("Unable to perform move to elemnt action on  : " + eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());


		}

	}

	public void moveToElement(By locator, String eleName,int xOffset,int yOffset ) throws Exception   
	{
		try {
			WebElement element = driver.findElement(locator);
			Actions action = new Actions(driver);
			action.moveToElement(element, xOffset, yOffset).build().perform();
			VscBase.childTest.pass("Perform move to element action on  : " + eleName);

		}catch(Exception e){
			VscBase.childTest.fail("Unable to perform move to elemnt action on  : " + eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
		}

	}

	public void moveToElement( String eleName,int xOffset,int yOffset ) throws Exception   
	{
		try {
			Actions action = new Actions(driver);
			action.moveByOffset(xOffset, yOffset).build().perform();
			VscBase.childTest.pass("Perform move to element action on  : " + eleName);

		}catch(Exception e){
			VscBase.childTest.fail("Unable to perform move to elemnt action on  : " + eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
		}

	}

	public void clickAndHold( By locator, String eleName ) throws Exception   
	{
		try {
			WebElement element = driver.findElement(locator);
			Actions action = new Actions(driver);
			action.clickAndHold(element).build().perform();
			VscBase.childTest.pass("Perform click and hold action on  : " + eleName);

		}catch(Exception e){
			VscBase.childTest.fail("Unable to perform  click and hold action on  : " + eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
		}

	}

	public void dragAndDrop( By frmElemnt,By toElemnt, String fromEleName ,String toEleName ) throws Exception   
	{
		try {
			WebElement fromElement = driver.findElement(frmElemnt);
			WebElement toElement = driver.findElement(toElemnt);
			Actions action = new Actions(driver);
			action.dragAndDrop(fromElement,toElement).build().perform(); 
			VscBase.childTest.pass("Perform drag and drop action from : " + fromEleName +" to " + toEleName);

		}catch(Exception e){
			VscBase.childTest.fail("Unable to perform drag and drop action from : " + fromEleName +" to " + toEleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());
		}

	}


	public void dropdown(By locator,String value, String eleName) throws Exception   
	{
		try {
			WebElement element = driver.findElement(locator);
			Select drpdown = new Select(element);
			drpdown.selectByValue(value);
			VscBase.childTest.pass("dropdown value is set as " +value + " on : " + eleName );

		}catch(Exception e){
			VscBase.childTest.fail("Unable to set dropdown value on  element : " + eleName +" as " + value , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());


		}

	}

	public void dropdown(By locator,int index, String eleName) throws Exception   
	{
		try {
			WebElement element = driver.findElement(locator);
			Select drpdown = new Select(element);
			drpdown.selectByIndex(index);
			VscBase.childTest.pass("dropdown value is selected on : " + eleName +" as "+index);

		}catch(Exception e){
			VscBase.childTest.fail("Unable to set dropdown value on  element : " + eleName +" as " + index , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());


		}

	}
	public void dropdownVisibleTxt(By locator,String value, String eleName) throws Exception   
	{
		try {
			WebElement element = driver.findElement(locator);
			Select drpdown = new Select(element);
			drpdown.selectByVisibleText(value);
			VscBase.childTest.pass("dropdown value is set as " +value + " on : " + eleName );

		}catch(Exception e){
			VscBase.childTest.fail("Unable to set dropdown value on  element : " + eleName +" as " + value , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}

	}

	public void alertaccept() throws Exception   
	{
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			VscBase.childTest.pass("Alert  accepted" );

		}catch(Exception e){
			VscBase.childTest.fail("Unable to accept alert" , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}

	}

	public void alertdismiss() throws Exception   
	{
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			VscBase.childTest.pass("Alert closed" );

		}catch(Exception e){
			VscBase.childTest.fail("Unable to dismiss alert" , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}

	}
	public String alerttext() throws Exception   
	{
		String text =null;
		try {
			Alert alert = driver.switchTo().alert();
			text=alert.getText();
			VscBase.childTest.pass("Read  alert content" );

		}catch(Exception e){
			VscBase.childTest.fail("Unable to read alert content" , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}
		return text;
	}

	public void  alert(String content) throws Exception   
	{
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(content);
			VscBase.childTest.pass("Alert is updated as : "+ content);

		}catch(Exception e){
			VscBase.childTest.fail("Unable to update alert content as :  " +content , MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}
	}

	public String tooltip(By locator, String eleName) throws Exception   
	{
		String text = null;
		try {
			text = driver.findElement(locator).getAttribute("title");
			VscBase.childTest.pass("Read tooltip  of element : " +eleName);

		}catch( Exception e) {
			VscBase.childTest.fail("Unable to read tooltip of element : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}
		return text;
	}	

	public List<WebElement> findelements(By locator, String eleName) throws Exception   
	{
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(locator);

		}catch( Exception e) {
			VscBase.childTest.fail("Unable to locate elements : " +eleName, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}
		return elements;
	}	

	public  void scroll(int frompixel, int topixel) throws Exception   
	{

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(frompixel,topixel)");

			VscBase.childTest.pass("Perform scroll action from pixel :" +frompixel + " to "+topixel);

		}catch( Exception e) {
			VscBase.childTest.fail("Unable scroll action from pixel :" +frompixel + " to "+topixel, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}
	}	


	public  void scroll(By locator ) throws Exception   
	{
		WebElement element = driver.findElement(locator);
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
			VscBase.childTest.pass("Perform scroll action up to the element :" +element);

		}catch( Exception e) {
			VscBase.childTest.fail("Unable to Perform scroll action up to the element : " +element, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}
	}	

	public  void scroll() throws Exception   
	{
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			VscBase.childTest.pass("Perform scroll down the web page at the bottom of the page" );

		}catch( Exception e) {
			VscBase.childTest.fail("Unable to Perform scroll down the web page at the bottom of the page", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}
	}	
	
	public  void implicitWait(long time) throws Exception   
	{
		try {
			driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
			VscBase.childTest.pass("webdriver is perform implicit wait for "+ time);

		}catch( Exception e) {
			VscBase.childTest.fail("Unable to Perform implicit wait action", MediaEntityBuilder.createScreenCaptureFromBase64String(screenshot()).build());

		}
	}	
	
	
}
