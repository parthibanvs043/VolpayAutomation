package com.volante.locators;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class LocatorStatusBox {

public static void GetStatusByID(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		try {

			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			} else {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			String FinalMsg = element.getText().substring(2);
			System.out.println("FinalMsg=....." + FinalMsg);
			if (dt.equalsIgnoreCase(FinalMsg)) {

				ReportGeneration.test.log(Status.PASS,strStep); 
			} else {
				String screenShotPath = GetScreenShot.capture(wd, strStep);
				ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			}

		} catch (NoSuchElementException e) 
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