package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Utility {

	public static String filePath;
	Utility encode;

	@Test
	public void encrypt() {
		encode = new Utility();
		encode.encode("");

	}

	public String decrypt(String encryptedpassword) {
		encryptedpassword = encryptedpassword.replaceAll("en/", "");
		byte[] decryptedPasswordBytes = Base64.getDecoder().decode(encryptedpassword.trim());
		String decryptedpassword = new String(decryptedPasswordBytes);
		return  decryptedpassword;

	}

	public void encode(String actualpassword) {
		actualpassword = actualpassword.trim();
		String encryptedPassword = Base64.getEncoder().encodeToString(actualpassword.getBytes());
		encryptedPassword ="en/"+encryptedPassword;
		System.out.println("encryptedpassword : "+encryptedPassword);

	}


	public String getscreenshot(WebDriver driver) {
		String base64 = null;
		try {
			String Date =  new SimpleDateFormat("yyyy.MM.dd.hh.mm").format(new Date());
			TakesScreenshot scrShot =((TakesScreenshot)driver);
			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//Move image file to new destination
			filePath = System.getProperty("user.dir")+"./snapshot/"+Date+".jpg";
			//filePath = System.getProperty("user.dir")+"./snapshot/ElementScreenshot.jpg";
			File DestFile=new File(filePath);
			//Copy file at destination
			FileUtils.copyFile(SrcFile, DestFile);
			
			
			Thread.sleep(2000);
		     InputStream is = new FileInputStream(filePath);
		     byte[] imageBytes = IOUtils.toByteArray(is);
		     Thread.sleep(2000);
		     base64 = Base64.getEncoder().encodeToString(imageBytes);
		     base64 = "data:image/jpg;base64,"+base64;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		//return filePath;
		return base64;
	}



}
