package com.volante.volpayui;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.excel.ReadExcel;
import com.volante.excel.RolesRead;
import com.volante.recorder.VideoReord;
import com.volante.reports.GenerateReport;

import jxl.Sheet;
import jxl.Workbook;

import com.volante.utilities.*;

public class VolPayDriver {
	
	public LoadFile load;
	public GenerateReport report;
	static WebDriver driver;
	Logger logger = Logger.getLogger(this.getClass().getName());
	public static String scenario;
	public static String  SNo;
	VideoReord record =new VideoReord();

@BeforeTest
@Parameters({ "Report" })
public void LoadAll(@Optional String ReportFileName) throws IOException {
		String userhome = "user.dir";
		String path = System.getProperty(userhome);
		System.out.println("Dislayuserhome=" + path);
		load = new LoadFile(path + "/src/main/resources/class/VolPayUI.properties");
		PropertyConfigurator.configure(path + "/src/main/resources/class/log4j.properties");
		GenerateReport.StartReport(ReportFileName);
	}

@SuppressWarnings("deprecation")
@Parameters({ "driverPath" })
@Test
public void VolPayframework(@Optional String driverPath) {
		// TODO Auto-generated method stub
		//MovetheFiles.moveTheFile();
		int driverSheet = 0;
		try {
			//To Capture the video
		    record.startRecording();
		    //Read the Workbook
			Workbook wb = Workbook.getWorkbook(new File(driverPath));
			Sheet sheet = wb.getSheet(driverSheet);
			int driverRows = sheet.getRows();
			int scCount = 0;

			String  brow, exec ,choosemethod;
			for (int row = 1; row < driverRows; row++) {
				SNo = sheet.getCell(0, row).getContents();
				System.out.println(SNo);
				scenario = sheet.getCell(1, row).getContents();
				// System.out.println("Check the Test
				// Scenario...."+row+"_"+scenario);
				brow = sheet.getCell(2, row).getContents();
				exec = sheet.getCell(3, row).getContents();
				choosemethod = sheet.getCell(4,row).getContents();
				System.out.println("choosemethod="+choosemethod);
                
				if (exec.equalsIgnoreCase("YES")) {
					//GenerateReport.getmethodname();

					scCount = scCount + 1;
					switch (brow) {
					case "Firefox":
						// For Firefox
						System.setProperty("webdriver.gecko.driver", LoadFile.prop.getProperty("FireFox"));
						driver = new FirefoxDriver();
						//driver = new HtmlUnitDriver();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						if(choosemethod.equalsIgnoreCase("ReferenceData"))
						{
						   ReadExcel.readExcelSheet(driver, driverPath, row, scCount);
						}
						else if(choosemethod.equalsIgnoreCase("Entitlement"))
						{
							RolesRead.readExcelSheet(driver, driverPath, row, scCount);
						}
						break;

					case "Chrome":
						System.setProperty("webdriver.chrome.driver", LoadFile.prop.getProperty("Chrome"));
						driver = new ChromeDriver();
						//driver = new HtmlUnitDriver();
						if(choosemethod.equalsIgnoreCase("ReferenceData"))
						{
						   ReadExcel.readExcelSheet(driver, driverPath, row, scCount);
						}
						else if(choosemethod.equalsIgnoreCase("Entitlement"))
						{
							RolesRead.readExcelSheet(driver, driverPath, row, scCount);
						}
						break;

					case "InternetExplorer":
						System.setProperty("webdriver.ie.driver", LoadFile.prop.getProperty("InternetExplorer"));
						DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
						capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						driver = new InternetExplorerDriver(capabilities);
						if(choosemethod.equalsIgnoreCase("ReferenceData"))
						{
						   ReadExcel.readExcelSheet(driver, driverPath, row, scCount);
						}
						else if(choosemethod.equalsIgnoreCase("Entitlement"))
						{
							RolesRead.readExcelSheet(driver, driverPath, row, scCount);
						}
						break;

					case "Headless":
						System.setProperty("webdriver.chrome.driver", LoadFile.prop.getProperty("Chrome"));
						ChromeOptions options = new ChromeOptions();
						options.addArguments("window-size=1400,800");
						options.addArguments("headless");
						driver = new ChromeDriver(options);
						//driver = new HtmlUnitDriver();
						if(choosemethod.equalsIgnoreCase("ReferenceData"))
						{
						   ReadExcel.readExcelSheet(driver, driverPath, row, scCount);
						}
						else if(choosemethod.equalsIgnoreCase("Entitlement"))
						{
							RolesRead.readExcelSheet(driver, driverPath, row, scCount);
						}
						break;
						
					case "Continue":

						//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						if(choosemethod.equalsIgnoreCase("ReferenceData"))
						{
						   ReadExcel.readExcelSheet(driver, driverPath, row, scCount);
						}
						else if(choosemethod.equalsIgnoreCase("Entitlement"))
						{
							RolesRead.readExcelSheet(driver, driverPath, row, scCount);
						}
						break;
					

					default:
						break;
					}
				}

			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		//ArchieveFiles.archiveFile();
	}
	@AfterMethod
	public void getResult(ITestResult result) throws IOException {
		try {
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenShotPath = GetScreenShot.capture(driver, "screenShotName");
				GenerateReport.test.log(LogStatus.FAIL, result.getThrowable());
				GenerateReport.test.log(LogStatus.FAIL,
						"FAILED Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
			}
		} catch (WebDriverException e) {
			// String screenShotPath = GetScreenShot.capture(driver,
			// "screenShotName");
			// test.log(LogStatus.FAIL, "FAILED-1 Snapshot below: " +
			// test.addScreenCapture(screenShotPath));
		}
		//GenerateReport.extent.endTest(GenerateReport.test);

	}

	@AfterTest
	public void endReport() throws Exception {

		//GenerateReport.extent.endTest(GenerateReport.test);
		GenerateReport.extent.flush();
		record.stopRecording();
		// extent.close();
	}
}
