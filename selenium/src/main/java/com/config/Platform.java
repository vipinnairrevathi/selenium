package com.config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Platform {

	public static WebDriver driver;
	public static final String SauceACCESS_KEY  ="eb31a23d-2449-43af-95bf-38f281366610";
	public static final String SauceUSERNAME  ="vipin.nair60revathi.-_";
	public static final String SauceURL = "http://" + SauceUSERNAME + ":" + SauceACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	public static final String BSUSERNAME = "vipinnair4";
	public static final String BSAUTOMATE_KEY = "adwtDAwvBy8hkTCmk1Eo";
	public static final String BSURL = "https://" + BSUSERNAME + ":" + BSAUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	

	public WebDriver setsaucelab () {

		try {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "latest");
			caps.setCapability("name", "VSC TEST AUTOMATION");
			caps.setCapability("extendedDebugging", "true");
			driver = new RemoteWebDriver(new URL(SauceURL), caps);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	public WebDriver setgrid () {

		try {
			 DesiredCapabilities caps = new  DesiredCapabilities();
			caps.setBrowserName("chrome");
			ChromeOptions options = new ChromeOptions();
			options.merge(caps);
			String huburl = "http://192.168.0.14:4444/wd/hub";
			driver = new RemoteWebDriver(new URL(huburl),caps);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;


	}

	public WebDriver setbrowserstack () {

		try {
		    DesiredCapabilities caps = new DesiredCapabilities();
		    caps.setCapability("os", "Windows");
		    caps.setCapability("os_version", "8.1");
		    caps.setCapability("browser", "Chrome");
		    caps.setCapability("browser_version", "79.0");
		    caps.setCapability("project", "Virtual security consultant");
		    caps.setCapability("build", "Build1");
		    caps.setCapability("name", "Login Test");
		    caps.setCapability("browserstack.local", "false");
		    caps.setCapability("browserstack.debug", "true");
		    caps.setCapability("browserstack.networkLogs", "true");
		    caps.setCapability("browserstack.selenium_version", "3.141.59");
		    driver = new RemoteWebDriver(new URL(BSURL), caps);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;


	}
	
	public static void main(String[] args) throws Exception {

		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "latest");
		WebDriver driver = new RemoteWebDriver(new URL(SauceURL), caps);
		driver.get("https://www.amazon.in/");
	}


}