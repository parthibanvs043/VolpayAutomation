package com.volante.UserInformation;

import java.io.File;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.volante.locators.LocatorByID;
import com.volante.locators.LocatorByXPATH;
import com.volante.locators.LocatorGetDate;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class SuperAdminUser 
{
	  public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteSuperAdmin( WebDriver wd,String Sheetname,String destFile)  throws Exception 
	{
		    try
		    {
		    	 UserInfoObjectsList.UserInfoObject();
	    	     Workbook wb = Workbook.getWorkbook(new File(destFile));
	             BRSheet=wb.getSheet(Sheetname);
	        int rows_count=BRSheet.getRows();
	        int newrowscount=rows_count-1;
	        System.out.println("No of Rows in UserInformation Page="+newrowscount);        
	        Thread.sleep(3000);
		    for (int row=1; row<=newrowscount; row++)
		       {    
			        Cell TestName=BRSheet.getCell(1,row);
			        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory(ReferenceDataDriver.Sheetname);
	                Cell UserID =BRSheet.getCell(2,row);
	                Cell FirstName =BRSheet.getCell(3,row);
	                Cell LastName=BRSheet.getCell(4,row);
	                Cell UserMailID=BRSheet.getCell(5,row);
	                Cell adminpassword=BRSheet.getCell(6,row);
	                Cell ConfirmPW=BRSheet.getCell(7,row);
	                Cell TimeZone=BRSheet.getCell(8,row);
	                //Cell EffectiveFromDate=BRSheet.getCell(9,row);
	                Cell EffectiveTillDate=BRSheet.getCell(10,row);
	                // Execution Part  
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.UserIDVal, UserID.getContents(), " UserID enetered as " +UserID.getContents());
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.FirstNameVal, FirstName.getContents(), " FirstName enetered as " +FirstName.getContents());
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.LastNameVal, LastName.getContents(), " LastName enetered as " +LastName.getContents());
	                LocatorByID.Enter_ID(wd, UserInfoObjectsList.UserMailIDVal, UserMailID.getContents(), " UserMailID enetered as " +UserMailID.getContents());
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.adminpasswordVal, adminpassword.getContents(), " adminpassword enetered as " +adminpassword.getContents());
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.ConfirmPWVal, ConfirmPW.getContents(), " ConfirmPW enetered as " +ConfirmPW.getContents());
	                LocatorByXPATH.Select_XPath(wd, UserInfoObjectsList.TimeZoneVal, TimeZone.getContents(), "The selected Time zone is  : " +TimeZone.getContents());                
	                LocatorGetDate.SelectDate(wd, UserInfoObjectsList.EffectiveFromDateVal, "Selected the Effective From Date as today");
	                LocatorByID.Enter_ID(wd, UserInfoObjectsList.EffectiveTillDateVal, EffectiveTillDate.getContents(), "Entered the Till Date as "+EffectiveTillDate.getContents());
	                Thread.sleep(2000);
	                LocatorByXPATH.Click_XPath(wd, UserInfoObjectsList.ContinueVal, "All the values entered. Process to next step");
	                Thread.sleep(3000);
	                LocatorByXPATH.Click_XPath(wd, UserInfoObjectsList.AdminSubmitVal, "Submit the credentials");
	                Thread.sleep(3000);
	                
	           }
		    }
 catch (NoSuchElementException e) {
				
			} 
		     catch (Exception e) 
				{
					
				}
}
}