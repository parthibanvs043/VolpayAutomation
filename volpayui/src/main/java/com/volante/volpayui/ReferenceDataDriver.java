package com.volante.volpayui;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.volante.param.utilities.ObjectMap;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.LoadFile;

import jxl.Sheet;
import jxl.Workbook;

public class ReferenceDataDriver 
{

	 public static ObjectMap objmap;
     public static LoadFile load;
     public static WebDriver wd;
     static WebDriver driver;
     public static String Methodname;
 	 public static String  Sheetname;


@BeforeTest
@Parameters({ "Report" })
public static void CallReport(@Optional String ReportFileName)
			{
		           String workingDir=System.getProperty("user.dir");
	               load = new LoadFile(workingDir + "/src/main/resources/class/VolPayUI.properties");
	              // load = new LoadFile (workingDir+"/src/main/resources/propertiesfile/Login.properties");
	              // objmap = new ObjectMap (workingDir+"/src/main/resources/propertiesfile/LoginObject.properties");       
		          ReportGeneration.startReport(ReportFileName);
			}
@SuppressWarnings("deprecation")
@Parameters({ "driverPath" })
@Test
public void VolPayframework(@Optional String driverPath) {
		int driverSheet = 0;
		try {
			//To Capture the video
		    //record.startRecording();
		    //Read the Workbook
			Workbook wb = Workbook.getWorkbook(new File(driverPath));
			Sheet sheet = wb.getSheet(driverSheet);
			int driverRows = sheet.getRows();
			int scCount = 0;

			String  brow, exec ;
			for (int row = 1; row < driverRows; row++) {
				Sheetname = sheet.getCell(0, row).getContents();
				System.out.println(Sheetname);
				System.out.println("Before Sheetname="+Sheetname);
				Methodname = sheet.getCell(1, row).getContents();
				System.out.println("Before Methodname="+Methodname);
				brow = sheet.getCell(2, row).getContents();
				exec = sheet.getCell(3, row).getContents();
                
				if (exec.equalsIgnoreCase("YES")) {
					//GenerateReport.getmethodname();
					System.out.println("Sheetname="+Sheetname);
					System.out.println("Methodname="+Methodname);

					scCount = scCount + 1;
					switch (brow) {
					case "Firefox":
						// For Firefox
						System.setProperty("webdriver.gecko.driver", LoadFile.prop.getProperty("FireFox"));
						driver = new FirefoxDriver();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						ReferenceDataExcel.RDExcelSheet(driver, driverPath, Sheetname);
						break;

					case "Chrome":
						System.setProperty("webdriver.chrome.driver", LoadFile.prop.getProperty("Chrome"));
						driver = new ChromeDriver();
						ReferenceDataExcel.RDExcelSheet(driver, driverPath, Sheetname);
						break;

					case "InternetExplorer":
						System.setProperty("webdriver.ie.driver", LoadFile.prop.getProperty("InternetExplorer"));
						DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
						capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						driver = new InternetExplorerDriver(capabilities);
						ReferenceDataExcel.RDExcelSheet(driver, driverPath, Sheetname);
						break;
					case "Continue":
						
						ReferenceDataExcel.RDExcelSheet(driver, driverPath, Sheetname);
						break;
					

					default:
						break;
					}
				}

			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
}
@AfterTest
public static void endReport() {
			
	           ReportGeneration.extent.flush();
		}
}