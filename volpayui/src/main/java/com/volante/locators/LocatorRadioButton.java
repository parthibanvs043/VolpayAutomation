package com.volante.locators;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
 
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;

public class LocatorRadioButton {

	public static void RadioEnter_name(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement element = wd.findElement(By.name(pr));*/
			if (element.isDisplayed()){
				//GenerateReport.test.log(LogStatus.PASS, strStep,"" + Methodname + " :element found  Successfully");
			}
			List<WebElement> elements = wd.findElements(By.name(pr));
			// This will tell you the number of checkboxes are present
			int iSize = elements.size();
			// Start the loop from first checkbox to last checkboxe
			for (int i = 0; i < iSize; i++) {
				// Store the checkbox name to the string variable, using 'Value'
				// attribute
				String sValue = elements.get(i).getAttribute("value");
				boolean bValue = false;
				bValue = elements.get(i).isSelected();
				// Select the checkbox it the value of the checkbox is same what
				// you are looking for
				if (bValue == false & sValue.equalsIgnoreCase(dt)) {
					elements.get(i).click();
					// This will take the execution out of for loop
					break;
				} else if (bValue == true & sValue.equalsIgnoreCase(dt)) {
					// CheckBox.get(i).click();
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

	public static void RadioEnter_Id(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			 
			WebDriverWait wait = new WebDriverWait(wd, 60);
			WebElement elements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(pr)));
			/*wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			WebElement elements = wd.findElement(By.id(pr));*/
			if (elements.isDisplayed()){
				GenerateReport.test.log(LogStatus.PASS, strStep,"" + Methodname + " :element found  Successfully");
			}
			List<WebElement> element = wd.findElements(By.id(pr));
			// This will tell you the number of checkboxes are present
			int iSize = element.size();
			// Start the loop from first checkbox to last checkboxe
			for (int i = 0; i < iSize; i++) {
				// Store the checkbox name to the string variable, using 'Value'
				// attribute
				String sValue = element.get(i).getAttribute("value");
				// System.out.println("Slected row is..."+i);
				// System.out.println("RadioButton Values...."+sValue);
				boolean bValue = false;
				bValue = element.get(i).isSelected();
				// System.out.println("RadioButton enabled Values...."+bValue);
				// Select the checkbox it the value of the checkbox is same what
				// you are looking for
				if (bValue == false & sValue.equalsIgnoreCase(dt)) {
					// System.out.println("Input data....."+dt);
					element.get(i).click();
					// System.out.println("IN Values...."+sValue);
					// This will take the execution out of for loop
					break;
				} else if (bValue == true & sValue.equalsIgnoreCase(dt)) {
					// CheckBox.get(i).click();
					// System.out.println("Output data....."+dt);
					// System.out.println("Out Values...."+sValue);
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
