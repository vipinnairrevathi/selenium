package com.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Basepage extends Page{

	public Basepage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getpagetittle() {
		return driver.getTitle() ;
	}

	@Override
	public String getpageheader() {
		// TODO Auto-generated method stub
		return null;
	}


}
