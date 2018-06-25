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
import com.volante.search.advancesearch;
import com.volante.utilities.GetScreenShot;

public class PaymentAcceptReject {

	// To accept file / payment
	public static void Paymentaccept(WebDriver wd, String field, String value, int rno, String strStep)
			throws IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebDriverWait wait = new WebDriverWait(wd, 20);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains (text(),'Accept')]")));
			if (element.isDisplayed()) {
				GenerateReport.test.log(LogStatus.PASS, "Is Accept Button Present", "Yes");
				GenerateReport.test.log(LogStatus.PASS,"Accept Button Refer Below Screen: " + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "PaymentAcceptButtonScreen")));
				element.click();
				Thread.sleep(3000);
				 System.out.println("File /Payment Accepted");
				wd.findElement(By.cssSelector("div[tooltip='Refresh']")).click();
				GenerateReport.test.log(LogStatus.PASS, "Accept the Duplicate Payment through button", "Accepted successfuly");
				advancesearch.Pymtadvsearch(wd, value, field, rno,strStep);
				GenerateReport.test.log(LogStatus.PASS,"Payment Accepted Refer Below Screen: " + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "PaymentAcceptScreen")));
			} else {
				GenerateReport.test.log(LogStatus.FAIL, strStep, " " + Methodname + " :Cannot perform Acccept action");
			}
		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Run time exception Occured :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}

	}

	// To Reject file / payment
	public static void Paymentreject(WebDriver wd, String field, String value, int rno, String strStep)
			throws IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			WebDriverWait wait = new WebDriverWait(wd, 20);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains (text(),'Reject')]")));
			if (element.isDisplayed()) {
				GenerateReport.test.log(LogStatus.PASS, "Is Reject Button Present", "Yes");
				GenerateReport.test.log(LogStatus.PASS,"Reject Button Refer Below Screen: " + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "PaymentRejectButtonScreen")));
				element.click();
				// System.out.println("File /Payment Rejected");
				GenerateReport.test.log(LogStatus.PASS, "Reject the Duplicate Payment through button", "Rejected successfuly");
				GenerateReport.test.log(LogStatus.PASS,"File Accepted Refer Below Screen: " + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "PaymentRejectScreen")));
				advancesearch.Pymtadvsearch(wd, value, field, rno,strStep);
			} else {
				// System.out.println("Reject button is not available");
				GenerateReport.test.log(LogStatus.PASS, "Is Reject Button Present", "No");
				GenerateReport.test.log(LogStatus.FAIL, strStep, " " + Methodname + " :Cannot perform Reject action");
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
