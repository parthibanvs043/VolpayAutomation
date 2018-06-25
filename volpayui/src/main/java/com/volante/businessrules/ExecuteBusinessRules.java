package com.volante.businessrules;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.volante.param.utilities.*;
import com.volante.utilities.LoadFile;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExecuteBusinessRules 
{

	 public static ObjectMap objmap;
     public LoadFile load;
     public Workbook BRBook;
     Sheet BRSheet;
     public static WebDriver driver;

@BeforeTest
public void Preload() throws IOException, InterruptedException
   {
               String workingDir=System.getProperty("user.dir");
               load = new LoadFile(workingDir + "/src/main/resources/class/VolPayUI.properties");
               load = new LoadFile (workingDir+"/src/test/resources/Login.properties");
               objmap = new ObjectMap (workingDir+"/src/test/resources/BusinessRulesobject.properties");    
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

public void ExecuteBR() throws BiffException, IOException
{
	  String workingDir=System.getProperty("user.dir");
	  BRBook= Workbook.getWorkbook(new File(workingDir+"/testdata/ParamInputs/MPI_InitiateTransaction.xls"));        
      BRSheet=BRBook.getSheet("BusinessRules");
      int rows_count=BRSheet.getRows();
      for (int row=1; row<=rows_count; row++)
  	   { 
              // Business Rules Attributes
  	                Cell officecode=BRSheet.getCell(1,row);
  	                Cell RuleCode=BRSheet.getCell(1,row);
  	                Cell RuleName=BRSheet.getCell(1,row);
  	                Cell ProcessCode=BRSheet.getCell(1,row);
  	                Cell WFCode=BRSheet.getCell(1,row);
  	                
  	            // Rule Builder Attributes    
  	                Cell Rule=BRSheet.getCell(1,row);
  	            //Business Rules Attributes    
  	                Cell RuleCDate=BRSheet.getCell(1,row);
  	                Cell RulePhase=BRSheet.getCell(1,row);
  	                Cell Description=BRSheet.getCell(1,row);
  	                Cell Status=BRSheet.getCell(1,row);
  	                Cell EffFromDate=BRSheet.getCell(1,row);
  	                Cell EffTillDate=BRSheet.getCell(1,row);
  	   }
}
} 
