package com.volante.UserInformation;

import java.io.File;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.volante.locators.LocatorByXPATH;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class SuperAdminPwdReset 
{
	  public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteAdminPwdReset( WebDriver wd,String Sheetname,String destFile)  throws Exception 
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
	                Cell OldPSWD =BRSheet.getCell(2,row);
	                Cell NewPSWD =BRSheet.getCell(3,row);
	                Cell ConfirmNewPSWD=BRSheet.getCell(4,row);
	                // Execution Part  
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.OldPWVal, OldPSWD.getContents(), " Old Password was " +OldPSWD.getContents());
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.NewPWVal, NewPSWD.getContents(), " New Password enetered as " +NewPSWD.getContents());
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.ConfirmNewPWVal, ConfirmNewPSWD.getContents(), " LastName enetered as " +ConfirmNewPSWD.getContents());
	                Thread.sleep(2000);
	                LocatorByXPATH.Click_XPath(wd, UserInfoObjectsList.UpdatebuttonVal, "Update the new  credentials");
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