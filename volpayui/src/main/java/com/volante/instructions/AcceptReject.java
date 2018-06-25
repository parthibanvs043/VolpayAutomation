package com.volante.instructions;

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

public class AcceptReject {

	// To accept file / payment through Instruction Id Search
	public static void Fileaccept(WebDriver wd,  String value, String strStep) throws IOException {
		try {
			
			WebDriverWait wait = new WebDriverWait(wd, 30);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains (text(),'Accept')]")));
			if (element.isDisplayed()) {
				GenerateReport.test.log(LogStatus.PASS, "Is Accept Button Present", "Yes");
				GenerateReport.test.log(LogStatus.PASS,"Accept Button Refer Below Screen: " + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "AcceptButtonScreen")));
				element.click();
				//System.out.println("File Accepted");
				wd.findElement(By.id("restoreFileData")).click();
				GenerateReport.test.log(LogStatus.PASS, "Accept the Duplicate File through button", "Accepted successfuly");
				Thread.sleep(3000);
				advancesearch.InstrIdsearch(wd, value, strStep);
				GenerateReport.test.log(LogStatus.PASS,"File Accepted Refer Below Screen: " + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "FileAcceptScreen")));
			} else {
				GenerateReport.test.log(LogStatus.FAIL, "Is Accept Button Present", "No");
				GenerateReport.test.log(LogStatus.FAIL, "Accept Button not available"," Cannot perform Acccept action");
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

	//To accept file / payment through Instruction Id Search
	public static void Filereject(WebDriver wd, String value, String strStep) throws IOException {
		try {
			WebDriverWait wait = new WebDriverWait(wd, 30);
			WebElement element = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains (text(),'Reject')]")));
			if (element.isDisplayed()) {
				GenerateReport.test.log(LogStatus.PASS, "Is Reject Button Present", "Yes");
				GenerateReport.test.log(LogStatus.PASS,"Reject Button Refer Below Screen: " + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "RejectButtonScreen")));
				element.click();
				//System.out.println("File  Rejected");
				GenerateReport.test.log(LogStatus.PASS, "Reject the Duplicate File through button", "Rejected successfuly");
				GenerateReport.test.log(LogStatus.PASS,"File Accepted Refer Below Screen: " + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "FileRejectScreen")));
				advancesearch.InstrIdsearch(wd, value, strStep);
			} else {
				System.out.println("Reject button is not available");
				GenerateReport.test.log(LogStatus.PASS, "Is Reject Button Present", "No");
				GenerateReport.test.log(LogStatus.FAIL, "Reject Button not available",
						" Cannot perform Reject action");
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
