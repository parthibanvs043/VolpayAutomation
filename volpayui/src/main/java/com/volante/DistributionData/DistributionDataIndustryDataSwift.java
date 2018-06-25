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
import com.volante.locators.LocatorDropListSelect;
import com.volante.locators.LocatorGetDate;
import com.volante.locators.LocatorRadioButton;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class DistributionDataIndustryDataSwift
{
	 public static Workbook BRBook;
	   static Sheet BRSheet;

public static void ExecuteIndustryDataSwift(WebDriver wd,String Sheetname , String destFile) throws Exception 
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
		    WebElement IndustryDataSwift = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(DistributionList.IndustryDataSwiftLinkVal)));
		    IndustryDataSwift.click();
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
			        ReportGeneration.logger = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory("IndustryDataSwift");
	       	        Cell ModificationFlag=BRSheet.getCell(2,row);
	                Cell RecordKey=BRSheet.getCell(3,row);
	                Cell OfficeType=BRSheet.getCell(4,row); 
					Cell ParentOfficeKey=BRSheet.getCell(5,row);
					Cell HeadOfficeKey=BRSheet.getCell(6,row);
					Cell LegalType=BRSheet.getCell(7,row);
					Cell LegalParentKey=BRSheet.getCell(8,row);
					Cell GroupType=BRSheet.getCell(9,row);
					Cell GroupParentKey=BRSheet.getCell(10,row);
					Cell InstitutionStatus=BRSheet.getCell(11,row);
					Cell CooperativeGroupKey=BRSheet.getCell(12,row);
					Cell ISOLEICode=BRSheet.getCell(13,row);
					Cell BIC8=BRSheet.getCell(14,row);
					Cell BranchBIC=BRSheet.getCell(15,row);
					Cell BIC=BRSheet.getCell(16,row);
					Cell CHIPSUID=BRSheet.getCell(17,row);
					Cell NationalID=BRSheet.getCell(18,row);
					Cell ConnectedBIC=BRSheet.getCell(19,row);
					Cell InstitutionName=BRSheet.getCell(20,row);
					Cell BranchInformation=BRSheet.getCell(21,row);
					Cell POBNumber=BRSheet.getCell(22,row);
					Cell StreetAddress1=BRSheet.getCell(23,row);
					Cell StreetAddress2=BRSheet.getCell(24,row);
					Cell StreetAddress3=BRSheet.getCell(25,row);
					Cell StreetAddress4=BRSheet.getCell(26,row);
					Cell City=BRSheet.getCell(27,row);
					Cell CPS=BRSheet.getCell(28,row);
					Cell ZIPCode=BRSheet.getCell(29,row);
					Cell CountryName=BRSheet.getCell(30,row);
					Cell ISOCountryCode=BRSheet.getCell(31,row);
					Cell Timezone=BRSheet.getCell(32,row);
					Cell SubtypeIndicator=BRSheet.getCell(33,row);
					Cell NetworkConnectivity=BRSheet.getCell(34,row);
					Cell BranchQualifiers=BRSheet.getCell(35,row);
					Cell ServiceCodes=BRSheet.getCell(36,row);
					Cell SSIGroupKey=BRSheet.getCell(37,row);
					Cell IBANKey=BRSheet.getCell(38,row);
					Cell FieldA=BRSheet.getCell(39,row);
					Cell FieldB=BRSheet.getCell(40,row);
					
	                // Execution Part     
	                
	                LocatorByCSS.Click_CSS(wd, DistributionList.GridViewAddButton, "Click the Grid View Add button");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, DistributionList.ModificationFlagVal, ModificationFlag.getContents(), "ModificationFlag");
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, DistributionList.RecordKeyVal, RecordKey.getContents(), "RecordKey");
	                Thread.sleep(3000);
	                LocatorByID.Enter_ID(wd, DistributionList.OfficeTypeVal, OfficeType.getContents(), "OfficeType");
					LocatorByID.Enter_ID(wd, DistributionList.ParentOfficeKeyVal, ParentOfficeKey.getContents(), "ParentOfficeKey");
					LocatorByID.Enter_ID(wd, DistributionList.HeadOfficeKeyVal, HeadOfficeKey.getContents(), "HeadOfficeKey");
					LocatorByID.Enter_ID(wd, DistributionList.LegalTypeVal, LegalType.getContents(), "LegalType");
					LocatorByID.Enter_ID(wd, DistributionList.LegalParentKeyVal, LegalParentKey.getContents(), "LegalParentKey");
					LocatorByID.Enter_ID(wd, DistributionList.GroupTypeVal, GroupType.getContents(), "GroupType");
					LocatorByID.Enter_ID(wd, DistributionList.GroupParentKeyVal, GroupParentKey.getContents(), "GroupParentKey");
					LocatorByID.Enter_ID(wd, DistributionList.InstitutionStatusVal, InstitutionStatus.getContents(), "InstitutionStatus");
					LocatorByID.Enter_ID(wd, DistributionList.CooperativeGroupKeyVal, CooperativeGroupKey.getContents(), "CooperativeGroupKey");
					LocatorByID.Enter_ID(wd, DistributionList.ISOLEICodeVal, ISOLEICode.getContents(), "ISOLEICode");
					LocatorByID.Enter_ID(wd, DistributionList.BIC8Val, BIC8.getContents(), "BIC8");
					LocatorByID.Enter_ID(wd, DistributionList.BranchBICVal, BranchBIC.getContents(), "BranchBIC");
					LocatorByID.Enter_ID(wd, DistributionList.BICVal, BIC.getContents(), "BIC");
					LocatorByID.Enter_ID(wd, DistributionList.CHIPSUIDVal, CHIPSUID.getContents(), "CHIPSUID");
					LocatorByID.Enter_ID(wd, DistributionList.NationalIDVal, NationalID.getContents(), "NationalID");
					LocatorByID.Enter_ID(wd, DistributionList.ConnectedBICVal, ConnectedBIC.getContents(), "ConnectedBIC");
					LocatorByID.Enter_ID(wd, DistributionList.InstitutionNameVal, InstitutionName.getContents(), "InstitutionName");
					LocatorByID.Enter_ID(wd, DistributionList.BranchInformationVal, BranchInformation.getContents(), "BranchInformation");
					LocatorByID.Enter_ID(wd, DistributionList.POBNumberVal, POBNumber.getContents(), "POBNumber");
					LocatorByID.Enter_ID(wd, DistributionList.StreetAddress1Val, StreetAddress1.getContents(), "StreetAddress1");
					LocatorByID.Enter_ID(wd, DistributionList.StreetAddress2Val, StreetAddress2.getContents(), "StreetAddress2");
					LocatorByID.Enter_ID(wd, DistributionList.StreetAddress3Val, StreetAddress3.getContents(), "StreetAddress3");
					LocatorByID.Enter_ID(wd, DistributionList.StreetAddress4Val, StreetAddress4.getContents(), "StreetAddress4");
					LocatorByID.Enter_ID(wd, DistributionList.CityVal, City.getContents(), "City");
					LocatorByID.Enter_ID(wd, DistributionList.CPSVal, CPS.getContents(), "CPS");
					LocatorByID.Enter_ID(wd, DistributionList.ZIPCodeVal, ZIPCode.getContents(), "ZIPCode");
					LocatorByID.Enter_ID(wd, DistributionList.CountryNameVal, CountryName.getContents(), "CountryName");
					LocatorByID.Enter_ID(wd, DistributionList.ISOCountryCodeVal, ISOCountryCode.getContents(), "ISOCountryCode");
					LocatorByID.Enter_ID(wd, DistributionList.TimezoneVal, Timezone.getContents(), "Timezone");
					LocatorByID.Enter_ID(wd, DistributionList.SubtypeIndicatorVal, SubtypeIndicator.getContents(), "SubtypeIndicator");
					LocatorByID.Enter_ID(wd, DistributionList.NetworkConnectivityVal, NetworkConnectivity.getContents(), "NetworkConnectivity");
					LocatorByID.Enter_ID(wd, DistributionList.BranchQualifiersVal, BranchQualifiers.getContents(), "BranchQualifiers");
					LocatorByID.Enter_ID(wd, DistributionList.ServiceCodesVal, ServiceCodes.getContents(), "ServiceCodes");
					LocatorByID.Enter_ID(wd, DistributionList.SSIGroupKeyVal, SSIGroupKey.getContents(), "SSIGroupKey");
					LocatorByID.Enter_ID(wd, DistributionList.IBANKeyVal, IBANKey.getContents(), "IBANKey");
					LocatorByID.Enter_ID(wd, DistributionList.FieldAVal, FieldA.getContents(), "FieldA");
					LocatorByID.Enter_ID(wd, DistributionList.FieldBVal, FieldB.getContents(), "FieldB");
	                LocatorByLinks.Click_Link(wd, DistributionList.IndustryDataSwiftLinkVal, "");
	                ChangesLostPopUP.ChangesLost(wd,"IndustryDataSwift ");
	                Thread.sleep(2000);
	           }
		    }
		    catch (IOException e)
		    {
		    	  System.out.println("Exception="+e.getMessage());
		    }
}
}
