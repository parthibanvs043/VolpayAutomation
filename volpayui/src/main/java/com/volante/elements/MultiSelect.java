package com.volante.elements;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
 
import com.volante.utilities.GetScreenShot;

public class MultiSelect {
	@SuppressWarnings("null")
	public static void MultiSelect_CSS(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.cssSelector(pr));*/
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
			GenerateReport.test.log(LogStatus.PASS, strStep,
					"" + Methodname + " : Multi select for Value " + dt + " Selected Successfully");
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

	@SuppressWarnings("null")
	public static void MultiSelect_Id(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.id(pr));*/
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
			GenerateReport.test.log(LogStatus.PASS, strStep,
					"" + Methodname + " : Multi select BY id for Value  " + dt + " Selected Successfully");
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

	@SuppressWarnings("null")
	public static void MultiSelect_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.xpath(pr));*/
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
				GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : element absent ");
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
			GenerateReport.test.log(LogStatus.PASS, strStep,
					"" + Methodname + " : Multi select BY id for Value  " + dt + " Selected Successfully");
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