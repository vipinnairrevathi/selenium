package com.utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.config.ConfigSuppoter;

public class Report {



	public static final String HTML = "Report/AutomationReport.html";
	public static final String DEST = "Report/AutomationReport.pdf";
	public static ExtentReports extent;
	ConfigSuppoter cs = new ConfigSuppoter("config.properties");
	ExtentHtmlReporter htmlReporter;
	Report report;
	
	public ExtentReports generateHtmlReport() {
		
		String reportGeneration = cs.getproperty("Report.Generation");
		if("true".equalsIgnoreCase(reportGeneration));
		report = new Report();
		return extent = report.htmlreport();
		
	}
	
	public ExtentReports htmlreport() {

		htmlReporter = new ExtentHtmlReporter("./Report/AutomationReport.html");
		//config
		htmlReporter.config().setDocumentTitle(cs.getproperty("Report.Tittle"));
		htmlReporter.config().setReportName(cs.getproperty("Report.Name"));
		String theme = cs.getproperty("Report.Theme").trim();
		if("Dark".equalsIgnoreCase(theme)) {
		htmlReporter.config().setTheme(Theme.DARK);
		}else {
			htmlReporter.config().setTheme(Theme.STANDARD);
		}
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;

	}

}

