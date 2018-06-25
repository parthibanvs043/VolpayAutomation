package com.volante.UserInformation;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.volante.locators.LocatorByCSS;
import com.volante.locators.LocatorByID;
import com.volante.locators.LocatorByXPATH;
import com.volante.locators.LocatorDropListSelect;
import com.volante.locators.LocatorGetDate;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class CreateUser 
{
	  public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteCreateUser( WebDriver wd,String Sheetname,String destFile)  throws Exception 
	{
	try
    {
    	 UserInfoObjectsList.UserInfoObject();
	     Workbook wb = Workbook.getWorkbook(new File(destFile));
         BRSheet=wb.getSheet(Sheetname);
    int rows_count=BRSheet.getRows();
    int newrowscount=rows_count-1;
    System.out.println("No of Rows in Create User Profile Sheet="+newrowscount); 
    WebDriverWait wait = new WebDriverWait(wd, 30);
    //WebElement AdminPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(UserInfoObjectsList.AdminPanelLinkVal)));
    System.out.println("hereee2");
    WebElement APView = wd.findElement(By.xpath("//li[@id='AdminPanel']/a/i[2]"));
    Boolean APviewed = APView.isDisplayed();
    Boolean APViewVal = APView.getAttribute("class").contains("-plus");
    if ((APViewVal)&&(APviewed)){
    	APView.click();
   	 System.out.println("Admin Panel Clicked");
   	 Thread.sleep(2000);
    }
    WebElement RolePerm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(UserInfoObjectsList.UserMgmtLinkVal)));
    RolePerm.click();
    Thread.sleep(2000);
    WebElement GridView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(UserInfoObjectsList.GridView)));
	String gridclass = GridView.getAttribute("class");
	 boolean gridV = gridclass.contains("disabledBtnColor");
		if (!gridV) 
		{
			GridView.click();
			System.out.println("grid view enabled");
		}
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
        Cell UserRoleID = BRSheet.getCell(8,row);
        Cell UserStatus = BRSheet.getCell(9,row);
        Cell TimeZone=BRSheet.getCell(10,row);
       //Cell UserEfectiveFromDate=BRSheet.getCell(11,row);
        //Cell UserEffectiveTillDate=BRSheet.getCell(12,row);
        Cell RoleStatus = BRSheet.getCell(13,row);
       //Cell EfectiveFromDate=BRSheet.getCell(11,row);
        Cell EffectiveTillDate=BRSheet.getCell(15,row);
       // Execution Part 
        LocatorByCSS.Click_CSS(wd, UserInfoObjectsList.GridViewAddButton, "Clicked the Grid view button to create Role");
        Thread.sleep(2000);
        LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.UserIDVal, UserID.getContents(), " UserID enetered as " +UserID.getContents());
        LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.FirstNameVal, FirstName.getContents(), " FirstName enetered as " +FirstName.getContents());
        LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.LastNameVal, LastName.getContents(), " LastName enetered as " +LastName.getContents());
        LocatorByID.Enter_ID(wd, UserInfoObjectsList.UserMailIDVal, UserMailID.getContents(), " UserMailID enetered as " +UserMailID.getContents());
        LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.adminpasswordVal, adminpassword.getContents(), " adminpassword enetered as " +adminpassword.getContents());
        LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.ConfirmPWVal, ConfirmPW.getContents(), " ConfirmPW enetered as " +ConfirmPW.getContents());
        LocatorByXPATH.Select_XPath(wd, UserInfoObjectsList.UserRoleIDVal,UserRoleID.getContents(), " RoleID selected is " +UserRoleID.getContents());
        Thread.sleep(2000);
        LocatorDropListSelect.DropListEnterText_Xpath(wd, UserInfoObjectsList.UserStatusVal,UserStatus.getContents(), " Status selected is " +UserStatus.getContents());
        Thread.sleep(2000);
        LocatorByXPATH.Select_XPath(wd, UserInfoObjectsList.TimeZoneVal, TimeZone.getContents(), "The selected Time zone is  : " +TimeZone.getContents()); 
        LocatorGetDate.SelectDate(wd, UserInfoObjectsList.UserEffecFromDateVal, "Selected the Effective From Date as today");
        //LocatorByID.Enter_ID(wd, UserInfoObjectsList.UserEffecTillDateVal, UserEffectiveTillDate.getContents(), "Entered the Till Date as "+UserEffectiveTillDate.getContents());
        Thread.sleep(2000);
        LocatorDropListSelect.DropListEnterText_Xpath(wd, UserInfoObjectsList.UserRoleStatusVal,RoleStatus.getContents(), " Status selected is " +RoleStatus.getContents());
        Thread.sleep(2000);
        LocatorGetDate.SelectDate(wd, UserInfoObjectsList.EffectiveFromDateVal, "Selected the Effective From Date as today");
        System.out.println(" from date value is " +UserInfoObjectsList.EffectiveFromDateVal);
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