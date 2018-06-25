package com.volante.locators;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;

public class LocatorDropListSelect {

	public static void DropListSelectText_Xpath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {

			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			if(!element.isDisplayed())
			{
				((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			else
			{
			((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", element);
			}
			element.click();
			WebElement elementlist = wd.findElement(By.xpath("//span[@class='select2-results']/ul"));
			List<WebElement> DropList = elementlist.findElements(By.tagName("li"));
			for (WebElement drop : DropList) 
			{
				String valText = drop.getText();
				System.out.println("DROP TEXT VALUES="+valText);
				Thread.sleep(1000);
				if (valText.equalsIgnoreCase(dt)) {
					((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", drop);
					Thread.sleep(2000);
					drop.click();
					drop.sendKeys(Keys.ENTER);
					System.out.println("elemt selected for dt "+valText);
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
	public static void DropListEnterText_Xpath(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
			try {
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(pr)));
			element.click();
			element.sendKeys(dt);
			Thread.sleep(2000);
			element.sendKeys(Keys.ENTER);
			ReportGeneration.test.log(Status.PASS,strStep);
			}	
		 catch (NoSuchElementException e) {
			 String screenShotPath = GetScreenShot.capture(wd, strStep);
				ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (Exception e) {
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}

}