/*package com.volante.BankData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.volante.param.utilities.ObjectMap;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.LoadFile;

public class TestExecuteForBankData 
{
	 public static ObjectMap objmap;
     public static LoadFile load;
     public static WebDriver wd;
	
@BeforeTest
public static void CallReport()
		{
	              String workingDir=System.getProperty("user.dir");
                  load = new LoadFile(workingDir + "/src/main/resources/class/VolPayUI.properties");
                  load = new LoadFile (workingDir+"/src/main/resources/propertiesfile/Login.properties");
                  objmap = new ObjectMap (workingDir+"/src/main/resources/propertiesfile/LoginObject.properties");       
	              ReportGeneration.startReport("/VolPayUI_BankData.html");
		}
@SuppressWarnings("deprecation")
@Parameters({"browser"})
@BeforeClass
public static void Setup(@Optional String browser) throws Exception {
		{
			if (browser.equalsIgnoreCase("Firefox")) {
				System.out.println("Running Firefox");
				System.setProperty("webdriver.gecko.driver",LoadFile.prop.getProperty("FireFox"));
				wd = new FirefoxDriver();
				wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.out.println("Running Chrome");
				System.setProperty("webdriver.chrome.driver",LoadFile.prop.getProperty("Chrome"));
				wd = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("InternetExplorer")) {
				System.out.println("Running Internet Explorer");
				System.setProperty("webdriver.ie.driver",LoadFile.prop.getProperty("InternetExplorer"));
				DesiredCapabilities capabilities = DesiredCapabilities
						.internetExplorer();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,
						true);
				wd = new InternetExplorerDriver(capabilities);
}
}
		wd.get(LoadFile.prop.getProperty("URL"));
		Thread.sleep(3000);
		wd.manage().window().maximize();
		Thread.sleep(4000);
		WebElement username=wd.findElement(objmap.getLocator("user"));
		username.sendKeys(LoadFile.prop.getProperty("VolPay_Username"));
		WebElement Password=wd.findElement(objmap.getLocator("pwd"));
		Password.sendKeys(LoadFile.prop.getProperty("VolPay_Password"));
		wd.findElement(objmap.getLocator("loginbutton")).click();
		wd.navigate().to("javascript:document.getElementById('overridelink').click()");
		}

@Test
public static void BankData() throws Exception
{
	                      
	                      //BankDataCalendar.ExecuteCalendar(wd);
	                      //BankDataRegion.ExecuteRegion(wd);
	                      //BankDataCountry.ExecuteCountry(wd);
	                       //BankDataCurrency.ExecuteCurrency(wd);
	                       //BankDataDepartment.ExecuteDepartment(wd);
	                         //BankDataOffice.ExecuteOffice(wd);
	                         //BankDataBranch.ExecuteBranch(wd);
	                           BankDataFxRate.ExecuteFxRate(wd);

}
	
@AfterTest
public static void CloseReport()
		{
		             ReportGeneration.endReport();
		}		
}
*/