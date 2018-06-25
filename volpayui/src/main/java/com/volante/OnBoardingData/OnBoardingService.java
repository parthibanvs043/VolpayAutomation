package com.volante.OnBoardingData;

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
import com.volante.locators.LocatorDropListSelect;
import com.volante.locators.LocatorGetDate;
import com.volante.locators.LocatorStatusBox;
import com.volante.locators.LocatorTextValidation;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class OnBoardingService 
{
	   static Sheet BRSheet;

public static void ExecuteService( WebDriver wd,String Sheetname,String destFile) throws Exception 
	{
		    try
		    {
		    	OnBoardingObjectList.OnboardingObject();	
	    	     Workbook wb = Workbook.getWorkbook(new File(destFile));
	             BRSheet=wb.getSheet(Sheetname);
	             int rows_count=BRSheet.getRows();
	             int newrowscount=rows_count-1;
	             System.out.println("No of Rows in Region Page="+newrowscount);
	             WebDriverWait wait = new WebDriverWait(wd, 30);
	       // WebElement OnBoardingData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(OnBoardingObjectList.OnboardingData)));
	        WebElement OBDView = wd.findElement(By.xpath("//li[@id='OnboardingData']/a/i[2]"));
            Boolean OBDviewed = OBDView.isDisplayed();
            Boolean OBDViewVal = OBDView.getAttribute("class").contains("-plus");
            if ((OBDViewVal)&&(OBDviewed)){
           	 OBDView.click();
           	 System.out.println("Clicked");
           	 Thread.sleep(2000);
            }
		    WebElement Department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(OnBoardingObjectList.ServiceLinkVal)));
		    Department.click();
			WebElement GridView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(OnBoardingObjectList.GridView)));
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
	       	        Cell ServiceCode=BRSheet.getCell(2,row);
	                Cell ServiceName=BRSheet.getCell(3,row);
	                Cell ServiceDesc=BRSheet.getCell(4,row);
	                Cell ServiceGroupCode=BRSheet.getCell(5,row);
	                Cell OfferedByEntity=BRSheet.getCell(6,row);
	                Cell MarketCcy=BRSheet.getCell(7,row);
	                Cell InstructionCcy=BRSheet.getCell(8,row);
	                Cell ServiceIdConfigCode=BRSheet.getCell(9,row);
	                Cell ServiceIdPattern=BRSheet.getCell(10,row);
	                Cell PDCParameters=BRSheet.getCell(11,row);
	                Cell Status=BRSheet.getCell(12,row);
	               //Cell EffectiveFromDate=BRSheet.getCell(13,row);
	                Cell EffectiveTillDate=BRSheet.getCell(14,row);
	                // Execution Part          
	                LocatorByCSS.Click_CSS(wd, OnBoardingObjectList.GridViewAddButton, "Clicked the Grid view button to create Service Group");
	                Thread.sleep(2000);
	                LocatorTextValidation.Text_XPath(wd, OnBoardingObjectList.AddnewText, "Onboarding New Service", "Text Value matched in Add New Service Page");
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.ServiceCode, ServiceCode.getContents(), "Entered the Branch Code as "+ServiceCode.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.ServiceName, ServiceName.getContents(), "Entered the Branch Name as "+ServiceName.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.ServiceDesc, ServiceDesc.getContents(), "Entered the Branch Name as "+ServiceDesc.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.ServiceGrpCode, ServiceGroupCode.getContents(), "Select the Calendar Code as "+ServiceGroupCode.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.OfferedByEntity, OfferedByEntity.getContents(), "Select the Currency Code as "+OfferedByEntity.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.MarketCurrency, MarketCcy.getContents(), "Select the Country Code as "+MarketCcy.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.InstructionCurrency, InstructionCcy.getContents(), "Select the Region Code as "+InstructionCcy.getContents());
	                Thread.sleep(3000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.ServiceIdConfigCode, ServiceIdConfigCode.getContents(), "Entered the Branch Code as "+ServiceIdConfigCode.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.ServiceIdPatternCode, ServiceIdPattern.getContents(), "Select the Region Code as "+ServiceIdPattern.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.PDCParameters, PDCParameters.getContents(), "Select the Default Department Code as "+PDCParameters.getContents());
	                Thread.sleep(3000);
	                LocatorByName.DropDown_Text_Name(wd, OnBoardingObjectList.Status, Status.getContents(), "Select the Status as "+Status.getContents());
	                LocatorGetDate.SelectDate(wd, OnBoardingObjectList.EffectiveFromDate, "Selected the Effective From Date as today");
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.EffectiveTillDate, EffectiveTillDate.getContents(), "Entered the Till Date as "+EffectiveTillDate.getContents());
	                LocatorByCSS.Click_CSS(wd, OnBoardingObjectList.SubmitButton, "Save the details by Clicking the Submit button");
	                LocatorStatusBox.GetStatusByID(wd, OnBoardingObjectList.SuccessMsg, "Service successfully added.", "Success Matched Successfully");
	                Thread.sleep(3000);
	                LocatorByLinks.Click_Link(wd, OnBoardingObjectList.ServiceLinkVal, "Click the Servie link");
	                ChangesLostPopUP.ChangesLost(wd,"Service ");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}
