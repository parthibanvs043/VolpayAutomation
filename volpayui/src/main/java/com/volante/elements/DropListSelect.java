package com.volante.elements;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;

import com.volante.utilities.GetScreenShot;

public class DropListSelect {

	public static void DropListSelectText_Xpath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement elementselect = wd.findElement(By.xpath(pr));*/
			element.click();
			WebElement elementlist = wd.findElement(By.xpath("//span[@class='select2-results']/ul"));
			List<WebElement> DropList = elementlist.findElements(By.tagName("li"));
			for (WebElement drop : DropList) {
				String valText = drop.getText();
				Thread.sleep(1000);
				if (valText.equalsIgnoreCase(dt)) {
					((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", drop);
					drop.click();
					 System.out.println("elemt selected for dt "+valText);

					GenerateReport.test.log(LogStatus.PASS, strStep,
							"" + Methodname + " : Value " + dt + " selected succesfully");
					break;
				} 
			}
		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element " + e.getMessage());
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
	public static void DropListEnterText_Xpath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement elementselect = wd.findElement(By.xpath(pr));*/
			element.click();
			element.sendKeys(dt);
			Thread.sleep(2000);
			element.sendKeys(Keys.ENTER);
			GenerateReport.test.log(LogStatus.PASS, strStep,"" + Methodname + " : element with id as " + pr + " and value " + dt + " selected Successfully");
			}	
		 catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element " + e.getMessage());
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
	public static void DropListSelectText_CSS(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {

			 WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.cssSelector(pr));*/
			List<WebElement> DropList = element.findElements(By.tagName("li"));
			for (WebElement drop : DropList) {
				String valText = drop.getText();
				Thread.sleep(1000);
				if (valText.equalsIgnoreCase(dt)) {
					((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", drop);
					drop.click();
					// System.out.println("elemt selected for dt "+valText);
					GenerateReport.test.log(LogStatus.PASS, strStep,
							"" + Methodname + " : Value " + dt + " selected succesfully");
					break;
				} else {
					// System.out.println("value not present as dt");
					GenerateReport.test.log(LogStatus.FAIL, strStep,
							"" + Methodname + " : Value " + dt + " Not Found ");
				}
			}
		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element " + e.getMessage());
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

	public static void SelectText_Xpath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			//WebElement element = wd.findElement(By.id(pr));
			element.click();
			// System.out.println(" *****id is " +pr);
			Select SelectVal = new Select(element);
			List<WebElement> ElemOpts = SelectVal.getOptions();
			int opts = ElemOpts.size();
			Thread.sleep(1500);
			for (int i = 1; i < opts; i++) {
				String Value = ElemOpts.get(i).getText();
				System.out.println("value is ========" +Value);
				if (Value.equalsIgnoreCase(dt)) {
					SelectVal.selectByVisibleText(Value);
					System.out.println("value clicked ========" +Value);
					GenerateReport.test.log(LogStatus.PASS, strStep,
							"" + Methodname + " : Value " + dt + " selected succesfully");
					break;
				} else {
					GenerateReport.test.log(LogStatus.FAIL, strStep,
							"" + Methodname + " : Value " + dt + " Not Found in select option");
				}
			}

		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element " + e.getMessage());
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

	public static void DropdownSelectAction_Xpath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			//WebElement elementpr = wd.findElement(By.xpath(pr));
			element.click();
			System.out.println(" elemt clicled ");
			Actions actions = new Actions(wd); 
			actions.moveToElement(element).click(); 
			System.out.println("actions ;'lskdfll" );
			actions.sendKeys(dt).perform();
			Thread.sleep(2000);
			actions.sendKeys(Keys.ENTER).build().perform();
			System.out.println(" performed");
			GenerateReport.test.log(LogStatus.PASS, strStep,
					"" + Methodname + " : Value  selected  for Value  " + dt + " Selected Successfully");			
					
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
