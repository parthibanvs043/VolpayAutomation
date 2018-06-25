package com.volante.elements;

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

public class CheckBox {
	// Checking
	public static void CheckingChkbox(WebDriver wd, String pr, String strStep) throws InterruptedException, IOException {
		boolean checkstatus;

		try {
			
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.xpath(pr));*/
			checkstatus = element.isSelected();
			if (checkstatus == true) {
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : Checkbox is already checked");
			} else {
				element.click();
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"" + Methodname + " : Checkbox element is  checked Successfuly");
			}

		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element using Xpath" + e.getMessage());
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

	// Unchecking

}
