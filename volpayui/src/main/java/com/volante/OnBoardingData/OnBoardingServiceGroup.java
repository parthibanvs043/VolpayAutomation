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
import com.volante.locators.LocatorGetDate;
import com.volante.locators.LocatorTextValidation;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class OnBoardingServiceGroup {

	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteServiceGroup( WebDriver wd,String Sheetname,String destFile)  throws Exception 
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
	        //WebElement OnBoardingData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(OnBoardingObjectList.OnboardingData)));
	        WebElement OBDView = wd.findElement(By.xpath("//li[@id='OnboardingData']/a/i[2]"));
            Boolean OBDviewed = OBDView.isDisplayed();
            Boolean OBDViewVal = OBDView.getAttribute("class").contains("-plus");
            if ((OBDViewVal)&&(OBDviewed)){
           	 OBDView.click();
           	 System.out.println("Clicked");
           	 Thread.sleep(2000);
            }
		    WebElement Department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(OnBoardingObjectList.ServiceGroupLinkVal)));
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
	       	        Cell ServiceGroupCode=BRSheet.getCell(2,row);
	                Cell ServiceGroupName=BRSheet.getCell(3,row);
	                Cell ServiceGroupDesc=BRSheet.getCell(4,row);
	                Cell Status=BRSheet.getCell(5,row);
	               //Cell EffectiveFromDate=BRSheet.getCell(6,row);
	                Cell EffectiveTillDate=BRSheet.getCell(7,row);
	                // Execution Part          
	                LocatorByCSS.Click_CSS(wd, OnBoardingObjectList.GridViewAddButton, "Clicked the Grid view button to create Service Group");
	                Thread.sleep(2000);
	                LocatorTextValidation.Text_XPath(wd, OnBoardingObjectList.AddnewText, "Onboarding New Service Group", "Text Value matched in Add New Service Group Page");
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.ServiceGroupCode, ServiceGroupCode.getContents(), "Entered the ServiceGroupCode Code as "+ServiceGroupCode.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.ServiceGroupName, ServiceGroupName.getContents(), "Entered the ServiceGroupName Name as "+ServiceGroupName.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.ServiceGroupDesc, ServiceGroupDesc.getContents(), "Entered the Branch Name as "+ServiceGroupDesc.getContents());
	                Thread.sleep(3000);
	                LocatorByName.DropDown_Text_Name(wd, OnBoardingObjectList.Status, Status.getContents(), "Select the Status as "+Status.getContents());
	                LocatorGetDate.SelectDate(wd, OnBoardingObjectList.EffectiveFromDate, "Selected the Effective From Date as today");
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.EffectiveTillDate, EffectiveTillDate.getContents(), "Entered the Till Date as "+EffectiveTillDate.getContents());
	                LocatorByCSS.Click_CSS(wd, OnBoardingObjectList.SubmitButton, "Save the details by Clicking the Submit button");
	                LocatorByLinks.Click_Link(wd, OnBoardingObjectList.ServiceGroupLinkVal, "Click the Servie Group link");
	                ChangesLostPopUP.ChangesLost(wd,"ServiceGroup ");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}
