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

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class StatusBox 
{

public static void GetStatusByID(WebDriver wd, String pr, String dt, String strStep) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		try 
		{		 
			WebDriverWait wait = new WebDriverWait(wd,60);
			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.id(pr));*/
			     if(!element.isDisplayed())
  	           {
  	              ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);	
  	           }
			     else
					{
						((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
					}
			     String FinalMsg =element.getText().substring(2);
			     String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			if(dt.equalsIgnoreCase(FinalMsg))
			{
				 
				  GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Success Message is Matched"+FinalMsg);
			}
			else
			{
				
				GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Success Message Not Matched"+FinalMsg);
				String screenShotPath = GetScreenShot.capture(wd, strStep);
	 		   	GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
			}
			
		} 
		catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep,"Unable to generate the Success Message" +e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
 		   	GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} 
		catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep,"Runtime Exception while generating the message" +e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
 		   	GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}
       
}