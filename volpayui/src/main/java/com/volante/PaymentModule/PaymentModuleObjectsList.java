package com.volante.PaymentModule;

import java.io.File;
import java.rmi.UnexpectedException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;


public class PaymentModuleObjectsList 
{
	public static String SubmitButton,InitiateTransaction, GridViewAddButton, GridView, EffectiveTillDateVal, SuccessMsg,
	ChangeModule,AddnewText,RefreshButton;
	public static String InitiateTransactionLinkVal;
	public static String PartyCode, Service, MessageType, PSACode, Branch, Products,
	ValueDate, DebtorCustomerProprietaryCode, PaymentCurrency, Amount, EndtoEnd,
	ChargeCode, OCClientID, OCName, OCAddressLine1, OCAddressLine2, OCCity, OCState,
	OCPostCode, OCCountry, OCAccountNumber, OCAccountCurrency, OCAccountName,
	OCAccountDomiciledCountry, BankIdentifierType, BankIdentifierCode, BBAddressLine1,
	BBAddressLine2, BBCity, BBState, BBPostCode, BBCountry, BDAccountNo, BDName,
	BeneficiaryAddressLine1, BeneficiaryAddressLine2, BenCity, BenState, BenPostCode,
	BenCountry, RemittanceID, RemittanceInformation, IntermediaryDetailsBankIdentifierType,
	IntermediaryDetailsBankIdentifierCode, InterBankAddressLine1, InterBankAddressLine2, IntermediaryBankDetailsButton,
	InterBankCity, InterBankState, InterPostCode, InterBankCountry, SaveAsTemplateButton, TemplateName,
	RolesAccessible, Status, EffectiveFromDate, EffectiveTillDate, Description,MPITemplateLink,BankDataModule;
	
public static void PaymentModuleObject() throws DocumentException, UnexpectedException {
		
	try
	{
		String workingDir = System.getProperty("user.dir");
		File inputFile = new File(workingDir + "/src/main/resources/objectRespository/PaymentModule.xml");
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read(inputFile);
		//InitiateTransaction = document.selectSingleNode("//PaymentModule/Links/InitiateTransactionLink").getText();
		// View buttons
				GridView = document.selectSingleNode("//PaymentModule/GridView/View").getText();
				GridViewAddButton = document.selectSingleNode("//PaymentModule/GridView/AddNewButton").getText();
		//MPILInks
				InitiateTransactionLinkVal = document.selectSingleNode("//PaymentModule/Links/InitiateTransactionLink").getText();
		// MPI Template
		PartyCode = document.selectSingleNode("//PaymentModule/InitiateTransaction/PartyCode").getText();
		System.out.println("no of error=1");
		Service = document.selectSingleNode("//PaymentModule/InitiateTransaction/Service").getText();
		System.out.println("no of error=2");
		MessageType = document.selectSingleNode("//PaymentModule/InitiateTransaction/MessageType").getText();
		System.out.println("no of error=3");
		PSACode = document.selectSingleNode("//PaymentModule/InitiateTransaction/PSACode").getText();
		System.out.println("no of error=4");
		Branch = document.selectSingleNode("//PaymentModule/InitiateTransaction/Branch").getText();
		System.out.println("no of error=5");
		Products = document.selectSingleNode("//PaymentModule/InitiateTransaction/ProductsSupported").getText();
		System.out.println("no of error=6");
		ValueDate = document.selectSingleNode("//PaymentModule/InitiateTransaction/ValueDate").getText();
		System.out.println("no of error=7");
		DebtorCustomerProprietaryCode = document.selectSingleNode("//PaymentModule/InitiateTransaction/DebtorCustomerProprietaryCode").getText();
		System.out.println("no of error=8");
		PaymentCurrency = document.selectSingleNode("//PaymentModule/InitiateTransaction/PaymentCurrency").getText();
		System.out.println("no of error=9");
		Amount = document.selectSingleNode("//PaymentModule/InitiateTransaction/Amount").getText();
		System.out.println("no of error=10");
		EndtoEnd = document.selectSingleNode("//PaymentModule/InitiateTransaction/EndToEndID").getText();
		System.out.println("no of error=11");
		ChargeCode = document.selectSingleNode("//PaymentModule/InitiateTransaction/ChargeCode").getText();
		System.out.println("no of error=12");
		OCClientID = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCClientID").getText();
		System.out.println("no of error=13");
		OCName = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCName").getText();
		System.out.println("no of error=14");
		OCAddressLine1 = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCAddressLine1").getText();
		System.out.println("no of error=15");
		OCAddressLine2 = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCAddressLine2").getText();
		System.out.println("no of error=16");
		OCCity = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCCity").getText();
		System.out.println("no of error=17");
		OCState = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCState").getText();
		System.out.println("no of error=18");
		OCPostCode = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCPostCode").getText();
		System.out.println("no of error=19");
		OCCountry = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCCountry").getText();
		System.out.println("no of error=20");
		OCAccountNumber = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCAccountNumber").getText();
		System.out.println("no of error=21");
		OCAccountCurrency = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCAccountCurrency").getText();
		System.out.println("no of error=22");
		OCAccountName = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCAccountName").getText();
		System.out.println("no of error=23");
		OCAccountDomiciledCountry = document.selectSingleNode("//PaymentModule/InitiateTransaction/OCAccountDomiciledCountry").getText();
		System.out.println("no of error=24");
		BankIdentifierType = document.selectSingleNode("//PaymentModule/InitiateTransaction/BankIdentifierType").getText();
		System.out.println("no of error=25");
		BankIdentifierCode = document.selectSingleNode("//PaymentModule/InitiateTransaction/BankIdentifierCode").getText();
		System.out.println("no of error=26");
		BBAddressLine1 = document.selectSingleNode("//PaymentModule/InitiateTransaction/BBAddressLine1").getText();
		System.out.println("no of error=27");
		BBAddressLine2 = document.selectSingleNode("//PaymentModule/InitiateTransaction/BBAddressLine2").getText();
		System.out.println("no of error=28");
		BBCity = document.selectSingleNode("//PaymentModule/InitiateTransaction/BBCity").getText();
		System.out.println("no of error=29");
		BBState = document.selectSingleNode("//PaymentModule/InitiateTransaction/BBState").getText();
		System.out.println("no of error=30a");
		BBPostCode = document.selectSingleNode("//PaymentModule/InitiateTransaction/BBPostCode").getText();
		System.out.println("no of error=30");
		BBCountry = document.selectSingleNode("//PaymentModule/InitiateTransaction/BBCountry").getText();
		System.out.println("no of error=31");
		BDAccountNo = document.selectSingleNode("//PaymentModule/InitiateTransaction/BDAccountNo").getText();
		System.out.println("no of error=32");
		BDName = document.selectSingleNode("//PaymentModule/InitiateTransaction/BDName").getText();
		System.out.println("no of error=33");
		BeneficiaryAddressLine1 = document.selectSingleNode("//PaymentModule/InitiateTransaction/BeneficiaryAddressLine1").getText();
		System.out.println("no of error=34");
		BeneficiaryAddressLine2 = document.selectSingleNode("//PaymentModule/InitiateTransaction/BeneficiaryAddressLine2").getText();
		System.out.println("no of error=35");
		BenCity = document.selectSingleNode("//PaymentModule/InitiateTransaction/BDCity").getText();
		System.out.println("no of error=36");
		BenState = document.selectSingleNode("//PaymentModule/InitiateTransaction/BDState").getText();
		System.out.println("no of error=37");
		BenPostCode = document.selectSingleNode("//PaymentModule/InitiateTransaction/BDPostCode").getText();
		System.out.println("no of error=38");
		BenCountry = document.selectSingleNode("//PaymentModule/InitiateTransaction/BDCountry").getText();
		System.out.println("no of error=39");
		RemittanceID = document.selectSingleNode("//PaymentModule/InitiateTransaction/RemittanceID").getText();
		System.out.println("no of error=40");
		RemittanceInformation = document.selectSingleNode("//PaymentModule/InitiateTransaction/RemittanceInformation").getText();
		System.out.println("no of error=41");
		IntermediaryDetailsBankIdentifierType = document.selectSingleNode("//PaymentModule/InitiateTransaction/IntermediaryDetailsBankIdentifierType").getText();
		System.out.println("no of error=42");
		IntermediaryDetailsBankIdentifierCode = document.selectSingleNode("//PaymentModule/InitiateTransaction/IntermediaryDetailsBankIdentifierCode").getText();
		System.out.println("no of error=43");
		InterBankAddressLine1 = document.selectSingleNode("//PaymentModule/InitiateTransaction/InterBankAddressLine1").getText();
		System.out.println("no of error=44");
		InterBankAddressLine2 = document.selectSingleNode("//PaymentModule/InitiateTransaction/InterBankAddressLine2").getText();
		System.out.println("no of error=45");
		InterBankCity = document.selectSingleNode("//PaymentModule/InitiateTransaction/InterBankCity").getText();
		System.out.println("no of error=46");
		InterBankState = document.selectSingleNode("//PaymentModule/InitiateTransaction/InterBankState").getText();
		System.out.println("no of error=47");
		InterPostCode = document.selectSingleNode("//PaymentModule/InitiateTransaction/InterPostCode").getText();
		System.out.println("no of error=48");
		InterBankCountry = document.selectSingleNode("//PaymentModule/InitiateTransaction/InterBankCountry").getText();
		System.out.println("no of error=49");
		SaveAsTemplateButton = document.selectSingleNode("//PaymentModule/InitiateTransaction/SaveAsTemplateButton").getText();
		System.out.println("no of error=49a");
		TemplateName = document.selectSingleNode("//PaymentModule/InitiateTransaction/TemplateName").getText();
		System.out.println("no of error=50");
		RolesAccessible = document.selectSingleNode("//PaymentModule/InitiateTransaction/RolesAccessible").getText();
		System.out.println("no of error=51");
		Status = document.selectSingleNode("//PaymentModule/InitiateTransaction/Status").getText();
		System.out.println("no of error=52");
		EffectiveFromDate = document.selectSingleNode("//PaymentModule/InitiateTransaction/EffectiveFromDate").getText();
		System.out.println("no of error=53");
		EffectiveTillDate = document.selectSingleNode("//PaymentModule/InitiateTransaction/EffectiveTillDate").getText();
		System.out.println("no of error=54");
		Description = document.selectSingleNode("//PaymentModule/InitiateTransaction/Description").getText();
		System.out.println("no of error=55");
		SubmitButton = document.selectSingleNode("//PaymentModule/InitiateTransaction/SubmitButton").getText();
		System.out.println("no of error=56");
		SuccessMsg = document.selectSingleNode("//PaymentModule/InitiateTransaction/SuccessMsg").getText();
		System.out.println("no of error=57");
		BankDataModule = document.selectSingleNode("//PaymentModule/InitiateTransaction/BankDataModule").getText();
		System.out.println("no of error=59");
		MPITemplateLink = document.selectSingleNode("//PaymentModule/InitiateTransaction/MPITemplateLink").getText();
		System.out.println("no of error=58");
		RefreshButton = document.selectSingleNode("//PaymentModule/InitiateTransaction/RefreshButton").getText();
		System.out.println("no of error=60");
		
	}
	catch (Exception e)
	{
		     System.out.println("Unable to read xml file"+e.getMessage());
	}
}
}
