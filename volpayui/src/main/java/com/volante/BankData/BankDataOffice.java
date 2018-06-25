package com.volante.BankData;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.volante.locators.LocatorByCSS;
import com.volante.locators.LocatorByID;
import com.volante.locators.LocatorByLinks;
import com.volante.locators.LocatorByName;
import com.volante.locators.LocatorCalenderFromDate;
import com.volante.locators.LocatorDropListSelect;
import com.volante.locators.LocatorGetDate;
import com.volante.locators.LocatorRadioButton;
import com.volante.locators.LocatorStatusBox;
import com.volante.locators.LocatorTextValidation;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class BankDataOffice 
{
	   static Sheet BRSheet;

public static void ExecuteOffice( WebDriver wd,String Sheetname,String destFile)  throws Exception 
	{
		    try
		    {
		    	 BankDataObjectsList.BankDataObject();
	    	     Workbook wb = Workbook.getWorkbook(new File(destFile));
	             BRSheet=wb.getSheet(Sheetname);
	        int rows_count=BRSheet.getRows();
	        int newrowscount=rows_count-1;
	        System.out.println("No of Rows in Region Page="+newrowscount);
	        WebDriverWait wait = new WebDriverWait(wd, 30);
	        //WebElement BankData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(BankDataObjectsList.BankData)));
	        WebElement BDView = wd.findElement(By.xpath("//*[@id='BankData']/a/i[2]"));
            Boolean BDviewed = BDView.isDisplayed();
            Boolean BDViewVal = BDView.getAttribute("class").contains("-plus");
            if ((BDViewVal)&&(BDviewed)){
           	 BDView.click();
           	 System.out.println("Clicked");
           	 Thread.sleep(2000);
            }
		    WebElement Department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(BankDataObjectsList.OfficeLinkVal)));
		    Department.click();
			WebElement GridView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BankDataObjectsList.GridView)));
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
	       	        Cell OfficeCode=BRSheet.getCell(2,row);
	                Cell OfficeName=BRSheet.getCell(3,row);
	                Cell DefaultOffice=BRSheet.getCell(4,row);
	                Cell CalendarCode=BRSheet.getCell(5,row);
	                Cell CurrencyCode=BRSheet.getCell(7,row);
	                Cell CountryCodeList=BRSheet.getCell(8,row);
	                Cell RegionCodeList=BRSheet.getCell(9,row);
	                Cell BDP=BRSheet.getCell(10,row);
	                Cell DefaultDepartment=BRSheet.getCell(11,row);	                
	                Cell Status=BRSheet.getCell(12,row);
	               //Cell EffectiveFromDate=BRSheet.getCell(13,row);
	                Cell EffectiveTillDate=BRSheet.getCell(14,row);
	                // Execution Part          
	                LocatorByCSS.Click_CSS(wd, BankDataObjectsList.GridViewAddButton, "Clicked the Grid view button to create Office");
	                Thread.sleep(2000);
	                LocatorTextValidation.Text_XPath(wd, BankDataObjectsList.AddnewText, "Onboarding New Office", "Text Value matched in Add New Office Page");
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.OfficeCodeVal, OfficeCode.getContents(), "Enter the Office Code as "+OfficeCode.getContents());
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.OfficeNameVal, OfficeName.getContents(), "Enter the Office Name as "+OfficeName.getContents());
	                Thread.sleep(3000);
	                LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.DefaultOffice, DefaultOffice.getContents(), "IsDefaultOffice as "+DefaultOffice.getContents());
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.OfficeCalendarCode, CalendarCode.getContents(), "Select the Calendar Code as "+CalendarCode.getContents());
	                Thread.sleep(3000);
	                LocatorGetDate.SelectDate(wd, BankDataObjectsList.EffectiveFromDateVal, "Selected the Business Date as today");
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.OfficeCurrencyCode, CurrencyCode.getContents(), "Select the Currency Code as "+CurrencyCode.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.OfficeCountryCodeList, CountryCodeList.getContents(), "Select the Country Code as "+CountryCodeList.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.OfficeRegionCodeList, RegionCodeList.getContents(), "Select the Region Code as "+RegionCodeList.getContents());
	                Thread.sleep(3000);
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.BackDatedPayment, BDP.getContents(), "Enter the Back Dated Payments as "+BDP.getContents());
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.DefaultDepartment, DefaultDepartment.getContents(), "Select the Default Department Code as "+DefaultDepartment.getContents());
	                Thread.sleep(3000);
	                LocatorByName.DropDown_Text_Name(wd, BankDataObjectsList.StatusVal, Status.getContents(), "Select the Status as "+Status.getContents());
	                LocatorCalenderFromDate.FromDate(wd, BankDataObjectsList.EffectiveFromDateVal, "Selected the Effective From Date as today");
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.EffectiveTillDateVal, EffectiveTillDate.getContents(), "Entered the Till Date as "+EffectiveTillDate.getContents());
	                LocatorByCSS.Click_CSS(wd, BankDataObjectsList.SubmitButton, "Save the details by Clicking the Submit button");
	                LocatorStatusBox.GetStatusByID(wd, BankDataObjectsList.SuccessMsg, "Office successfully added.", "Success Matched Successfully");
	            	Thread.sleep(3000);
	                LocatorByLinks.Click_Link(wd, BankDataObjectsList.OfficeLinkVal, "Click the office link");
	                ChangesLostPopUP.ChangesLost(wd,"Office ");
	                Thread.sleep(2000);
	           }
		    }
 catch (NoSuchElementException e) {
				
			} 
		     catch (Exception e) 
				{
					
				}
}
}
