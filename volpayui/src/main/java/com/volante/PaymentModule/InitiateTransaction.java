package com.volante.PaymentModule;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.volante.locators.LocatorByCSS;
import com.volante.locators.LocatorByLinks;
import com.volante.locators.LocatorByName;
import com.volante.locators.LocatorByXPATH;
import com.volante.locators.LocatorDropListSelect;
import com.volante.locators.LocatorGetDate;
import com.volante.locators.LocatorMultiSelect;
import com.volante.pages.HandleAlert;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class InitiateTransaction 
{
	   public static Workbook BRBook;
	   static Sheet BRSheet;
public static void ExecuteInitiateTransaction( WebDriver wd,String Sheetname,String destFile)  throws Exception 
	{
		    try
		    {
		    PaymentModuleObjectsList.PaymentModuleObject();
	    	Workbook wb = Workbook.getWorkbook(new File(destFile));
	        BRSheet=wb.getSheet(Sheetname);
	        int rows_count=BRSheet.getRows();
	        int newrowscount=rows_count-1;
	        System.out.println("No of Rows in MPITemplate Page="+newrowscount);
	        WebDriverWait wait = new WebDriverWait(wd, 30);
	       // WebElement InitiateTrans = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(PaymentModuleObjectsList.InitiateTransaction)));
	        WebElement BDView = wd.findElement(By.xpath("//*[@id='PaymentModule']/a/i[2]"));
            Boolean BDviewed = BDView.isDisplayed();
            Boolean BDViewVal = BDView.getAttribute("class").contains("-plus");
            if ((BDViewVal)&&(BDviewed)){
           	 BDView.click();
           	 System.out.println("Clicked");
           	 Thread.sleep(2000);
            }
            System.out.println(" done 1");
		    WebElement Region = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(PaymentModuleObjectsList.InitiateTransactionLinkVal)));
		    System.out.println(" done 2    "    +PaymentModuleObjectsList.InitiateTransactionLinkVal);
			Region.click();
			/*WebElement GridView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PaymentModuleObjectsList.GridView)));
			 String gridclass = GridView.getAttribute("class");
			 boolean gridV = gridclass.contains("disabledBtnColor");
				if (!gridV) 
				{
					GridView.click();
					System.out.println("grid view enabled");
				}*/
	        Thread.sleep(3000);
		    for (int row=1; row<=newrowscount; row++)
		       {    
			        Cell TestName=BRSheet.getCell(1,row);
			        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory(ReferenceDataDriver.Sheetname);
			        Cell PD_Party=BRSheet.getCell(2,row);
			        Cell PD_Service=BRSheet.getCell(3,row);
			        Cell PD_MsgType=BRSheet.getCell(4,row);
			        Cell PD_PSACode=BRSheet.getCell(5,row);
			        Cell PD_Branch=BRSheet.getCell(6,row);
			        Cell PD_Product=BRSheet.getCell(7,row);
			        Cell PD_ValueDate=BRSheet.getCell(8,row);
			        Cell PD_DebtorCustomerProprietaryCode=BRSheet.getCell(9,row);
			        Cell PD_PaymentCCY=BRSheet.getCell(10,row);
			        Cell PD_Amount=BRSheet.getCell(11,row);
			        Cell PD_EndToEnd=BRSheet.getCell(12,row);
			        Cell PD_ChargeCode=BRSheet.getCell(13,row);
			        Cell OC_ClientID=BRSheet.getCell(14,row);
			        Cell OC_Name=BRSheet.getCell(15,row);
			        Cell OC_AddressLine1=BRSheet.getCell(16,row);
			        Cell OC_AddressLine2=BRSheet.getCell(17,row);
			        Cell OC_City=BRSheet.getCell(18,row);
			        Cell OC_State=BRSheet.getCell(19,row);
			        Cell OC_PostCode=BRSheet.getCell(20,row);
			        Cell OC_Country=BRSheet.getCell(21,row);
			        Cell OC_AccountNumber=BRSheet.getCell(22,row);
			        Cell OC_AccountCurrency=BRSheet.getCell(23,row);
			        Cell OC_AccountName=BRSheet.getCell(24,row);
			        Cell OC_AccountDomiciledCountry=BRSheet.getCell(25,row);
			        Cell BDD_BBType=BRSheet.getCell(26,row);
			        Cell BDD_BIC=BRSheet.getCell(27,row);
			        Cell BDD_AddressLine1=BRSheet.getCell(28,row);
			        Cell BDD_AddressLine2=BRSheet.getCell(29,row);
			        Cell BDD_City=BRSheet.getCell(30,row);
			        Cell BDD_State=BRSheet.getCell(31,row);
			        Cell BDD_PostCode=BRSheet.getCell(32,row);
			        Cell BDD_Country=BRSheet.getCell(33,row);
			        Cell BD_AccounNo=BRSheet.getCell(34,row);
			        Cell BD_Name=BRSheet.getCell(35,row);
			        Cell BD_BAL1=BRSheet.getCell(36,row);
			        Cell BD_BAL2=BRSheet.getCell(37,row);
			        Cell BD_City=BRSheet.getCell(38,row);
			        Cell BD_State=BRSheet.getCell(39,row);
			        Cell BD_PostCode=BRSheet.getCell(40,row);
			        Cell BD_Country=BRSheet.getCell(41,row);
			        Cell RemittanceID=BRSheet.getCell(42,row);
			        Cell RemittanceInfo=BRSheet.getCell(43,row);
			        Cell ID_BBType=BRSheet.getCell(44,row);
			        Cell ID_BIC=BRSheet.getCell(45,row);
			        Cell ID_AddressLine1=BRSheet.getCell(46,row);
			        Cell ID_AddressLine2=BRSheet.getCell(47,row);
			        Cell ID_City=BRSheet.getCell(48,row);
			        Cell ID_State=BRSheet.getCell(49,row);
			        Cell ID_PostCode=BRSheet.getCell(50,row);
			        Cell ID_Country=BRSheet.getCell(51,row);
			        Cell TD_TName=BRSheet.getCell(52,row);
			        Cell Roles_Accessible=BRSheet.getCell(53,row);
			        Cell Status=BRSheet.getCell(54,row);
			       // Cell TD_FromDate=BRSheet.getCell(55,row);
			        Cell TD_TillDate=BRSheet.getCell(56,row);
			        Cell TD_Description=BRSheet.getCell(57,row);
			        //Cell SucessMsg=BRSheet.getCell(58,row);
	               
	                // Execution Part  
			        Thread.sleep(3000);
			        LocatorDropListSelect.DropListSelectText_Xpath(wd, PaymentModuleObjectsList.PartyCode, PD_Party.getContents(), "Party For MPI is "+PD_Party.getContents());  // Party & Service gets selected once party is selected
	                Thread.sleep(2000);
	                System.out.println("vnkjdskjgndskj="+PaymentModuleObjectsList.PartyCode);
			        LocatorByName.Select_Name(wd, PaymentModuleObjectsList.MessageType, PD_MsgType.getContents(), "Message Type is " +PD_MsgType.getContents()); // MsgType & PSA gets selected once MsgType is selected
	                LocatorByName.Select_Name(wd, PaymentModuleObjectsList.Branch, PD_Branch.getContents(), " Branch is "+PD_Branch.getContents());
	                LocatorByName.Select_Name(wd, PaymentModuleObjectsList.Products, PD_Product.getContents(), " ProductSupported is "+PD_Product.getContents());
	                //ValueDate will automatically set to today
	                //Disabled field
	                LocatorByName.Select_Name(wd, PaymentModuleObjectsList.PaymentCurrency, PD_PaymentCCY.getContents(), "Payment Currency is  "+PD_PaymentCCY.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.Amount, PD_Amount.getContents(), "Entered Amount is "  +PD_Amount.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.EndtoEnd, PD_EndToEnd.getContents(), "Enetered EndToEnd ID is" +PD_EndToEnd.getContents());
	                LocatorByName.Select_Name(wd, PaymentModuleObjectsList.ChargeCode, PD_ChargeCode.getContents(), "CharageCode is selected as  "+PD_ChargeCode.getContents() );
	                //ClientID & Name by default 
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.OCAddressLine1, OC_AddressLine1.getContents(), "Ordering Customer's Addressline1 ");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.OCAddressLine2, OC_AddressLine2.getContents(), "Ordering Customer's Addressline2 ");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.OCCity, OC_City.getContents(), "Ordering Customer's city " +OC_City.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.OCState, OC_State.getContents(), "Ordering Customer's State");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.OCPostCode, OC_PostCode.getContents(), "Ordering Customer's PostCode");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.OCCountry, OC_Country.getContents(), "Ordering Customer's Country");
	                LocatorByName.DropDown_Text_Name(wd, PaymentModuleObjectsList.OCAccountNumber, OC_AccountNumber.getContents(), "Ordering Customer's Account Number : "+OC_AccountNumber.getContents()); //Account currency & Name gets selected . 
	                LocatorByName.DropDown_Text_Name(wd, PaymentModuleObjectsList.OCAccountDomiciledCountry, OC_AccountDomiciledCountry.getContents(), "Ordering Customer's Account Domiciled Country is  " +OC_AccountDomiciledCountry);
	                LocatorByName.DropDown_Text_Name(wd, PaymentModuleObjectsList.BankIdentifierType, BDD_BBType.getContents(), "Benificiary Bank's BankIdentificationType selected as  " +BDD_BBType.getContents());
	               // Thread.sleep(2000);
	                LocatorByName.DropDown_Text_Name(wd, PaymentModuleObjectsList.BankIdentifierCode, BDD_BIC.getContents(), "Benificiary Bank's BIC : " +BDD_BIC.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BBAddressLine1, BDD_AddressLine1.getContents(), "Benificairy Bank's  Addressline1 ");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BBAddressLine2, BDD_AddressLine2.getContents(), "Benificairy Bank's Addressline2 ");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BBCity, BDD_City.getContents(), "Benificairy Bank's " +BDD_City.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BBState, BDD_State.getContents(), "Benificairy Bank's State " +BDD_State.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BBPostCode, BDD_PostCode.getContents(), "Benificairy Bank's PostCode " +BDD_PostCode.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BBCountry, BDD_Country.getContents(), "Benificairy Bank's Country  " +BDD_Country.getContents());	                
	                LocatorByName.Enter_Name(wd, PaymentModuleObjectsList.BDAccountNo, BD_AccounNo.getContents(), "Benficiary's Account Number : " +BD_AccounNo.getContents()); 
	                LocatorByName.Enter_Name(wd, PaymentModuleObjectsList.BDName, BD_Name.getContents(), "Benficiary's Name : " +BD_Name.getContents()); 	               
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BeneficiaryAddressLine1, BD_BAL1.getContents(), "Benificairy's  Addressline1 ");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BeneficiaryAddressLine2, BD_BAL2.getContents(), "Benificairy's Addressline2 ");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BenCity, BD_City.getContents(), "Benificairy Bank's " +BD_City.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BenState, BD_State.getContents(), "Benificairy Bank's State " +BD_State.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BenPostCode, BD_PostCode.getContents(), "Benificairy Bank's PostCode " +BD_PostCode.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.BenCountry, BD_Country.getContents(), "Benificairy Bank's Country  " +BD_Country.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.RemittanceID, RemittanceID.getContents(), "Remittance information . ID is  " +RemittanceID.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.RemittanceInformation, RemittanceInfo.getContents(), "Remittance information is  " +RemittanceInfo.getContents());
	                LocatorByName.DropDown_Text_Name(wd, PaymentModuleObjectsList.IntermediaryDetailsBankIdentifierType, ID_BBType.getContents(), "Intermediary Deatils BankIdentification selected as  " +ID_BBType.getContents());
	                LocatorByName.DropDown_Text_Name(wd, PaymentModuleObjectsList.IntermediaryDetailsBankIdentifierCode, ID_BIC.getContents(), "Intermediary Deatils BankIdentification selected as BIC : " +ID_BIC.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.InterBankAddressLine1, ID_AddressLine1.getContents(), "Intermediary Deatils  Addressline1 ");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.InterBankAddressLine2, ID_AddressLine2.getContents(), "Intermediary Deatils Addressline2 ");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.InterBankCity, ID_City.getContents(), "Intermediary Deatils Bank's " +ID_City.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.InterBankState, ID_State.getContents(), "Intermediary Deatils Bank's State " +ID_State.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.InterPostCode, ID_PostCode.getContents(), "Intermediary Deatils Bank's PostCode " +ID_PostCode.getContents());
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.InterBankCountry, ID_Country.getContents(), "Intermediary Deatils Bank's Country  " +ID_Country.getContents());	
	                LocatorByCSS.Click_CSS(wd, PaymentModuleObjectsList.SaveAsTemplateButton, "Clicking the SaveAsTemplate Button to create the Template");
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.TemplateName, TD_TName.getContents(), "Template Name  is  " +TD_TName.getContents());	
	                LocatorMultiSelect.MultiSelect_XPath(wd, PaymentModuleObjectsList.RolesAccessible, Roles_Accessible.getContents(), "Role Accessible for   " +Roles_Accessible.getContents());
	                LocatorByCSS.DropDown_Text_CSS(wd, PaymentModuleObjectsList.Status, Status.getContents(), "Select the status as "+Status.getContents());
	                LocatorGetDate.SelectDate(wd, PaymentModuleObjectsList.EffectiveFromDate, "Selected the Effective From Date as today");
	                LocatorByName.Enter_Name(wd, PaymentModuleObjectsList.EffectiveTillDate, TD_TillDate.getContents(), "Entered the Till Date as "+TD_TillDate.getContents());	
	                LocatorByCSS.Enter_CSS(wd, PaymentModuleObjectsList.Description, TD_Description.getContents(), "Template Description is  " +TD_Description.getContents());	
	                LocatorByCSS.Click_CSS(wd, PaymentModuleObjectsList.SaveAsTemplateButton, "Clicking the SaveAsTemplate Button to create the Template and Initiating the payment");
	                HandleAlert.ButtonsAlert(wd, PaymentModuleObjectsList.SuccessMsg, "Instruction Created Successfully and MPITemplate successfully added.", "Success Message Matched Successfully");
	                Thread.sleep(1000);
	                LocatorByLinks.Click_Link(wd, PaymentModuleObjectsList.InitiateTransactionLinkVal, "Click the Initiatetransaction link");
	            	//LocatorByLinks.Click_Link(wd, PaymentModuleObjectsList.BankDataModule, "Click the BankData link");
	            	//LocatorByLinks.Click_Link(wd, PaymentModuleObjectsList.MPITemplateLink, "Click the MPITemplate link");
	                //ChangesLostPopUP.ChangesLost(wd,"InitiateTransaction ");
	                Thread.sleep(3000);
	                LocatorByXPATH.Click_XPath(wd, PaymentModuleObjectsList.RefreshButton, "Click the Refresh Button");
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
