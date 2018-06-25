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

public class ActionDefinition
{
	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteActionDefinition(WebDriver wd,String Sheetname , String destFile) throws Exception 
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
		    WebElement AppConfig = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(SystemDataObjectList.ActionDefinitionLinkVal)));
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
			        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory("ActionDefinition");
	       	        Cell ADActionName=BRSheet.getCell(2,row);
	                Cell ADWorkFlowCode=BRSheet.getCell(3,row);
	                Cell ADDescription=BRSheet.getCell(4,row);
	                Cell ADFunctionName=BRSheet.getCell(5,row);
	                Cell ADRestURL=BRSheet.getCell(6,row);
	                Cell ADRestMethod=BRSheet.getCell(7,row);
	                Cell ADSuccessURL=BRSheet.getCell(8,row);
	                Cell ADFailureURL=BRSheet.getCell(9,row);
	                Cell ADFlowName=BRSheet.getCell(10,row);
	                Cell ADAdditionalConfig=BRSheet.getCell(11,row);
	                Cell ADStatus=BRSheet.getCell(12,row);
	               // Cell ADEffectiveFromDate=BRSheet.getCell(13,row);
	                Cell ADEffectiveTillDate=BRSheet.getCell(14,row);
	                Cell ADDualControlRequired=BRSheet.getCell(15,row);
	                Cell ADMandateNote=BRSheet.getCell(16,row);
	                Cell ADGroupActionAllowed=BRSheet.getCell(17,row);
	                Cell ADAliasName=BRSheet.getCell(18,row);
	                Cell ADClientAliasName=BRSheet.getCell(19,row);
	                // Execution Part    	                
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.GridViewAddButton, "Click the Grid View Add button");
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADActionNameVal, ADActionName.getContents(), "Action Def Name as " +ADActionName.getContents());
	               
	                LocatorByCSS.Select_CSS(wd, SystemDataObjectList.ADWorkFlowCodeVal, ADWorkFlowCode.getContents(), "Action Def WorkFlowCode as " +ADWorkFlowCode.getContents());
	                
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADDescriptionVal, ADDescription.getContents(), "Action Def Description as " +ADDescription.getContents());
	               
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADFunctionNameVal, ADFunctionName.getContents(), "Action Def FunctionName as " +ADFunctionName.getContents());
	                
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADRestURLVal, ADRestURL.getContents(), "Action Def RestURL as " +ADRestURL.getContents());
	               
	                LocatorByCSS.DropDown_Text_CSS(wd, SystemDataObjectList.ADRestMethodVal, ADRestMethod.getContents(), "Action Def RestMethod as " +ADRestMethod.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADSuccessURLVal, ADSuccessURL.getContents(), "Action Def SuccessURL as " +ADSuccessURL.getContents());
	       
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADFailureURLVal, ADFailureURL.getContents(), "Action Def FailureURL as " +ADFailureURL.getContents());
	            
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADFlowNameVal, ADFlowName.getContents(), "Action Def FlowName as " +ADFlowName.getContents());
	            
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADAdditionalConfigVal, ADAdditionalConfig.getContents(), "Action Def AdditionalConfig as " +ADAdditionalConfig.getContents());	              
	                LocatorByName.DropDown_Text_Name(wd, SystemDataObjectList.ADStatusVal, ADStatus.getContents(), "Select the Status as "+ADStatus.getContents());
	                Thread.sleep(2000);
	                LocatorGetDate.SelectDate(wd, SystemDataObjectList.ADEffectiveFromDateVal, "Selected the Effective From Date as today");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADEffectiveTillDateVal, ADEffectiveTillDate.getContents(), "Entered the Till Date as "+ADEffectiveTillDate.getContents());
	                Thread.sleep(1000);
	                LocatorRadioButton.RadioEnter_name(wd, SystemDataObjectList.ADDualControlRequiredVal, ADDualControlRequired.getContents(), "Action Def ADDualControlRequired as " +ADDualControlRequired.getContents());
	                Thread.sleep(1000);
	                LocatorRadioButton.RadioEnter_name(wd, SystemDataObjectList.ADMandateNoteVal, ADMandateNote.getContents(), "Action Def MandateNote as " +ADMandateNote.getContents());
	                Thread.sleep(1000);
	                LocatorRadioButton.RadioEnter_name(wd, SystemDataObjectList.ADGroupActionAllowedVal, ADGroupActionAllowed.getContents(), "Action Def GroupActionAllowed as " +ADGroupActionAllowed.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADAliasNameVal, ADAliasName.getContents(), "Action Def AliasName as " +ADAliasName.getContents());
	                Thread.sleep(1000);	                
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.ADClientAliasNameVal, ADClientAliasName.getContents(), "Action Def ClientAliasName as " +ADClientAliasName.getContents());
	                Thread.sleep(1000);
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.SubmitButton, "Submit");
	                LocatorByLinks.Click_Link(wd, SystemDataObjectList.ActionDefinitionLinkVal, "");
	                ChangesLostPopUP.ChangesLost(wd,"Action Definition");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}