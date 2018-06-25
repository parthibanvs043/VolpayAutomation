package com.volante.instructions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class InstructionAdvanceSearch {
	//To do for instruction advanced search

		public static void advseachByID(WebDriver wd, String value, String strStep) throws InterruptedException, IOException {
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			try{
			wd.findElement(By.xpath("//a[@title='Received Instructions']")).click();
			wd.findElement(By.xpath("//span[contains(text(),'Show Advanced Search')]")).click();
			List<WebElement> input = wd.findElements(By.tagName("input"));
			for (WebElement inputtags : input) {
				String Placeholder = inputtags.getAttribute("placeholder");
				if (Placeholder.equalsIgnoreCase("Instruction ID")) {
					WebElement inputfield = wd.findElement(By.xpath("(//input[@placeholder='Instruction ID'])[2]"));
					inputfield.click();
					inputfield.sendKeys(value);
					Thread.sleep(1500);
					wd.findElement(By.xpath("//button[@value='Search']")).click();	
							WebElement InstrID = wd.findElement(By.xpath("(//table[starts-with(@class,'table table-striped')])[2]/tbody/tr[1]/td[2]"));
							String InstrIDVal = InstrID.getText();
							System.out.println("---------------InstrID for File  = " + InstrIDVal);
							WebElement InstrStatus = wd.findElement(By.xpath("(//table[starts-with(@class,'table table-striped')])[2]/tbody/tr[1]/td[7]"));
							String InstrStatusVal = InstrStatus.getText();
							System.out.println("---------------InstrStatusVal for File  = " + InstrStatusVal);	
							// clear Advance Payment result
							wd.findElement(By.id("searchBtn")).click();						
							if (value.equalsIgnoreCase(InstrIDVal)) {
							// To search by InstructionId	
								String screenShotPath = GetScreenShot.capture(wd, strStep);
								GenerateReport.test.log(LogStatus.PASS,"PASS-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								GenerateReport.test.log(LogStatus.PASS, strStep, " "+ Methodname+ " :Advance search completed Successfully for ID");
								System.out.println("Success ");	
						}					
							break;												}						
					Thread.sleep(1500);
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
		public static void advseachByOrgInstrID(WebDriver wd, String value, String strStep) throws InterruptedException, IOException {
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			try{
			wd.findElement(By.xpath("//a[@title='Received Instructions']")).click();
			wd.findElement(By.xpath("//span[contains(text(),'Show Advanced Search')]")).click();
			List<WebElement> input = wd.findElements(By.tagName("input"));
			for (WebElement inputtags : input) {
				String Placeholder = inputtags.getAttribute("placeholder");
				if (Placeholder.equalsIgnoreCase("Original Instruction ID")) {
					WebElement inputfield = wd.findElement(By.xpath("//input[@placeholder='Original Instruction ID']"));
					inputfield.click();
					inputfield.sendKeys(value);
					Thread.sleep(1500);
					wd.findElement(By.xpath("//button[@value='Search']")).click();	
					Thread.sleep(2000);				
							WebElement OrgID = wd.findElement(By.xpath("(//table[starts-with(@class,'table table-striped')])[2]/tbody/tr[1]/td[8]"));
							String OrgIDVal = OrgID.getText();
							System.out.println("---------------InstrStatusVal for File  = " + OrgIDVal);	
							// clear Advance Payment result
							wd.findElement(By.id("searchBtn")).click();	
							//to verify search result
							if (value.equalsIgnoreCase(OrgIDVal)) {
								String screenShotPath = GetScreenShot.capture(wd, strStep);
								GenerateReport.test.log(LogStatus.PASS,"PASS-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								GenerateReport.test.log(LogStatus.PASS, strStep, " "+ Methodname+ " :Advance search completed Successfully for Orginal Instr ID " +OrgIDVal);
								System.out.println("Success ");	
						}					
							break;												}						
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
		public static void advseachByStatus(WebDriver wd, String value, String strStep) throws InterruptedException, IOException {
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			try{
			wd.findElement(By.xpath("//a[@title='Received Instructions']")).click();
			wd.findElement(By.xpath("//span[contains(text(),'Show Advanced Search')]")).click();
			WebElement inputfield = wd.findElement(By.xpath("(//input[@placeholder='Select an option'])[1]"));
					inputfield.click();
					//Thread.sleep(1500);
					WebElement ul = wd.findElement(By.xpath("//span[@class ='select2-results']/ul"));
					//Thread.sleep(1500);
					List<WebElement> DropList = ul.findElements(By.tagName("li"));
					for (WebElement drop : DropList) {						
						String valText = drop.getText();
						 System.out.println("Val text is " + valText);
						//Thread.sleep(2000);
						if (valText.equalsIgnoreCase(value)){
							((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", drop);
							  System.out.println("Clicked " +valText +" and " +value);
							Thread.sleep(2000);
							drop.click();
							break;
						}
					}
					Thread.sleep(1500);
					wd.findElement(By.xpath("//button[@value='Search']")).click();	
							WebElement InstrID = wd.findElement(By.xpath("(//table[starts-with(@class,'table table-striped')])[2]/tbody/tr[1]/td[2]"));
							String InstrIDVal = InstrID.getText();
							System.out.println("---------------InstrID for File  = " + InstrIDVal);
							WebElement InstrStatus = wd.findElement(By.xpath("(//table[starts-with(@class,'table table-striped')])[2]/tbody/tr[1]/td[7]"));
							String InstrStatusVal = InstrStatus.getText();
							System.out.println("---------------InstrStatusVal for File  = " + InstrStatusVal);	
							// clear Advance Payment result
							wd.findElement(By.id("searchBtn")).click();						
							if (value.equalsIgnoreCase(InstrStatusVal)) {
							// To search by InstructionId	
								String screenShotPath = GetScreenShot.capture(wd, strStep);
								GenerateReport.test.log(LogStatus.PASS,"PASS-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
								GenerateReport.test.log(LogStatus.PASS, strStep, " "+ Methodname+ " :Advance search completed Successfully for Instruction Status " +InstrStatusVal);
								System.out.println("Success ");	
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
		public static void advseachByPSACode(WebDriver wd, String value, String strStep) throws InterruptedException, IOException {
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			try{
			wd.findElement(By.xpath("//a[@title='Received Instructions']")).click();
			wd.findElement(By.xpath("//span[contains(text(),'Show Advanced Search')]")).click();
			WebElement inputfield = wd.findElement(By.xpath("(//input[@placeholder='Select an option'])[2]"));
					inputfield.click();
					WebElement ul = wd.findElement(By.xpath("//span[@class ='select2-results']/ul"));
					List<WebElement> DropList = ul.findElements(By.tagName("li"));
					for (WebElement drop : DropList) {						
						String valText = drop.getText();
						 System.out.println("Val text is " + valText);
						if (valText.equalsIgnoreCase(value)){
							((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", drop);
							  System.out.println("Clicked " +valText +" and " +value);
							Thread.sleep(2000);
							drop.click();
							wd.findElement(By.xpath("//button[@value='Search']")).click();
							Thread.sleep(1500);
							String screenShotPath = GetScreenShot.capture(wd, strStep);
							GenerateReport.test.log(LogStatus.PASS,"PASS-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
							GenerateReport.test.log(LogStatus.PASS, strStep, " "+ Methodname+ " :Advance search completed Successfully for PSA Code" +value);
								System.out.println("Success ");	
								wd.findElement(By.id("searchBtn")).click();		
								Thread.sleep(1500);
								break;
							}
					
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
		public static void advseachByInstrType(WebDriver wd, String value, String strStep) throws InterruptedException, IOException {
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			try{
			wd.findElement(By.xpath("//a[@title='Received Instructions']")).click();
			wd.findElement(By.xpath("//span[contains(text(),'Show Advanced Search')]")).click();
			WebElement inputfield = wd.findElement(By.xpath("(//input[@placeholder='Select an option'])[3]"));
					inputfield.click();
					WebElement ul = wd.findElement(By.xpath("//span[@class ='select2-results']/ul"));
					List<WebElement> DropList = ul.findElements(By.tagName("li"));
					for (WebElement drop : DropList) {						
						String valText = drop.getText();
						 System.out.println("Val text is " + valText);
						if (valText.equalsIgnoreCase(value)){
							((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", drop);
							  System.out.println("Clicked " +valText +" and " +value);
							Thread.sleep(2000);
							drop.click();
							wd.findElement(By.xpath("//button[@value='Search']")).click();
							Thread.sleep(1500);
							String screenShotPath = GetScreenShot.capture(wd, strStep);
							GenerateReport.test.log(LogStatus.PASS,"PASS-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
							GenerateReport.test.log(LogStatus.PASS, strStep, " "+ Methodname+ " :Advance search completed Successfully for Instruction Type " +value);
								System.out.println("Success ");	
								wd.findElement(By.id("searchBtn")).click();		
								Thread.sleep(1500);
								break;
							}
					
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
		
		
		
		public static void advseachByEntryDate(WebDriver wd, String StartDateVal,String EndDateVal, String strStep) throws InterruptedException, IOException {
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			try{
			wd.findElement(By.xpath("//a[@title='Received Instructions']")).click();
			wd.findElement(By.xpath("//span[contains(text(),'Show Advanced Search')]")).click();
			//StartDate 
			wd.findElement(By.id("EntryDateStart")).click();
			String stdate = StartDateVal.replace("-","").substring(0, 8);
			System.out.println(" start date " +stdate);
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
				GenerateReport.test.log(LogStatus.PASS, strStep, " "+ Methodname+ " : Instruction Id search completed Successfully");
				WebElement InstrIdResult = wd.findElement(By.xpath("//div[8]/table/tbody/tr/td[2]"));
				String InstrIdResultVal = InstrIdResult.getText();
				//System.out.println("===********************InstrResult Value" + InstrIdResultVal);
				GenerateReport.test.log(LogStatus.PASS,strStep ,""+Methodname+"Intruction Id Search result is " + InstrIdResultVal);
				InstrIdResult.click();
				Thread.sleep(1000);
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
}
