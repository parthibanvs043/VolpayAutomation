package com.volante.pagevalidation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.volante.excel.OutputtoFile;
import com.volante.param.utilities.*;
import com.volante.utilities.LoadFile;

public class ReadAllPages 
{

	 public static ObjectMap objmap;
     public LoadFile load;
     public static WebDriver driver;

@BeforeTest
public void Preload() throws IOException, InterruptedException
   {
               String workingDir=System.getProperty("user.dir");
               load = new LoadFile(workingDir + "/src/main/resources/class/VolPayUI.properties");
               load = new LoadFile (workingDir+"/src/main/resources/propertiesfile/Login.properties");  
               objmap = new ObjectMap (workingDir+"/src/main/resources/propertiesfile/LoginObject.properties"); 
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
			} else if (browser.equalsIgnoreCase("Chrome")) {
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
				//driver = new InternetExplorerDriver(capabilities);
			}}
		driver.get(LoadFile.prop.getProperty("URL"));
		Thread.sleep(3000);
		//driver.manage().window().maximize();
		Thread.sleep(4000);
		WebElement username=driver.findElement(objmap.getLocator("user"));
		username.sendKeys(LoadFile.prop.getProperty("VolPay_Username"));
		WebElement Password=driver.findElement(objmap.getLocator("pwd"));
		Password.sendKeys(LoadFile.prop.getProperty("VolPay_Password"));
		driver.findElement(objmap.getLocator("loginbutton")).click();
		driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
@Parameters({"strPath"})
@Test
public void HomeModule(@Optional String strPath) throws IOException, InterruptedException
{
	       
	       OutputtoFile out = new OutputtoFile();
	       WebDriverWait wait = new WebDriverWait(driver, 30);
	       WebElement Home = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='Home']/a")));
	       Home.click();
	       //My Profile Page
		   driver.findElement(By.xpath("//a[@title='My Profile']/span")).click();
		   Thread.sleep(2000);
		   WebElement MyProfile = driver.findElement(By.tagName("body"));
	       String MyProfiletext = MyProfile.getText();
	       out.writeoutputtofile(strPath+"Home_Myprofile.txt",MyProfiletext);
		   // Alert & Notifications Page
		   driver.findElement(By.xpath("//a[@title='Alerts & Notifications']/span")).click();
		   Thread.sleep(2000);
		   WebElement Alerts = driver.findElement(By.tagName("body"));
	       String Alertstext = Alerts.getText();
	       out.writeoutputtofile(strPath+"Home_Alerts.txt",Alertstext);
	    
}
@Parameters({"strPath"})
@Test(dependsOnMethods={"HomeModule"})
public void AdminModule(@Optional String strPath) throws IOException, InterruptedException
{
	       OutputtoFile out = new OutputtoFile();
		   driver.findElement(By.xpath("//a[@title='Admin Panel']/span")).click();
	       //My User Management Page
		   driver.findElement(By.xpath("//a[@title='User Management']/span")).click();
		   Thread.sleep(2000);
		   WebElement UserMgmt = driver.findElement(By.tagName("body"));
	       String UserMgmttext = UserMgmt.getText();
	       out.writeoutputtofile(strPath+"AdminPanel_UserManagement.txt",UserMgmttext);
		   // User Management-Add user page
		   driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
		   Thread.sleep(2000);
		   WebElement UserMgmtAdduser = driver.findElement(By.tagName("body"));
	       String UserMgmtAddusertext = UserMgmtAdduser.getText();
	       out.writeoutputtofile(strPath+"AdminPanel_UserManagement_AdduserPage.txt",UserMgmtAddusertext);
	       // Roles & Permissions Page
	       
	       driver.findElement(By.xpath("//a[@title='Roles & Permissions']/span")).click();
		   Thread.sleep(2000);
		   WebElement Roles = driver.findElement(By.tagName("body"));
	       String Rolestext = Roles.getText();
	       out.writeoutputtofile(strPath+"AdminPanel_RolesPage.txt",Rolestext);
	       
		   // Roles & Permissions Page -Add Role
		   driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
		   Thread.sleep(2000);
		   WebElement RolestextAddrole = driver.findElement(By.tagName("body"));
	       String RolestextAddroletext = RolestextAddrole.getText();
	       out.writeoutputtofile(strPath+"AdminPanel_Roles_AddRolePage.txt",RolestextAddroletext);
}

