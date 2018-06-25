package com.volante.pages;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class PageScrollDown 
{

	
public static void ScrollDownByXPath(WebDriver wd, String pr, String strStep) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
{

		try {
			   WebDriverWait wait = new WebDriverWait(wd,60);
			   WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			   ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			   String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			   GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Scroll to element"+element);
			} catch (NoSuchElementException e) {
				GenerateReport.test.log(LogStatus.FAIL, strStep,"Unable to scroll down" +e.getMessage());
				String screenShotPath = GetScreenShot.capture(wd, strStep);
				GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
			} catch (Exception e) {
				GenerateReport.test.log(LogStatus.FAIL, strStep,"Runtime Exception while scrolling down" +e.getMessage());
				String screenShotPath = GetScreenShot.capture(wd, strStep);
				GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
			}
			}

public static void ScrollDownById(WebDriver wd, String pr,String strStep) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
{
	try {
		
		   WebDriverWait wait = new WebDriverWait(wd,60);
		   WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
		   ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);

		   String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		   GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Scroll to element"+element);
	} 
	catch (NoSuchElementException e) {
		GenerateReport.test.log(LogStatus.FAIL, strStep,"Unable to scroll down" +e.getMessage());
		String screenShotPath = GetScreenShot.capture(wd, strStep);
		GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
	} 
	catch (Exception e) {
		GenerateReport.test.log(LogStatus.FAIL, strStep,"Runtime Exception while scrolling down" +e.getMessage());
		String screenShotPath = GetScreenShot.capture(wd, strStep);
		GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
	}
}

public static void ScrollDownByCSS(WebDriver wd, String pr,String strStep) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
{
	try {
		
		   WebDriverWait wait = new WebDriverWait(wd,60);
		   WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr)));
		   ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
		   String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		   GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Scroll to element"+element);
	} 
	catch (NoSuchElementException e) {
		GenerateReport.test.log(LogStatus.FAIL, strStep,"Unable to scroll down"+e.getMessage());
		String screenShotPath = GetScreenShot.capture(wd, strStep);
		GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
	} 
	catch (Exception e) {
		GenerateReport.test.log(LogStatus.FAIL, strStep,"Runtime Exception while scrolling down"+e.getMessage());
		String screenShotPath = GetScreenShot.capture(wd, strStep);
		GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
	}
}
public static void ScrollDownByName(WebDriver wd, String pr,String strStep) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
{
	try {
		   WebDriverWait wait = new WebDriverWait(wd,20);
		   WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pr)));
		   ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
		   String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
	       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Scroll to element"+element);
	    } 
	catch (NoSuchElementException e) 
	  {	
		GenerateReport.test.log(LogStatus.FAIL, strStep,"Unable to scroll down"+e.getMessage());
		String screenShotPath = GetScreenShot.capture(wd, strStep);
		GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
	} 
	catch (Exception e) {
		GenerateReport.test.log(LogStatus.FAIL, strStep,"Runtime Exception while scrolling down"+e.getMessage());
		String screenShotPath = GetScreenShot.capture(wd, strStep);
		GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
	}
}
}
