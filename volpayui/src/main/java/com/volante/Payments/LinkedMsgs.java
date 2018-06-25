package com.volante.Payments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class LinkedMsgs {
	public static void LinkedMessages(WebDriver wd, String strStep) throws IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement linkMsg = wd.findElement(By.xpath("(//ul[@class='nav nav-tabs'])//li[6]"));
			WebElement linkMsgpresence = linkMsg.findElement(By.tagName("a"));
			String linkMsgclass = linkMsgpresence.getAttribute("aria-expanded");
			if (linkMsgclass.equalsIgnoreCase("false")) {
				linkMsg.click();
				// System.out.println(" Linked Message tab selected");
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Navigated to Linked Message tab ");
			} else {
				// System.out.println(" tab already selected ");
				GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " :Already Linked Message tab ");
			}
			int linkedrows = wd.findElements(By.xpath(".//*[@id='tab6']/tbody/tr")).size();
			// System.out.println("linkedrows="+linkedrows);
			for (int s = 1; s <= linkedrows; s++) {
				Thread.sleep(2000);
				String LinkedMsgID = wd.findElement(By.xpath(".//*[@id='tab6']/tbody/tr[" + s + "]/td[1]")).getText();
				String LinkedMsgFunc = wd.findElement(By.xpath(".//*[@id='tab6']/tbody/tr[" + s + "]/td[2]")).getText();
				String Direction = wd.findElement(By.xpath(".//*[@id='tab6']/tbody/tr[" + s + "]/td[3]")).getText();
				String TimeStamp = wd.findElement(By.xpath(".//*[@id='tab6']/tbody/tr[" + s + "]/td[4]")).getText();
				// System.out.println(LinkedMsgID+" : "+LinkedMsgFunc+" :
				// "+Direction+" : "+TimeStamp);
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"Linked Message  tab  details are as follows : 1.LinkedMsgID =  " + LinkedMsgID
								+ " 2.LinkedMsgFunc = " + LinkedMsgFunc + " 3.Direction = " + Direction
								+ " 4.TimeStamp= " + TimeStamp + ".");
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Linked message Completed Successfuly ");
			}
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
