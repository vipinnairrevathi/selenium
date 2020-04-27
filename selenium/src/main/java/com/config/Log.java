package com.config;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log {
	
	public Logger log;
	
	public Log() {
		PropertyConfigurator.configure("./log/log4j.properties");
		 log = Logger.getLogger("vscapplicationLog");
	}
	
	public void onstart(String name) {
		log.info("<--------------------"+name +" test ----------------------------------------->");
		
		}
	
	public void lauch() {
	log.info("Launching browser");
	}
	
	public void entry(String entry) {
		log.info(entry);
		}
	
}
