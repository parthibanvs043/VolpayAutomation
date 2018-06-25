package com.volante.reports;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGeneration {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;
	public static ExtentTest test;

	@Parameters({ "Report" })
	@BeforeTest
	public static void startReport(@Optional String ReportFileName) {
		
		
		htmlReporter = new ExtentHtmlReporter(new File(ReportFileName));
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host Name", "VolPayUI");
		extent.setSystemInfo("Component", "VolPayUI");
		htmlReporter.config().setDocumentTitle("VolPay");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setProtocol(Protocol.HTTPS);
		htmlReporter.config().setReportName("VolPayUI");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public static void endReport() {
		extent.flush();
	}
}
