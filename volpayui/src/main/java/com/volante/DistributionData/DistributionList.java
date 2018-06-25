package com.volante.DistributionData;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class DistributionList {

	public static String DistributionData, SubmitButton, GridViewAddButton, GridView, EffectiveTillDateVal, SuccessMsg,
	ChangeModule;
	
	public static String BankRoutingLinkVal, CountryCorrespondentLinkVal, CurrencyCorrespondentLinkVal, IndustryDataSwiftLinkVal, MOPLinkVal, MOPPriorityLinkVal,
	CutOffLinkVal, BulkProfileLinkVal, BulkProfileOverrideLinkVal;
	
	public static String BranchVal, PartyCodeVal, BRCurrencyVal, BRCountryCodeVal,ServiceVal,ProductVal,DestinationBankCodeVal,DestinationBankIdentifierVal,
	MessageTypeVal,RoutingMethodVal,AgentBankPartyCodeVal,AgentAccountVal,StatusVal,EffectiveFromDateVal,BRMinAmtVal,BRMaxAmtVal;
	
	public static String CountryCorrespondentPartyCodeVal,CCCountryCodeVal,CCRoutingMethodVal;
	
	public static String  CurrencyCorrespondentPartyCodeVal,CCCurrencyCodeVal;
	
	public static String ModificationFlagVal,RecordKeyVal,OfficeTypeVal,ParentOfficeKeyVal,HeadOfficeKeyVal,LegalTypeVal,
	LegalParentKeyVal,GroupTypeVal,GroupParentKeyVal,InstitutionStatusVal,CooperativeGroupKeyVal,ISOLEICodeVal,BIC8Val,
	BranchBICVal,BICVal,CHIPSUIDVal,NationalIDVal,ConnectedBICVal,InstitutionNameVal,BranchInformationVal,POBNumberVal,StreetAddress1Val,StreetAddress2Val,StreetAddress3Val,
	StreetAddress4Val,CityVal,CPSVal,ZIPCodeVal,CountryNameVal,ISOCountryCodeVal,TimezoneVal,SubtypeIndicatorVal,NetworkConnectivityVal,BranchQualifiersVal,ServiceCodesVal, 
	SSIGroupKeyVal,IBANKeyVal,FieldAVal,FieldBVal;
	
	public static String MOPCodeVal,MOPCategoryVal,MOPTechnicalNameVal,OutputFormatVal,ProductCodeVal,ClearingSchemeCodeVal,CashClearingSchemeCodeVal,SettlementAccountNosVal,
	SupportedChargeCodesVal,DescriptionVal,CalendarCodeVal,MOPBusinessDateVal,EarliestValueDateVal,LatestValueDateVal,ValueDateExtensionVal,CutOffCodeVal,
	RoleForwardValueDateVal,MOPTimeExtensionVal,ValidateMembershipVal,MinAmountVal,MaxAmountVal,BulkPaymentVal,HolidayBulkProfileVal,WeekdayBulkProfileVal,
	WeekendBulkProfileVal,FileIDConfigurationCodeVal, PaymentIDConfigurationCodeVal,ExpectResponseVal, MOPExternalIdentifierVal, ProcessCodeVal, 
	ResponseFormatIdentifierFlowVal,CountryCodeVal,MinimumAmountVal,MaximumAmountVal,MinimumProcessingDaysVal,CurrencyCodeVal,MOPCutOffCodeVal,MOPEffectiveTillDateVal;
	
	public static String MethodOfPaymentCodeVal,PriorityVal,CurrencyVal,CCtrMinimumProcessingDaysVal,CcyCMinimumProcessingDaysVal;
	
	public static String CutOffNameVal,EndTimeVal,StartTimeVal,CtrCMinimumProcessingDaysVal;
	
	public static String BulkProfileCodeVal,MaxPaymentsPerBulkMessageVal,BulkFrequencyVal, BulkEndTimeVal, BulkStartTimeVal,BulkTriggerCountVal, 
	PerformBulkingatMOPCutOffTimeVal,FixedBulkTimesVal;
	
	public static String MOPVal,OverridetypeVal,OverridevalueVal,BulkProfileVal;
	
	
	
	
public static void DistributionDataObject() throws DocumentException {

	String workingDir = System.getProperty("user.dir");
	File inputFile = new File(workingDir + "/src/main/resources/objectRespository/DistributionData.xml");
	SAXReader saxReader = new SAXReader();
	Document document = saxReader.read(inputFile);
	DistributionData = document.selectSingleNode("//DistributionData/DistributionDataModule").getText();
	SubmitButton = document.selectSingleNode("//DistributionData/Submit").getText();
	SuccessMsg = document.selectSingleNode("//DistributionData/statusBox").getText();
	ChangeModule = document.selectSingleNode("//DistributionData/ChangesModule").getText();
	// View buttons
	GridView = document.selectSingleNode("//DistributionData/GridView/View").getText();
	GridViewAddButton = document.selectSingleNode("//DistributionData/GridView/AddNewButton").getText();
	// Links in Distribution Data

	BankRoutingLinkVal = document.selectSingleNode("//DistributionData/Links/BankRoutingLink").getText();
	CountryCorrespondentLinkVal = document.selectSingleNode("//DistributionData/Links/CountryCorrespondentLink").getText();
	CurrencyCorrespondentLinkVal = document.selectSingleNode("//DistributionData/Links/CurrencyCorrespondentLink").getText();
	IndustryDataSwiftLinkVal = document.selectSingleNode("//DistributionData/Links/IndustryDataSwiftLink").getText();
	MOPLinkVal = document.selectSingleNode("//DistributionData/Links/MethodOfPaymentLink").getText();
	MOPPriorityLinkVal = document.selectSingleNode("//DistributionData/Links/MOPPriorityLink").getText();
	CutOffLinkVal = document.selectSingleNode("//DistributionData/Links/CutOffLink").getText();
	BulkProfileLinkVal = document.selectSingleNode("//DistributionData/Links/BulkProfileLink").getText();
	BulkProfileOverrideLinkVal = document.selectSingleNode("//DistributionData/Links/BulkProfileOverrideLink").getText();
	
	
	// BankRouting values
	
			BranchVal = document.selectSingleNode("//DistributionData/BankRouting/Branch").getText();
			PartyCodeVal = document.selectSingleNode("//DistributionData/BankRouting/PartyCode").getText();
			BRCurrencyVal = document.selectSingleNode("//DistributionData/BankRouting/Currency").getText();
			BRCountryCodeVal = document.selectSingleNode("//DistributionData/BankRouting/CountryCode").getText();
			ServiceVal = document.selectSingleNode("//DistributionData/BankRouting/Service").getText();
			ProductVal = document.selectSingleNode("//DistributionData/BankRouting/Product").getText();
			BRMinAmtVal = document.selectSingleNode("//DistributionData/BankRouting/MinimumAmount").getText();
			BRMaxAmtVal = document.selectSingleNode("//DistributionData/BankRouting/MaximumAmount").getText();
			DestinationBankCodeVal = document.selectSingleNode("//DistributionData/BankRouting/DestinationBankCode").getText();
			DestinationBankIdentifierVal = document.selectSingleNode("//DistributionData/BankRouting/DestinationBankIdentifier").getText();
			MessageTypeVal = document.selectSingleNode("//DistributionData/BankRouting/MessageType").getText();
			RoutingMethodVal = document.selectSingleNode("//DistributionData/BankRouting/RoutingMethod").getText();
			AgentBankPartyCodeVal = document.selectSingleNode("//DistributionData/BankRouting/AgentBankPartyCode").getText();
			AgentAccountVal = document.selectSingleNode("//DistributionData/BankRouting/AgentAccount").getText();
			StatusVal = document.selectSingleNode("//DistributionData/BankRouting/Status").getText();
			EffectiveFromDateVal = document.selectSingleNode("//DistributionData/BankRouting/EffectiveFromDate").getText();
			EffectiveTillDateVal = document.selectSingleNode("//DistributionData/BankRouting/EffectiveTillDate").getText();
		
	// CountryCorresponent values	
		
			CCCountryCodeVal = document.selectSingleNode("//DistributionData/CountryCorrespondent/CountryCode").getText();
			CountryCorrespondentPartyCodeVal = document.selectSingleNode("//DistributionData/CountryCorrespondent/CountryCorrespondentPartyCode").getText();
			CCRoutingMethodVal = document.selectSingleNode("//DistributionData/CountryCorrespondent/RoutingMethod").getText();
			CtrCMinimumProcessingDaysVal = document.selectSingleNode("//DistributionData/CountryCorrespondent/MinimumProcessingDays").getText();
			/*StatusVal = document.selectSingleNode("//DistributionData/CountryCorrespondent/Status").getText();
			EffectiveFromDateVal = document.selectSingleNode("//DistributionData/CountryCorrespondent/EffectiveFromDate").getText();
			EffectiveTillDateVal = document.selectSingleNode("//DistributionData/CountryCorrespondent/EffectiveTillDate").getText();*/
			
	// CurrencyCorresponent values
			
			CCCurrencyCodeVal = document.selectSingleNode("//DistributionData/CurrencyCorrespondent/CurrencyCode").getText();
			CurrencyCorrespondentPartyCodeVal = document.selectSingleNode("//DistributionData/CurrencyCorrespondent/CurrencyCorrespondentPartyCode").getText();
			RoutingMethodVal = document.selectSingleNode("//DistributionData/CurrencyCorrespondent/RoutingMethod").getText();
			CcyCMinimumProcessingDaysVal = document.selectSingleNode("//DistributionData/CurrencyCorrespondent/MinimumProcessingDays").getText();
			/*StatusVal = document.selectSingleNode("//DistributionData/CurrencyCorrespondent/Status").getText();
			EffectiveFromDateVal = document.selectSingleNode("//DistributionData/CurrencyCorrespondent/EffectiveFromDate").getText();
			EffectiveTillDateVal = document.selectSingleNode("//DistributionData/CurrencyCorrespondent/EffectiveTillDate").getText();*/
			
	// Industry-DataSwift values
			
			ModificationFlagVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/ModificationFlag").getText();
			RecordKeyVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/RecordKey").getText();
			OfficeTypeVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/OfficeType").getText();
			ParentOfficeKeyVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/ParentOfficeKey").getText();
			HeadOfficeKeyVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/HeadOfficeKey").getText();
			LegalTypeVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/LegalType").getText();
			LegalParentKeyVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/LegalParentKey").getText();
			GroupTypeVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/GroupType").getText();
			GroupParentKeyVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/GroupParentKey").getText();
			InstitutionStatusVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/InstitutionStatus").getText();
			CooperativeGroupKeyVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/CooperativeGroupKey").getText();
			ISOLEICodeVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/ISOLEICode").getText();
			BIC8Val = document.selectSingleNode("//DistributionData/IndustryDataSwift/BIC8").getText();
			BranchBICVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/BranchBIC").getText();
			BICVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/BIC").getText();
			CHIPSUIDVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/CHIPSUID").getText();
			NationalIDVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/NationalID").getText();
			ConnectedBICVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/ConnectedBIC").getText();
			InstitutionNameVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/InstitutionName").getText();
			BranchInformationVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/BranchInformation").getText();
			POBNumberVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/POBNumber").getText();
			StreetAddress1Val = document.selectSingleNode("//DistributionData/IndustryDataSwift/StreetAddress1").getText();
			StreetAddress2Val = document.selectSingleNode("//DistributionData/IndustryDataSwift/StreetAddress2").getText();
			StreetAddress3Val = document.selectSingleNode("//DistributionData/IndustryDataSwift/StreetAddress3").getText();
			StreetAddress4Val = document.selectSingleNode("//DistributionData/IndustryDataSwift/StreetAddress4").getText();
			CityVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/City").getText();
			CPSVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/CPS").getText();
			ZIPCodeVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/ZIPCode").getText();
			CountryNameVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/CountryName").getText();
			ISOCountryCodeVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/ISOCountryCode").getText();
			TimezoneVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/Timezone").getText();
			SubtypeIndicatorVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/SubtypeIndicator").getText();
			NetworkConnectivityVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/NetworkConnectivity").getText();
			BranchQualifiersVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/BranchQualifiers").getText();
			ServiceCodesVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/ServiceCodes").getText();
			SSIGroupKeyVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/SSIGroupKey").getText();
			IBANKeyVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/IBANKey").getText();
			FieldAVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/FieldA").getText();
			FieldBVal = document.selectSingleNode("//DistributionData/IndustryDataSwift/FieldB").getText();
						
	// MethodOfPayment values	
			
			MOPCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/MOPCode").getText();
			MOPCategoryVal = document.selectSingleNode("//DistributionData/MethodOfPayment/MOPCategory").getText();
			MOPTechnicalNameVal = document.selectSingleNode("//DistributionData/MethodOfPayment/MOPTechnicalName").getText();
			OutputFormatVal = document.selectSingleNode("//DistributionData/MethodOfPayment/OutputFormat").getText();
			ProductCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/ProductCode").getText();
			ClearingSchemeCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/ClearingSchemeCode").getText();
			CashClearingSchemeCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/CashClearingSchemeCode").getText();
			CountryCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/CountryCode").getText();
			CurrencyCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/CurrencyCode").getText();
			SettlementAccountNosVal = document.selectSingleNode("//DistributionData/MethodOfPayment/SettlementAccountNos").getText();
			SupportedChargeCodesVal = document.selectSingleNode("//DistributionData/MethodOfPayment/SupportedChargeCodes").getText();
			DescriptionVal = document.selectSingleNode("//DistributionData/MethodOfPayment/Description").getText();
			CalendarCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/CalendarCode").getText();
			MOPBusinessDateVal = document.selectSingleNode("//DistributionData/MethodOfPayment/MOPBusinessDate").getText();
			MinimumProcessingDaysVal = document.selectSingleNode("//DistributionData/MethodOfPayment/MinimumProcessingDays").getText();
			EarliestValueDateVal = document.selectSingleNode("//DistributionData/MethodOfPayment/EarliestValueDate").getText();
			LatestValueDateVal = document.selectSingleNode("//DistributionData/MethodOfPayment/LatestValueDate").getText();
			ValueDateExtensionVal = document.selectSingleNode("//DistributionData/MethodOfPayment/ValueDateExtension").getText();
			MOPCutOffCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/CutOffCode").getText();
			RoleForwardValueDateVal = document.selectSingleNode("//DistributionData/MethodOfPayment/RoleForwardValueDate").getText();
			MOPTimeExtensionVal = document.selectSingleNode("//DistributionData/MethodOfPayment/MOPTimeExtension").getText();
			ValidateMembershipVal = document.selectSingleNode("//DistributionData/MethodOfPayment/ValidateMembership").getText();
			MinAmountVal = document.selectSingleNode("//DistributionData/MethodOfPayment/MinAmount").getText();
			MaxAmountVal = document.selectSingleNode("//DistributionData/MethodOfPayment/MaxAmount").getText();
			BulkPaymentVal = document.selectSingleNode("//DistributionData/MethodOfPayment/BulkPayment").getText();
			HolidayBulkProfileVal = document.selectSingleNode("//DistributionData/MethodOfPayment/HolidayBulkProfile").getText();
			WeekdayBulkProfileVal = document.selectSingleNode("//DistributionData/MethodOfPayment/WeekdayBulkProfile").getText();
			WeekendBulkProfileVal = document.selectSingleNode("//DistributionData/MethodOfPayment/WeekendBulkProfile").getText();
			FileIDConfigurationCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/FileIDConfigurationCode").getText();
			PaymentIDConfigurationCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/PaymentIDConfigurationCode").getText();
			ExpectResponseVal = document.selectSingleNode("//DistributionData/MethodOfPayment/ExpectResponse").getText();
			MOPExternalIdentifierVal = document.selectSingleNode("//DistributionData/MethodOfPayment/MOPExternalIdentifier").getText();
			ProcessCodeVal = document.selectSingleNode("//DistributionData/MethodOfPayment/ProcessCode").getText();
			ResponseFormatIdentifierFlowVal = document.selectSingleNode("//DistributionData/MethodOfPayment/ResponseFormatIdentifierFlow").getText();
			/*StatusVal = document.selectSingleNode("//DistributionData/MethodOfPayment/Status").getText();
			EffectiveFromDateVal = document.selectSingleNode("//DistributionData/MethodOfPayment/EffectiveFromDate").getText();*/
			MOPEffectiveTillDateVal = document.selectSingleNode("//DistributionData/MethodOfPayment/EffectiveTillDate").getText();
			
			
	// MethodOfPaymentPriority values
			
		
			MethodOfPaymentCodeVal = document.selectSingleNode("//DistributionData/MethodOfPaymentPriority/MethodOfPaymentCode").getText();
			CurrencyVal = document.selectSingleNode("//DistributionData/MethodOfPaymentPriority/Currency").getText();
			PriorityVal = document.selectSingleNode("//DistributionData/MethodOfPaymentPriority/Priority").getText();
			/*StatusVal = document.selectSingleNode("//DistributionData/MethodOfPaymentPriority/Status").getText();
			EffectiveFromDateVal = document.selectSingleNode("//DistributionData/MethodOfPaymentPriority/EffectiveFromDate").getText();
			EffectiveTillDateVal = document.selectSingleNode("//DistributionData/MethodOfPaymentPriority/EffectiveTillDate").getText();*/
			
	// CutOff values		
			
			CutOffCodeVal = document.selectSingleNode("//DistributionData/CutOff/CutOffCode").getText();
			CutOffNameVal = document.selectSingleNode("//DistributionData/CutOff/CutOffName").getText();
			//StatusVal = document.selectSingleNode("//DistributionData/CutOff/Status").getText();
			EndTimeVal = document.selectSingleNode("//DistributionData/CutOff/EndTime").getText();
			StartTimeVal = document.selectSingleNode("//DistributionData/CutOff/StartTime").getText();
			/*EffectiveFromDateVal = document.selectSingleNode("//DistributionData/CutOff/EffectiveFromDate").getText();
			EffectiveTillDateVal = document.selectSingleNode("//DistributionData/CutOff/EffectiveTillDate").getText();*/
			
	// BulkProfile values	
			BulkProfileCodeVal = document.selectSingleNode("//DistributionData/BulkProfile/BulkProfileCode").getText();
			MaxPaymentsPerBulkMessageVal = document.selectSingleNode("//DistributionData/BulkProfile/MaxPaymentsPerBulkMessage").getText();
			BulkFrequencyVal = document.selectSingleNode("//DistributionData/BulkProfile/BulkFrequency").getText();
			BulkEndTimeVal = document.selectSingleNode("//DistributionData/BulkProfile/BulkEndTime").getText();
			BulkStartTimeVal = document.selectSingleNode("//DistributionData/BulkProfile/BulkStartTime").getText();
			BulkTriggerCountVal = document.selectSingleNode("//DistributionData/BulkProfile/BulkTriggerCount").getText();
			PerformBulkingatMOPCutOffTimeVal = document.selectSingleNode("//DistributionData/BulkProfile/PerformBulkingatMOPCutOffTime").getText();
			/*StatusVal = document.selectSingleNode("//DistributionData/BulkProfile/Status").getText();
			EffectiveFromDateVal = document.selectSingleNode("//DistributionData/BulkProfile/EffectiveFromDate").getText();
			EffectiveTillDateVal = document.selectSingleNode("//DistributionData/BulkProfile/EffectiveTillDate").getText();*/
			FixedBulkTimesVal = document.selectSingleNode("//DistributionData/BulkProfile/FixedBulkTimes").getText();	
			
	// BulkProfileOverride values				
			MOPVal = document.selectSingleNode("//DistributionData/BulkProfileOverride/MOP").getText();
			OverridetypeVal = document.selectSingleNode("//DistributionData/BulkProfileOverride/Overridetype").getText();
			OverridevalueVal = document.selectSingleNode("//DistributionData/BulkProfileOverride/Overridevalue").getText();
			BulkProfileVal = document.selectSingleNode("//DistributionData/BulkProfileOverride/BulkProfile").getText();
			/*StatusVal = document.selectSingleNode("//DistributionData/BulkProfileOverride/Status").getText();
			EffectiveFromDateVal = document.selectSingleNode("//DistributionData/BulkProfileOverride/EffectiveFromDate").getText();
			EffectiveTillDateVal = document.selectSingleNode("//DistributionData/BulkProfileOverride/EffectiveTillDate").getText();*/

			
}

}
