package com.volante.locators;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;

public class LocatorMultiSelect {
	@SuppressWarnings("null")
	public static void MultiSelect_CSS(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr)));
			if (element != null) {
				// System.out.println("Element is Present");
				GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : element present ");
				String Stringvalues = dt;
				String[] FinalValue = Stringvalues.split(",");
				for (String W : FinalValue) {
					element.click();
					// System.out.println("MultiSlectValue= "+W);
					element.sendKeys(W);
					element.sendKeys(Keys.ENTER);
				}
			} else {
				// System.out.println("Element is Absent");
				GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : element absent ");
				String Stringvalues = dt;
				String[] FinalValue = Stringvalues.split(",");
				for (String W : FinalValue) {
					element.click();
					// System.out.println("MultiSlectValue= "+W);
					element.sendKeys(W);
					element.sendKeys(Keys.ENTER);
				}
			}
			ReportGeneration.test.log(Status.PASS,strStep); 
		} 
		catch (NoSuchElementException e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} 
		catch (Exception e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}

	@SuppressWarnings("null")
	public static void MultiSelect_Id(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			if (element != null) {
				// System.out.println("Element is Present");
				GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : element present ");
				String Stringvalues = dt;
				String[] FinalValue = Stringvalues.split(",");
				for (String W : FinalValue) {
					// Console.WriteLine(item);
					Thread.sleep(2000);
					element.click();
					Thread.sleep(4000);
					// System.out.println("MultiSlectValue= "+W);
					element.sendKeys(W);
					Thread.sleep(5000);
					element.sendKeys(Keys.ENTER);
				}
			} else {
				// System.out.println("Element is Absent");
				GenerateReport.test.log(LogStatus.PASS, strStep, " " + Methodname + " : element absent ");
				String Stringvalues = dt;
				String[] FinalValue = Stringvalues.split(",");
				for (String W : FinalValue) {
					// Console.WriteLine(item);
					Thread.sleep(2000);
					element.click();
					Thread.sleep(4000);
					// System.out.println("MultiSlectValue= "+W);
					element.sendKeys(W);
					Thread.sleep(5000);
					element.sendKeys(Keys.ENTER);
				}
			}
			ReportGeneration.test.log(Status.PASS,strStep); 
		} 
		catch (NoSuchElementException e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} 
		catch (Exception e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}

	@SuppressWarnings("null")
	public static void MultiSelect_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			if (element != null) {
				// System.out.println("Element is Present");
				//GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : element present ");
				String Stringvalues = dt;
				String[] FinalValue = Stringvalues.split(",");
				for (String W : FinalValue) {
					// Console.WriteLine(item);
					Thread.sleep(2000);
					element.click();
					Thread.sleep(4000);
					// System.out.println("MultiSlectValue= "+W);
					element.sendKeys(W);
					Thread.sleep(5000);
					element.sendKeys(Keys.ENTER);
				}
			} else {
				// System.out.println("Element is Absent");
				//GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : element absent ");
				String Stringvalues = dt;
				String[] FinalValue = Stringvalues.split(",");
				for (String W : FinalValue) {
					// Console.WriteLine(item);
					Thread.sleep(2000);
					element.click();
					Thread.sleep(4000);
					// System.out.println("MultiSlectValue= "+W);
					element.sendKeys(W);
					Thread.sleep(5000);
					element.sendKeys(Keys.ENTER);
				}
			}
			ReportGeneration.test.log(Status.PASS,strStep); 
		} 
		catch (NoSuchElementException e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} 
		catch (Exception e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}
}