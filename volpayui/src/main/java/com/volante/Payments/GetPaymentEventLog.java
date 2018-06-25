package com.volante.Payments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class GetPaymentEventLog 
{
	
public static void PaymentEventlog(WebDriver wd,String strStep) throws InterruptedException, IOException
{
	String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
	try
	{		
		WebElement PymtEvent = wd.findElement(By.xpath("(//ul[@class='nav nav-tabs'])//li[1]"));
		WebElement PymtEventpresence = PymtEvent.findElement(By.tagName("a"));
		String PymtEventclass = PymtEventpresence.getAttribute("aria-expanded");
				if (PymtEventclass.equalsIgnoreCase("false")) {
					PymtEvent.click();
					//System.out.println(" Payemnt Event Log  tab selected");
					GenerateReport.test.log(LogStatus.PASS, strStep,
							"" + Methodname + " : Navigated to Payemnt Event Log  tab ");
				} else {
					//System.out.println(" tab already selected ");
					GenerateReport.test.log(LogStatus.PASS, strStep,
							"" + Methodname + " : Already in  Payemnt Event Log  tab ");
				}
	     // int PaymnetEventlog=wd.findElements(By.id("tableExport")).size();
	     // System.out.println("No of rows in event log="+PaymnetEventlog);
          int Paymenteventrows = wd.findElements(By.xpath(".//*[@id='tab1']/tbody/tr")).size();
         // System.out.println("Total no of rows in Payment event log="+Paymenteventrows);
	      for (int s=1;s<=Paymenteventrows;s++)
	         {
	        	 Thread.sleep(2000);
				 String Timestampvalue= wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr["+s+"]/td[1]")).getText();
				 String eventvalue= wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr["+s+"]/td[2]")).getText();
	        	 String Actortvalue= wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr["+s+"]/td[3]")).getText();
				 String descriptionvalue= wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr["+s+"]/td[4]")).getText();
				 //System.out.println(Timestampvalue+" : "+eventvalue+" : "+Actortvalue+" : "+descriptionvalue);
				 GenerateReport.test.log(LogStatus.PASS, strStep,
							"Payment Details tab  details are as follows : 1.Timestampvalue =  " + Timestampvalue + " 2.eventvalue = " + eventvalue
									+ " 3.Actortvalue = " + Actortvalue + " 4.descriptionvalue= " + descriptionvalue+".");
				 GenerateReport.test.log(LogStatus.PASS, strStep,
							"" + Methodname + " : Payment Details Completed Successfuly ");
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
