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

public class OnBoardingParty 
{

	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteParty( WebDriver wd,String Sheetname,String destFile) throws Exception 
	{
		    try
		    {
		    	 OnBoardingObjectList.OnboardingObject();	
   	             Workbook wb = Workbook.getWorkbook(new File(destFile));
                 BRSheet=wb.getSheet(Sheetname);
                 int rows_count=BRSheet.getRows();
                 int newrowscount=rows_count-1;
                 System.out.println("No of Rows in Party Page="+newrowscount);
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
		    WebElement Department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(OnBoardingObjectList.PartyLinkVal)));
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
			        Cell PartyCode=BRSheet.getCell(2,row);
			        Cell PartyName=BRSheet.getCell(3,row);
			        Cell PartyDisplayname=BRSheet.getCell(4,row);
			        Cell ParentPartyCode=BRSheet.getCell(5,row);
			        Cell PartyType=BRSheet.getCell(6,row);
			        Cell PartySubType=BRSheet.getCell(7,row);
			        Cell SupportsUC=BRSheet.getCell(8,row);
			        Cell UCDataAvailable=BRSheet.getCell(9,row);
			        Cell PartyExternalIdentifier=BRSheet.getCell(10,row);
			        Cell ChargesAccountNumber=BRSheet.getCell(11,row);
			        Cell ChargesAccountCurrency=BRSheet.getCell(12,row);
			        Cell ProcessRestrication=BRSheet.getCell(13,row);
			        Cell CalendarCode=BRSheet.getCell(14,row);
			        Cell CutOffProfileCode=BRSheet.getCell(15,row);
			        Cell AddressLine1=BRSheet.getCell(16,row);
			        Cell AddressLine2=BRSheet.getCell(17,row);
			        Cell City=BRSheet.getCell(18,row);
			        Cell State=BRSheet.getCell(19,row);
			        Cell PostCode=BRSheet.getCell(20,row);
			        Cell Country=BRSheet.getCell(21,row);
			        Cell EmailID=BRSheet.getCell(22,row);
			        Cell PhoneNo=BRSheet.getCell(23,row);
			        Cell LegalEntityIdentifier=BRSheet.getCell(24,row);

	                Cell Status=BRSheet.getCell(25,row);
	               //Cell EffectiveFromDate=BRSheet.getCell(26,row);
	                Cell EffectiveTillDate=BRSheet.getCell(27,row);
	                // Execution Part          
	                LocatorByCSS.Click_CSS(wd, OnBoardingObjectList.GridViewAddButton, "Clicked the Grid view button to create Party");
	                Thread.sleep(2000);
	                LocatorTextValidation.Text_XPath(wd, OnBoardingObjectList.AddnewText, "Onboarding New Party", "Text Value matched in Add New Party Page");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_PartyCode, PartyCode.getContents(), "Entered the Party Code as "+PartyCode.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_PartyName, PartyName.getContents(), "Entered the Party Name as "+PartyName.getContents());
	                Thread.sleep(1000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_PartyDisplayname, PartyDisplayname.getContents(), "Entered the Party Name as "+PartyDisplayname.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.Party_ParentPartyCode, ParentPartyCode.getContents(), "Select the ParentPartyCode Code as "+ParentPartyCode.getContents());
	                Thread.sleep(3000);
	                LocatorByID.DropDown_Text_ID(wd, OnBoardingObjectList.Party_PartyType, PartyType.getContents(), "Select the Party Type as "+PartyType.getContents());
	                LocatorByID.DropDown_Text_ID(wd, OnBoardingObjectList.Party_PartySubType, PartySubType.getContents(), "Select the Party Sub Type as "+PartySubType.getContents());
	                LocatorRadioButton.RadioEnter_name(wd, OnBoardingObjectList.Party_SupportsUC, SupportsUC.getContents(), "Select SupportsUC as "+SupportsUC.getContents());
	                LocatorRadioButton.RadioEnter_name(wd, OnBoardingObjectList.Party_UCDataAvailable, UCDataAvailable.getContents(), "Select UCDataAvailable  as "+UCDataAvailable.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_PartyExternalIdentifier, PartyExternalIdentifier.getContents(), "Enter the Party External Identifier as "+PartyExternalIdentifier.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_ChargesAccountNumber, ChargesAccountNumber.getContents(), "Enter the Default Charges Account Number as "+ChargesAccountNumber.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_ChargesAccountCurrency, ChargesAccountCurrency.getContents(), "Enter the Default Charges Account Currency as  "+ChargesAccountCurrency.getContents());
	                LocatorByID.DropDown_Text_ID(wd, OnBoardingObjectList.Party_ProcessRestrication, ProcessRestrication.getContents(), "Select the ProcessRestrication as "+ProcessRestrication.getContents());
	                Thread.sleep(1500);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.Party_CalendarCode, CalendarCode.getContents(), "Select the CalendarCode as "+CalendarCode.getContents());
	                Thread.sleep(3000);
	                LocatorDropListSelect.DropListSelectText_Xpath(wd, OnBoardingObjectList.Party_CutOffProfileCode, CutOffProfileCode.getContents(), "Select the CutOffProfileCode as "+CutOffProfileCode.getContents());
	                Thread.sleep(3000);
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_AddressLine1, AddressLine1.getContents(), "Entered the AddressLine1 as "+AddressLine1.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_AddressLine2, AddressLine2.getContents(), "Entered the AddressLine2 as "+AddressLine2.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_City, City.getContents(), "Entered the City as "+City.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_State, State.getContents(), "Entered the State as "+State.getContents());
	                LocatorByXPATH.Enter_XPath(wd, OnBoardingObjectList.Party_PostCode, PostCode.getContents(), "Entered the PostCode as "+PostCode.getContents());
	                LocatorByXPATH.Enter_XPath(wd, OnBoardingObjectList.Party_Country, Country.getContents(), "Entered the Country as "+Country.getContents());
	                LocatorByXPATH.Enter_XPath(wd, OnBoardingObjectList.Party_EmailID, EmailID.getContents(), "Entered the EmailID as "+EmailID.getContents());
	                LocatorByXPATH.Enter_XPath(wd, OnBoardingObjectList.Party_PhoneNo, PhoneNo.getContents(), "Entered the PhoneNo as "+PhoneNo.getContents());
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.Party_LegalEntityIdentifier, LegalEntityIdentifier.getContents(), "Entered the LegalEntityIdentifier as "+LegalEntityIdentifier.getContents());
	                LocatorByName.DropDown_Text_Name(wd, OnBoardingObjectList.Status, Status.getContents(), "Select the Status as "+Status.getContents());
	                LocatorGetDate.SelectDate(wd, OnBoardingObjectList.EffectiveFromDate, "Selected the Effective From Date as today");
	                LocatorByID.Enter_ID(wd, OnBoardingObjectList.EffectiveTillDate, EffectiveTillDate.getContents(), "Entered the Till Date as "+EffectiveTillDate.getContents());
	                LocatorByCSS.Click_CSS(wd, OnBoardingObjectList.SubmitButton, "Save the details by Clicking the Submit button");
	                LocatorStatusBox.GetStatusByID(wd, OnBoardingObjectList.SuccessMsg, "Party successfully added.", "Success Matched Successfully");
	                Thread.sleep(3000);
	                LocatorByLinks.Click_Link(wd, OnBoardingObjectList.PartyLinkVal, "Click the Party link");
	                ChangesLostPopUP.ChangesLost(wd,"Party ");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}
