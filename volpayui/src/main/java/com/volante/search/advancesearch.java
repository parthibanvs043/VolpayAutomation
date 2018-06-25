package com.volante.search;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class advancesearch {
	public static void Pymtadvsearch(WebDriver wd, String value, String field, int rno,String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			wd.findElement(By.xpath("//a[@title='All Payments']")).click();
			wd.findElement(By.xpath("//span[contains(text(),'Show Advanced Search')]")).click();
			List<WebElement> input = wd.findElements(By.tagName("input"));
			for (WebElement inputtags : input) {
				String Placeholder = inputtags.getAttribute("placeholder");
				if (Placeholder.equalsIgnoreCase(field)) {
					inputtags.click();
					inputtags.clear();
					inputtags.sendKeys(value);
					Thread.sleep(1500);
					wd.findElement(By.xpath("//button[@value='Search']")).click();
					WebElement InstrId = wd.findElement(By.xpath("//div[1]/table/tbody/tr/td[3]"));
					String InstrIdVal = InstrId.getText();
					//System.out.println("===********************Instruction ID is " + InstrIdVal);
					Thread.sleep(1000);
					// clear Advance Payment result
					wd.findElement(By.id("searchBtn")).click();
					// To search by InstructionId
					InstrIdsearch(wd, InstrIdVal,strStep);
					int PaymentCount = wd.findElements(By.xpath(".//*[@id='tab1']/tbody/tr")).size();
					//System.out.println("Total No of Payments=" + PaymentCount);
					// To check if payment is present & Select the payment
					for (int r = 1; r <= PaymentCount; r++) {
						WebElement PaymentID = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + r + "]/td[1]"));
						Thread.sleep(2500);
						WebElement PaymentStatus = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + r + "]/td[8]"));
						String GetPaymentID = PaymentID.getText();
						String GetPaymentStatus = PaymentStatus.getText();
						if (value.equalsIgnoreCase(GetPaymentID)) {
							PaymentID.click();
							Thread.sleep(1500);
							System.out.println("Matched Payment clicked");
						}
						System.out.println("===********************Final Payment Status " + GetPaymentStatus+ " for payment " + r + " with Payment Id " + GetPaymentID);
						GenerateReport.test.log(LogStatus.PASS, strStep,
								""+Methodname+ " : Advance serach result for After search result is " + GetPaymentStatus + " for payment "+ r + " with Payment Id " + GetPaymentID);
						}
					break;
				}
			}
			
			GenerateReport.test.log(LogStatus.PASS, strStep,""+Methodname+" : Advance search completed Successfully and verified");
			
			
		} catch (NoSuchElementException e) {
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

	public static void InstrIdsearch(WebDriver wd, String value,String strStep) throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			wd.findElement(By.xpath("//a[@title ='Received Instructions']")).click();
			WebElement searchId = wd.findElement(By.cssSelector("#searchBox"));
			searchId.click();
			searchId.clear();
			searchId.sendKeys(value);
			Thread.sleep(1500);
			wd.findElement(By.cssSelector(".fa.fa-search")).click();
			GenerateReport.test.log(LogStatus.PASS, "Search By Instruction ID", " "+ Methodname+ " : Instruction Id search completed Successfully");
			WebElement InstrIdResult = wd.findElement(By.xpath("//div[8]/table/tbody/tr/td[2]"));
			String InstrIdResultVal = InstrIdResult.getText();
			//System.out.println("===********************InstrResult Value" + InstrIdResultVal);
			GenerateReport.test.log(LogStatus.PASS,"Search By Instruction ID" ,""+Methodname+"Intruction Id Search result is " + InstrIdResultVal);
			InstrIdResult.click();
			Thread.sleep(2000);
		} catch (NoSuchElementException e) {
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

//To do for instruvtion advanced search
	public static void Instradvsearch(WebDriver wd, String value, String field, int rno,String strStep) throws InterruptedException {
		wd.findElement(By.xpath("//a[@title='All Payments']")).click();
		wd.findElement(By.xpath("//span[contains(text(),'Show Advanced Search')]")).click();
		List<WebElement> input = wd.findElements(By.tagName("input"));
		for (WebElement inputtags : input) {
			String Placeholder = inputtags.getAttribute("placeholder");
			if (Placeholder.equalsIgnoreCase(field)) {
				inputtags.click();
				inputtags.clear();
				inputtags.sendKeys(value);
				Thread.sleep(1500);
				wd.findElement(By.xpath("//button[@value='Search']")).click();
				GenerateReport.test.log(LogStatus.PASS, "Advance Search", "Advance search completed Successfully");

			}
		}

	}
}