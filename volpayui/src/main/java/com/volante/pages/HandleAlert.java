package com.volante.pages;

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
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class HandleAlert 
{

	public static void ButtonsAlert(WebDriver wd, String pr, String dt, String strStep) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
 		try 
 		{
 			WebDriverWait wait = new WebDriverWait(wd,60);
 			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr))); 
 			    //System.out.println("msgggggg");
 			     if(!element.isDisplayed())
   	           {
   	              ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);	
   	           }
 			 String FinalMsg =element.getText().substring(2);
 			 String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();   
 			if(dt.equalsIgnoreCase(FinalMsg))
 			{	   
 				ReportGeneration.test.log(Status.PASS, strStep); 
 				//GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Alert Message is Matched"+FinalMsg);
 			}
 			else
 			{
 				String screenShotPath = GetScreenShot.capture(wd, strStep);
				ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
 				//GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Alert Message is Not Matched"+FinalMsg);
 				//String screenShotPath = GetScreenShot.capture(wd, strStep);
 	 		   	//GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
 			}
 			 
 		} 
 		catch (NoSuchElementException e) {
			
 			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			//GenerateReport.test.log(LogStatus.FAIL, strStep,"Alert is not generated"+e.getMessage());
			//String screenShotPath = GetScreenShot.capture(wd, strStep);
 		   	//GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			//GenerateReport.test.log(LogStatus.FAIL, strStep,"Runtime Exception while generating the alert"+e.getMessage());
			//String screenShotPath = GetScreenShot.capture(wd, strStep);
 		   	//GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
 	}
}
