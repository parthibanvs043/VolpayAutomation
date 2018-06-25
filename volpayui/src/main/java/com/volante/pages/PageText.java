package com.volante.pages;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
public class PageText 
{
public static void verifyTextinPage(WebDriver wd, String pr,String dt, String strStep) throws RowsExceededException, BiffException, WriteException, IOException
{
        	  try {
        		   boolean pagetext=wd.getPageSource().contains(dt);
        		   String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
            	   if(pagetext==true)
            	   {  
            		   
   				       GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Text found in the page"+ dt);
            	   }
            	   else
            	   {
            		   
            		   GenerateReport.test.log(LogStatus.FAIL, strStep," "+Methodname+" : Text not found in the page"+ dt);
            		   String screenShotPath = GetScreenShot.capture(wd, strStep);
            		   GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
            	   }
        	  } 
        	  catch (NoSuchElementException e) {
  				GenerateReport.test.log(LogStatus.FAIL, strStep,"Unable to find the text"+e.getMessage());
  				String screenShotPath = GetScreenShot.capture(wd, strStep);
  				GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
  			} 
        	  catch (Exception e) {
  				GenerateReport.test.log(LogStatus.FAIL, strStep,"Runtime Exception while finding the text"+e.getMessage());
  				String screenShotPath = GetScreenShot.capture(wd, strStep);
  				GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
  			}
}
}