package com.volante.Payments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;
import com.volante.volpayui.VolPayDriver;

public class Communications {
	public static void ExternalCommunications(WebDriver wd, String strStep) throws IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement exttab = wd.findElement(By.xpath("(//ul[@class='nav nav-tabs'])//li[3]"));
			WebElement exttabpresence = exttab.findElement(By.tagName("a"));
			String exttabclass = exttabpresence.getAttribute("aria-expanded");
			if (exttabclass.equalsIgnoreCase("false")) {
				exttab.click();
				// System.out.println(" External communication tab selected");
				GenerateReport.test.log(LogStatus.PASS, Methodname ,"Navigated to External Communication Tab ");
			} else {
				// System.out.println(" tab already selected ");
				GenerateReport.test.log(LogStatus.PASS,Methodname ,"Already selected External Communication Tab");
			}
			int ExternalCommrows = wd.findElements(By.xpath(".//*[@id='tab3']/tbody/tr")).size();
			// System.out.println("ExternalCommrows=" + ExternalCommrows);
			for (int s = 1; s <= ExternalCommrows; s++) {
				Thread.sleep(2000);
				String GroupRefID = wd.findElement(By.xpath(".//*[@id='tab3']/tbody/tr[" + s + "]/td[1]")).getText();
				String MsgID = wd.findElement(By.xpath(".//*[@id='tab3']/tbody/tr[" + s + "]/td[2]")).getText();
				String MsgType = wd.findElement(By.xpath(".//*[@id='tab3']/tbody/tr[" + s + "]/td[3]")).getText();
				String SourceDestination = wd.findElement(By.xpath(".//*[@id='tab3']/tbody/tr[" + s + "]/td[4]")).getText();
				String Direction = wd.findElement(By.xpath(".//*[@id='tab3']/tbody/tr[" + s + "]/td[5]")).getText();
				WebElement TransModenew=wd.findElement(By.xpath(".//*[@id='tab3']/tbody/tr[" + s + "]/td[6]"));
				String TransMode = TransModenew.getText();
				String TimeStamp = wd.findElement(By.xpath(".//*[@id='tab3']/tbody/tr[" + s + "]/td[7]")).getText();
				String Action = wd.findElement(By.xpath(".//*[@id='tab3']/tbody/tr[" + s + "]/td[8]")).getText();
				WebElement newstatus=wd.findElement(By.xpath(".//*[@id='tab3']/tbody/tr[" + s + "]/td[9]"));
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", TransModenew);
				String Status = newstatus.getText();
				// System.out.println(GroupRefID + " : " + MsgID + " : " +
				// MsgType + " : " + SourceDestination + " : "+ Direction + " :
				// " + TransMode + ":" + TimeStamp + ":" + Action + " : " +
				// Status);
				GenerateReport.test.log(LogStatus.PASS, Methodname,
						"External Communication tab  details are as follows : 1.GroupRefID =  " + GroupRefID + " 2.MsgID = " + MsgID
								+ " 3.MsgType = " + MsgType + " 4.SourceDestination= " + SourceDestination
								+  "5.Direction= " + Direction + "6.TransMode = " + TransMode + "7.TimeStamp= "
								+ TimeStamp + "8.Action = " + Action +  " 9.Status = " + Status + ".");
			   }
			((JavascriptExecutor) wd).executeScript("document.body.style.zoom='90%'");
			GenerateReport.test.log(LogStatus.PASS, strStep + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "ExternalCommunication_"+VolPayDriver.scenario+strStep)));
			GenerateReport.test.log(LogStatus.PASS, Methodname,"External Communication Completed Successfuly ");
			((JavascriptExecutor) wd).executeScript("document.body.style.zoom='100%'");
		} catch (NoSuchElementException e) {
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
