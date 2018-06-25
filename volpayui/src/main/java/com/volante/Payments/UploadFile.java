package com.volante.Payments;

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



public class UploadFile 
{
 
public static void Fileupload(WebDriver wd, String pr, String dt,String strStep) throws IOException
{
	String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();  
	try {
		      WebDriverWait wait = new WebDriverWait(wd, 60);
	          WebElement UploadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadBtn")));
	         // UploadButton.click();    // to this for latest version
	          UploadButton.sendKeys(dt);
	          Thread.sleep(2500);
	          wd.findElement(By.id("uploadHere")).click();
			  GenerateReport.test.log(LogStatus.PASS, strStep,""+Methodname+ ":File uploaded Successfully");
			}
	  catch (NoSuchElementException e) {
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
/*public static void Fileuploadold(WebDriver wd, String pr, String dt,String strStep) throws IOException
{
	String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();  
	try {
		      WebDriverWait wait = new WebDriverWait(wd, 60);
		      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'File Upload')]")));
		      element.click();
		      WebElement FileUpload = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FileUpload")));
	          FileUpload.click();
	          WebElement SelectPSA = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("select2-Filechannel-container")));
	          SelectPSA.click();
	          WebElement UploadFile = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select2-search__field")));
	          UploadFile.sendKeys(pr);
	          Thread.sleep(2000);
	          UploadFile.sendKeys(Keys.ENTER);
	          WebElement UploadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploadBtn")));
	          UploadButton.sendKeys(dt);
	          Thread.sleep(2500);
	          wd.findElement(By.id("uploadHere")).click();
			  GenerateReport.test.log(LogStatus.PASS, strStep,""+Methodname+ ":File uploaded Successfully");
			}
	  catch (NoSuchElementException e) {
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
}*/
}
