package vsc.objectRepository;

import java.util.Map;
import org.openqa.selenium.By;
import com.config.Action;
import com.config.VscBase;

public class HomePage extends PageProvider{
	
	private static By link_signIn =By.xpath("//a[@data-nav-ref='nav_ya_signin'and @id='nav-link-accountList']"); 

	
	public static Action action;
	public static Map<Object, Object> testData;
	
	
	
	
	public HomePage navigateTologin() throws Exception
	
	{
		VscBase.childTest = VscBase.parentTest.createNode("Login to the application");
		action.implicitWait(20);
		action.click(link_signIn, "Accountlink");
		action.implicitWait(20);
		return toHomePage();
	}

	
	public  HomePage()

	{
		action = new Action();
		testData = PageProvider.testData;
	}
	
	
}
