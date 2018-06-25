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
import com.volante.locators.LocatorByXPATH;
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

public class OnBoardingAccount {

	   static Sheet BRSheet;

public static void ExecuteAccount( WebDriver wd,String Sheetname,String destFile) throws Exception 
	{
		    try
		    {
		    	 OnBoardingObjectList.OnboardingObject();	
   	             Workbook wb = Workbook.getWorkbook(new File(destFile));
                 BRSheet=wb.getSheet(Sheetname);
                 int rows_count=BRSheet.getRows();
                 int newrowscount=rows_count-1;
                 System.out.println("No of Rows in Account Page="+newrowscount);
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
	        WebElement Department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(OnBoardingObjectList.AccountLinkVal)));
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
			        Cell AccountNumber=BRSheet.getCell(2,row);
			        Cell IBAN=BRSheet.getCell(3,row);
			        Cell AccountName=BRSheet.getCell(4,row);
			        Cell PartyCode=BRSheet.getCell(5,row);
			        Cell AccounType=BRSheet.getCell(6,row);
			        Cell PrefferedAccountNumber=BRSheet.getCell(7,row);
			        Cell AccountCurrencyLsit=BRSheet.getCell(8,row);
			        Cell DefaultCurrency=BRSheet.getCell(9,row);
			        Cell AccountingSystem=BRSheet.getCell(10,row);
			        Cell BranchCode=BRSheet.getCell(11,row);
			        Cell ProcessingRestrications=BRSheet.getCell(12,row);
			        Cell LegalEntityIdentifier=BRSheet.getCell(13,row);
			        Cell AccountDebitAuthorization=BRSheet.getCell(14,row);
			        Cell AddressLine1=BRSheet.getCell(15,row);
			        Cell AddressLine2=BRSheet.getCell(16,row);
			        Cell City=BRSheet.getCell(17,row);
			        Cell State=BRSheet.getCell(18,row);
			        Cell PostCode=BRSheet.getCell(19,row);
			        Cell Country=BRSheet.getCell(20,row);
			        Cell EmailID=BRSheet.getCell(21,row);
			        Cell PhoneNo=BRSheet.getCell(22,row);
	                Cell Status=BRSheet.getCell(23,row);
	               //Cell EffectiveFromDate=BRSheet.getCell(24,row);
	                Cell EffectiveTillDate=BRSheet.getCell(25,row);
	                // Execution Part          
	                LocatorByCSS.Click_CSS(wd, OnBoardingObjectList.GridViewAddButton, "Clicked the Grid view button to create Account");
	                Thread.sleep(2000);
	                LocatorTextValidation.Text_XPath(wd, OnBoardingObjectList.AddnewText, "Onboarding New Account", "Text Value matched in Add New Account Page");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Acc_AccountNumber, AccountNumber.getContents(), "Entered the AccountNumber as "+AccountNumber.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Acc_IBAN, IBAN.getContents(), "Entered the IBAN as "+IBAN.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Acc_AccountName, AccountName.getContents(), "Enter the AccountName as "+AccountName.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.Acc_PartyCode, PartyCode.getContents(), "Select the Party Code as "+PartyCode.getContents());
	                Thread.sleep(3000);
	                LocatorByXPATH.DropDown_Text_XPath(wd, OnBoardingObjectList.Acc_AccounType, AccounType.getContents(), "Select the AccounType as "+AccounType.getContents());
	                LocatorRadioButton.RadioEnter_name(wd, OnBoardingObjectList.Acc_PrefferedAccountNumber, PrefferedAccountNumber.getContents(), "Select the PrefferedAccountNumber as  "+PrefferedAccountNumber.getContents());
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.Acc_AccountCurrencyLsit, AccountCurrencyLsit.getContents(), "Select the Currency Code as "+AccountCurrencyLsit.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.Acc_DefaultCurrency, DefaultCurrency.getContents(), "Select the Country Code as "+DefaultCurrency.getContents());
	                Thread.sleep(3000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Acc_AccountingSystem, AccountingSystem.getContents(), "Entered the AccountingSystem as "+AccountingSystem.getContents());
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.Acc_BranchCode, BranchCode.getContents(), "Select the BranchCode as" +BranchCode.getContents());
	                Thread.sleep(3000);
	                LocatorByXPATH.DropDown_Text_XPath(wd, OnBoardingObjectList.Acc_ProcessingRestrications, ProcessingRestrications.getContents(), "Select the ProcessingRestrications as "+ProcessingRestrications.getContents());
	                Thread.sleep(2000);	
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Acc_LegalEntityIdentifier, LegalEntityIdentifier.getContents(), "Enter the Branch Code");
	                Thread.sleep(3000);	                
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.Acc_AccountDebitAuthorization, AccountDebitAuthorization.getContents(), "Select AccountDebitAuthorization as "+AccountDebitAuthorization.getContents());
	                Thread.sleep(3000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Acc_AddressLine1, AddressLine1.getContents(), "Entered the AddressLine1 as "+AddressLine1.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Acc_AddressLine2, AddressLine2.getContents(), "Entered the AddressLine2 as "+AddressLine2.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Acc_City, City.getContents(), "Entered the City as "+City.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Acc_State, State.getContents(), "Entered the State as "+State.getContents());
	                LocatorByXPATH.Enter_XPath(wd, OnBoardingObjectList.Acc_PostCode, PostCode.getContents(), "Entered the PostCode as "+PostCode.getContents());
	                LocatorByXPATH.Enter_XPath(wd, OnBoardingObjectList.Acc_Country, Country.getContents(), "Entered the Country as "+Country.getContents());
	                LocatorByXPATH.Enter_XPath(wd, OnBoardingObjectList.Acc_EmailID, EmailID.getContents(), "Entered the EmailID as "+EmailID.getContents());
	                LocatorByXPATH.Enter_XPath(wd, OnBoardingObjectList.Acc_PhoneNo, PhoneNo.getContents(), "Entered the PhoneNo as "+PhoneNo.getContents());
	                Thread.sleep(3000);
	                //((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView(true);", OnBoardingObjectList.Status);
	                LocatorByName.DropDown_Text_Name(wd, OnBoardingObjectList.Status, Status.getContents(), "Select the Status as "+Status.getContents());
	                LocatorGetDate.SelectDate(wd, OnBoardingObjectList.EffectiveFromDate, "Selected the Effective From Date as today");
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.EffectiveTillDate, EffectiveTillDate.getContents(), "Entered the Till Date as "+EffectiveTillDate.getContents());
	                LocatorByCSS.Click_CSS(wd, OnBoardingObjectList.SubmitButton, "Save the details by Clicking the Submit button");
	                LocatorStatusBox.GetStatusByID(wd, OnBoardingObjectList.SuccessMsg, "Account successfully added.", "Success Matched Successfully");
	                Thread.sleep(3000);
	                LocatorByLinks.Click_Link(wd, OnBoardingObjectList.AccountLinkVal, "Click the Account link");
	                ChangesLostPopUP.ChangesLost(wd,"Account");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}
