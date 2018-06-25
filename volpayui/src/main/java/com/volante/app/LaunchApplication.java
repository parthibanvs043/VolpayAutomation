package com.volante.app;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class LaunchApplication {

	public static void Launch_App(WebDriver wd, String url, String strStep) throws Exception {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			wd.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			wd.get(url);
			wd.manage().window().maximize();
			GenerateReport.test.log(LogStatus.PASS, strStep, Methodname + " :URL Launched Successfully");
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			GenerateReport.test.log(LogStatus.FAIL, strStep, e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GenerateReport.test.log(LogStatus.FAIL, strStep, e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}
}
