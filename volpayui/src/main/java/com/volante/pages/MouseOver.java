package com.volante.pages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class MouseOver 
{

public static void Mouseclick_CSS(WebDriver wd, String pr, String strStep) throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element=wd.findElement(By.cssSelector(pr));*/
			/*if (!element.isDisplayed()){
				
			((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			else
			{
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}*/
			//element.click();
			Actions actions = new Actions(wd);
			actions.moveToElement(element);
			actions.click().build().perform();
			Thread.sleep(10000);
			GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : Css element clicked Successfully");
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

}
