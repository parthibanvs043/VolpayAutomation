package com.volante.reports;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.volante.volpayui.VolPayDriver;

public class GenerateReport {
	public static ExtentReports extent;
	public static ExtentTest test;
	static WebDriver driver;

	@Parameters({ "Report" })
	@BeforeTest
	public static void StartReport(@Optional String ReportFileName) {
		String userhome = "user.dir";
		String path = System.getProperty(userhome);
		extent = new ExtentReports(ReportFileName);
		extent.assignProject("VOLPAY");
		extent.addSystemInfo("SeleniumVersion", "3.7.1");
		extent.addSystemInfo("Component", "UserInterface");
		extent.loadConfig(new File(path+ "/src/main/resources/reportConfig/extent-config.xml"));

	}

	public static void getmethodname() {
		//test = extent.startTest(Category).assignCategory("VolPayUI");
		//test.log(LogStatus.PASS, Steps, Steps);
		test = GenerateReport.extent.startTest(VolPayDriver.scenario).assignCategory(VolPayDriver.SNo);
		
	}
}
