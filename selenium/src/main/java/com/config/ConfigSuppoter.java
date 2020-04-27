package com.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class ConfigSuppoter {

	static Properties props = new Properties();
	String configFile;
	String configValue;



	public String getproperty(String strKey)  {

		try {
			File f = new File (configFile);
			if(f.exists()) {
				FileInputStream in = new FileInputStream(f);
				props.load(in);
				configValue=props.getProperty(strKey);
				in.close();
			}else	
				System.out.println("File not found");

		}catch(IOException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println(e);
		}
		return configValue;

	}



	public String setproperty(String strKey,String value)  {

		try {
			File f = new File (configFile);
			if(f.exists()) {
				FileInputStream in = new FileInputStream(f);									
				props.load(in);
				props.setProperty(strKey, value);
				in.close();
			}else	
				System.out.println("File not found");

		}catch(IOException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println(e);
		}
		return configValue;

	}
	
	
	
	
	
	

	public void removeproperty(String strKey)  {

		try {
			File f = new File (configFile);
			if(f.exists()) {
				FileInputStream in = new FileInputStream(f);									
				props.load(in);
				props.remove(strKey);
				props.store(new FileOutputStream(configFile), null);
				in.close();
			}else	
				System.out.println("File not found");

		}catch(IOException e) {
			e.getMessage();
			e.printStackTrace();
			System.out.println(e);
		}

	}

	public ConfigSuppoter(String configFile)  {
		this.configFile=configFile;
	}

	public static String getHostName() throws UnknownHostException {

		InetAddress addr = InetAddress.getLocalHost();
		String hostname = addr.getHostName();

		return hostname;
	}

	public void clean() {

		props.clear();

	}



}


