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
import com.volante.locators.LocatorRadioButton;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class StatusDefinition
{
	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteStatusDefinition(WebDriver wd,String Sheetname , String destFile) throws Exception 
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
		    WebElement AppConfig = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(SystemDataObjectList.StatusDefinitionLinkVal)));
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
			        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory("StatusDefinition");
	       	        Cell SDProcessStatus=BRSheet.getCell(2,row);
	                Cell SDWorkFlowCode=BRSheet.getCell(3,row);
	                Cell SDDescription=BRSheet.getCell(4,row);
	                Cell SDUserControl=BRSheet.getCell(5,row);
	                Cell SDStatus=BRSheet.getCell(6,row);
	                Cell SDColourA=BRSheet.getCell(7,row);
	                Cell SDColourB=BRSheet.getCell(8,row);
	                Cell SDOpacity=BRSheet.getCell(9,row);
	                //Cell SDEffectiveFromDate=BRSheet.getCell(10,row);
	                Cell SDEffectiveTillDate=BRSheet.getCell(11,row);
	                Cell SDAliasName=BRSheet.getCell(12,row);
	                Cell SDClientAliasName=BRSheet.getCell(13,row);
	                // Execution Part    	                
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.GridViewAddButton, "Click the Grid View Add button");
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.SDProcessStatusVal, SDProcessStatus.getContents(), "Status Def Name as " +SDProcessStatus.getContents());	               
	                LocatorByCSS.Select_CSS(wd, SystemDataObjectList.SDWorkFlowCodeVal, SDWorkFlowCode.getContents(), "Status Def WorkFlowCode as " +SDWorkFlowCode.getContents());	                
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.SDDescriptionVal, SDDescription.getContents(), "Status Def Description as " +SDDescription.getContents());	               
	                LocatorRadioButton.RadioEnter_name(wd, SystemDataObjectList.SDUserControlVal, SDUserControl.getContents(), "Status Def UserControl as " +SDUserControl.getContents());	                
	                LocatorByName.DropDown_Text_Name(wd, SystemDataObjectList.SDStatusVal, SDStatus.getContents(), "Status Def Status as " +SDStatus.getContents());	               
	                LocatorByCSS.Enter_CSS(wd, SystemDataObjectList.SDColourAVal, SDColourA.getContents(), "Status Def ColourA as " +SDColourA.getContents());	                
	                Thread.sleep(2000);
	                LocatorByCSS.Enter_CSS(wd, SystemDataObjectList.SDColourBVal, SDColourB.getContents(), "Status Def ColourB as " +SDColourB.getContents());	       
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.SDOpacityVal, SDOpacity.getContents(), "Status Def Opacity as " +SDOpacity.getContents());
	                LocatorGetDate.SelectDate(wd, SystemDataObjectList.SDEffectiveFromDateVal, "Selected the Effective From Date as today");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.SDEffectiveTillDateVal, SDEffectiveTillDate.getContents(), "Entered the Till Date as "+SDEffectiveTillDate.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.SDAliasNameVal, SDAliasName.getContents(), "Status Def AliasName as " +SDAliasName.getContents());
	                Thread.sleep(1000);	                
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.SDClientAliasNameVal, SDClientAliasName.getContents(), "Status Def ClientAliasName as " +SDClientAliasName.getContents());
	                Thread.sleep(1000);
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.SubmitButton, "Submit");
	                LocatorByLinks.Click_Link(wd, SystemDataObjectList.StatusDefinitionLinkVal, "");
	                ChangesLostPopUP.ChangesLost(wd,"Status Definition");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}