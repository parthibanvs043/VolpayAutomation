package com.volante.elements;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
 
import com.volante.utilities.GetScreenShot;

public class TextValidation {

	// Click method using locater ID
	public static void Text_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.xpath(pr));*/
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			else
			{
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			element.click();
			String Textvalue = element.getText();
			if (Textvalue.equalsIgnoreCase(dt)) {
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Text Value " + dt + " Matched with element value " + Textvalue);
			} else {
				GenerateReport.test.log(LogStatus.FAIL, strStep,
						"" + Methodname + " : Text Value " + dt + " Not Matched with element value " + Textvalue);
			}
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

	// Verify Text using locater ID
	public static void NoText_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.xpath(pr));*/
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			element.click();
			Thread.sleep(2000);
			String Textvalue = element.getText();
			if (!Textvalue.equalsIgnoreCase(dt)) {
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Text Value " + dt + " not Matched with element value " + Textvalue);
			} else {
				GenerateReport.test.log(LogStatus.FAIL, strStep,
						"" + Methodname + " : Text Value " + dt + "  Matched with element value " + Textvalue);
			}
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

	// Verify Text using locater ID
	public static void TextPresent_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.xpath(pr));*/
			System.out.println(pr);
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			Thread.sleep(2000);
			String Textvalue = element.getText();
			if (Textvalue.contains(dt)) {
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Text Value " + dt + " present Matched with element value " + Textvalue);
			} else {
				GenerateReport.test.log(LogStatus.FAIL, strStep, "" + Methodname + " : Text Value " + dt
						+ " Not present or not matched with element value " + Textvalue);
			}
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