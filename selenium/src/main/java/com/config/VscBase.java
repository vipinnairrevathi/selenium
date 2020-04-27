package com.config;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.utilities.EmailNotification;
import com.utilities.Report;
import io.github.bonigarcia.wdm.WebDriverManager;

public class VscBase {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest parentTest;
	public static ExtentTest childTest;
	public static Platform platfrm;
	public static Log log;
	ExtentHtmlReporter htmlReporter;
	EmailNotification email;
	Report report;



	String method;
	ConfigSuppoter cs = new ConfigSuppoter("application.properties");



	@BeforeTest(alwaysRun = true)
	public void generateReport()
	{
		
		report = new Report();
		extent = report.generateHtmlReport();
		//env details
		extent.setSystemInfo("Browser", cs.getproperty("Browser"));
		extent.setSystemInfo("Environment", cs.getproperty("Environment"));
		
		
	}
	@BeforeMethod(alwaysRun = true)
	public void methodname(Method method) {

		parentTest = extent.createTest(method.getName());
		log.onstart(method.getName());
	}

	@BeforeClass(alwaysRun = true)
	public void beforeclass() {

		log = new Log();
		platfrm = new Platform();
		String browser = cs.getproperty("Browser");
		String platform = cs.getproperty("platform");
		if(platform.equalsIgnoreCase("Saucelab")) {
			driver =platfrm.setsaucelab();
			log.lauch();
		}
		if(platform.equalsIgnoreCase("grid")) {
			driver =platfrm.setgrid();
			log.lauch();
		}
		if(platform.equalsIgnoreCase("Browserstack")) {
			driver =platfrm.setbrowserstack();
			log.lauch();
		}
		else {
		switch (browser) {
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(); 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.lauch();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.lauch();
			break;
		case "IE":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.lauch();
			break;
		default:System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
		driver = new FirefoxDriver(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.lauch();
		}

		}

	}

	@AfterClass(alwaysRun = true)
	public void afterclass() {
		extent.flush();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		email = new EmailNotification();
		email.notification();
		driver.quit();


	} 



}