@Parameters({"strPath"})
@Test(dependsOnMethods={"AdminModule"})
public void Bankdata(@Optional String strPath) throws IOException, InterruptedException
{
	 OutputtoFile out = new OutputtoFile();
	 driver.findElement(By.xpath("//a[@title='Bank Data']/span")).click();
	 //Calendar
	 driver.findElement(By.xpath("//a[@title='Calendar']/span")).click();
	 Thread.sleep(2000);
	 WebElement Calendar = driver.findElement(By.tagName("body"));
	 String BankDatatext = Calendar.getText();
	 out.writeoutputtofile(strPath+"BankData_Calendar.txt",BankDatatext);
	 //AddIcon
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon = driver.findElement(By.tagName("body"));
	 String AddIcontext = AddIcon.getText();
	 out.writeoutputtofile(strPath+"BankData_Calendar_AddCalendar.txt",AddIcontext);
	//Country
	 driver.findElement(By.xpath("//a[@title='Country']/span")).click();
     Thread.sleep(2000);
	 WebElement Country = driver.findElement(By.tagName("body"));
	 String BankDatatext1 = Country.getText();
	 out.writeoutputtofile(strPath+"BankData_Country.txt",BankDatatext1);
	 //AddIcon1
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon1 = driver.findElement(By.tagName("body"));
	 String AddIcontext1 = AddIcon1.getText();
	 out.writeoutputtofile(strPath+"BankData_Country_AddCountry.txt",AddIcontext1);
	//Region
	 driver.findElement(By.xpath("//a[@title='Region']/span")).click();
	 Thread.sleep(2000);
     WebElement Region = driver.findElement(By.tagName("body"));
	 String BankDatatext2 = Region.getText();
     out.writeoutputtofile(strPath+"BankData_Region.txt",BankDatatext2);
	//AddIcon2
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon2 = driver.findElement(By.tagName("body"));
	 String AddIcontext2 = AddIcon2.getText();
	 out.writeoutputtofile(strPath+"BankData_Region_AddRegion.txt",AddIcontext2);	 
	//Currency
	 driver.findElement(By.xpath("//a[@title='Currency']/span")).click();
	 Thread.sleep(2000);
	 WebElement Currency = driver.findElement(By.tagName("body"));
	 String BankDatatext3 = Currency.getText();
	 out.writeoutputtofile(strPath+"BankData_Currency.txt",BankDatatext3);
	//AddIcon3
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon3 = driver.findElement(By.tagName("body"));
	 String AddIcontext3 = AddIcon3.getText();
	 out.writeoutputtofile(strPath+"BankData_Currency_AddCurrency.txt",AddIcontext3);
	//Office
	 driver.findElement(By.xpath("//a[@title='Office']/span")).click();
	 Thread.sleep(2000);
	 WebElement Office = driver.findElement(By.tagName("body"));
	 String BankDatatext4 = Office.getText();
	 out.writeoutputtofile(strPath+"BankData_Office.txt",BankDatatext4);
	//AddIcon4
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon4 = driver.findElement(By.tagName("body"));
	 String AddIcontext4 = AddIcon4.getText();
	 out.writeoutputtofile(strPath+"BankData_Office_AddOffice.txt",AddIcontext4);
	//Branch
	 driver.findElement(By.xpath("//a[@title='Branch']/span")).click();
	 Thread.sleep(2000);
	 WebElement Branch = driver.findElement(By.tagName("body"));
	 String BankDatatext5 = Branch.getText();
	 out.writeoutputtofile(strPath+"BankData_Branch.txt",BankDatatext5);
	 //AddIcon5
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon5 = driver.findElement(By.tagName("body"));
	 String AddIcontext5 = AddIcon5.getText();
	 out.writeoutputtofile(strPath+"BankData_Branch_AddBranch.txt",AddIcontext5);
	//Department
	 driver.findElement(By.xpath("//a[@title='Department']/span")).click();
	 Thread.sleep(2000);
	 WebElement Department = driver.findElement(By.tagName("body"));
	 String BankDatatext6 = Department.getText();
	 out.writeoutputtofile(strPath+"BankData_Department.txt",BankDatatext6);
	 //AddIcon6
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon6 = driver.findElement(By.tagName("body"));
	 String AddIcontext6 = AddIcon6.getText();
	 out.writeoutputtofile(strPath+"BankData_Department_AddDepart.txt",AddIcontext6);	 
	//Membership
	 driver.findElement(By.xpath("//a[@title='Membership']/span")).click();
	 Thread.sleep(2000);
	 WebElement Membership = driver.findElement(By.tagName("body"));
	 String BankDatatext7 = Membership.getText();
	 out.writeoutputtofile(strPath+"BankData_Membership.txt",BankDatatext7);
	 //AddIcon7
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon7 = driver.findElement(By.tagName("body"));
	 String AddIcontext7 = AddIcon7.getText();
	 out.writeoutputtofile(strPath+"BankData_Membership_AddMembership.txt",AddIcontext7);	 
	//Business Rules
	 driver.findElement(By.xpath("//a[@title='Business Rules']/span")).click();
	 Thread.sleep(2000);
	 WebElement BusinessRules = driver.findElement(By.tagName("body"));
	 String BankDatatext8 = BusinessRules.getText();
	 out.writeoutputtofile(strPath+"BankData_BusinessRules.txt",BankDatatext8);
	 //AddIcon8
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon8 = driver.findElement(By.tagName("body"));
	 String AddIcontext8 = AddIcon8.getText();
	 out.writeoutputtofile(strPath+"BankData_BusinessRules_AddBR.txt",AddIcontext8);	 
	//FX Rates
	 driver.findElement(By.xpath("//a[@title='FX Rates']/span")).click();
	 Thread.sleep(2000);
	 WebElement FXRates = driver.findElement(By.tagName("body"));
	 String BankDatatext9 = FXRates.getText();
	 out.writeoutputtofile(strPath+"BankData_FXRates.txt",BankDatatext9);
	 //AddIcon9
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon9 = driver.findElement(By.tagName("body"));
	 String AddIcontext9 = AddIcon9.getText();
	 out.writeoutputtofile(strPath+"BankData_FXRates_AddFx.txt",AddIcontext9);	 
	//MPI Template
	 driver.findElement(By.xpath("//a[@title='MPI Template']/span")).click();
	 Thread.sleep(2000);
	 WebElement MPITemplate = driver.findElement(By.tagName("body"));
	 String BankDatatext10 = MPITemplate.getText();
	 out.writeoutputtofile(strPath+"BankData_MPITemplate.txt",BankDatatext10);
	 //AddIcon10
	 driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	 Thread.sleep(2000);
	 WebElement AddIcon10 = driver.findElement(By.tagName("body"));
	 String AddIcontext10 = AddIcon10.getText();
	 out.writeoutputtofile(strPath+"BankData_MPITemplate_AddMPI.txt",AddIcontext10);	 
					
}

