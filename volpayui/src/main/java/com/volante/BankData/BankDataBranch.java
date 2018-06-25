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

public class BankDataBranch 
{
	   static Sheet BRSheet;

public static void ExecuteBranch( WebDriver wd,String Sheetname,String destFile)  throws Exception 
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
	        WebElement BDView = wd.findElement(By.xpath("//li[@id='BankData']/a/i[2]"));
            Boolean BDviewed = BDView.isDisplayed();
            Boolean BDViewVal = BDView.getAttribute("class").contains("-plus");
            if ((BDViewVal)&&(BDviewed)){
           	 BDView.click();
           	 System.out.println("Clicked");
           	 Thread.sleep(2000);
            }
		    WebElement Department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(BankDataObjectsList.BranchLinkVal)));
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
	       	        Cell BranchCode=BRSheet.getCell(2,row);
	                Cell BranchName=BRSheet.getCell(3,row);
	                Cell DefaultBranch=BRSheet.getCell(4,row);
	                Cell OfficeCode=BRSheet.getCell(5,row);
	                Cell ParentBranchCode=BRSheet.getCell(6,row);
	                Cell PartyCode=BRSheet.getCell(7,row);
	                Cell CountryCode=BRSheet.getCell(8,row);
	                Cell CalendarCode=BRSheet.getCell(9,row);
	                Cell BaseCurrency=BRSheet.getCell(10,row);
	                Cell SupportedCurrency=BRSheet.getCell(11,row);
	                Cell Status=BRSheet.getCell(12,row);
	               //Cell EffectiveFromDate=BRSheet.getCell(13,row);
	                Cell EffectiveTillDate=BRSheet.getCell(14,row);
	                // Execution Part          
	                LocatorByCSS.Click_CSS(wd, BankDataObjectsList.GridViewAddButton, "Clicked the Grid view button to create Branch");
	                Thread.sleep(2000);
	                LocatorTextValidation.Text_XPath(wd, BankDataObjectsList.AddnewText, "Onboarding New Branch", "Text Value matched in Add New Branch Page");
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.BranchCodeVal, BranchCode.getContents(), "Entered the Branch Code as "+BranchCode.getContents());
	                Thread.sleep(500);
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.BranchNameVal, BranchName.getContents(), "Entered the Branch Name as "+BranchName.getContents());
	                Thread.sleep(500);
	                LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.DefaultBranch, DefaultBranch.getContents(), "IsDefaultBranch as "+DefaultBranch.getContents());
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.BranchOfficeCode, OfficeCode.getContents(), "Select the Calendar Code as "+OfficeCode.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.ParentBranchCode, ParentBranchCode.getContents(), "Select the Currency Code as "+ParentBranchCode.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.BranchPartyCode, PartyCode.getContents(), "Select the Country Code as "+PartyCode.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.BranchCountryCodeList, CountryCode.getContents(), "Select the Region Code as "+CountryCode.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.BranchCalendarCodeList, CalendarCode.getContents(), "Select the Region Code as "+CalendarCode.getContents());
	                Thread.sleep(3000);
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.BaseCurrency, BaseCurrency.getContents(), "Base Currency fro Branch as "+BaseCurrency.getContents());
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, BankDataObjectsList.SupportedCurrency, SupportedCurrency.getContents(), "Select the Default Department Code as "+SupportedCurrency.getContents());
	                Thread.sleep(3000);
	                LocatorByName.DropDown_Text_Name(wd, BankDataObjectsList.StatusVal, Status.getContents(), "Select the Status as "+Status.getContents());
	                LocatorGetDate.SelectDate(wd, BankDataObjectsList.EffectiveFromDateVal, "Selected the Effective From Date as today");
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.EffectiveTillDateVal, EffectiveTillDate.getContents(), "Entered the Till Date as "+EffectiveTillDate.getContents());
	                LocatorByCSS.Click_CSS(wd, BankDataObjectsList.SubmitButton, "Save the details by Clicking the Submit button");
	            	LocatorStatusBox.GetStatusByID(wd, BankDataObjectsList.SuccessMsg, "Branch successfully added.", "Success Matched Successfully");
	            	Thread.sleep(3000);
	                LocatorByLinks.Click_Link(wd, BankDataObjectsList.BranchLinkVal, "Click the Branch link");
	                ChangesLostPopUP.ChangesLost(wd,"Branch ");
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
