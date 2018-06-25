package com.volante.calender;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class CalenderTillDate {

	public static void TillDate(WebDriver wd, String pr, String strStep) throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			boolean isChecked = false;
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wd.findElements(By.cssSelector(pr)).get(2).click();
			WebElement alll = wd.findElement(By.className("table-condensed"));
			List<WebElement> roww = alll.findElements(By.tagName("tr"));
			for (int i = 2; i < roww.size(); i++) {
				List<WebElement> col = roww.get(i).findElements(By.tagName("td"));
				for (WebElement v : col) {
					DateFormat dateFormat = new SimpleDateFormat("dd");
					Date date = new Date();
					String today = dateFormat.format(date);
					String padded = v.getText();
					if (padded.length() < 2) {
						padded = "0" + padded;
						if (padded.equalsIgnoreCase(today)) {
							v.click();
							isChecked = true;
							break;
						}
					} else if (padded.equalsIgnoreCase(today)) {
						v.click();
						isChecked = true;
						break;
					}
				}
				if (isChecked) {
					break;
				}
			}

			//String SelectedDate = element.getText();
			GenerateReport.test.log(LogStatus.PASS, strStep, ""+Methodname+" : Date Selected Successfully as " + Methodname);

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