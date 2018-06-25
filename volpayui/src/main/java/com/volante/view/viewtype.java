package com.volante.view;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class viewtype {
	public static void grid(WebDriver wd,String strStep) throws IOException{
		try {
	//Check if grid view is enabled
	WebElement gridview = wd.findElement(By.id("btn_2"));
	String gridclass = gridview.getAttribute("class");
			boolean gridV = gridclass.contains("disabledBtnColor");
			if (!gridV) 
			{
				gridview.click();
				Thread.sleep(1500);
				//System.out.println("grid view enabled");
			    GenerateReport.test.log(LogStatus.PASS, strStep,"Grid view enabled succesfully");
			}
	}
		catch (NoSuchElementException e) {
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
	public static void list(WebDriver wd,String strStep) throws IOException{
		try {
	//Check if list view is enabled
	WebElement listview = wd.findElement(By.id("btn_1"));
	String listclass = listview.getAttribute("class");
			boolean classval = listclass.contains("disabledBtnColor");
			if (!classval) 
			{
				listview.click();
				Thread.sleep(1500);
				System.out.println("List view enabled");
			    GenerateReport.test.log(LogStatus.PASS,"Grid view enabled succesfully");

			}
	}
		catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element "+e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep ,"Run time exception Occured :- "+e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}
}
