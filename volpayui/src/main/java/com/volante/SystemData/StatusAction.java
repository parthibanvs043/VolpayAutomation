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
import com.volante.locators.LocatorByXPATH;
import com.volante.locators.LocatorGetDate;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class StatusAction
{
	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteStatusAction(WebDriver wd,String Sheetname , String destFile) throws Exception 
	{
		    try
		    {
		    	 SystemDataObjectList.SystemDataObject();
				    Workbook wb = Workbook.getWorkbook(new File(destFile));
		            BRSheet=wb.getSheet(Sheetname);
		            int rows_count=BRSheet.getRows();
		            int newrowscount=rows_count-1;
		            System.out.println("No of Rows in Action Definition Page="+newrowscount);
			        WebDriverWait wait = new WebDriverWait(wd, 30);
			        WebElement SDView = wd.findElement(By.xpath("//li[@id='SystemData']/a/i[2]"));
		            Boolean SDviewed = SDView.isDisplayed();
		            Boolean SDViewVal = SDView.getAttribute("class").contains("-plus");
		            if ((SDViewVal)&&(SDviewed)){
		           	 SDView.click();
		           	 System.out.println("Clicked");
		           	 Thread.sleep(2000);
		            }
		    WebElement AppConfig = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(SystemDataObjectList.StatusActionLinkVal)));
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
			        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory("StatusAction");
	       	        Cell SAWorkFlowCode=BRSheet.getCell(2,row);
	                Cell SAAction=BRSheet.getCell(3,row);
	                Cell SAProcessStatus=BRSheet.getCell(4,row);
	                Cell SAProcessName=BRSheet.getCell(5,row);
	                Cell SAStatus=BRSheet.getCell(6,row);
	               // Cell SAEffectiveFromDate=BRSheet.getCell(7,row);
	                Cell SAEffectiveTillDate=BRSheet.getCell(8,row);	              
	                // Execution Part    	                
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.GridViewAddButton, "Click the Grid View Add button");
	                Thread.sleep(1000);
	                LocatorByCSS.Select_CSS(wd, SystemDataObjectList.SAWorkFlowCodeVal, SAWorkFlowCode.getContents(), "Status Action WorkFlowCode as " +SAWorkFlowCode.getContents());
	                Thread.sleep(2000);
	                LocatorByID.DropDown_Text_ID(wd, SystemDataObjectList.SAActionVal, SAAction.getContents(), "Status Action Action as " +SAAction.getContents());
	                Thread.sleep(1000);
	                LocatorByXPATH.DropDown_Text_XPath(wd, SystemDataObjectList.SAProcessStatusVal, SAProcessStatus.getContents(), "Status Action ProcessStatus as " +SAProcessStatus.getContents());
	                Thread.sleep(1000);
	                LocatorByXPATH.DropDown_Text_XPath(wd, SystemDataObjectList.SAProcessNameVal, SAProcessName.getContents(), "Status Action ProcessName as " +SAProcessName.getContents());
	                Thread.sleep(1000);
	                LocatorByName.DropDown_Text_Name(wd, SystemDataObjectList.SAStatusVal, SAStatus.getContents(), "Select the Status as "+SAStatus.getContents());
	                Thread.sleep(2000);
	                LocatorGetDate.SelectDate(wd, SystemDataObjectList.ADEffectiveFromDateVal, "Selected the Effective From Date as today");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.SAEffectiveTillDateVal, SAEffectiveTillDate.getContents(), "Entered the Till Date as "+SAEffectiveTillDate.getContents());
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.SubmitButton, "Submit");
	                LocatorByLinks.Click_Link(wd, SystemDataObjectList.StatusActionLinkVal, "");
	                ChangesLostPopUP.ChangesLost(wd,"Status Action");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}