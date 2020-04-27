package vsc.objectRepository;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.config.Action;
import com.config.VscBase;
import com.utilities.Utility;




public class LoginPage extends PageProvider {

	private static By txt_username =By.xpath("//input[@type='email']"); 
	private static By btn_continue =By.xpath("//input[@id='continue']"); 
	private static By responseMessage =By.xpath("//span[@class='a-list-item']"); 

	public static Action action;
	public static Map<Object, Object> testData;
	public static LoginPage loginPage;

	public LoginPage login() throws Exception

	{
		loginPage = new LoginPage();
		try {
			action.type(txt_username,"username",testData.get("Username").toString());
			action.click(btn_continue, "continue button");
//			if(action.displayed(responseMessage, "Warning message ")) {
//				loginPage.invaildusername();
//			}
			action.implicitWait(20);
		}catch(Exception e) {

		}
		return toLoginPage();


	}

	public LoginPage invaildusername() {
		String text;
		try {
			text = action.getText(responseMessage, "Warning" );
			VscBase.childTest.fail("Unable to perform login action. Error Message: - " + text ).addScreenCaptureFromBase64String(adriver.screenshot(),"Error Screen shot");
			VscBase.parentTest.fail("Enter Valid username : " + text );
			Assert.fail(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return toLoginPage();	
	}


	public  LoginPage()

	{
		action = new Action();
		testData = PageProvider.testData;
	}

}
