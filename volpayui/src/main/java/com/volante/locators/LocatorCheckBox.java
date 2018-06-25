package com.volante.locators;

import java.io.IOException;
import org.openqa.selenium.By;
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

public class LocatorCheckBox {
	// Checking
	public static void CheckingChkbox(WebDriver wd, String pr, String strStep) throws InterruptedException, IOException {
		boolean checkstatus;

		try {
			
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			checkstatus = element.isSelected();
			if (checkstatus == true) {
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : Checkbox is already checked");
			} else {
				element.click();
				ReportGeneration.test.log(Status.PASS,strStep); 
			} 
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