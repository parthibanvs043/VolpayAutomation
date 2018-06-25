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

public class IncidenceDefinition
{
	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteIncidenceDefinition(WebDriver wd,String Sheetname , String destFile) throws Exception 
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
		    WebElement AppConfig = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(SystemDataObjectList.IncidenceDefinitionLinkVal)));
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
	       	        Cell IDIncidenceType=BRSheet.getCell(2,row);
	                Cell IDIncidenceCode=BRSheet.getCell(3,row);
	                Cell IDProcessName=BRSheet.getCell(4,row);
	                Cell IDPSACode=BRSheet.getCell(5,row);
	                Cell IDWorkFlowCode=BRSheet.getCell(6,row);
	                Cell IDDescription=BRSheet.getCell(7,row);
	                Cell IDProcessStatus=BRSheet.getCell(8,row);
	                Cell IDIncidenceResolution=BRSheet.getCell(9,row);
	                Cell IDSeverity=BRSheet.getCell(10,row);
	                Cell IDStatus=BRSheet.getCell(11,row);
	              //  Cell IDEffectiveFromDate=BRSheet.getCell(12,row);
	                Cell IDEffectiveTillDate=BRSheet.getCell(13,row);
	                Cell IDIncidenceOrigin=BRSheet.getCell(14,row);
	                Cell IDCanClientSetPreference=BRSheet.getCell(15,row);
	                Cell IDOperationsSeverityPreference=BRSheet.getCell(16,row);
	                Cell IDClientSeverityPreference=BRSheet.getCell(17,row);
	                Cell IDRepairandManualInput=BRSheet.getCell(18,row);
	                
	                // Execution Part    	                
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.GridViewAddButton, "Click the Grid View Add button");
	                Thread.sleep(1000);
	                LocatorByCSS.DropDown_Text_CSS(wd, SystemDataObjectList.IDIncidenceTypeVal, IDIncidenceType.getContents(), "Incidence Def Name as " +IDIncidenceType.getContents());	               
	                LocatorByCSS.Select_CSS(wd, SystemDataObjectList.IDIncidenceCodeVal, IDIncidenceCode.getContents(), "Incidence Def IncidenceCode as " +IDIncidenceCode.getContents());	                
	                LocatorByCSS.Select_CSS(wd, SystemDataObjectList.IDProcessNameVal, IDProcessName.getContents(), "Incidence Def ProcessName as " +IDProcessName.getContents());	               
	                LocatorByCSS.Select_CSS(wd, SystemDataObjectList.IDPSACodeVal, IDPSACode.getContents(), "Incidence Def PSACode as " +IDPSACode.getContents());	                
	                LocatorByCSS.Select_CSS(wd, SystemDataObjectList.IDWorkFlowCodeVal, IDWorkFlowCode.getContents(), "Incidence Def WorkFlowCode as " +IDWorkFlowCode.getContents());	               
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.IDDescriptionVal, IDDescription.getContents(), "Incidence Def Description as " +IDDescription.getContents());	                
	                Thread.sleep(1000);
	                LocatorByCSS.DropDown_Text_CSS(wd, SystemDataObjectList.IDProcessStatusVal, IDProcessStatus.getContents(), "Incidence Def ProcessStatus as " +IDProcessStatus.getContents());	       
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.IDIncidenceResolutionVal, IDIncidenceResolution.getContents(), "Incidence Def IncidenceResolution as " +IDIncidenceResolution.getContents());
	                LocatorByCSS.DropDown_Text_CSS(wd, SystemDataObjectList.IDSeverityVal, IDSeverity.getContents(), "Incidence Def Severity as " +IDSeverity.getContents());
	                LocatorByName.DropDown_Text_Name(wd, SystemDataObjectList.IDStatusVal, IDStatus.getContents(), "Incidence Def Status as " +IDStatus.getContents());
	                LocatorGetDate.SelectDate(wd, SystemDataObjectList.SDEffectiveFromDateVal, "Selected the Effective From Date as today");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.IDEffectiveTillDateVal, IDEffectiveTillDate.getContents(), "Incidence Def EffectiveTillDate as " +IDEffectiveTillDate.getContents());
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.IDIncidenceOriginVal, IDIncidenceOrigin.getContents(), "Incidence Def IncidenceOrigin as " +IDIncidenceOrigin.getContents());
	                LocatorRadioButton.RadioEnter_name(wd, SystemDataObjectList.IDCanClientSetPreferenceVal, IDCanClientSetPreference.getContents(), "Incidence Def IDCanClientSetPreference as " +IDCanClientSetPreference.getContents());
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.IDOperationsSeverityPreferenceVal, IDOperationsSeverityPreference.getContents(), "Incidence Def IDOperationsSeverityPreference as " +IDOperationsSeverityPreference.getContents());
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.IDClientSeverityPreferenceVal, IDClientSeverityPreference.getContents(), "Incidence Def IDClientSeverityPreference as " +IDClientSeverityPreference.getContents());
	                LocatorByID.Enter_ID(wd, SystemDataObjectList.IDRepairandManualInputVal, IDRepairandManualInput.getContents(), "Incidence Def IDRepairandManualInput as " +IDRepairandManualInput.getContents());
	                LocatorByCSS.Click_CSS(wd, SystemDataObjectList.SubmitButton, "Submit");
	                LocatorByLinks.Click_Link(wd, SystemDataObjectList.IncidenceDefinitionLinkVal, "");
	                ChangesLostPopUP.ChangesLost(wd,"Incidence Definition");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}