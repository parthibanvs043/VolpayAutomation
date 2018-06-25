package com.volante.OnBoardingData;

import java.io.File;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;


public class OnBoardingObjectList 
{
	public static String OnboardingData, SubmitButton, GridViewAddButton, GridView, SuccessMsg,ChangeModule,AddnewText,
	Status,EffectiveFromDate,EffectiveTillDate;
	
	public static String ServiceGroupLinkVal, ServiceLinkVal, ProductLinkVal, PartyLinkVal, AccountLinkVal, TransportLinkVal,PSALinkVal;
	
	public static String Acc_AccountNumber,Acc_IBAN,Acc_AccountName,Acc_AccounType,Acc_PartyCode,Acc_PrefferedAccountNumber,Acc_AccountCurrencyLsit
	,Acc_DefaultCurrency,Acc_AccountingSystem,Acc_BranchCode,Acc_ProcessingRestrications,Acc_LegalEntityIdentifier,
	Acc_AccountDebitAuthorization,Acc_AddressLine1,Acc_AddressLine2,Acc_City,Acc_State,Acc_PostCode,Acc_Country
	,Acc_EmailID,Acc_PhoneNo;
	
	public static String Party_PartyCode,Party_PartyName,Party_PartyDisplayname,Party_ParentPartyCode,Party_PartyType,Party_PartySubType
	,Party_SupportsUC,Party_UCDataAvailable,Party_PartyExternalIdentifier,Party_ChargesAccountNumber,Party_ChargesAccountCurrency,
	Party_ProcessRestrication,Party_CalendarCode,Party_CutOffProfileCode,Party_AddressLine1,Party_AddressLine2,Party_City,
	Party_State,Party_PostCode,Party_Country,Party_EmailID,Party_PhoneNo,Party_LegalEntityIdentifier;
	
	public static String ServiceGroupCode,ServiceGroupName,ServiceGroupDesc;
	public static String ServiceCode,ServiceName,ServiceDesc,ServiceGrpCode,OfferedByEntity,MarketCurrency, InstructionCurrency,
	ServiceIdConfigCode,ServiceIdPatternCode,PDCParameters;
	
