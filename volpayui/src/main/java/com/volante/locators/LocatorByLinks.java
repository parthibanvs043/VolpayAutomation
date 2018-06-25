package com.volante.locators;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;

public class LocatorByLinks {

	// Click on Link using LinkText
	public static void Click_Link(WebDriver wd, String pr, String strStep) throws InterruptedException, IOException {
		try {

			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(pr)));
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			element.click();
			ReportGeneration.test.log(Status.PASS, strStep);
		} catch (NoSuchElementException e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (Exception e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}

	// Verify the Link Text
	public static void Verify_linkText(WebDriver wd, String pr, String strStep)
			throws InterruptedException, IOException {
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {

			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(pr)));
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			if (element.isDisplayed()) {
				// ystem.out.println("Yes");
				ReportGeneration.test.log(Status.PASS, strStep);
			}
		} catch (NoSuchElementException e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (Exception e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}
}