@Parameters({"strPath"})
@Test(dependsOnMethods={"Bankdata"})

public void SystemMonitoring(@Optional String strPath) throws IOException, InterruptedException
{
	
	 OutputtoFile out = new OutputtoFile();
	 driver.findElement(By.xpath("//a[@title='System Monitoring']/span")).click();
	 //Route Registry
	 driver.findElement(By.xpath("//a[@title='Route Registry']/span")).click();
	 Thread.sleep(2000);
	 WebElement Route = driver.findElement(By.tagName("body"));
	 String SystemMonitoringtext = Route.getText();
	 out.writeoutputtofile(strPath+"SystemMonitoring_Route.txt",SystemMonitoringtext);
	 //Service Registry
	 driver.findElement(By.xpath("//a[@title='Service Registry']/span")).click();
	 Thread.sleep(2000);
	 WebElement Service = driver.findElement(By.tagName("body"));
	 String SystemMonitoringtext1 = Service.getText();
	 out.writeoutputtofile(strPath+"SystemMonitoring_Service.txt",SystemMonitoringtext1);
	
}


@Parameters({"strPath"})
@Test(dependsOnMethods={"SystemMonitoring"})
public void Security(@Optional String strPath) throws IOException, InterruptedException
{

	OutputtoFile out = new OutputtoFile();
	driver.findElement(By.xpath("//a[@title='Security']/span")).click();
	//Approvals
	 driver.findElement(By.xpath("//a[@title='Approvals']/span")).click();
	 Thread.sleep(2000);
	 WebElement Approvals = driver.findElement(By.tagName("body"));
	 String Securitytext = Approvals.getText();
	 out.writeoutputtofile(strPath+"Securitytext_Approvals.txt",Securitytext);

}
@Parameters({"strPath"})
@Test(dependsOnMethods={"Security"})
public void Reports(@Optional String strPath) throws  IOException, InterruptedException
{

	OutputtoFile out = new OutputtoFile();
	driver.findElement(By.xpath("//a[@title='Reports']/span")).click();
	//Report
	 driver.findElement(By.xpath("//a[@title='Report']/span")).click();
	 Thread.sleep(2000);
	 WebElement Report = driver.findElement(By.tagName("body"));
	 String Reportstext = Report.getText();
	 out.writeoutputtofile(strPath+"Reporttext_Report.txt",Reportstext);

}

