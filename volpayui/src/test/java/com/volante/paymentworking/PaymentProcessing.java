package com.volante.paymentworking;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;
public class PaymentProcessing {
	static WebDriver driver;

	// method to click the rth row
	public static void clickrow(WebDriver wd, int rowno, String part1path, String part2path) throws InterruptedException {
		WebElement rowRecord = wd.findElement(By.xpath(part1path + rowno + part2path));
		System.out.println("Row is  csdff" + rowRecord);
		Thread.sleep(2500);
		rowRecord.click();
		Thread.sleep(5000);
		System.out.println(+rowno + "th row got clicked.");
		wd.findElement(By.xpath("//span[contains(text(),'Received Instructions')]")).click();
		Thread.sleep(5000);

	}

	// Method to sort the colum
	public static void sortcolumn(WebDriver wd ,int colno, String colpath, String ColValue) {
		String ColToSort = ColValue;
		WebElement CValue = wd.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr/th[" + colno + "]"));
		String coltxt = CValue.getText();
		System.out.println("sValue = " + coltxt);
		// To Match with Column Value
		if (coltxt.contains(ColToSort)) {
			System.out.println("To sort by Entry date");
			CValue.click();
			System.out.println(coltxt + "Got Clicked");
		}
	}

	// To get total no of records from a module
	public static void recordcount(WebDriver wd ,String Rpath) {
		WebElement recordcount = wd.findElement(By.xpath(Rpath));
		String NoOfRecords = recordcount.getText();
		System.out.println(" Total No Records Shown are :    " + NoOfRecords);
	}
	
