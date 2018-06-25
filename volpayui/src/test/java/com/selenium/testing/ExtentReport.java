package com.selenium.testing;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.utility.CaptureScreenShot;
 
public class ExtentReport {
 
	ExtentReports reports;
	ExtentHtmlReporter htmlReporter;
	ExtentTest test;
	WebDriver driver;
 
	@BeforeTest
	public void startTest() {
		reports = new ExtentReports();
 
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//extentreport.html");
		reports.attachReporter(htmlReporter);
 
		reports.setSystemInfo("Machine", "Anshul-772G");
		reports.setSystemInfo("Env", "DevOps");
		reports.setSystemInfo("Build", "Integration");
		reports.setSystemInfo("Browser", "IE");
	}
 
	@BeforeMethod
	public void openApplication() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "E:\\SeleniumNewSuite\\volpayui\\src\\main\\resources\\browser\\Windows\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://localhost:8443/VolPayHubUI/");
		Thread.sleep(3000);
	}
 
	@Test
	public void verifyTittleTest() throws IOException {
		String screenShot = CaptureScreenShot.captureScreen(driver, "Login.png");
		test = reports.createTest("verifyTittleTest");
		String expetedTitle = "VolPay";
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, expetedTitle);
		test.fail("details").addScreenCaptureFromPath(screenShot);
	}
 
	@Test(dependsOnMethods={"verifyTittleTest"})
	public void Login() throws InterruptedException, IOException {
		String screenShot = CaptureScreenShot.captureScreen(driver, "Loginsdfsfsd.png");
		test = reports.createTest("Login"); 
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("admin@1234");
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);
		test.log(Status.FAIL, "Login Failed");
		test.fail("details").addScreenCaptureFromPath(screenShot);
		
		
	}
 
/*	@AfterMethod
	public void setTestResult(ITestResult result) throws IOException {
 
		String screenShot = CaptureScreenShot.captureScreen(driver, CaptureScreenShot.generateFileName(result));
 
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getName());
			test.log(Status.FAIL,result.getThrowable());
			test.fail("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName());
			test.pass("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test Case : " + result.getName() + " has been skipped");
		}
 
		reports.flush();
		driver.close();
	}
	*/
 
	@AfterTest
	public void endTest() {
		reports.flush();
	}
}