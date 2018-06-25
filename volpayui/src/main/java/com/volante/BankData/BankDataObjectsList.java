package com.volante.BankData;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class BankDataObjectsList {

	public static String BankData, SubmitButton, GridViewAddButton, GridView, EffectiveTillDateVal, SuccessMsg,
			ChangeModule,AddnewText;
	public static String CalendarLinkVal, CountryLinkVal, RegionLinkVal, CurrencyLinkVal, OfficeLinkVal, BranchLinkVal,
			DepartmentLinkVal, MemberShipLinkVal, BRLinkVal, FxRateLinkVal, MPITEmplateLinkVal;
	public static String CountryCodeVal, CountryNameVal, RegionCodelistVal, CtryCalendarCodeVal;
	public static String RegionCodeVal, RegionNameVal, CountryCodeListVal, RegionCalendarCodeVal, StatusVal,
			EffectiveFromDateVal;
	public static String CalendarCodeVal_C, CalendarNameVal, CalendarValidTillDateVal, IsSaturdayVal, IsSundayVal,
			IsMondayVal, IsTuesdayVal, IsWednesdayVal, IsThursdayVal, IsFridayVal, HolidayDateVal,
			HolidayDescriptionVal;
	public static String CurrencyCodeVal, CurrencyNameVal, DecimalDigits, CcyCalendarCodeVal, CcyCountryCodeVal;
	public static String DepartmentCodeVal,DepartmentNameVal,CanReroute;
	public static String OfficeCodeVal,OfficeNameVal,DefaultOffice,OfficeCalendarCode,OfficeBusinessDate,
	OfficeCurrencyCode,OfficeCountryCodeList,OfficeRegionCodeList,BackDatedPayment,DefaultDepartment;
	
	public static String BranchCodeVal,BranchNameVal,DefaultBranch,BranchOfficeCode,ParentBranchCode,
	BranchPartyCode,BranchCountryCodeList,BranchCalendarCodeList,BaseCurrency,SupportedCurrency;

	public static String FXOfficeCodeVal,ApplicableDate,SourceCurrency,TargetCurrency,Rate,Threshold;
	
	
	
public static void BankDataObject() throws DocumentException {

		String workingDir = System.getProperty("user.dir");
		File inputFile = new File(workingDir + "/src/main/resources/objectRespository/BankData.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
        
		AddnewText= document.selectSingleNode("//BankData/TextValues/AddNewCalendar").getText();
		BankData = document.selectSingleNode("//BankData/BankDataModule").getText();
		SubmitButton = document.selectSingleNode("//BankData/Submit").getText();
		SuccessMsg = document.selectSingleNode("//BankData/statusBox").getText();
		ChangeModule = document.selectSingleNode("//BankData/ChangesModule").getText();
		// View buttons
		GridView = document.selectSingleNode("//BankData/GridView/View").getText();
		GridViewAddButton = document.selectSingleNode("//BankData/GridView/AddNewButton").getText();
		// Links in Bank Data

		CalendarLinkVal = document.selectSingleNode("//BankData/Links/CalendarLink").getText();
		CountryLinkVal = document.selectSingleNode("//BankData/Links/CountryLink").getText();
		RegionLinkVal = document.selectSingleNode("//BankData/Links/RegionLink").getText();
		CurrencyLinkVal = document.selectSingleNode("//BankData/Links/CurrencyLink").getText();
		OfficeLinkVal = document.selectSingleNode("//BankData/Links/OfficeLink").getText();
		BranchLinkVal = document.selectSingleNode("//BankData/Links/BranchLink").getText();
		DepartmentLinkVal = document.selectSingleNode("//BankData/Links/DepartmentLink").getText();
		MemberShipLinkVal = document.selectSingleNode("//BankData/Links/MemberShipLink").getText();
		BRLinkVal = document.selectSingleNode("//BankData/Links/BusinessRulesLink").getText();
		FxRateLinkVal = document.selectSingleNode("//BankData/Links/FxRateLink").getText();
		MPITEmplateLinkVal = document.selectSingleNode("//BankData/Links/MPITemplateLink").getText();

		// Region Code values
		RegionCodeVal = document.selectSingleNode("//BankData/Region/RegionCode").getText();
		RegionNameVal = document.selectSingleNode("//BankData/Region/RegionName").getText();
		CountryCodeListVal = document.selectSingleNode("//BankData/Region/CountryCodeList").getText();
		RegionCalendarCodeVal = document.selectSingleNode("//BankData/Region/CalendarCode").getText();
		StatusVal = document.selectSingleNode("//BankData/Region/Status").getText();
		EffectiveFromDateVal = document.selectSingleNode("//BankData/Region/EffectiveFromDate").getText();
		EffectiveTillDateVal = document.selectSingleNode("//BankData/Region/EffectiveTillDate").getText();

		// Country Code Values
		CountryCodeVal = document.selectSingleNode("//BankData/Country/CountryCode").getText();
		CountryNameVal = document.selectSingleNode("//BankData/Country/CountryName").getText();
		RegionCodelistVal = document.selectSingleNode("//BankData/Country/RegionCode").getText();
		CtryCalendarCodeVal = document.selectSingleNode("//BankData/Country/CalendarCode").getText();
		// StatusVal=document.selectSingleNode("//BankData/Country/Status").getText();
		// EffectiveFromDateVal=document.selectSingleNode("//BankData/Country/EffectiveFromDate").getText();

		// Calendar Code values
		CalendarCodeVal_C = document.selectSingleNode("//BankData/Calendar/CalendarCode").getText();
		CalendarNameVal = document.selectSingleNode("//BankData/Calendar/CalendarName").getText();
		CalendarValidTillDateVal = document.selectSingleNode("//BankData/Calendar/CalendarValidTillDate").getText();
		IsSaturdayVal = document.selectSingleNode("//BankData/Calendar/IsSaturday").getText();
		IsSundayVal = document.selectSingleNode("//BankData/Calendar/IsSunday").getText();
		IsMondayVal = document.selectSingleNode("//BankData/Calendar/IsMonday").getText();
		IsTuesdayVal = document.selectSingleNode("//BankData/Calendar/IsTuesday").getText();
		IsWednesdayVal = document.selectSingleNode("//BankData/Calendar/IsWednesday").getText();
		IsThursdayVal = document.selectSingleNode("//BankData/Calendar/IsThursday").getText();
		IsFridayVal = document.selectSingleNode("//BankData/Calendar/IsFriday").getText();
		StatusVal = document.selectSingleNode("//BankData/Calendar/Status").getText();
		EffectiveFromDateVal = document.selectSingleNode("//BankData/Calendar/EffectiveFromDate").getText();
		EffectiveTillDateVal = document.selectSingleNode("//BankData/Calendar/EffectiveTillDate").getText();
		HolidayDateVal = document.selectSingleNode("//BankData/Calendar/HolidayDate").getText();
		HolidayDescriptionVal = document.selectSingleNode("//BankData/Calendar/HolidayDescription").getText();

		// Currency Code Values
		CurrencyCodeVal = document.selectSingleNode("//BankData/Currency/CurrencyCode").getText();
		CurrencyNameVal = document.selectSingleNode("//BankData/Currency/CurrencyName").getText();
		DecimalDigits = document.selectSingleNode("//BankData/Currency/DecimalDigit").getText();
		CcyCalendarCodeVal = document.selectSingleNode("//BankData/Currency/CalendarCode").getText();
		CcyCountryCodeVal = document.selectSingleNode("//BankData/Currency/CountryCode").getText();
		// StatusVal=document.selectSingleNode("//BankData/Country/Status").getText();
		// EffectiveFromDateVal=document.selectSingleNode("//BankData/Country/EffectiveFromDate").getText();

		// Department Code Values
		DepartmentCodeVal = document.selectSingleNode("//BankData/Department/DepartmentCode").getText();
		DepartmentNameVal = document.selectSingleNode("//BankData/Department/DepartmentName").getText();
		CanReroute = document.selectSingleNode("//BankData/Department/CanReroute").getText();
		
		// Office Code Values
		OfficeCodeVal = document.selectSingleNode("//BankData/Office/OfficeCode").getText();
	    OfficeNameVal = document.selectSingleNode("//BankData/Office/OfficeName").getText();
		DefaultOffice = document.selectSingleNode("//BankData/Office/DefaultOfffice").getText();
		OfficeCalendarCode = document.selectSingleNode("//BankData/Office/CalendarCode").getText();
		OfficeBusinessDate = document.selectSingleNode("//BankData/Office/BusinessDate").getText();
		OfficeCurrencyCode = document.selectSingleNode("//BankData/Office/CurrencyCode").getText();
		OfficeCountryCodeList = document.selectSingleNode("//BankData/Office/CountryCodeList").getText();
		OfficeRegionCodeList = document.selectSingleNode("//BankData/Office/RegionCodeList").getText();
		BackDatedPayment = document.selectSingleNode("//BankData/Office/BackdatedPaymentsDays").getText();
		DefaultDepartment = document.selectSingleNode("//BankData/Office/DefaultDepartment").getText();
		
		//Branch Code Values
		BranchCodeVal = document.selectSingleNode("//BankData/Branch/BranchCode").getText();
	    BranchNameVal = document.selectSingleNode("//BankData/Branch/BranchName").getText();
		DefaultBranch = document.selectSingleNode("//BankData/Branch/DefaultBranch").getText();
		BranchOfficeCode = document.selectSingleNode("//BankData/Branch/OfficeCode").getText();
		ParentBranchCode = document.selectSingleNode("//BankData/Branch/ParentBranchCode").getText();
		BranchPartyCode = document.selectSingleNode("//BankData/Branch/PartyCode").getText();
		BranchCountryCodeList = document.selectSingleNode("//BankData/Branch/CountryCode").getText();
		BranchCalendarCodeList = document.selectSingleNode("//BankData/Branch/CalendarCode").getText();
		BaseCurrency = document.selectSingleNode("//BankData/Branch/BaseCurrency").getText();
		SupportedCurrency = document.selectSingleNode("//BankData/Branch/SupportedCurrency").getText();
		
		// RXRate Code Values
		FXOfficeCodeVal = document.selectSingleNode("//BankData/FxRate/OfficeCode").getText();
	    ApplicableDate = document.selectSingleNode("//BankData/FxRate/ApplicableDate").getText();
		SourceCurrency = document.selectSingleNode("//BankData/FxRate/SourceCurrency").getText();
		TargetCurrency = document.selectSingleNode("//BankData/FxRate/TargetCurrency").getText();
		Rate = document.selectSingleNode("//BankData/FxRate/Rate").getText();
		Threshold = document.selectSingleNode("//BankData/FxRate/Threshold").getText();		
	}
}