@Parameters({"strPath"})
@Test(dependsOnMethods={"Reports"})
public void OnboardingData(@Optional String strPath) throws  IOException, InterruptedException
{

	OutputtoFile out = new OutputtoFile();
	driver.findElement(By.xpath("//a[@title='Onboarding Data']/span")).click();
	//ServiceGroup
	driver.findElement(By.xpath("//a[@title='Service Group']/span")).click();
	Thread.sleep(2000);
	WebElement ServiceGroup = driver.findElement(By.tagName("body"));
	String ServiceGrouptext = ServiceGroup.getText();
	out.writeoutputtofile(strPath+"OnboardingData_ServiceGroup.txt",ServiceGrouptext);
	//AddIcon1
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon1 = driver.findElement(By.tagName("body"));
	String AddIcontext1 = AddIcon1.getText();
	out.writeoutputtofile(strPath+"OnboardingData_ServiceGroup_Add.txt",AddIcontext1);
	//Service
	driver.findElement(By.xpath("//a[@title='Service']/span")).click();
	Thread.sleep(2000);
	WebElement Service = driver.findElement(By.tagName("body"));
	String Servicetext = Service.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Service.txt",Servicetext);
	//AddIcon2
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon2 = driver.findElement(By.tagName("body"));
	String AddIcontext2 = AddIcon2.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Service_Add.txt",AddIcontext2);
	//Product
	driver.findElement(By.xpath("//a[@title='Product']/span")).click();
	Thread.sleep(2000);
	WebElement Product = driver.findElement(By.tagName("body"));
	String Producttext = Product.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Product.txt",Producttext);
	//AddIcon3
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon3 = driver.findElement(By.tagName("body"));
	String AddIcontext3 = AddIcon3.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Product_Add.txt",AddIcontext3);
	//Party
	driver.findElement(By.xpath("//a[@title='Party']/span")).click();
	Thread.sleep(2000);
	WebElement Party = driver.findElement(By.tagName("body"));
	String Partytext = Party.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Party.txt",Partytext);
	//AddIcon4
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon4 = driver.findElement(By.tagName("body"));
	String AddIcontext4 = AddIcon4.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Party_Add.txt",AddIcontext4);
	//Account
	driver.findElement(By.xpath("//a[@title='Account']/span")).click();
	Thread.sleep(2000);
	WebElement Account = driver.findElement(By.tagName("body"));
	String Accounttext = Account.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Account.txt",Accounttext);
	//AddIcon5
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon5 = driver.findElement(By.tagName("body"));
	String AddIcontext5 = AddIcon5.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Account_Add.txt",AddIcontext5);
	//Transport
	driver.findElement(By.xpath("//a[@title='Transport']/span")).click();
	Thread.sleep(2000);
	WebElement Transport = driver.findElement(By.tagName("body"));
	String Transporttext = Transport.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Transport.txt",Transporttext);
	//AddIcon6
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon6 = driver.findElement(By.tagName("body"));
	String AddIcontext6 = AddIcon6.getText();
	out.writeoutputtofile(strPath+"OnboardingData_Transport_Add.txt",AddIcontext6);
	//PSA
	driver.findElement(By.xpath("//a[@title='Party Service Association']/span")).click();
	Thread.sleep(2000);
	WebElement PSA = driver.findElement(By.tagName("body"));
	String PSAtext = PSA.getText();
	out.writeoutputtofile(strPath+"OnboardingData_PSA.txt",PSAtext);
	//AddIcon7
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon7 = driver.findElement(By.tagName("body"));
	String AddIcontext7 = AddIcon7.getText();
	out.writeoutputtofile(strPath+"OnboardingData_PSA_Add.txt",AddIcontext7);
	
}

