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

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ToolTip {
	
public static void ToolTipByXPath(WebDriver wd, String pr, String dt, String strStep) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
	   

	  try {
		  WebDriverWait wait = new WebDriverWait(wd,60);
			WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr))); 
			// WebElement tooltip=wd.findElement(By.xpath(pr));
			 Actions builder=new Actions(wd);
			 builder.moveToElement(element).perform();
			 String tooltip_msg=element.getAttribute("tooltip");
			 String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName(); 
			 if(dt.equalsIgnoreCase(tooltip_msg))
			 {   
				 GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Tooltip message is "+tooltip_msg);
			 }
			 else
			 {
				 GenerateReport.test.log(LogStatus.FAIL, strStep, " "+Methodname+" : Tooltip message is not matched "+tooltip_msg);
			 } 
	  }
	  catch (NoSuchElementException e) {
		  GenerateReport.test.log(LogStatus.FAIL, strStep, " Unable to find element "+e.getMessage());
		  String screenShotPath = GetScreenShot.capture(wd, strStep);
		  GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} 
	  catch (Exception e) {
		  GenerateReport.test.log(LogStatus.FAIL, strStep, " Runtime Exception found while finding element "+e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
}
}