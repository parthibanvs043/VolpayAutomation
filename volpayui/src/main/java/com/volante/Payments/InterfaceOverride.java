package com.volante.Payments;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.locators.LocatorByID;
import com.volante.reports.GenerateReport;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;
import com.volante.volpayui.ReferenceDataDriver;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
public class InterfaceOverride {
	 static Sheet BRSheet;
	public static void Override(WebDriver wd , String dt, String PymtStatus,String strStep,String destFile,int Sheetname) throws InterruptedException, IOException
	{	
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try
		{	
			WebDriverWait wait = new WebDriverWait(wd,60);
			if (!(PymtStatus.equalsIgnoreCase("WAITING_OFACRESPONSE")||PymtStatus.equalsIgnoreCase("WAITING_LIQUIDITYCONTROLRESPONSE")||PymtStatus.equalsIgnoreCase("WAITING_FUNDSCONTROLRESPONSE")))
			 {
			       WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Add Notes')]/following::button[1]")));
			       System.out.println("elem");
				   if(element.isDisplayed())
				   {
					   System.out.println("elem displayed");
					 element.click();
					 Thread.sleep(2000);
					 ExecuteOFACOverride(wd, Sheetname, destFile);
				   }
				   else 
				   {
					   GenerateReport.test.log(LogStatus.PASS, strStep," " + Methodname + " : Payement cannot be overriden.");
				   }
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
			//For Overriding...	
		public static void ExecuteOFACOverride( WebDriver wd,int Sheetname,String destFile)  throws Exception 
		{
			    try
			    {
			    	 OverrideObjectlist.OverrideObject();;
		    	     Workbook wb = Workbook.getWorkbook(new File(destFile));
		             BRSheet=wb.getSheet("OFACOverrideValue");
		             int rows_count=BRSheet.getRows();
		             int newrowscount=rows_count-1;
		             for (int row=1; row<=newrowscount; row++)
				       {    
					        Cell TestName=BRSheet.getCell(1,row);
					        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory(ReferenceDataDriver.Sheetname);
			       	        Cell GroupStatusReason=BRSheet.getCell(2,row);
			                Cell GroupStatusReasonInfo=BRSheet.getCell(3,row);
			                Cell Owner=BRSheet.getCell(4,row);
			                Cell StatusReason=BRSheet.getCell(5,row);
			                Cell NumberOfHits=BRSheet.getCell(6,row);
			                Cell HitCategory=BRSheet.getCell(7,row);
			                Cell OriginalStatusReason=BRSheet.getCell(8,row);
			                Cell StatusInformation=BRSheet.getCell(9,row);
			                // Execution Part  
			                LocatorByID.DropDown_Text_ID(wd, OverrideObjectlist.GroupStatusReasonVal, GroupStatusReason.getContents(), "Select GroupStatusReason as"+GroupStatusReason.getContents());
			                LocatorByID.Enter_ID(wd, OverrideObjectlist.GroupStatusReasonInfoVal, GroupStatusReasonInfo.getContents(), "Enter GroupStatusReasonInfo as"+GroupStatusReasonInfo.getContents());
			                LocatorByID.Enter_ID(wd, OverrideObjectlist.OwnerVal, Owner.getContents(), "Entered Owner as "+Owner.getContents());
			                LocatorByID.DropDown_Text_ID(wd, OverrideObjectlist.StatusReasonVal, StatusReason.getContents(), "Entered the Calendar Name as "+StatusReason.getContents());
			                LocatorByID.Enter_ID(wd, OverrideObjectlist.NumberOfHitsVal, GroupStatusReason.getContents(), "Entered the Calendar Name as "+NumberOfHits.getContents());
			                LocatorByID.Enter_ID(wd, OverrideObjectlist.HitCategoryVal, HitCategory.getContents(), "Entered the Calendar Name as "+HitCategory.getContents());
			                LocatorByID.Enter_ID(wd, OverrideObjectlist.OriginalStatusReasonVal, OriginalStatusReason.getContents(), "Entered the Calendar Name as "+OriginalStatusReason.getContents());
			                LocatorByID.Enter_ID(wd, OverrideObjectlist.StatusInformationVal, StatusInformation.getContents(), "Entered the Calendar Name as "+StatusInformation.getContents());		                
			            	Thread.sleep(500);			                
			           }
				    }
		 catch (NoSuchElementException e) {						
					} 
				     catch (Exception e) 
						{
							
						}
		}
}