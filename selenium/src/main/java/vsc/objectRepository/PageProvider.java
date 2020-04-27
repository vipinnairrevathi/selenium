package vsc.objectRepository;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.config.Action;
import com.config.ConfigSuppoter;
import com.config.VscBase;

public class PageProvider {

	public static WebDriver driver;
	public static Action adriver;
	public static String email ;
	public static Map<Object, Object> testData;

	ConfigSuppoter cs = new ConfigSuppoter("application.properties");


	public  PageProvider()

	{
		driver = VscBase.driver;
		
		
	}
	
	public PageProvider launch(Map<Object, Object> data)

	{
		adriver = new Action();
		String url = cs.getproperty("Environment");
		driver.get(url);
		email = "username";
		testData = data;
		return new PageProvider();
	}

	public HomePage toHomePage() {
		return new HomePage();
	}
	
	public LoginPage toLoginPage() {
		return new LoginPage();
	}



}