package com.volante.paymentworking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AddNotes {
	static WebDriver driver;
	
	public void instrnotes (WebDriver wd , String notes , int rowC ,int colC) throws InterruptedException{
		String firsthalfrow = "//div[@class='listView FixHead dataGroupsScroll']/table/tbody/tr[";
		String secondhalfrow = "]/td[2]";
		String fileDetCol = "]/td[7]";
		String MOPCol = "]/td[7]";
		String fileInstType = "]/td[3]";
		String filePSA = "]/td[5]";
		String TransdetPath = "]/td/pre";
		String PymtCount = "]/td[6]/div/span[1]";
		for (int i = 1; i <= colC; i++) {
			
			PaymentProcessing.sortcolumn(driver,i, "//div[@class='listView FixHead dataGroupsScroll']/table/thead/tr/th[" + i + "]","Entry Date & Time");
		}
				for (int j = 1; j <= rowC; j++) {
					WebElement rowRecord = driver.findElement(By.xpath(firsthalfrow + j + secondhalfrow));
						System.out.println("Row is  csdff" + rowRecord);
						//get file status 
						WebElement InstrStatus = driver.findElement(By.xpath(firsthalfrow + j + fileDetCol));
						String FStatus = InstrStatus.getText();
						System.out.println("---------------File Status for File " +  " = " + FStatus);
						Thread.sleep(2500);
						rowRecord.click();
						Thread.sleep(5000);
						System.out.println(+j + "th row got clicked.");
					System.out.println("instruction clicked");
					Thread.sleep(5000);
					WebElement addbtn = driver.findElement(By.xpath("//*[contains(text(),'Add Notes')]"));
					if(addbtn.isDisplayed()){
					addbtn.click();
					System.out.println("Add notes clicked");
					driver.findElement(By.id("Notes")).sendKeys("Note added as This is the "+j+"th instruction"+" with "+FStatus+" Status");
					System.out.println("Note added as This is the "+j+"th instruction"+" with "+FStatus+" Status");
					driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
					Thread.sleep(2000);
					//To verify notes added
					// to do 
					driver.findElement(By.xpath("//span[contains(text(),'Received Instructions')]")).click();
					Thread.sleep(3000);
					}
					else {
						System.out.println(" no Add Notes Button ");
						driver.findElement(By.xpath("//span[contains(text(),'Received Instructions')]")).click();
						Thread.sleep(3000);
					}
				}	

		}
				
	
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
	// To get record count call the method
	PaymentProcessing.recordcount(driver,"//span[contains(text(),'records shown')]/preceding::span[1]");
	// Get number of rows In table.
	int rowCount = driver.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/tbody/tr")).size();
	System.out.println("No of Rows in a Page...." + rowCount);
	// Get number of columns In table.
	int Colcount = driver.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr/th")).size();
	System.out.println("Number Of Columns = " + Colcount);
	instrnotes(driver, "notes added ", rowCount, Colcount);
	 }
}