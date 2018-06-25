package com.volante.locators;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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

public class LocatorByXPATH {

	// Click method using locater ID
	public static void Click_XPath(WebDriver wd, String pr, String strStep) throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.xpath(pr));*/
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			else
			{
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			element.click();
			ReportGeneration.test.log(Status.PASS,strStep); 
		} 
		catch (NoSuchElementException e) 
		{
			System.out.println("First Catch");
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} 
		catch (Exception e) 
		{
			System.out.println("second Catch"+ e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}

	// Send the Text using Locator ID
	public static void Enter_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			else
			{
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}
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
	// Single Select Using locator Xpath
	public static void Select_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
		    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
			else
			{
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			element.click();
			Thread.sleep(2000);
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
	public static void DropDown_Text_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
				System.out.println("here1");
			}
			else
			{
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
				System.out.println("here2");
			}
			element.click();
			element.sendKeys(Keys.ENTER);
			Thread.sleep(1500);
			Select se = new Select(wd.findElement(By.xpath(pr)));
			se.selectByVisibleText(dt);
			ReportGeneration.test.log(Status.PASS,strStep); 
		} 
		catch (NoSuchElementException e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep+ " with No Such Elem Exception", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} 
		catch (Exception e) 
		{
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep+ " Runtime Exception " +e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}
	// Select from DropDown by using Index
	public static void DropDown_Index_XPath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			if (!element.isDisplayed()) {
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);
			}
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