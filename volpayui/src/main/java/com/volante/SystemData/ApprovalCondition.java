package com.volante.SystemData;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.volante.locators.LocatorByCSS;
import com.volante.locators.LocatorByID;
import com.volante.locators.LocatorByLinks;
import com.volante.locators.LocatorByName;
import com.volante.locators.LocatorGetDate;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ApprovalCondition
{
	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteApprovalCondition(WebDriver wd,String Sheetname , String destFile) throws Exception 
	{
		    try
		    {
		    	 SystemDataObjectList.SystemDataObject();
				    Workbook wb = Workbook.getWorkbook(new File(destFile));
		            BRSheet=wb.getSheet(Sheetname);
		            int rows_count=BRSheet.getRows();
		            int newrowscount=rows_count-1;
		            System.out.println("No of Rows in LogConfiguration Page="+newrowscount);
			        WebDriverWait wait = new WebDriverWait(wd, 30);
			        WebElement SDView = wd.findElement(By.xpath("//li[@id='SystemData']/a/i[2]"));
		            Boolean SDviewed = SDView.isDisplayed();
		            Boolean SDViewVal = SDView.getAttribute("class").contains("-plus");
		            if ((SDViewVal)&&(SDviewed)){
		           	 SDView.click();
		           	 System.out.println("Clicked");
		           	 Thread.sleep(2000);
		            }
		    WebElement AppConfig = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(SystemDataObjectList.ApprovalConditionLinkVal)));
		    AppConfig.click();
			WebElement GridView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(SystemDataObjectList.GridView)));
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
			        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory("ApprovalCondition");
	       	        Cell ACApprovalCount=BRSheet.getCell(2,row);
	                Cell ACResourceName=BRSheet.getCell(3,row);
	                Cell ACOperation=BRSheet.getCell(4,row);
	                Cell ACStatus=BRSheet.getCell(5,row);
	                //Cell ACEffectiveFromDate=BRSheet.getCell(6,row);
	                Cell ACEffectiveTillDate=BRSheet.getCell(7,row);
	                Cell ACAttributeName=BRSheet.getCell(8,row);
	                Cell ACOperator=BRSheet.getCell(9,row);
	                Cell ACondValue=BRSheet.getCell(10,row);	                
	                // Execution Part    	                
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.GridViewAddButton, "Click the Grid View Add button");
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ACApprovalCountVal, ACApprovalCount.getContents(), "Approval Condition ApprovalCount as " +ACApprovalCount.getContents());
	                Thread.sleep(1000);
	                LocatorByCSS.Select_CSS(wd, SystemDataObjectList.ACResourceNameVal, ACResourceName.getContents(), "Approval Condition ResourceName as " +ACResourceName.getContents());
	                Thread.sleep(1000);
	                LocatorByCSS.DropDown_Text_CSS(wd, SystemDataObjectList.ACOperationVal, ACOperation.getContents(), "Approval Condition  Operation as " +ACOperation.getContents());
	                LocatorByName.DropDown_Text_Name(wd, SystemDataObjectList.ACStatusVal, ACStatus.getContents(), "Approval Condition  Status as " +ACStatus.getContents());
	                Thread.sleep(3000);
	                LocatorGetDate.SelectDate(wd, SystemDataObjectList.ACEffectiveFromDateVal, "Selected the Effective From Date as today");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ACEffectiveTillDateVal, ACEffectiveTillDate.getContents(), "Entered the Till Date as "+ACEffectiveTillDate.getContents());
	                Thread.sleep(1000);
	                LocatorByID.DropDown_Text_ID(wd, SystemDataObjectList.ACAttributeNameVal, ACAttributeName.getContents(), "Approval Condiion AttributeValue as  "+ACAttributeName.getContents());
	                Thread.sleep(2000);
	                LocatorByID.DropDown_Text_ID(wd, SystemDataObjectList.ACOperatorVal, ACOperator.getContents(), "Approval Condiion Operator as "+ACOperator.getContents());
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ACondValueVal, ACondValue.getContents(), "Approval Condiion ACondValue as "+ACondValue.getContents());
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.SubmitButton, "Submit");
	                LocatorByLinks.Click_Link(wd, SystemDataObjectList.ApprovalConditionLinkVal, "");
	                ChangesLostPopUP.ChangesLost(wd,"Approval Condition");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}