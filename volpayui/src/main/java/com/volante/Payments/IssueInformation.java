package com.volante.Payments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class IssueInformation {
	public static void PaymentErrorInfo(WebDriver wd, String strStep) throws IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement IssInfo = wd.findElement(By.xpath("(//ul[@class='nav nav-tabs'])//li[5]"));
			WebElement IssInfopresence = IssInfo.findElement(By.tagName("a"));
			String IssInfoclass = IssInfopresence.getAttribute("aria-expanded");
			if (IssInfoclass.equalsIgnoreCase("false")) {
				IssInfo.click();
				// System.out.println(" Issue Information tab selected");
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Navigated to Issue Information tab ");
			} else {
				// System.out.println(" tab already selected ");
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Already in Issue Information tab ");
			}
			// wd.findElement(By.xpath("//html/body/div[2]/div/div[3]/div/div[2]/div[5]/div[2]/div/ul/li[5]/a")).click();
			int issueInforows = wd.findElements(By.xpath(".//*[@id='tab5']/tbody/tr")).size();
			System.out.println("issueInforows=" + issueInforows);
			for (int s = 1; s <= issueInforows; s++) {
				Thread.sleep(2000);
				String IssueCode = wd.findElement(By.xpath(".//*[@id='tab5']/tbody/tr[" + s + "]/td[1]")).getText();
				String Description = wd.findElement(By.xpath(".//*[@id='tab5']/tbody/tr[" + s + "]/td[2]")).getText();
				String IssueOrigin = wd.findElement(By.xpath(".//*[@id='tab5']/tbody/tr[" + s + "]/td[3]")).getText();
				String Severity = wd.findElement(By.xpath(".//*[@id='tab5']/tbody/tr[" + s + "]/td[4]")).getText();
				String SuggResolution = wd.findElement(By.xpath(".//*[@id='tab5']/tbody/tr[" + s + "]/td[5]"))
						.getText();
				String TimeStamp = wd.findElement(By.xpath(".//*[@id='tab5']/tbody/tr[" + s + "]/td[6]")).getText();
				String IsHandled = wd.findElement(By.xpath(".//*[@id='tab5']/tbody/tr[" + s + "]/td[7]")).getText();
				//System.out.println(IssueCode + " : " + Description + " : " + IssueOrigin + " : " + Severity + " : "+ SuggResolution + " : " + TimeStamp + ":" + IsHandled);
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"Issue Information tab  details are as follows : 1.IssueCode =  " + IssueCode
								+ " 2.Description = " + Description + " 3.IssueOrigin = " + IssueOrigin
								+ " 4.Severity= " + Severity + " 5.SuggResolution = " + SuggResolution
								+ " 6.TimeStamp = " + TimeStamp + "7.IsHandled = " + IsHandled + ".");
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Issue Information  Completed Successfuly ");
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
