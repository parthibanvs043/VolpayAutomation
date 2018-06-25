package com.volante.pages;

import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ScrollDown 
{
	
public static void ScrollDownByPosition(WebDriver wd, String pr, String dt, String strStep) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException
{

		try {
            JavascriptExecutor jse = (JavascriptExecutor) wd;
            jse.executeScript("window.scrollBy(0,dt)", "");
            String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName(); 
			GenerateReport.test.log(LogStatus.PASS, strStep," "+Methodname+" : Scroll down to position by given value"+dt);
			
		}  
		catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep,"Unable to scroll down" +e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep,"Runtime Exception while scrolling down" +e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}
}
