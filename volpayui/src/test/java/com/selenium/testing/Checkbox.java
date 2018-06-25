package com.selenium.testing;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Checkbox 
{

	WebDriver driver;

	// @SuppressWarnings("deprecation")
	@Test
	public void Payments() throws InterruptedException {

		System.setProperty(
				"webdriver.gecko.driver",
				"E:/VolPay_Automation/WorkingVolPay/VolPay_Mavan_Final/VOLPAY/src/main/resources/browser/Windows/geckodriver.exe");
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
		driver.findElement(
				By.xpath("html/body/div[2]/div/div/div[2]/form/div[3]/button"))
				.click();
		Thread.sleep(5000);
		    driver.findElement(By.linkText("Home")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.linkText("My Profile")).click();
		
		//List of Summary
		        //WebElement list = driver.findElement(By.id("paymentDashboard_statusSummary"));
		        //list.click();
		        driver.findElement(By.id("paymentDashboard_statusSummary_REPAIR")).click();
}
}