	// To get column values in a list
	public static void listofColvalues(String RowPath,String Colpart1 ,String ColPart2) {
		List<WebElement> valuesofcol = driver.findElements(By.xpath(RowPath));
		for (int x = 1; x <= valuesofcol.size(); x++) {
			WebElement valforcolno = driver.findElement(By.xpath(Colpart1 + x + ColPart2));
			String colvalforrow = valforcolno.getText();
			System.out.println("Value for col ID is -------" + colvalforrow);
		}
	}
	// Search by Id Verification
	public static void searchVerify(String searchVal , String SPath){
	WebElement idsearch = driver.findElement(By.xpath(SPath));
	String ISearch = idsearch.getText();
	if (ISearch.contains(searchVal)){
		System.out.println("Verification done successfully for  "+ISearch);
	}		
	}
	public static void VerifyByColumnName(WebDriver wd, String pr, String dt, String module, String strStep) throws InterruptedException, IOException {
		  wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		  try { 
			  int rows = wd.findElements(By.xpath(pr)).size(); 
			  System.out.println( "Total No of rows in table =" + rows); 
		  // To check if payment is present & Select the payment 
		  for (int r = 1; r <= rows; r++) {
		  System.out.println(" loop for row " +r); 
		  WebElement col =  wd.findElement(By.xpath(pr+"["+r+"]/td["+module+"]/span")); 
		  String colval  = col.getText(); 
		  System.out.println(" values for first col is ====="  +colval);
		  if (colval.equalsIgnoreCase(dt)) { 
			  col.click();
		  System.out.println(" val clicked for " +col);
		   break;
		  }
		  } 
		  } 
		  catch (NoSuchElementException e) {
		  System.out.println("Unable to find the module"+ e.getMessage()); 
		 		  } 
		  catch (Exception e) { 
			  System.out.println("runtime exc"+ e.getMessage()); 
		 	  
		  }
	}
	// To get column values in a list
		public static void ClickBasedOnColvalues(WebDriver wd, String dt,String trpath ,String tdpath,String Colindex) {
			 int rows = wd.findElements(By.xpath(trpath)).size(); 
			  System.out.println( "Total No of rows in table =" + rows); 
			for (int x = 1; x <= rows; x++) {
				  WebElement colValue =  wd.findElement(By.xpath(trpath+"["+x+"]/td["+tdpath+"]/span")); 
				String colvalforrow = colValue.getText();
				System.out.println("Value for col ID is -------" + colvalforrow);
				  if (colvalforrow.equalsIgnoreCase(dt)) { 
					  colValue.click();
				  System.out.println(" val clicked for " +colvalforrow);
				   break;
			}
		}
		}
	// @SuppressWarnings("deprecation")
	@Test
	public void Payments() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"E:\\VolPaySuite\\VolPayUIAutomation\\volpayui\\src\\main\\resources\\browser\\Windows\\geckodriver.exe");
		Thread.sleep(3000);
		driver = new FirefoxDriver();
		driver.get("https://localhost:8443/VolPayHubUI/");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("admin");
		Thread.sleep(3000);
		driver.findElement(By.id("password")).sendKeys("admin@123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);
		System.out.println("Login");
		driver.findElement(By.xpath("//span[contains(text(),'Received Instructions')]")).click();
		System.out.println("Clicked received instr");
		Thread.sleep(3000);
		//To Select grid View
		driver.findElement(By.id("btn_2")).click();
		Thread.sleep(3000);
		//To Select ViewMOPBased Distribution
		driver.findElement(By.id("btn_3")).click();
		// Get number of rows In table.
		String firsthalfrow = "html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/tbody/tr[";
		String secondhalfrow = "]/td[2]";
		//String fileDetCol = "]/td[7]";
		String fileDetCol = "]/td[8]";
		String MOPCol = "]/td[7]";
		String fileInstType = "]/td[3]";
		String filePSA = "]/td[5]";
		String TransdetPath = "]/td/pre";
		String PymtCount = "]/td[6]/div/span[1]";
		
		//int expectedIndexValue = getIndexFromXpath("//div[@class='listView FixHead dataGroupsScroll']/table/thead/tr", "th", "Instruction Status");
		// To get record count call the method
		recordcount(driver,"//span[contains(text(),'records shown')]/preceding::span[1]");
		int rowCount = driver.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/tbody/tr")).size();
		System.out.println("No of Rows in a Page...." + rowCount);
		// Get number of columns In table.
		int Colcount = driver.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr/th")).size();
		System.out.println("Number Of Columns = " + Colcount);
		for (int i = 1; i <= Colcount; i++) {
			//sortcolumn(driver,i, "html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr/th[" + i + "]","Entry Date & Time");
			  String EntryDate = "Entry Date & Time"; WebElement CValue =driver.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr/th["+ i + "]")); 
			  String colVal = CValue.getText();
			  System.out.println("sValue = " + colVal); 
			  // To Match with Column  Value 
			  if (colVal.contains(EntryDate)) { 
				  System.out.println( "To sort by Entry date"); CValue.click();
			  System.out.println(colVal + "Got Clicked"); }
			 
		}

				for (int j = 1; j <= rowCount; j++) {
			// To get Transport Info Details
			WebElement transinfo = driver.findElement(By.xpath(firsthalfrow + j + "]/td[1]/i"));
			boolean pre = transinfo.isDisplayed()| transinfo.isEnabled();
			if (pre==false) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				//Thread.sleep(4000);
			}
			
			transinfo.click();
			EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			eventDriver.executeScript("document.querySelector('div[class*=\"listView FixHead dataGroupsScroll\"]').scrollTop=500");
			if (!transinfo.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", transinfo);
				Thread.sleep(4000);
			}
			

			System.out.println("TransInfo Path ------------" + firsthalfrow + (j + 1) + TransdetPath);
			String path = firsthalfrow+(j+1)+TransdetPath;
			WebElement TransDetailstext = driver.findElement(By.xpath(path));
			
			//to scroll
			Actions action = new Actions(driver);
		    action.moveToElement(driver.findElement(By.xpath(path)));
			//EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
			//eventDriver.executeScript("document.querySelector('(//div[@class=\"contentContainer\"]/div)[4]').scrollTop=100");
			if (!TransDetailstext.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				//Thread.sleep(4000);
			}
			String TransDetails = TransDetailstext.getText();
			System.out.println("Transport deatils are for " + j + "th row is " + TransDetails);
			String[] FinalValue = TransDetails.split(",");
			for (String W : FinalValue) {
				String TransContent = W.replaceAll("\"", "");
				if (TransContent.contains("TransportName")) {
					String TransName = TransContent.substring(TransContent.lastIndexOf(":")).replace(":", "");
					System.out.println("TransName is ==============  " + TransName);
					// To get File Details for the file [Status , Payment Count,Instruction Type]
					if (!TransName.isEmpty()) {
						// To Get PSA Code
						WebElement filePSAcode = driver.findElement(By.xpath(firsthalfrow + j + filePSA));
						String PSACode = filePSAcode.getText();
						System.out.println("---------------File Name for File " + TransName + " = " + PSACode);
								// To Get File Status if MOP Distribution is OFF
								WebElement InstrStatus = driver.findElement(By.xpath(firsthalfrow + j + fileDetCol));
								String FStatus = InstrStatus.getText();
								System.out.println("---------------File Status for File " + TransName + " = " + FStatus);
								//			OR
						/*// To Get File Status if MOP distribution is ON
						WebElement InstrStatus1 = driver.findElement(By.xpath(firsthalfrow + j + fileDetCol));
						String FStatus1 = InstrStatus1.getText();
						System.out.println("---------------File Status for File " + TransName + " = " + FStatus);*/
								
						// To Get MOPDetails
						WebElement MOPDet = driver.findElement(By.xpath(firsthalfrow + j + MOPCol));
						String MOP = MOPDet.getText();
						System.out.println("---------------File MOP for File " + TransName + " = " + MOP);				
						//to get Instr MOP count
						WebElement MOPs = driver.findElement(By.xpath("//td[@ng-if='viewMOPStatus']/div"));
						List <WebElement> MOPlist =MOPs.findElements(By.tagName("span"));
						for (WebElement PymtMOP : MOPlist) {
							String MOPTxt = PymtMOP.getText();
							System.out.println("MOPs are------" +MOPTxt);
						}
						// To get Payment Count if File is not REJECTED
						if (!FStatus.equals("REJECTED")) {
							WebElement pymtCnt = driver.findElement(By.xpath(firsthalfrow + j + PymtCount));
							String PCount = pymtCnt.getText().replace("()", "");
							System.out.println("---------------Payment count for File " + TransName + " = " + PCount);
						}
						// To get Instruction Type
						WebElement InstrType = driver.findElement(By.xpath(firsthalfrow + j + fileInstType));
						String FInsType = InstrType.getText();
						System.out.println("---------------File Status for File " + TransName + " = " + FInsType);
					}
					// click the instruction if File name matches
					if (TransName.equalsIgnoreCase("01_Channel_MOPValid_Amount_Min100-Max100000.xml")) {
						System.out.println("File name matched *********");
						clickrow(driver,j, firsthalfrow, secondhalfrow);
						//To Select ViewMOPBased Distribution
						driver.findElement(By.id("btn_3")).click();
						
						  WebElement rowRecord =driver.findElement(By.xpath(firsthalfrow + j + secondhalfrow)); 
						  System.out.println("Row is  csdff" + rowRecord); Thread.sleep(2500); rowRecord.click();
						 Thread.sleep(5000); System.out.println(+j +"th row got clicked."); 
						 driver.findElement(By.xpath("//span[contains(text(),'Received Instructions')]")).click(); 
						 Thread.sleep(5000);
						 
					} else {
						System.out.println("selecting payment based on time");
						clickrow(driver,j, firsthalfrow, secondhalfrow);
						//To Select ViewMOPBased Distribution
						driver.findElement(By.id("btn_3")).click();
						
						  WebElement rowRecord =driver.findElement(By.xpath(firsthalfrow + j + secondhalfrow)); 
						  System.out.println("Row is  csdff" + rowRecord); Thread.sleep(2500); 
						  rowRecord.click();
						   Thread.sleep(5000); System.out.println(+j + "th row got clicked."); 
						   driver.findElement(By.xpath("//span[contains(text(),'Received Instructions')]")).click(); 
						   Thread.sleep(5000);
						 
					}
				}

			}

		}
				// To get column values in a list
					List<WebElement> valuesofcol = driver.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/tbody/tr"));
					for (int x = 1; x <= valuesofcol.size(); x++) {
						WebElement valforcolno = driver.findElement(By.xpath(firsthalfrow + x + secondhalfrow));
						String colvalforrow = valforcolno.getText();
						System.out.println("Value for col ID is -------" + colvalforrow);
						WebElement searchById = driver.findElement(By.xpath("//input[@id='searchBox']"));
						searchById.clear();
						searchById.sendKeys(colvalforrow);
						driver.findElement(By.xpath("//span[@id='SearchFontIcon']")).click();
						recordcount(driver, "//span[contains(text(),'records shown')]/preceding::span[1]");
						// Search by Id Verification
						WebElement idsearch = driver.findElement(By.xpath("//div[@class='ng-scope']/p/b"));
						String ISearch = idsearch.getText();
						if (ISearch.contains(colvalforrow)){
							System.out.println("------successfuly search is "+colvalforrow);
						}						
						searchVerify(colvalforrow, "//div[@class='ng-scope']/p/b");
						Thread.sleep(5000);
						driver.findElement(By.xpath("//input[@id='searchBtn']")).click();
						}
				
				//div[@class='listView FixHead dataGroupsScroll']/table/thead/tr   th   InstructionStatus
	}
	public int getIndexFromXpath(String xPath, String tagName, String value){
		WebElement ele = driver.findElement(By.xpath(xPath));
		int eleValue =0;
		int count = ele.findElements(By.tagName(tagName)).size();
		for (eleValue =0; eleValue<= count;eleValue++){
			String actualValue = ele.findElement(By.tagName(tagName)).getText();
			
			if(actualValue.contentEquals(value)){
				System.out.println(eleValue);
				return eleValue;
			}
		}
		return eleValue;
	}


}