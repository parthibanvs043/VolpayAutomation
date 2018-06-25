package com.selenium.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class PageValidation 
{
	WebDriver driver;

	// @SuppressWarnings("deprecation")
	@Test
	public void Payments() throws InterruptedException {

		System.setProperty(
				"webdriver.gecko.driver",
				"F:\\VolPayAutomation\\volpayui\\src\\main\\resources\\browser\\Windows\\geckodriver.exe");
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
		driver.findElement(By.xpath(".//*[@id='BankData']/a/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(".//*[@id='Calendar']/a")).click();
		Thread.sleep(3000);
		WebElement bodyText = driver.findElement(By.tagName("body"));
		String AllTextOnPage = bodyText.getText();
		System.out.println(AllTextOnPage);
		driver.findElement(By.xpath(".//*[@id='accordion']/div[1]/div[3]/div")).click();
		WebElement bodyTextnew = driver.findElement(By.tagName("body"));
		String AllTextOnPagenew = bodyTextnew.getText();
		System.out.println("Calendar Text Code="+AllTextOnPagenew);
		
		// User Management
		driver.findElement(By.xpath(".//*[@id='AdminPanel']/a/span")).click();
		driver.findElement(By.xpath(".//*[@id='UserManagement']")).click();
		WebElement USerMgmt = driver.findElement(By.tagName("body"));
		String USerMgmtnew = USerMgmt.getText();
		System.out.println("Calendar Text Code="+USerMgmtnew);
		
		
}
}