@Parameters({"strPath"})
@Test(dependsOnMethods={"OnboardingData"})

public void DistributionData(@Optional String strPath) throws  IOException, InterruptedException

{
	OutputtoFile out = new OutputtoFile();
	driver.findElement(By.xpath("//a[@title='Distribution Data']/span")).click();
	//BankRouting
	driver.findElement(By.xpath("//a[@title='Bank Routing']/span")).click();
	Thread.sleep(2000);
	WebElement BankRouting = driver.findElement(By.tagName("body"));
	String BankRoutingtext = BankRouting.getText();
	out.writeoutputtofile(strPath+"DistributionData_BankRouting.txt",BankRoutingtext);
	//AddIcon1
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon1 = driver.findElement(By.tagName("body"));
	String AddIcontext1 = AddIcon1.getText();
	out.writeoutputtofile(strPath+"DistributionData_BankRouting_Add.txt",AddIcontext1);	
	//CountryCorrespondent
	driver.findElement(By.xpath("//a[@title='Country Correspondent']/span")).click();
	Thread.sleep(2000);
	WebElement CountryCorrespondent = driver.findElement(By.tagName("body"));
	String CountryCorrespondenttext = CountryCorrespondent.getText();
	out.writeoutputtofile(strPath+"DistributionData_CtyCorrespondent.txt",CountryCorrespondenttext);
	//AddIcon2
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon2 = driver.findElement(By.tagName("body"));
	String AddIcontext2 = AddIcon2.getText();
	out.writeoutputtofile(strPath+"DistributionData_CtyCorrespondent_Add.txt",AddIcontext2);
	
	//Currency Correspondent
	driver.findElement(By.xpath("//a[@title='Currency Correspondent']/span")).click();
	Thread.sleep(2000);
	WebElement CurrencyCorrespondent = driver.findElement(By.tagName("body"));
	String CurrencyCorrespondenttext = CurrencyCorrespondent.getText();
	out.writeoutputtofile(strPath+"DistributionData_CcyCorrespondent.txt",CurrencyCorrespondenttext);
    driver.findElement(By.cssSelector("i[class='fa fa-plus-square']")).click();
   	Thread.sleep(2000);
   	WebElement AddIcon44 = driver.findElement(By.tagName("body"));
   	String AddIcontext44 = AddIcon44.getText();
   	out.writeoutputtofile(strPath+"Distribution_AddIcon4.txt",AddIcontext44);	
	//IndustryData-SWIFT
	driver.findElement(By.xpath("//a[@title='Industry Data-SWIFT']/span")).click();
	Thread.sleep(2000);
	WebElement IndustryDataSWIFT = driver.findElement(By.tagName("body"));
	String IndustryDataSWIFTtext = IndustryDataSWIFT.getText();
	out.writeoutputtofile(strPath+"DistributionData_IndustryDataSWIFT.txt",IndustryDataSWIFTtext);
	//AddIcon3
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon3 = driver.findElement(By.tagName("body"));
	String AddIcontext3 = AddIcon3.getText();
	out.writeoutputtofile(strPath+"DistributionData_IndustryDataSWIFT_Add.txt",AddIcontext3);	
	 //MOP
   	driver.findElement(By.xpath("//a[@title='Method of Payment']/span")).click();
   	Thread.sleep(2000);
   	WebElement MOP = driver.findElement(By.tagName("body"));
   	String MOPtext = MOP.getText();
   	out.writeoutputtofile(strPath+"DistributionData_MOP.txt",MOPtext);
   	//GridView
   	driver.findElement(By.xpath("//i[@class='fa fa-table']")).click();
   	Thread.sleep(2000);
   	WebElement Grid = driver.findElement(By.tagName("body"));
   	String Gridtext = Grid.getText();
   	out.writeoutputtofile(strPath+"DistributionData_MOP_Add.txt",Gridtext);
   	//AddIcon4
	//MOPPriority
	driver.findElement(By.xpath("//a[@title='MOP Priority']/span")).click();
	Thread.sleep(2000);
	WebElement MOPPriority = driver.findElement(By.tagName("body"));
	String MOPPrioritytext = MOPPriority.getText();
	out.writeoutputtofile(strPath+"DistributionData_MOPPriority.txt",MOPPrioritytext);
	//AddIcon5
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon5 = driver.findElement(By.tagName("body"));
	String AddIcontext5 = AddIcon5.getText();
	out.writeoutputtofile(strPath+"DistributionData_MOPPriority_Add.txt",AddIcontext5);	
	//CutOff
	driver.findElement(By.xpath("//a[@title='CutOff']/span")).click();
	Thread.sleep(2000);
	WebElement CutOff = driver.findElement(By.tagName("body"));
	String CutOfftext = CutOff.getText();
	out.writeoutputtofile(strPath+"DistributionData_CutOff.txt",CutOfftext);
	//AddIcon6
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon6 = driver.findElement(By.tagName("body"));
	String AddIcontext6 = AddIcon6.getText();
	out.writeoutputtofile(strPath+"DistributionData_CutOff_Add.txt",AddIcontext6);	
	//BulkProfile
	driver.findElement(By.xpath("//a[@title='Bulk Profile']/span")).click();
	Thread.sleep(2000);
	WebElement BulkProfile = driver.findElement(By.tagName("body"));
	String BulkProfiletext = BulkProfile.getText();
	out.writeoutputtofile(strPath+"DistributionData_BulkProfile.txt",BulkProfiletext);
	//AddIcon7
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon7 = driver.findElement(By.tagName("body"));
	String AddIcontext7 = AddIcon7.getText();
	out.writeoutputtofile(strPath+"DistributionData_BulkProfile_Add.txt",AddIcontext7);	
	//BulkProfileOverride
	driver.findElement(By.xpath("//a[@title='Bulk Profile Override']/span")).click();
	Thread.sleep(2000);
	WebElement BulkProfileOverride = driver.findElement(By.tagName("body"));
	String BulkProfileOverridetext = BulkProfileOverride.getText();
	out.writeoutputtofile(strPath+"DistributionData_BulkProfileOverride.txt",BulkProfileOverridetext);
	//AddIcon8
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon8 = driver.findElement(By.tagName("body"));
	String AddIcontext8 = AddIcon8.getText();
	out.writeoutputtofile(strPath+"DistributionData_BulkProfileOverride_Add.txt",AddIcontext8);	
}

