package com.volante.DistributionData;

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
import com.volante.locators.LocatorCalenderFromDate;
import com.volante.locators.LocatorGetDate;
import com.volante.locators.LocatorRadioButton;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class DistributionDataMOP
{
	 public static Workbook BRBook;
	   static Sheet BRSheet;
public static void ExecuteMOP(WebDriver wd,String Sheetname , String destFile) throws Exception 
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
		    WebElement MethodOfPayment = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(DistributionList.MOPLinkVal)));
		    MethodOfPayment.click();
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
			        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory("MethodOfPayment");
	       	        Cell MOPCode=BRSheet.getCell(2,row);
	                Cell MOPCategory=BRSheet.getCell(3,row);
	                Cell MOPTechnicalName=BRSheet.getCell(4,row); 
					Cell OutputFormat=BRSheet.getCell(5,row);
					Cell ProductCode=BRSheet.getCell(6,row);
					Cell ClearingSchemeCode=BRSheet.getCell(7,row);
					Cell CashClearingSchemeCode=BRSheet.getCell(8,row);
					Cell CountryCode=BRSheet.getCell(9,row);
					Cell CurrencyCode=BRSheet.getCell(10,row);
					Cell SettlementAccountNos=BRSheet.getCell(11,row);
					Cell SupportedChargeCodes=BRSheet.getCell(12,row);
					Cell Description=BRSheet.getCell(13,row);
					Cell CalendarCode=BRSheet.getCell(14,row);
					//Cell MOPBusinessDate=BRSheet.getCell(15,row);
					Cell MinimumProcessingDays=BRSheet.getCell(16,row);
					Cell EarliestValueDate=BRSheet.getCell(17,row);
					Cell LatestValueDate=BRSheet.getCell(18,row);
					Cell ValueDateExtension=BRSheet.getCell(19,row);
					Cell CutOffCode=BRSheet.getCell(20,row);
					Cell RoleForwardValueDate=BRSheet.getCell(21,row);
					Cell MOPTimeExtension=BRSheet.getCell(22,row);
					Cell ValidateMembership=BRSheet.getCell(23,row);
					Cell MinAmount=BRSheet.getCell(24,row);
					Cell MaxAmount=BRSheet.getCell(25,row);
					Cell BulkPayment=BRSheet.getCell(26,row);
					Cell HolidayBulkProfile=BRSheet.getCell(27,row);
					Cell WeekdayBulkProfile=BRSheet.getCell(28,row);
					Cell WeekendBulkProfile=BRSheet.getCell(29,row);
					Cell FileIDConfigurationCode=BRSheet.getCell(30,row);
					Cell PaymentIDConfigurationCode=BRSheet.getCell(31,row);
					Cell ExpectResponse=BRSheet.getCell(32,row);
					Cell MOPExternalIdentifier=BRSheet.getCell(33,row);
					Cell ProcessCode=BRSheet.getCell(34,row);
					Cell ResponseFormatIdentifierFlow=BRSheet.getCell(35,row);
					Cell Status=BRSheet.getCell(36,row);
		            //Cell EffectiveFromDate=BRSheet.getCell(37,row);
		            Cell EffectiveTillDate=BRSheet.getCell(38,row);
	                // Execution Part     	                
	                LocatorByCSS.Click_CSS(wd, DistributionList.GridViewAddButton, "Click the Grid View Add button");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, DistributionList.MOPCodeVal, MOPCode.getContents(), "MOPCode");
	                Thread.sleep(2000);
	                LocatorByXPATH.Select_XPath(wd, DistributionList.MOPCategoryVal, MOPCategory.getContents(), "MOPCategory");
	                Thread.sleep(3000);
	                LocatorByID.Enter_ID(wd, DistributionList.MOPTechnicalNameVal, MOPTechnicalName.getContents(), "MOPTechnicalName");
					LocatorByID.Enter_ID(wd, DistributionList.OutputFormatVal, OutputFormat.getContents(), "OutputFormat");
					LocatorByXPATH.Select_XPath(wd, DistributionList.ProductCodeVal, ProductCode.getContents(), "ProductCode");
					LocatorByID.Enter_ID(wd, DistributionList.ClearingSchemeCodeVal, ClearingSchemeCode.getContents(), "ClearingSchemeCode");
					LocatorByXPATH.Select_XPath(wd, DistributionList.CashClearingSchemeCodeVal, CashClearingSchemeCode.getContents(), "CashClearingSchemeCode");
					LocatorByXPATH.Select_XPath(wd, DistributionList.CountryCodeVal, CountryCode.getContents(), "CountryCode");
					LocatorByXPATH.Select_XPath(wd, DistributionList.CurrencyCodeVal, CurrencyCode.getContents(), "CurrencyCode");
					LocatorByXPATH.Select_XPath(wd, DistributionList.SettlementAccountNosVal, SettlementAccountNos.getContents(), "SettlementAccountNos");
					LocatorByID.Enter_ID(wd, DistributionList.SupportedChargeCodesVal, SupportedChargeCodes.getContents(), "SupportedChargeCodes");
					LocatorByXPATH.Select_XPath(wd, DistributionList.DescriptionVal, Description.getContents(), "Description");
					LocatorByXPATH.Select_XPath(wd, DistributionList.CalendarCodeVal, CalendarCode.getContents(), "CalendarCode");
					LocatorGetDate.SelectDate(wd, DistributionList.MOPBusinessDateVal, "MOPBusinessDate as today");
					LocatorByID.Enter_ID(wd, DistributionList.MinimumProcessingDaysVal, MinimumProcessingDays.getContents(), "MinimumProcessingDays");
					LocatorByID.Enter_ID(wd, DistributionList.EarliestValueDateVal, EarliestValueDate.getContents(), "EarliestValueDate");
					LocatorByID.Enter_ID(wd, DistributionList.LatestValueDateVal, LatestValueDate.getContents(), "LatestValueDate");
					LocatorByID.Enter_ID(wd, DistributionList.ValueDateExtensionVal, ValueDateExtension.getContents(), "ValueDateExtension");
					LocatorByXPATH.Select_XPath(wd, DistributionList.MOPCutOffCodeVal, CutOffCode.getContents(), "CutOffCode");
					LocatorRadioButton.RadioEnter_name(wd, DistributionList.RoleForwardValueDateVal, RoleForwardValueDate.getContents(), "RoleForwardValueDate");
					LocatorByID.Enter_ID(wd, DistributionList.MOPTimeExtensionVal, MOPTimeExtension.getContents(), "MOPTimeExtension");
					LocatorRadioButton.RadioEnter_name(wd, DistributionList.ValidateMembershipVal, ValidateMembership.getContents(), "ValidateMembership");
					LocatorByID.Enter_ID(wd, DistributionList.MinAmountVal, MinAmount.getContents(), "MinAmount");
					LocatorByID.Enter_ID(wd, DistributionList.MaxAmountVal, MaxAmount.getContents(), "MaxAmount");
					LocatorRadioButton.RadioEnter_name(wd, DistributionList.BulkPaymentVal, BulkPayment.getContents(), "BulkPayment");
					LocatorByXPATH.Select_XPath(wd, DistributionList.HolidayBulkProfileVal, HolidayBulkProfile.getContents(), "HolidayBulkProfile");
					LocatorByXPATH.Select_XPath(wd, DistributionList.WeekdayBulkProfileVal, WeekdayBulkProfile.getContents(), "WeekdayBulkProfile");
					LocatorByXPATH.Select_XPath(wd, DistributionList.WeekendBulkProfileVal, WeekendBulkProfile.getContents(), "WeekendBulkProfile");
					LocatorByXPATH.Select_XPath(wd, DistributionList.FileIDConfigurationCodeVal, FileIDConfigurationCode.getContents(), "FileIDConfigurationCode");
					LocatorByXPATH.Select_XPath(wd, DistributionList.PaymentIDConfigurationCodeVal, PaymentIDConfigurationCode.getContents(), "PaymentIDConfigurationCode");
					LocatorRadioButton.RadioEnter_name(wd, DistributionList.ExpectResponseVal, ExpectResponse.getContents(), "ExpectResponse");
					LocatorByID.Enter_ID(wd, DistributionList.MOPExternalIdentifierVal, MOPExternalIdentifier.getContents(), "MOPExternalIdentifier");
					LocatorByXPATH.Select_XPath(wd, DistributionList.ProcessCodeVal, ProcessCode.getContents(), "ProcessCode");
					LocatorByID.Enter_ID(wd, DistributionList.ResponseFormatIdentifierFlowVal, ResponseFormatIdentifierFlow.getContents(), "ResponseFormatIdentifierFlow");
					LocatorByName.DropDown_Text_Name(wd, DistributionList.StatusVal, Status.getContents(), "Status");
					LocatorCalenderFromDate.FromDate(wd, DistributionList.EffectiveFromDateVal, "Select From Date");
					LocatorByID.Enter_ID(wd, DistributionList.MOPEffectiveTillDateVal, EffectiveTillDate.getContents(), "Enter the Till Date");
		            LocatorByCSS.Click_CSS(wd, DistributionList.SubmitButton, "Submit");
		            LocatorByLinks.Click_Link(wd, DistributionList.MOPLinkVal, "");
		            ChangesLostPopUP.ChangesLost(wd,"MOP ");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}
