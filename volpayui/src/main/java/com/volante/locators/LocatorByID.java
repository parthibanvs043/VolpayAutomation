package com.volante.locators;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;

public class LocatorByID {
	// Click method using locater ID
	public static void Click_ID(WebDriver wd, String pr, String strStep) throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));	
			if (wd.findElement(By.id(pr)) != null) {
				element.click();
			} else {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();
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
	// Send the Text using Locator ID
	public static void Enter_ID(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			//((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();
				element.clear();
				element.sendKeys(dt);
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
	// Single Select Using locator ID
	public static void Select_ID(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(3000);
			element.click();
			// System.out.println(".................Clicking.................");
			Thread.sleep(1500);
			element.sendKeys(dt);
			Thread.sleep(2000);
			element.sendKeys(Keys.ENTER);
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
	// Select from DropDown by Using Locator ID
	public static void DropDown_Text_ID(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			element.click();
			Select se = new Select(wd.findElement(By.id(pr)));
			se.selectByVisibleText(dt);
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
	// Select from DropDown by using Index
	public static void DropDown_Index_ID(WebDriver wd, String pr, String dt, String strStep)throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			Select se = new Select(element);
			int d = Integer.parseInt(dt);
			se.selectByIndex(d);
			ReportGeneration.test.log(Status.PASS,strStep); 
		} catch (NoSuchElementException e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (NumberFormatException e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (Exception e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}
}