	public static String ProductCode,ProductName,ProductDesc,ProductCat;
	
public static void OnboardingObject() throws DocumentException {
	
	String workingDir = System.getProperty("user.dir");
	File inputFile = new File(workingDir + "/src/main/resources/objectRespository/OnBoardingData.xml");
	SAXReader saxReader = new SAXReader();
	Document document = saxReader.read(inputFile);

	AddnewText= document.selectSingleNode("//OnboardingData/TextValues/AddNewText").getText();
	OnboardingData = document.selectSingleNode("//OnboardingData/OnboardingModule").getText();
	SubmitButton = document.selectSingleNode("//OnboardingData/Submit").getText();
	SuccessMsg = document.selectSingleNode("//OnboardingData/statusBox").getText();
	ChangeModule = document.selectSingleNode("//OnboardingData/ChangesModule").getText();
	// View buttons
	GridView = document.selectSingleNode("//OnboardingData/GridView/View").getText();
	GridViewAddButton = document.selectSingleNode("//OnboardingData/GridView/AddNewButton").getText();
	// Links in Bank Data

	ServiceGroupLinkVal = document.selectSingleNode("//OnboardingData/Links/ServiceGroupLink").getText();
	ServiceLinkVal = document.selectSingleNode("//OnboardingData/Links/ServiceLink").getText();
	ProductLinkVal = document.selectSingleNode("//OnboardingData/Links/ProductLink").getText();
	PartyLinkVal = document.selectSingleNode("//OnboardingData/Links/PartyLink").getText();
	AccountLinkVal = document.selectSingleNode("//OnboardingData/Links/AccountLink").getText();
	TransportLinkVal = document.selectSingleNode("//OnboardingData/Links/TransportLink").getText();
	PSALinkVal = document.selectSingleNode("//OnboardingData/Links/PSALink").getText();
	
	//Service Group Modules elements
	
	ServiceGroupCode= document.selectSingleNode("//OnboardingData/ServiceGroup/ServiceGroupCode").getText();
	ServiceGroupName=document.selectSingleNode("//OnboardingData/ServiceGroup/ServiceGroupName").getText();
    ServiceGroupDesc=document.selectSingleNode("//OnboardingData/ServiceGroup/ServiceGroupDesc").getText();
    Status=document.selectSingleNode("//OnboardingData/ServiceGroup/Status").getText();
    EffectiveFromDate=document.selectSingleNode("//OnboardingData/ServiceGroup/EffectiveFromDate").getText();
    EffectiveTillDate=document.selectSingleNode("//OnboardingData/ServiceGroup/EffectiveTillDate").getText();
    //Product Modules elements
    
    ProductCode= document.selectSingleNode("//OnboardingData/Product/ProductCode").getText();
    ProductName= document.selectSingleNode("//OnboardingData/Product/ProductName").getText();
    ProductDesc= document.selectSingleNode("//OnboardingData/Product/ProductDesc").getText();
    ProductCat= document.selectSingleNode("//OnboardingData/Product/ProductCat").getText();
    System.out.println("Print ProductCat=============="+ProductCat);
    //Servcie Modules elements
    
    ServiceCode= document.selectSingleNode("//OnboardingData/Service/ServiceCode").getText();
    ServiceName= document.selectSingleNode("//OnboardingData/Service/ServiceName").getText();
    ServiceDesc= document.selectSingleNode("//OnboardingData/Service/ServiceDesc").getText();
    ServiceGrpCode= document.selectSingleNode("//OnboardingData/Service/ServiceGroupCode").getText();
    OfferedByEntity= document.selectSingleNode("//OnboardingData/Service/OfferedByEntity").getText();
    MarketCurrency= document.selectSingleNode("//OnboardingData/Service/MarketCurrency").getText();
    InstructionCurrency= document.selectSingleNode("//OnboardingData/Service/InstructionCurrency").getText();
    ServiceIdConfigCode= document.selectSingleNode("//OnboardingData/Service/ServiceIdConfigCode").getText();
    ServiceIdPatternCode= document.selectSingleNode("//OnboardingData/Service/ServiceIdPatternCode").getText();
    PDCParameters= document.selectSingleNode("//OnboardingData/Service/PDCParameters").getText();
	//Account Modules elements
	
	Acc_AccountNumber= document.selectSingleNode("//OnboardingData/Account/AccountNumber").getText();
	Acc_IBAN= document.selectSingleNode("//OnboardingData/Account/IBAN").getText();
	Acc_AccountName= document.selectSingleNode("//OnboardingData/Account/AccountName").getText();
	Acc_PartyCode= document.selectSingleNode("//OnboardingData/Account/PartyCode").getText();
	Acc_AccounType= document.selectSingleNode("//OnboardingData/Account/AccounType").getText();
	Acc_PrefferedAccountNumber= document.selectSingleNode("//OnboardingData/Account/PrefferedAccountNumber").getText();
	Acc_AccountCurrencyLsit= document.selectSingleNode("//OnboardingData/Account/AccountCurrencyLsit").getText();
	Acc_DefaultCurrency= document.selectSingleNode("//OnboardingData/Account/DefaultCurrency").getText();
	Acc_AccountingSystem= document.selectSingleNode("//OnboardingData/Account/AccountingSystem").getText();
	Acc_BranchCode= document.selectSingleNode("//OnboardingData/Account/BranchCode").getText();
	Acc_ProcessingRestrications= document.selectSingleNode("//OnboardingData/Account/ProcessingRestrications").getText();
	Acc_LegalEntityIdentifier= document.selectSingleNode("//OnboardingData/Account/LegalEntityIdentifier").getText();
	Acc_AccountDebitAuthorization= document.selectSingleNode("//OnboardingData/Account/AccountDebitAuthorization").getText();
	Acc_AddressLine1= document.selectSingleNode("//OnboardingData/Account/AddressLine1").getText();
	Acc_AddressLine2= document.selectSingleNode("//OnboardingData/Account/AddressLine2").getText();
	Acc_City= document.selectSingleNode("//OnboardingData/Account/City").getText();
	Acc_State= document.selectSingleNode("//OnboardingData/Account/State").getText();
	Acc_PostCode= document.selectSingleNode("//OnboardingData/Account/PostCode").getText();
	Acc_Country= document.selectSingleNode("//OnboardingData/Account/Country").getText();
	Acc_EmailID= document.selectSingleNode("//OnboardingData/Account/EmailID").getText();
	Acc_PhoneNo= document.selectSingleNode("//OnboardingData/Account/PhoneNo").getText();

	//Party Modules elements
	Party_PartyCode= document.selectSingleNode("//OnboardingData/Party/PartyCode").getText();
	Party_PartyName= document.selectSingleNode("//OnboardingData/Party/PartyName").getText();
	Party_PartyDisplayname= document.selectSingleNode("//OnboardingData/Party/PartyDisplayname").getText();
	Party_ParentPartyCode= document.selectSingleNode("//OnboardingData/Party/ParentPartyCode").getText();
	Party_PartyType= document.selectSingleNode("//OnboardingData/Party/PartyType").getText();
	Party_PartySubType= document.selectSingleNode("//OnboardingData/Party/PartySubType").getText();
	Party_SupportsUC= document.selectSingleNode("//OnboardingData/Party/SupportsUC").getText();
	Party_UCDataAvailable= document.selectSingleNode("//OnboardingData/Party/UCDataAvailable").getText();
	Party_PartyExternalIdentifier= document.selectSingleNode("//OnboardingData/Party/PartyExternalIdentifier").getText();
	Party_ChargesAccountNumber= document.selectSingleNode("//OnboardingData/Party/ChargesAccountNumber").getText();
	Party_ChargesAccountCurrency= document.selectSingleNode("//OnboardingData/Party/ChargesAccountCurrency").getText();
	Party_ProcessRestrication= document.selectSingleNode("//OnboardingData/Party/ProcessRestrication").getText();
	Party_CalendarCode= document.selectSingleNode("//OnboardingData/Party/CalendarCode").getText();
	Party_CutOffProfileCode= document.selectSingleNode("//OnboardingData/Party/CutOffProfileCode").getText();
	Party_AddressLine1= document.selectSingleNode("//OnboardingData/Party/AddressLine1").getText();
	Party_AddressLine2= document.selectSingleNode("//OnboardingData/Party/AddressLine2").getText();
	Party_City= document.selectSingleNode("//OnboardingData/Party/City").getText();
	Party_State= document.selectSingleNode("//OnboardingData/Party/State").getText();
	Party_PostCode= document.selectSingleNode("//OnboardingData/Party/PostCode").getText();
	Party_Country= document.selectSingleNode("//OnboardingData/Party/Country").getText();
	Party_EmailID= document.selectSingleNode("//OnboardingData/Party/EmailID").getText();
	Party_PhoneNo= document.selectSingleNode("//OnboardingData/Party/PhoneNo").getText();
	Party_LegalEntityIdentifier= document.selectSingleNode("//OnboardingData/Party/LegalEntityIdentifier").getText();

}
}
