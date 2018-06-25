package com.volante.windowshandles;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class HadlingBrowserTabs {
	public static void OpenBrowserinSameWindow(WebDriver wd, String pr, String strStep)
			throws AWTException, InterruptedException, IOException {

		try {
			/*
			 * Set<String> windows = wd.getWindowHandles(); //String AdminWindow
			 * = wd.getWindowHandle(); ((JavascriptExecutor)
			 * wd).executeScript("window.open();"); Set<String> OpertorWindow =
			 * wd.getWindowHandles(); OpertorWindow.removeAll(windows); String
			 * customerSiteHandle = ((String) OpertorWindow.toArray()[0]);
			 * wd.switchTo().window(customerSiteHandle); wd.get(pr);
			 * //wd.switchTo().window(AdminWindow);
			 */
			Thread.sleep(3000);
			wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
			Set<String> windows = wd.getWindowHandles();
			for (String tab : windows) {
				wd.switchTo().window(tab);
				if (wd.getTitle().contains("New Tab"))
					wd.get("https://localhost:8443/VolPayHubUI/");
			}
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.test.log(LogStatus.PASS, strStep,
					" " + Methodname + " : Browser Opened as a next tab in Same Window");

		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep,
					"Unable to open browser in next tab in same window" + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep,
					"RunTime exception found while opening Browser as the tab in same window" + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}

	public static void AdminWindow(WebDriver wd, String strStep)
			throws AWTException, InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(wd.getWindowHandles());
			wd.switchTo().window(tabs2.get(0));
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.test.log(LogStatus.PASS, strStep, " " + Methodname + " : Switched to Admin Tab");

		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Unable to switch admin tab" + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep,
					"RunTime exception found while switching to admin tab" + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}

	}

	public static void OperatorWindow(WebDriver wd, String strStep)
			throws AWTException, InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(wd.getWindowHandles());
			wd.switchTo().window(tabs2.get(1));
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.test.log(LogStatus.PASS, strStep, " " + Methodname + " : Switched to Operator Tab");

		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Unable to switch Operator tab" + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep,
					"RunTime exception found while switching to Operator tab" + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}

	public static void ApproverWindow(WebDriver wd, String strStep)
			throws AWTException, InterruptedException, IOException {
		try {
			Thread.sleep(3000);
			ArrayList<String> tabs2 = new ArrayList<String>(wd.getWindowHandles());
			wd.switchTo().window(tabs2.get(2));
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.test.log(LogStatus.PASS, strStep, " " + Methodname + " : Switched to Approver Tab");

		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Unable to switch Approver tab" + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep,
					"RunTime exception found while switching to Approver tab" + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}

	}
}
