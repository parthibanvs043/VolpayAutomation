package com.volante.timeout;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class WaitTime {
	public static void WaitInSeconds(WebDriver wd, String dt, String strStep) throws InterruptedException, IOException {
		try {
			Thread.sleep(Long.parseLong(dt));
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.test.log(LogStatus.PASS, strStep,
					"" + Methodname + " : Wait in seconds for " + dt + " completed");
		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Run time exception Occured :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}

	public static void SetScriptTimeout(WebDriver wd, String dt, String strStep)
			throws InterruptedException, IOException {
		try {

			wd.manage().timeouts().setScriptTimeout(3, TimeUnit.SECONDS);
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.test.log(LogStatus.PASS, strStep,
					"" + Methodname + " : Set Script Timeout  " + dt + " completed");
		}

		catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Run time exception Occured :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}

	public static void PageLoadTimeout(WebDriver wd, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			wd.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.test.log(LogStatus.PASS, strStep,
					"" + Methodname + " : Page Load Timeout " + dt + " completed");
		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Run time exception Occured :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}

}
