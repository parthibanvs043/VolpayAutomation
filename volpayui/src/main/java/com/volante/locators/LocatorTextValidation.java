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

public class LocatorTextValidation {

	// Click method using locater ID
public static void Text_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			System.out.println("sfkewrgkhkergkle-----");
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			else
			{
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			//element.click();
			String Textvalue = element.getText();
			if (Textvalue.equalsIgnoreCase(dt)) {
				ReportGeneration.test.log(Status.PASS,strStep); 
			} else {
				String screenShotPath = GetScreenShot.capture(wd, strStep);
				ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			}
		} catch (NoSuchElementException e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (Exception e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}

	// Verify Text using locater ID
	public static void NoText_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			element.click();
			Thread.sleep(2000);
			String Textvalue = element.getText();
			if (!Textvalue.equalsIgnoreCase(dt)) {
				ReportGeneration.test.log(Status.PASS,strStep); 
			} else {
				String screenShotPath = GetScreenShot.capture(wd, strStep);
				ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			}
		}catch (NoSuchElementException e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (Exception e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}

	}

	// Verify Text using locater ID
	public static void TextPresent_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			System.out.println(pr);
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			Thread.sleep(2000);
			String Textvalue = element.getText();
			if (Textvalue.contains(dt)) {
				ReportGeneration.test.log(Status.PASS,strStep); 
			} else {
				String screenShotPath = GetScreenShot.capture(wd, strStep);
				ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			}
		} catch (NoSuchElementException e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (Exception e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}

	}
	public static void ByColumnName(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		try {
			int rows = wd.findElements(By.xpath(pr)).size();
			// System.out.println("Total No of rows in table =" + rows);
			// To check if payment is present & Select the payment
			for (int r = 1; r <= rows; r++) {
				WebElement col = wd.findElement(By.xpath(pr + "[" + r + "]/td[1]/span"));
				String colval = col.getText();
				if (colval.equalsIgnoreCase(dt)) {
					col.click();
					System.out.println(" val clicked for ***" + col);
					ReportGeneration.test.log(Status.PASS,strStep);  
					break;
				}
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