package com.volante.UserInformation;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.volante.locators.LocatorByCSS;
import com.volante.locators.LocatorByName;
import com.volante.locators.LocatorByXPATH;
import com.volante.locators.LocatorGetDate;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class CreateUserRole 
{
	  public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteCreateRole( WebDriver wd,String Sheetname,String destFile)  throws Exception 
	{
		    try
		    {
		    	 UserInfoObjectsList.UserInfoObject();
	    	     Workbook wb = Workbook.getWorkbook(new File(destFile));
	             BRSheet=wb.getSheet(Sheetname);
	        int rows_count=BRSheet.getRows();
	        int newrowscount=rows_count-1;
	        System.out.println("No of Rows in Roles & Responsiblities Sheet="+newrowscount); 
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
            WebElement RolePerm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(UserInfoObjectsList.RolesPermissionLinkVal)));
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
	                Cell RoleID =BRSheet.getCell(2,row);
	                Cell RoleName =BRSheet.getCell(3,row);
	                Cell RoleType=BRSheet.getCell(4,row);
	                Cell RoleStatus=BRSheet.getCell(5,row);
	                //Cell RoleEffectiveFromDate=BRSheet.getCell(6,row);
	                //Cell RoleEffectiveTillDate=BRSheet.getCell(7,row);
	                // Execution Part  
	                LocatorByCSS.Click_CSS(wd, UserInfoObjectsList.GridViewAddButton, "Clicked the Grid view button to create Role");
	                Thread.sleep(2000);
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.RoleIDVal, RoleID.getContents(), " RoleID enetered as " +RoleID.getContents());
	                LocatorByXPATH.Enter_XPath(wd, UserInfoObjectsList.RoleNameVal, RoleName.getContents(), " RoleName enetered as " +RoleName.getContents());
	                LocatorByName.DropDown_Text_Name(wd, UserInfoObjectsList.RoleTypeVal, RoleType.getContents(), "Selected RoleType is  " +RoleType.getContents());
	                LocatorByName.DropDown_Text_Name(wd, UserInfoObjectsList.RoleStatusVal, RoleStatus.getContents(), " Selected RoleStatus is " +RoleStatus.getContents());           
	                LocatorGetDate.SelectDate(wd, UserInfoObjectsList.RoleEffectiveFromDateVal, "Selected the Effective From Date as today");
	                //LocatorByID.Enter_ID(wd, UserInfoObjectsList.RoleEffectiveTillDateVal, RoleEffectiveTillDate.getContents(), "Entered the Till Date as "+RoleEffectiveTillDate.getContents());
	                Thread.sleep(2000);
	                LocatorByXPATH.Click_XPath(wd, UserInfoObjectsList.BtnAddRoleVal, "Click Add Role Button");
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