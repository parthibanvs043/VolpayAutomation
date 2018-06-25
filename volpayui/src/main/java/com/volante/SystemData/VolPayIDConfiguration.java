package com.volante.SystemData;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.volante.locators.LocatorByCSS;
import com.volante.locators.LocatorByLinks;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class VolPayIDConfiguration
{
	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteVolPayID(WebDriver wd,String Sheetname , String destFile) throws Exception 
	{
		    try
		    {
		    	 SystemDataObjectList.SystemDataObject();
				    Workbook wb = Workbook.getWorkbook(new File(destFile));
		            BRSheet=wb.getSheet(Sheetname);
		            int rows_count=BRSheet.getRows();
		            int newrowscount=rows_count-1;
		            System.out.println("No of Rows in VolPayIDConfig Page="+newrowscount);
			        WebDriverWait wait = new WebDriverWait(wd, 30);
			        WebElement SDView = wd.findElement(By.xpath("//li[@id='SystemData']/a/i[2]"));
		            Boolean SDviewed = SDView.isDisplayed();
		            Boolean SDViewVal = SDView.getAttribute("class").contains("-plus");
		            if ((SDViewVal)&&(SDviewed)){
		           	 SDView.click();
		           	 System.out.println("Clicked");
		           	 Thread.sleep(2000);
		            }
		    WebElement AppConfig = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(SystemDataObjectList.VolPayIDConfigurationLinkVal)));
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
			        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory("VolPayIDConfig");
	       	        Cell IDCode=BRSheet.getCell(2,row);
	                Cell IDPattern=BRSheet.getCell(3,row);
	                Cell IDMinLen=BRSheet.getCell(4,row);
	                Cell IDMaxLen=BRSheet.getCell(5,row);
	                Cell FixLen=BRSheet.getCell(6,row);
	                Cell FlowName=BRSheet.getCell(7,row);
	                Cell IsDefault=BRSheet.getCell(8,row);
	                
	                // Execution Part    	                
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.GridViewAddButton, "Click the Grid View Add button");
	                Thread.sleep(1000);
	                LocatorByCSS.Enter_CSS(wd, SystemDataObjectList.VIDIDCodeVal, IDCode.getContents(), "VolPayID Code");
	                Thread.sleep(1000);
	                LocatorByCSS.Enter_CSS(wd, SystemDataObjectList.VIDPatternVal, IDPattern.getContents(), "VolPayID Pattern");
	                Thread.sleep(1000);
	                LocatorByCSS.Enter_CSS(wd, SystemDataObjectList.VIDMinimumLengthVal, IDMinLen.getContents(), "VolPayID Mininum Length");
	                LocatorByCSS.Enter_CSS(wd, SystemDataObjectList.VIDMaximumLengthVal, IDMaxLen.getContents(), "VolPayID Maximum Length");
	                LocatorByCSS.Enter_CSS(wd, SystemDataObjectList.VIDFixLengthVal, FixLen.getContents(), "VolPayID Fix Length");
	                LocatorByCSS.Enter_CSS(wd, SystemDataObjectList.VIDFlowNameVal, FlowName.getContents(), "VolPayID FlowName");
	                LocatorByCSS.DropDown_Text_CSS(wd, SystemDataObjectList.VIDIsDefaultVal, IsDefault.getContents(), "VolPayID IsDefault value");
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.SubmitButton, "Submit");
	                LocatorByLinks.Click_Link(wd, SystemDataObjectList.VolPayIDConfigurationLinkVal, "");
	                ChangesLostPopUP.ChangesLost(wd,"VolPayIDConfiguration");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}