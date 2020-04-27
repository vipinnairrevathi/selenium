package com.config;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

public abstract class Page {
	
	WebDriver driver;
	
	
	public Page(WebDriver driver) {
		this.driver =driver;
	}
	
	public abstract String getpagetittle();
	public abstract String getpageheader();
	
	
	public <Tpage extends Basepage> Tpage getInstance(Class<Tpage> pageClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
	}
	
	
	
	}


