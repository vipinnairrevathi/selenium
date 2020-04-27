package vsc.test;

import java.util.Map;
import org.testng.annotations.Guice;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.config.VscBase;
import vsc.objectRepository.PageProvider;
import vsc.testData.LoginData;

@Guice
@Listeners(com.config.ListenerTest.class)	
public class LoginTest extends VscBase {



	@Test(groups = { "regression" },
			dataProvider="LoginTcName",dataProviderClass = LoginData.class)
	public void Login(Map<Object, Object> data) throws Exception {

		new PageProvider()
		.launch(data)
		.toHomePage()
		.navigateTologin()
		.toLoginPage()
		.login()
		;
	}	

	@Test(groups = { "functional" },
			dataProvider="LoginTcName",dataProviderClass = LoginData.class)
	public void Login1(Map<Object, Object> data) throws Exception {

		System.out.println("Regression test1");
	}	

	@Test(groups = { "functional" },
			dataProvider="LoginTcName",dataProviderClass = LoginData.class)
	public void Login3(Map<Object, Object> data) throws Exception {
		
		System.out.println("Regression test2");
	}	



}