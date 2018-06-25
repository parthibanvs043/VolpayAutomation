package com.volante.UserInformation;

import java.io.File;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import com.volante.locators.LocatorByCSS;
import com.volante.locators.LocatorByXPATH;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ReferenceDataDriver;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ForceReset 
{
	  public static Workbook BRBook;
	   static Sheet BRSheet;

	public static void ExecuteForceReset( WebDriver wd,String Sheetname,String destFile)  throws Exception 
	{
	try
    {
    	 UserInfoObjectsList.UserInfoObject();
	     Workbook wb = Workbook.getWorkbook(new File(destFile));
         BRSheet=wb.getSheet(Sheetname);
    int rows_count=BRSheet.getRows();
    int newrowscount=rows_count-1;
    System.out.println("No of Rows in ForceReset Sheet="+newrowscount); 
        Thread.sleep(3000);
    for (int row=1; row<=newrowscount; row++)
       {    
    	Cell TestName=BRSheet.getCell(1,row);
        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory(ReferenceDataDriver.Sheetname);
        Cell Keyword =BRSheet.getCell(2,row); // Same to be used to select byColumnName
        Cell IsForeceReset =BRSheet.getCell(3,row);
       // Execution Part 
                LocatorByCSS.Click_CSS(wd, UserInfoObjectsList.FilterBtnVal, "Filter the user");
                LocatorByCSS.Enter_CSS(wd, UserInfoObjectsList.KeywordVal, Keyword.getContents()," Keyword to be searched :- " +Keyword.getContents());
                LocatorByCSS.Click_CSS(wd, UserInfoObjectsList.SearchBtnVal, "Search for result");
                LocatorByXPATH.Click_XPath(wd, UserInfoObjectsList.ResultVal, "Click the result");
                LocatorByCSS.Click_CSS(wd, UserInfoObjectsList.EditVal, "Edit the seacrch result");
                LocatorByXPATH.Select_XPath(wd, UserInfoObjectsList.IsForeceResetVal, IsForeceReset.getContents(), " Is Force Reset is set as "  +IsForeceReset.getContents());
                Thread.sleep(2000);
                LocatorByCSS.Click_CSS(wd, UserInfoObjectsList.EditSubmitVal, "Save the changes");
       }
		    }
 catch (NoSuchElementException e) {
				
			} 
		     catch (Exception e) 
				{
					
				}
}
}