@Parameters({"strPath"})
@Test(dependsOnMethods={"DistributionData"})

public void SystemData(@Optional String strPath) throws  IOException, InterruptedException

{
	OutputtoFile out = new OutputtoFile();
	driver.findElement(By.xpath("//a[@title='System Data']/span")).click();
	//ApplicationConfig
	driver.findElement(By.xpath("//a[@title='Application Config']/span")).click();
	Thread.sleep(2000);
	WebElement ApplicationConfig = driver.findElement(By.tagName("body"));
	String ApplicationConfigtext = ApplicationConfig.getText();
	out.writeoutputtofile(strPath+"ApplicationConfigtext_ApplicationConfig.txt",ApplicationConfigtext);
	//AddIcon1
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square fa-fs14']")).click();
	Thread.sleep(2000);
	WebElement AddIcon1 = driver.findElement(By.tagName("body"));
	String AddIcontext1 = AddIcon1.getText();
	out.writeoutputtofile(strPath+"System_AddIcon1.txt",AddIcontext1);		
	//BusinessFunction
	driver.findElement(By.xpath("//a[@title='Business Function']/span")).click();
	Thread.sleep(2000);
	WebElement BusinessFunction = driver.findElement(By.tagName("body"));
	String BusinessFunctiontext = BusinessFunction.getText();
	out.writeoutputtofile(strPath+"BusinessFunctiontext_BusinessFunction.txt",BusinessFunctiontext);
	//AddIcon2
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon2 = driver.findElement(By.tagName("body"));
	String AddIcontext2 = AddIcon2.getText();
	out.writeoutputtofile(strPath+"System_AddIcon2.txt",AddIcontext2);		
	//BusinessProcess
	driver.findElement(By.xpath("//a[@title='Business Process']/span")).click();
	Thread.sleep(2000);
	WebElement BusinessProcess = driver.findElement(By.tagName("body"));
	String BusinessProcesstext = BusinessProcess.getText();
	out.writeoutputtofile(strPath+"BusinessProcesstext_BusinessProcess.txt",BusinessProcesstext);
	//AddIcon3
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon3 = driver.findElement(By.tagName("body"));
	String AddIcontext3 = AddIcon3.getText();
	out.writeoutputtofile(strPath+"System_AddIcon3.txt",AddIcontext3);		
	//VolPayIDConfiguration
	driver.findElement(By.xpath("//a[@title='VolPay ID Configuration']/span")).click();
	Thread.sleep(2000);
	WebElement VolPayIDConfiguration = driver.findElement(By.tagName("body"));
	String VolPayIDConfigurationtext = VolPayIDConfiguration.getText();
	out.writeoutputtofile(strPath+"VolPayIDConfigurationtext_VolPayIDConfiguration.txt",VolPayIDConfigurationtext);
	//ListView
   	driver.findElement(By.xpath("//i[@class='fa fa-list fa-fs14']")).click();
   	Thread.sleep(2000);
   	WebElement List = driver.findElement(By.tagName("body"));
   	String Listtext = List.getText();
   	out.writeoutputtofile(strPath+"Listtext_List.txt",Listtext);
	//AddIcon4
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon4 = driver.findElement(By.tagName("body"));
	String AddIcontext4 = AddIcon4.getText();
	out.writeoutputtofile(strPath+"System_AddIcon4.txt",AddIcontext4);		
	//ActionDefinition
	driver.findElement(By.xpath("//a[@title='Action Definition']/span")).click();
	Thread.sleep(2000);
	WebElement ActionDefinition = driver.findElement(By.tagName("body"));
	String ActionDefinitiontext = ActionDefinition.getText();
	out.writeoutputtofile(strPath+"ActionDefinitiontext_ActionDefinition.txt",ActionDefinitiontext);
	//AddIcon5
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon5 = driver.findElement(By.tagName("body"));
	String AddIcontext5 = AddIcon5.getText();
	out.writeoutputtofile(strPath+"System_AddIcon5.txt",AddIcontext5);		
	//StatusDefinition
	driver.findElement(By.xpath("//a[@title='Status Definition']/span")).click();
	Thread.sleep(2000);
	WebElement StatusDefinition = driver.findElement(By.tagName("body"));
	String StatusDefinitiontext = StatusDefinition.getText();
	out.writeoutputtofile(strPath+"StatusDefinitiontext_StatusDefinition.txt",StatusDefinitiontext);
	//AddIcon6
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon6 = driver.findElement(By.tagName("body"));
	String AddIcontext6 = AddIcon6.getText();
	out.writeoutputtofile(strPath+"System_AddIcon6.txt",AddIcontext6);		
	//IncidenceDefinition
	driver.findElement(By.xpath("//a[@title='Incidence Definition']/span")).click();
	Thread.sleep(2000);
	WebElement IncidenceDefinition = driver.findElement(By.tagName("body"));
	String IncidenceDefinitiontext = IncidenceDefinition.getText();
	out.writeoutputtofile(strPath+"IncidenceDefinitiontext_IncidenceDefinition.txt",IncidenceDefinitiontext);
	//AddIcon7
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon7 = driver.findElement(By.tagName("body"));
	String AddIcontext7 = AddIcon7.getText();
	out.writeoutputtofile(strPath+"System_AddIcon7.txt",AddIcontext7);		
	//StatusAction
	driver.findElement(By.xpath("//a[@title='Status Action']/span")).click();
	Thread.sleep(2000);
	WebElement StatusAction = driver.findElement(By.tagName("body"));
	String StatusActiontext = StatusAction.getText();
	out.writeoutputtofile(strPath+"StatusActiontext_StatusAction.txt",StatusActiontext);
	//AddIcon8
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon8 = driver.findElement(By.tagName("body"));
	String AddIcontext8 = AddIcon8.getText();
	out.writeoutputtofile(strPath+"System_AddIcon8.txt",AddIcontext8);	
	//LogConfiguration
	driver.findElement(By.xpath("//a[@title='Log Configuration']/span")).click();
	Thread.sleep(2000);
	WebElement LogConfiguration = driver.findElement(By.tagName("body"));
	String LogConfigurationtext = LogConfiguration.getText();
	out.writeoutputtofile(strPath+"LogConfigurationtext_LogConfiguration.txt",LogConfigurationtext);
	//AddIcon9
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon9 = driver.findElement(By.tagName("body"));
	String AddIcontext9 = AddIcon9.getText();
	out.writeoutputtofile(strPath+"System_AddIcon9.txt",AddIcontext9);	
	//ApprovalCondition
	driver.findElement(By.xpath("//a[@title='Approval Condition']/span")).click();
	Thread.sleep(2000);
	WebElement ApprovalCondition = driver.findElement(By.tagName("body"));
	String ApprovalConditiontext = ApprovalCondition.getText();
	out.writeoutputtofile(strPath+"ApprovalConditiontext_ApprovalCondition.txt",ApprovalConditiontext);
	//AddIcon9
	driver.findElement(By.xpath("//i[@class='fa fa-plus-square']")).click();
	Thread.sleep(2000);
	WebElement AddIcon10 = driver.findElement(By.tagName("body"));
	String AddIcontext10 = AddIcon10.getText();
	out.writeoutputtofile(strPath+"System_AddIcon10.txt",AddIcontext10);	
}
@Parameters({"strPath"})
@Test(dependsOnMethods={"SystemData"})

public void Logout(@Optional String strPath) throws IOException, InterruptedException

{
	        driver.findElement(By.cssSelector("span[class='namecls ng-binding']")).click();
	        Thread.sleep(2500);
	        driver.findElement(By.cssSelector("a[ng-click='logout()']")).click();
}
}



