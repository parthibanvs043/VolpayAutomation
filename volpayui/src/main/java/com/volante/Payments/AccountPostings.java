package com.volante.Payments;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class AccountPostings {
	public static void AccountPosting(WebDriver wd, String strStep) throws IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebElement PymtEvent = wd.findElement(By.xpath("(//ul[@class='nav nav-tabs'])//li[4]"));
			WebElement PymtEventpresence = PymtEvent.findElement(By.tagName("a"));
			String PymtEventclass = PymtEventpresence.getAttribute("aria-expanded");
			if (PymtEventclass.equalsIgnoreCase("false")) {
				PymtEvent.click();
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Navigated to AccountPosting Tab ");
				//System.out.println(" Account Posting tab selected");
			} else {
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Already selected AccountPosting Tab");
				//System.out.println(" Account Posting tab Already selected");
			}
			int AccountPostingrows = wd.findElements(By.xpath(".//*[@id='tab4']/tbody/tr")).size();
			// System.out.println("AccountPostingrows="+AccountPostingrows);
			for (int s = 1; s <= AccountPostingrows; s++) {
				Thread.sleep(2000);
				String BulkPostingEntryID = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[1]"))
						.getText();
				String PostingEntryID = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[2]"))
						.getText();
				String AcctCategory = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[3]")).getText();
				String AcctID = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[4]")).getText();
				String AcctCurrency = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[5]")).getText();
				String AcctType = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[6]")).getText();
				String AcctSystem = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[7]")).getText();
				String AcctBranch = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[8]")).getText();
				String PostingEntryType = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[9]"))
						.getText();
				String Amount = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[10]")).getText();
				String DebtCrdt = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[11]")).getText();
				String PsotingOver = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[12]")).getText();
				String Narrative = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[13]")).getText();
				String StatusReason = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[14]")).getText();
				String Status = wd.findElement(By.xpath(".//*[@id='tab4']/tbody/tr[" + s + "]/td[15]")).getText();
				// System.out.println(BulkPostingEntryID+" : "+PostingEntryID+"
				// : "+AcctCategory+" : "+AcctID+" : "+AcctCurrency+" :
				// "+AcctType+":"+AcctSystem+":"+AcctBranch+":"+PostingEntryType+":"+Amount+"
				// :"+DebtCrdt+":"+PsotingOver+":"+Narrative+":"+StatusReason+""+Status);
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"Account Posting Tab  details are as follows : 1.BulkPostingEntryID =  " + BulkPostingEntryID
								+ " 2.PostingEntryID = " + PostingEntryID + " 3.AcctCategory = " + AcctCategory
								+ " 4.AcctID =" + AcctID + " 5.AcctCurrency= " + AcctCurrency + " 6.AcctType= "
								+ AcctType + "7.AcctSystem= " + AcctSystem + "8.AcctBranch = " + AcctBranch
								+ "9.PostingEntryType= " + PostingEntryType + "10.Amount = " + Amount
								+ " 11.DebtCrdt = " + DebtCrdt + "12.PsotingOver = " + PsotingOver + "13.Narrative ="
								+ Narrative + "14.StatusReason = " + StatusReason + "15.Status = " + Status + ".");

			}
			GenerateReport.test.log(LogStatus.PASS, strStep,
					"" + Methodname + " : Account Posting Completed Successfuly ");
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
