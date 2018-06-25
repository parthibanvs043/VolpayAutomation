package com.volante.Payments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class AddingNotes 
{

	//For Add Notes
	public static void PmtAddnotes(WebDriver wd , String data,String strStep) throws InterruptedException, IOException
	{	
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try
		{		
			       WebDriverWait wait = new WebDriverWait(wd,30);
			       WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Add Notes')]")));
				   if(element.isDisplayed())
				   {
					   element.click();
				     GenerateReport.test.log(LogStatus.PASS, strStep,""+Methodname+ " : Add notes Button Found Successfully");
				     wd.switchTo().activeElement();
			         WebElement notes = wd.findElement(By.id("Notes"));
			         Thread.sleep(2000);
			         notes.sendKeys(data);
			         GenerateReport.test.log(LogStatus.PASS,  strStep,""+Methodname+ " adding notes as :-  " +data);
			         //System.out.println("notes added " +data);
			         Thread.sleep(2000);
			         wd.findElement(By.xpath("(//button[contains(text(),'Submit')])[2]")).click();
			         Thread.sleep(5000); 
			         GenerateReport.test.log(LogStatus.PASS, strStep,""+Methodname+ "AddNotes Completed successfully notes added as :-  " +data);
				   }
				   else 
					{
					   GenerateReport.test.log(LogStatus.FAIL, strStep,""+Methodname+"Button Not Found. Add Notes Unsuccessful");
					}
		 }

		catch (NoSuchElementException e) {
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
