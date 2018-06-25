package com.volante.Payments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class SystemInteractions {

	public static void SystemInteraction(WebDriver wd, String strStep) throws IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement SysInt = wd.findElement(By.xpath("(//ul[@class='nav nav-tabs'])//li[2]"));
			WebElement SysIntpresence = SysInt.findElement(By.tagName("a"));
			String SysIntclass = SysIntpresence.getAttribute("aria-expanded");
			if (SysIntclass.equalsIgnoreCase("false")) {
				SysInt.click();
				// System.out.println(" System Interaction tab selected");
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Navigated to System Interaction  tab ");
			} else {
				// System.out.println(" tab already selected ");
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Already in  System Interaction  tab ");

			}
			int SystemInteracctionrows = wd.findElements(By.xpath(".//*[@id='tab2']/tbody/tr")).size();
			System.out.println("SystemInteracctionrows=" + SystemInteracctionrows);
			for (int s = 1; s <= SystemInteracctionrows; s++) {
				Thread.sleep(2000);
				String GroupRefID = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[1]")).getText();
				String MsgID = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[2]")).getText();
				String RelationShip = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[3]")).getText();
				String InvocaionPoint = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[4]"))
						.getText();
				String IsSynch = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[5]")).getText();
				String TimeSatmp = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[6]")).getText();
				String Attempt = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[7]")).getText();
				String Status = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[8]")).getText();
				String OriInterStatus = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[9]"))
						.getText();
				String Action = wd.findElement(By.xpath(".//*[@id='tab2']/tbody/tr[" + s + "]/td[10]")).getText();
				// System.out.println(GroupRefID + " : " + MsgID + " : " +
				// RelationShip + " : " + InvocaionPoint + " : " + IsSynch + " :
				// " + TimeSatmp + ":" + Attempt + ":" + Status + ":" +
				// OriInterStatus + ":"+ Action);
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"System Interaction tab  details are as follows : 1.GroupRefID =  " + GroupRefID + " 2.MsgID = "
								+ MsgID + " 3.RelationShip = " + RelationShip + " 4.InvocaionPoint= " + InvocaionPoint
								+ " 5.IsSynch= " + IsSynch + " 6.TimeSatmp= " + TimeSatmp + " 7.Attempt= " + Attempt
								+ " 8.Status= " + Status + " 9.OriInterStatus= " + OriInterStatus + " 10.Action= "
								+ Action + ".");
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : System Interaction Completed Successfuly ");
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
