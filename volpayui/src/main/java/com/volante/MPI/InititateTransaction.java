package com.volante.MPI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.io.File;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.volante.param.utilities.ObjectMap;
import com.volante.utilities.LoadFile;

public class InititateTransaction {

	  public static ObjectMap objmap;
      public LoadFile load;
      public Workbook MPITemplate;
      Sheet MPISheet;
      public static WebDriver driver;

@BeforeTest
public void Preload() throws IOException, InterruptedException
    {
                String workingDir=System.getProperty("user.dir");
                load = new LoadFile(workingDir + "/src/main/resources/class/VolPayUI.properties");
                load = new LoadFile (workingDir+"/src/test/resources/Login.properties");
                objmap = new ObjectMap (workingDir+"/src/test/resources/MPITemplateObject.properties");    
}
@Parameters({"browser"})
@BeforeClass
public static void Setup(@Optional String browser) throws Exception {
		{
			if (browser.equalsIgnoreCase("Firefox")) {
				System.out.println("Running Firefox");
				System.setProperty("webdriver.gecko.driver",LoadFile.prop.getProperty("FireFox"));
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.out.println("Running Chrome");
				System.setProperty("webdriver.chrome.driver",LoadFile.prop.getProperty("Chrome"));
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("InternetExplorer")) {
				System.out.println("Running Internet Explorer");
				System.setProperty("webdriver.ie.driver",LoadFile.prop.getProperty("InternetExplorer"));
				DesiredCapabilities capabilities = DesiredCapabilities
						.internetExplorer();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,
						true);
				driver = new InternetExplorerDriver(capabilities);
			}}
		driver.get(LoadFile.prop.getProperty("URL"));
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		WebElement username=driver.findElement(objmap.getLocator("user"));
		username.sendKeys(LoadFile.prop.getProperty("VolPay_Username"));
		WebElement Password=driver.findElement(objmap.getLocator("pwd"));
		Password.sendKeys(LoadFile.prop.getProperty("VolPay_Password"));
		driver.findElement(objmap.getLocator("loginbutton")).click();
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
@Test
public void  ExecuteMPI() throws Exception
{
	             String workingDir=System.getProperty("user.dir");
	             MPITemplate= Workbook.getWorkbook(new File(workingDir+"/testdata/ParamInputs/MPI_InitiateTransaction.xls"));        
	             MPISheet=MPITemplate.getSheet("MPITemplate");
	             int rows_count=MPISheet.getRows();
	             for (int row=1; row<=rows_count; row++)
	         	   { 
	            	 // Payment Details details
	         	         Cell PD_Party=MPISheet.getCell(1,row);
	         	         Cell PD_Service=MPISheet.getCell(2,row);
	         	         Cell PD_MsgType=MPISheet.getCell(3,row);
	         	         Cell PD_PSACode=MPISheet.getCell(4,row);
	         	         Cell PD_Branch=MPISheet.getCell(5,row);
	         	         Cell PD_Product=MPISheet.getCell(6,row);
	         	         Cell PD_ValueDate=MPISheet.getCell(7,row);
	         	         Cell PD_DCPC=MPISheet.getCell(8,row);
	         	         Cell PD_PaymentCCY=MPISheet.getCell(9,row);
	         	         Cell PD_Amount=MPISheet.getCell(10,row);
	         	         Cell PD_EndToEnd=MPISheet.getCell(11,row);
	         	         Cell PD_ChargeCode=MPISheet.getCell(12,row);
	         	      // Ordering Customer details
	         	         Cell OC_ClientID=MPISheet.getCell(13,row);
	         	         Cell OC_Name=MPISheet.getCell(14,row);
	         	         Cell OC_AddressLine1=MPISheet.getCell(15,row);
	         	         Cell OC_AddressLine2=MPISheet.getCell(16,row);
	         	         Cell OC_City=MPISheet.getCell(17,row);
	         	         Cell OC_State=MPISheet.getCell(18,row);
	         	         Cell OC_PostCode=MPISheet.getCell(19,row);
	         	         Cell OC_Country=MPISheet.getCell(20,row);
	         	         Cell OC_AccountNumber=MPISheet.getCell(21,row);
	         	         Cell OC_AccountCurrency=MPISheet.getCell(22,row);
	         	         Cell OC_AccountName=MPISheet.getCell(23,row);
	         	         Cell OC_AccountCountry=MPISheet.getCell(24,row);
	         	     //Beneficary Bank Details
	         	         Cell BDD_BBType=MPISheet.getCell(25,row);
	         	         Cell BDD_BIC=MPISheet.getCell(26,row);
	         	         Cell BDD_AddressLine1=MPISheet.getCell(27,row);
	         	         Cell BDD_AddressLine2=MPISheet.getCell(28,row);
	         	         Cell BDD_City=MPISheet.getCell(29,row);
	         	         Cell BDD_State=MPISheet.getCell(30,row);
	         	         Cell BDD_PostCode=MPISheet.getCell(31,row);
	         	         Cell BDD_Country=MPISheet.getCell(32,row);
	         	     // Beneficary Details
	         	          Cell BD_AccounNo=MPISheet.getCell(33,row);
	         	          Cell BD_Name=MPISheet.getCell(34,row);
	         	          Cell BD_BAL1=MPISheet.getCell(35,row);
	         	          Cell BD_BAL2=MPISheet.getCell(36,row);
	         	          Cell BD_City=MPISheet.getCell(37,row);
	         	          Cell BD_State=MPISheet.getCell(38,row);
	         	          Cell BD_PostCode=MPISheet.getCell(39,row);
	         	          Cell BD_Country=MPISheet.getCell(40,row);
	         	    // Remittance Information          
		         	         Cell RemittanceID=MPISheet.getCell(41,row);
		         	         Cell RemittanceInfo=MPISheet.getCell(42,row);	         	         
	         	     // Intermediary Bank Details
	         	         Cell ID_BBType=MPISheet.getCell(43,row);
	         	         Cell ID_BIC=MPISheet.getCell(43,row);
	         	         Cell ID_AddressLine1=MPISheet.getCell(44,row);
	         	         Cell ID_AddressLine2=MPISheet.getCell(45,row);
	         	         Cell ID_City=MPISheet.getCell(46,row);
	         	         Cell ID_State=MPISheet.getCell(47,row);
	         	         Cell ID_PostCode=MPISheet.getCell(48,row);
	         	         Cell ID_Country=MPISheet.getCell(49,row);
	         	         
	         	         // Template Details
	         	         Cell TD_TName=MPISheet.getCell(50,row);
                         Cell Roles_Accessible=MPISheet.getCell(51,row);
                         Cell Status=MPISheet.getCell(52,row);
                         Cell TD_FromDate=MPISheet.getCell(53,row);
	         	    Cell TD_TillDate=MPISheet.getCell(54,row);
	         	    Cell TD_Description=MPISheet.getCell(55,row);

                         
                         
	         	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	         	   Thread.sleep(2000);
	         	    driver.findElement(objmap.getLocator("BankData")).click();
	         	    Thread.sleep(3000);
	         	 //TEmplate Name
	         	    driver.findElement(objmap.getLocator("MPITemplate")).click();
	         	    driver.findElement(objmap.getLocator("GridView")).click();
	         	    driver.findElement(objmap.getLocator("AddNew")).click();
	         	    
	         	  // Payment Details
	         	       WebElement PaymentDetails_Party=driver.findElement(objmap.getLocator("PD_Party"));
	         	       PaymentDetails_Party.click();
	         	       PaymentDetails_Party.sendKeys(PD_Party.getContents());
	         	       PaymentDetails_Party.sendKeys(Keys.ENTER);
	         	       WebElement PaymentDetails_Service=driver.findElement(objmap.getLocator("PD_Service"));
	         	       PaymentDetails_Service.click();   
	         	       PaymentDetails_Service.sendKeys(PD_Service.getContents());
	         	       PaymentDetails_Service.sendKeys(Keys.ENTER);
	         	      Select PaymentDetails_MsgType = new Select(driver.findElement(objmap.getLocator("PD_MsgType")));
	         	      PaymentDetails_MsgType.selectByVisibleText(PD_MsgType.getContents());
	         	       Select PaymentDetails_PSACode = new Select(driver.findElement(objmap.getLocator("PD_PSACode")));
	         	      PaymentDetails_PSACode.selectByVisibleText(PD_PSACode.getContents());
	         	      Thread.sleep(2000);
	         	     Select PaymentDetails_Branch = new Select(driver.findElement(objmap.getLocator("PD_Branch")));
	         	      PaymentDetails_Branch.selectByVisibleText(PD_Branch.getContents());
	         	     Select PaymentDetails_Product = new Select(driver.findElement(objmap.getLocator("PD_Product")));
	         	      PaymentDetails_Product.selectByVisibleText(PD_Product.getContents());
		         	     WebElement PaymentDetails_ValueDate=driver.findElement(objmap.getLocator("PD_ValueDate"));
	         	     PaymentDetails_ValueDate.sendKeys(PD_ValueDate.getContents());
	         	    Select PaymentDetails_PaymentCCY = new Select(driver.findElement(objmap.getLocator("PD_PaymentCCY")));
	         	   PaymentDetails_PaymentCCY.selectByVisibleText(PD_PaymentCCY.getContents());
	         	  WebElement PaymentDetails_Amoun=driver.findElement(objmap.getLocator("PD_Amoun"));
	         	     PaymentDetails_Amoun.sendKeys(PD_Amount.getContents());
	         	    WebElement PaymentDetails_EndToEnd=driver.findElement(objmap.getLocator("PD_EndToEnd"));
	         	     PaymentDetails_EndToEnd.sendKeys(PD_EndToEnd.getContents());
	         	   	         	    Select PaymentDetails_ChargeCode = new Select(driver.findElement(objmap.getLocator("PD_ChargeCode")));
		         	   PaymentDetails_ChargeCode.selectByVisibleText(PD_ChargeCode.getContents());
		         	  WebElement OrderingCustomer_AddressLine1=driver.findElement(objmap.getLocator("OC_AddressLine1"));
		         	 OrderingCustomer_AddressLine1.sendKeys(OC_AddressLine1.getContents());
		         	    WebElement OrderingCustomer_AddressLine2=driver.findElement(objmap.getLocator("OC_AddressLine2"));
		         	   OrderingCustomer_AddressLine2.sendKeys(OC_AddressLine2.getContents());
		         	    WebElement OrderingCustomer_City=driver.findElement(objmap.getLocator("OC_City"));
		         	   OrderingCustomer_City.sendKeys(OC_City.getContents());
		         	    WebElement OrderingCustomer_State=driver.findElement(objmap.getLocator("OC_State"));
		         	   OrderingCustomer_State.sendKeys(OC_State.getContents());
		         	    WebElement OrderingCustomer_PostCode=driver.findElement(objmap.getLocator("OC_PostCode"));
		         	   OrderingCustomer_PostCode.sendKeys(OC_PostCode.getContents());
		         	    WebElement OrderingCustomer_Country=driver.findElement(objmap.getLocator("OC_Country"));
		         	   OrderingCustomer_Country.sendKeys(OC_Country.getContents());
		         	    Select OrderingCustomer_AccountNumber = new Select(driver.findElement(objmap.getLocator("OC_AccountNumber")));
		         	   OrderingCustomer_AccountNumber.selectByVisibleText(OC_AccountNumber.getContents());
		         	  Select BeneficiaryBankDetails_BankIdentifierType = new Select(driver.findElement(objmap.getLocator("BDD_BBType")));
		         	 BeneficiaryBankDetails_BankIdentifierType.selectByVisibleText(BDD_BBType.getContents()); 
		         	  Select BeneficiaryBankDetails_BankIdentifierCode = new Select(driver.findElement(objmap.getLocator("BDD_BIC")));
		         	 BeneficiaryBankDetails_BankIdentifierCode.selectByVisibleText(BDD_BIC.getContents());
		         	WebElement BeneficiaryBankDetails_AddressLine1=driver.findElement(objmap.getLocator("BDD_AddressLine1"));
		         	BeneficiaryBankDetails_AddressLine1.sendKeys(BDD_AddressLine1.getContents());
		         	  WebElement BeneficiaryBankDetails_AddressLine2=driver.findElement(objmap.getLocator("BDD_AddressLine2"));
		         	 BeneficiaryBankDetails_AddressLine2.sendKeys(BDD_AddressLine2.getContents());
		         	  WebElement BeneficiaryBankDetails_City=driver.findElement(objmap.getLocator("BDD_City"));
		         	 BeneficiaryBankDetails_City.sendKeys(BDD_City.getContents());
		         	  WebElement BeneficiaryBankDetails_State=driver.findElement(objmap.getLocator("BDD_State"));
		         	 BeneficiaryBankDetails_State.sendKeys(BDD_State.getContents());
		         	WebElement BeneficiaryBankDetails_PostCode=driver.findElement(objmap.getLocator("BDD_PostCode"));
		         	BeneficiaryBankDetails_PostCode.sendKeys(BDD_PostCode.getContents());
		         	WebElement BeneficiaryBankDetails_Country=driver.findElement(objmap.getLocator("BDD_Country"));
		         	BeneficiaryBankDetails_Country.sendKeys(BDD_Country.getContents());
		         	
		         	WebElement BeneficiaryDetails_AccounNo=driver.findElement(objmap.getLocator("BD_AccounNo"));
		         	BeneficiaryDetails_AccounNo.sendKeys(BD_AccounNo.getContents());
		         	WebElement BeneficiaryDetails_Name=driver.findElement(objmap.getLocator("BD_Name"));
		         	BeneficiaryDetails_Name.sendKeys(BD_Name.getContents());
		         	WebElement BeneficiaryDetails_BAL1=driver.findElement(objmap.getLocator("BD_BAL1"));
		         	BeneficiaryDetails_BAL1.sendKeys(BD_BAL1.getContents());
		         	WebElement BeneficiaryDetails_BAL2=driver.findElement(objmap.getLocator("BD_BAL2"));
		         	BeneficiaryDetails_BAL2.sendKeys(BD_BAL2.getContents());
		         	WebElement BeneficiaryDetails_City=driver.findElement(objmap.getLocator("BD_City"));
		         	BeneficiaryDetails_City.sendKeys(BD_City.getContents());
		         	WebElement BeneficiaryDetails_State=driver.findElement(objmap.getLocator("BD_State"));
		         	BeneficiaryDetails_State.sendKeys(BD_State.getContents());
		         	WebElement BeneficiaryDetails_PostCode=driver.findElement(objmap.getLocator("BD_PostCode"));
		         	BeneficiaryDetails_PostCode.sendKeys(BD_PostCode.getContents());
		         	WebElement BeneficiaryDetails_Country=driver.findElement(objmap.getLocator("BD_Country"));
		         	BeneficiaryDetails_Country.sendKeys(BD_Country.getContents());
		         	WebElement RemittanceInformation_RemittanceID=driver.findElement(objmap.getLocator("RemittanceID"));
		         	RemittanceInformation_RemittanceID.sendKeys(RemittanceID.getContents());
		         	WebElement RemittanceInformation_RemittanceInfo=driver.findElement(objmap.getLocator("RemittanceInfo"));
		         	RemittanceInformation_RemittanceInfo.sendKeys(RemittanceInfo.getContents());
		         	Select IntermediaryBankDetails_BankIdentifierType = new Select(driver.findElement(objmap.getLocator("ID_BBType")));
		         	IntermediaryBankDetails_BankIdentifierType.selectByVisibleText(ID_BBType.getContents());
		         	Select IntermediaryBankDetails_BankIdentifierCode = new Select(driver.findElement(objmap.getLocator("ID_BIC")));
		         	IntermediaryBankDetails_BankIdentifierCode.selectByVisibleText(ID_BIC.getContents());
		         	WebElement IntermediaryDetails_AddressLine1=driver.findElement(objmap.getLocator("ID_AddressLine1"));
		         	IntermediaryDetails_AddressLine1.sendKeys(ID_AddressLine1.getContents());
		         	WebElement IntermediaryDetails_AddressLine2=driver.findElement(objmap.getLocator("ID_AddressLine2"));
		         	IntermediaryDetails_AddressLine2.sendKeys(ID_AddressLine2.getContents());
		         	WebElement IntermediaryDetails_City=driver.findElement(objmap.getLocator("ID_City"));
		         	IntermediaryDetails_City.sendKeys(ID_City.getContents());
		         	WebElement IntermediaryDetails_State=driver.findElement(objmap.getLocator("ID_State"));
		         	IntermediaryDetails_State.sendKeys(ID_State.getContents());
		         	WebElement IntermediaryDetails_PostCode=driver.findElement(objmap.getLocator("ID_PostCode"));
		         	IntermediaryDetails_PostCode.sendKeys(ID_PostCode.getContents());
		         	WebElement IntermediaryDetails_Country=driver.findElement(objmap.getLocator("ID_Country"));
		         	IntermediaryDetails_Country.sendKeys(ID_Country.getContents());
		         	
		         	
	         	   }
	         	}
	             
}
  
