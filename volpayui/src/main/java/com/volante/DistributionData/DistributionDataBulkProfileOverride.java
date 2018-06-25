package com.volante.DistributionData;

import java.io.File;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;

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

public class DistributionDataBulkProfileOverride
{
	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteBulkProfileOverride(WebDriver wd,String Sheetname ,String destFile) throws Exception 
	{
		    try
		    {
		    	 DistributionList.DistributionDataObject();
				    Workbook wb = Workbook.getWorkbook(new File(destFile));
		            BRSheet=wb.getSheet(Sheetname);
		            int rows_count=BRSheet.getRows();
		            int newrowscount=rows_count-1;
		            System.out.println("No of Rows in Region Page="+newrowscount);
			        WebDriverWait wait = new WebDriverWait(wd, 30);
			        WebElement DDView = wd.findElement(By.xpath("//li[@id='DistributionData']/a/i[2]"));
		            Boolean DDviewed = DDView.isDisplayed();
		            Boolean DDViewVal = DDView.getAttribute("class").contains("-plus");
		            if ((DDViewVal)&&(DDviewed)){
		           	 DDView.click();
		           	 System.out.println("Clicked");
		           	 Thread.sleep(2000);
		            }
		    WebElement BulkProfileOverride = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(DistributionList.BulkProfileOverrideLinkVal)));
		    BulkProfileOverride.click();
			WebElement GridView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(DistributionList.GridView)));
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
			        ReportGeneration.logger = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory("BulkProfileOverride");
	       	        Cell MOP=BRSheet.getCell(2,row);
	                Cell Overridetype=BRSheet.getCell(3,row);
	                Cell Overridevalue=BRSheet.getCell(4,row); 
					Cell BulkProfile=BRSheet.getCell(5,row); 
	                Cell Status=BRSheet.getCell(6,row);
	                Cell EffectiveFromDate=BRSheet.getCell(7,row);
	                Cell EffectiveTillDate=BRSheet.getCell(8,row);
	                
	                // Execution Part     
	                
	                LocatorByCSS.Click_CSS(wd, DistributionList.GridViewAddButton, "Click the Grid View Add button");
	                Thread.sleep(2000);
	                LocatorByXPATH.Select_XPath(wd, DistributionList.MOPVal, MOP.getContents(), "MOP");
	                Thread.sleep(2000);
	                LocatorByXPATH.DropDown_Text_XPath(wd, DistributionList.OverridetypeVal, Overridetype.getContents(), "Overridetype");
	                Thread.sleep(3000);
	                LocatorByXPATH.Enter_XPath(wd, DistributionList.OverridevalueVal, Overridevalue.getContents(), "Overridevalue");
	                LocatorByXPATH.Select_XPath(wd, DistributionList.BulkProfileVal, BulkProfile.getContents(), "BulkProfile");
					LocatorByName.DropDown_Text_Name(wd, DistributionList.StatusVal, Status.getContents(), "Status");
	                LocatorGetDate.SelectDate(wd, DistributionList.EffectiveFromDateVal, "Select From Date");
	                LocatorByID.Enter_ID(wd, DistributionList.EffectiveTillDateVal, EffectiveTillDate.getContents(), "Enter the Till Date");
	                LocatorByCSS.Click_CSS(wd, DistributionList.SubmitButton, "Submit");
	                LocatorByLinks.Click_Link(wd, DistributionList.BulkProfileOverrideLinkVal, "");
	                ChangesLostPopUP.ChangesLost(wd,"BulkProfileOverride ");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}
