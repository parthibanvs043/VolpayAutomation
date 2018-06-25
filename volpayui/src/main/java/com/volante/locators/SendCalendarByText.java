package com.volante.locators;
/*package com.volante.calender;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class SendCalendarByText 
{
       
 public static void Calendar_ID(WebDriver wd, String pr, String dt,  String strStep) throws InterruptedException, IOException {
		
	 try 
		{
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement element=wd.findElement(By.id(pr));
			if(!element.isDisplayed())
	        {
        	      ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);	
                }
	        element.click();
			element.clear();
			element.sendKeys(dt);
			element.sendKeys(Keys.ENTER);
    	    
			GenerateReport.test.log(LogStatus.PASS, strStep,"Date Selected Successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		}
	}

 public static void Calendar_name(WebDriver wd, String pr, String dt, String strTCNum, String strStep, int ScenarioNum) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
	try 
	{
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement element=wd.findElement(By.name(pr));
		element.click();
		element.clear();
		element.sendKeys(dt);
		element.sendKeys(Keys.ENTER);
		if(!element.isDisplayed())
	        {
        	      ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);	
                }
	        element.click();
	        
			GenerateReport.test.log(LogStatus.PASS, strStep,"Date Selected Successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		}
	}

 public static void Calendar_CSS(WebDriver wd, String pr, String dt, String strTCNum, String strStep, int ScenarioNum) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
	try 
	{
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement element=wd.findElement(By.cssSelector(pr));
		element.click();
		element.clear();
		element.sendKeys(dt);
		element.sendKeys(Keys.ENTER);
		if(!element.isDisplayed())
	        {
        	      ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);	
                }
	        element.click();
	        
			GenerateReport.test.log(LogStatus.PASS, strStep,"Date Selected Successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		}
	}

 public static void Calendar_Xpath(WebDriver wd, String pr, String dt, String strTCNum, String strStep, int ScenarioNum) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
	try 
	{
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement element=wd.findElement(By.xpath(pr));
		element.click();
		element.clear();
		element.sendKeys(dt);
		element.sendKeys(Keys.ENTER);
		if(!element.isDisplayed())
	        {
        	      ((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", element);	
                }
	        element.click();
	        
			GenerateReport.test.log(LogStatus.PASS, strStep,"Date Selected Successfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		}
		}
	}
*/