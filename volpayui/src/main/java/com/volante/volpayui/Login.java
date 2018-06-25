package com.volante.volpayui;

import java.io.File;
import java.io.IOException;
import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;

import com.volante.locators.LocatorByCSS;
import com.volante.locators.LocatorByID;
import com.volante.locators.LocatorByXPATH;
import com.volante.locators.LocatorTextValidation;
import com.volante.reports.ReportGeneration;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Login {
	
	 static Sheet BRSheet;
	 
public static void VolPayLogin( WebDriver wd,String Sheetname,String destFile) throws BiffException, InterruptedException, DocumentException 
{
	 try
	    {
		    
		     LoginObjects.VolPayLogin();
 	         Workbook wb = Workbook.getWorkbook(new File(destFile));
             BRSheet=wb.getSheet(Sheetname);
             int rows_count=BRSheet.getRows();
             int newrowscount=rows_count-1;
             System.out.println("No of Rows in Login Page="+newrowscount);
             for (int row=1; row<=newrowscount; row++)
   	          {    
  		       	
  		         Cell TestName=BRSheet.getCell(1,row);
  		         ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory(ReferenceDataDriver.Sheetname);
  		         Cell URL=BRSheet.getCell(2,row);
  		         Cell Username=BRSheet.getCell(3,row);
                 Cell Password=BRSheet.getCell(4,row);
         		 Thread.sleep(2000);
         		 wd.get(URL.getContents());
         		// wd.manage().window().maximize();
         		 Thread.sleep(2000);
         		 LocatorByID.Enter_ID(wd, LoginObjects.VolPayUser, Username.getContents(), "Entered the username as "+Username.getContents());
         		 LocatorByID.Enter_ID(wd, LoginObjects.VolPayPassword, Password.getContents(), "Entered the Password as "+Password.getContents());
         		 LocatorByXPATH.Click_XPath(wd, LoginObjects.LoginButton, "Click the login button");
         		 Thread.sleep(1500);
         		 LocatorTextValidation.Text_XPath(wd, LoginObjects.PaymentDashboard, "Payments Dashboard", "Login Successful and VolPay landed in Payments Dashboard Page");
         		 LocatorTextValidation.Text_XPath(wd, LoginObjects.Usertext, Username.getContents(), "Username matches in Top Right Corner");
   	          }
}
	  catch (IOException e)
	    {
	    	  System.out.println("Exception="+e.getMessage());
	    }
}
public static void VolPayLogout( WebDriver wd,String Sheetname,String destFile) throws BiffException, InterruptedException, DocumentException 
{
	 try
	    {
		    
		     LoginObjects.VolPayLogin();
 	         Workbook wb = Workbook.getWorkbook(new File(destFile));
             BRSheet=wb.getSheet(Sheetname);
             int rows_count=BRSheet.getRows();
             int newrowscount=rows_count-1;
             System.out.println("No of Rows in Login Page="+newrowscount);
             for (int row=1; row<=newrowscount; row++)
   	          {    
  		       	
  		         Cell TestName=BRSheet.getCell(1,row);
  		         ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory(ReferenceDataDriver.Sheetname);
  		        Thread.sleep(2000);
         		// wd.manage().window().maximize();
         		 LocatorByCSS.Click_CSS(wd, LoginObjects.Username, "select the user that should be logout");
         		LocatorByCSS.Click_CSS(wd, LoginObjects.Logoutbutton, "Click Logout");
         		 Thread.sleep(2000);
   	          }
}
	  catch (IOException e)
	    {
	    	  System.out.println("Exception="+e.getMessage());
	    }
}
public static void DefaultLogin( WebDriver wd,String Sheetname,String destFile) throws BiffException, InterruptedException, DocumentException 
{
	 try
	    {
		    
		     LoginObjects.VolPayLogin();
 	         Workbook wb = Workbook.getWorkbook(new File(destFile));
             BRSheet=wb.getSheet(Sheetname);
             int rows_count=BRSheet.getRows();
             int newrowscount=rows_count-1;
             System.out.println("No of Rows in Login Page="+newrowscount);
             for (int row=1; row<=newrowscount; row++)
   	          {    
  		       	
  		         Cell TestName=BRSheet.getCell(1,row);
  		         ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory(ReferenceDataDriver.Sheetname);
  		         Cell URL=BRSheet.getCell(2,row);
  		         Cell Username=BRSheet.getCell(3,row);
                 Cell Password=BRSheet.getCell(4,row);
         		 Thread.sleep(3000);
         		 wd.get(URL.getContents());
         		// wd.manage().window().maximize();
         		 Thread.sleep(2000);
         		 LocatorByID.Enter_ID(wd, LoginObjects.VolPayUser, Username.getContents(), "Entered the username as "+Username.getContents());
         		 LocatorByID.Enter_ID(wd, LoginObjects.VolPayPassword, Password.getContents(), "Entered the Password as "+Password.getContents());
         		 LocatorByXPATH.Click_XPath(wd, LoginObjects.LoginButton, "Click the login button");
         		 Thread.sleep(1500);
			}
}
	  catch (IOException e)
	    {
	    	  System.out.println("Exception="+e.getMessage());
	    }
}
}
