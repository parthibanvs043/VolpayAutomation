package com.volante.Payments;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;
import com.volante.volpayui.VolPayDriver;

public class Confirmation 
{
	//For Payment Confirmation
	public static void AllConfirmationStatus(WebDriver wd , String data,int Row , String PymtStatus,String strStep) throws InterruptedException, IOException
	{	
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try
		{		
			 WebDriverWait wait = new WebDriverWait(wd,30);
			 if (!(PymtStatus.equalsIgnoreCase("DUPLICATE")||PymtStatus.equalsIgnoreCase("REJECTED")||PymtStatus.equalsIgnoreCase("REPAIR")))
			 {
			       WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Payment Confirmation')]")));
				   if(element.isDisplayed())
				   {
					 element.click();
					 GenerateReport.test.log(LogStatus.PASS, strStep,"" + Methodname + " : Payment Confiramtion Button Found Successfully");
				     wd.switchTo().activeElement();
			         WebElement ConfStatusEle = wd.findElement(By.id("Confirmation Status"));
			         Select StatusSelect = new Select(ConfStatusEle);
			         List<WebElement> COpts = StatusSelect.getOptions();
			         int CS = COpts.size();
			         for(int i =1; i<CS ; i++)
			         {
			     		String ConfStatus = COpts.get(Row).getText();
			     		System.out.println(" status is " +ConfStatus);
			     		 //Select the Status
			        	 StatusSelect.selectByVisibleText(ConfStatus);
					     GenerateReport.test.log(LogStatus.PASS, strStep," " + Methodname + " : Confiramtion status selected as " +ConfStatus);
			        	 System.out.println("======= confiramtion status selected as " +ConfStatus);
			          	 //To add raw status message
			        	 WebElement RawStat = wd.findElement(By.xpath("//*[@id='Confirmation Raw Status']"));
			        	 RawStat.sendKeys(data+" "+ConfStatus);
					     GenerateReport.test.log(LogStatus.PASS, strStep,"" + Methodname + " : Confirmation Raw Message added as -  " +data+" for "+ConfStatus+" status");
			        	System.out.println("Status message added " +data+" "+ConfStatus);
			        	 Thread.sleep(1000);
			        	//To add Description message
			        	 WebElement Desc = wd.findElement(By.xpath("//input[@id='Description']"));
			        	 Desc.sendKeys(data+" "+ConfStatus);
					     GenerateReport.test.log(LogStatus.PASS, strStep,"" + Methodname + " : Confirmation Description  added as -  " +data+" for "+ConfStatus+" status");
			        	System.out.println("Description added as "+data+" "+ConfStatus);
			        	 Thread.sleep(1000);
			           	 //Submit
					      wd.findElement(By.xpath("(//button[contains(text(),'Submit')])[2]")).click();
					      Thread.sleep(3000);	
					      //To refresh 
					      wd.findElement(By.xpath("//button[@tooltip='Refresh']")).click();
					      System.out.println("Payments page refreshed");
					      Thread.sleep(1500);
					     GenerateReport.test.log(LogStatus.PASS, strStep,"" + Methodname + " : Payment Confirmation completed successfully  for the Status  "+ConfStatus);
			     		}        	      
				   }
				   else 
					{
					   GenerateReport.test.log(LogStatus.FAIL, strStep," " + Methodname + " : PaymentConfirmation Button Not Found. So Payment Confirmation Unsucessful");
					}
			   }
			 else {
					System.out.println("Payment confirmation is not possible for the "+PymtStatus +" status ");
				     GenerateReport.test.log(LogStatus.PASS, strStep ,"" + Methodname + " : Payment confirmation is not possible for this "+PymtStatus +" status ");
					}	
		}
		catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep+"_"+PymtStatus);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Run time exception Occured :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep+"_"+PymtStatus);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}
	
public static void PaymentConfirmation(WebDriver wd , String data, String PymtStatus,String strStep) throws InterruptedException, IOException
	{	
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try
		{		
			 WebDriverWait wait = new WebDriverWait(wd,30);
			 if (!(PymtStatus.equalsIgnoreCase("DUPLICATE")||PymtStatus.equalsIgnoreCase("REJECTED")||PymtStatus.equalsIgnoreCase("REPAIR")))
			 {
			       WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Payment Confirmation')]")));
				   if(element.isDisplayed())
				   {
					 element.click();
					 GenerateReport.test.log(LogStatus.PASS, strStep,"" + Methodname + " : Payment Confirmation Button Found Successfully");
				     wd.switchTo().activeElement();
			         WebElement ConfStatusEle = wd.findElement(By.id("Confirmation Status"));
			         Select StatusSelect = new Select(ConfStatusEle);
					    	 StatusSelect.selectByVisibleText(data);
					    	 //To add raw status message
				        	 WebElement RawStat = wd.findElement(By.xpath("//*[@id='Confirmation Raw Status']"));
				        	 RawStat.sendKeys(data);
						     GenerateReport.test.log(LogStatus.PASS, "Confirmation Raw Message added",data);
				        	 // System.out.println("Status message added " +data+" "+ConfStatus);
				        	 Thread.sleep(1000);
				        	 //To add Description message
				        	 WebElement Desc = wd.findElement(By.xpath("//input[@id='Description']"));
				        	 Desc.sendKeys(data);
						     GenerateReport.test.log(LogStatus.PASS, "Confirmation Description  added",data);
				        	 // System.out.println("Description added as "+data+" "+ConfStatus);
				        	 Thread.sleep(1000);
				           	 //Submit
						     wd.findElement(By.xpath("(//button[contains(text(),'Submit')])[2]")).click();
						     Thread.sleep(3000);	
						     //To refresh 
						     wd.findElement(By.xpath("//button[@tooltip='Refresh']")).click();
						     // System.out.println("Payments page refreshed");
						     Thread.sleep(5000);
						     GenerateReport.test.log(LogStatus.PASS, strStep, "Payment Confirmation completed successfully  for the Status  "+data);
						     GenerateReport.test.log(LogStatus.PASS, strStep + GenerateReport.test.addScreenCapture(GetScreenShot.capture(wd, "PaymentConfirmation_"+VolPayDriver.scenario+strStep)));
					      }
			     		}        	      
				   else 
					{
					   GenerateReport.test.log(LogStatus.FAIL, strStep," " + Methodname + " : PaymentConfirmation Button Not Found. So Payment Confirmation Unsucessful");
					}
			
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
	
}
