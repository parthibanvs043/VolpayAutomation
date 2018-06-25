package com.volante.locators;

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
import com.aventstack.extentreports.*;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;

public class LocatorCalenderTillDate {

	public static void TillDate(WebDriver wd, String pr, String strStep) throws InterruptedException, IOException {
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

			ReportGeneration.test.log(Status.PASS,strStep); 
		} 
		catch (NoSuchElementException e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} 
		catch (Exception e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}
}