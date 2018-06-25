package com.volante.paymentworking;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class testing {
	
	@Test
	public void Payments() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver",
				"E:\\VolPaySuite\\VolPayUIAutomation\\volpayui\\src\\main\\resources\\browser\\Windows\\geckodriver.exe");
		Thread.sleep(3000);
		WebDriver wd = new FirefoxDriver();
		wd.get("https://localhost:8443/VolPayHubUI/");
		Thread.sleep(3000);
		wd.manage().window().maximize();
		Thread.sleep(3000);
		wd.findElement(By.id("username")).sendKeys("admin");
		Thread.sleep(3000);
		wd.findElement(By.id("password")).sendKeys("admin@123");
		Thread.sleep(3000);
		wd.findElement(By.xpath("html/body/div[2]/div/div/div[2]/form/div[3]/button")).click();
		Thread.sleep(3000);
		System.out.println("Login");
		wd.findElement(By.xpath("//span[contains(text(),'Received Instructions')]")).click();
		System.out.println("Clicked received instr");
		Thread.sleep(3000);
		// To Select grid View
		wd.findElement(By.id("btn_2")).click();
		Thread.sleep(3000);
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {

			Boolean RvcdInstr = wd.findElements(By.xpath(".//*[@id='ReceivedInstructions']/a/span")).size() != 0;
			System.out.println(" ------ Rvcdintrs is " + RvcdInstr);
			/* Read the Instructions in Received Instructions Page */
			WebDriverWait wait = new WebDriverWait(wd, 20);
			WebElement ClickReceivedInst = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ReceivedInstructions']/a/span")));
			ClickReceivedInst.click();
			System.out.println("instr clicked");
			Thread.sleep(1500);
			WebElement gridview = wd.findElement(By.id("btn_2"));
			String gridclass = gridview.getAttribute("class");
			// Check if grid view is enabled
			boolean gridV = gridclass.contains("disabledBtnColor");
			if (!gridV) {
				gridview.click();
				System.out.println("grid view enabled");
			}
			// Thread.sleep(1500);
			/* Get no of Instructions in Received Instructions Page */
			int Row_count = wd
					.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/tbody/tr"))
					.size();
			System.out.println("Number Of Rows = " + Row_count);
			/* Get no of Columns in Received Instructions Page */
			int Col_count = wd
					.findElements(
							By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr[1]/th"))
					.size();
			System.out.println("Number Of Columns = " + Col_count);
			/* Loop the instructions in Received Instructions Page */
			for (int filerows = 1; filerows <= Row_count; filerows++) {
				WebElement test = wd
						.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/tbody/tr["
								+ filerows + "]/td[2]"));
				Thread.sleep(1500);
				test.click();
				Thread.sleep(1500);
				/* Get the Payment Details */
				wd.findElements(By.id("tableExport"));
				// Thread.sleep(1500);
				/* Get the no of Payments in Payments Details tab */
				int PaymentCount = wd.findElements(By.xpath(".//*[@id='tab1']/tbody/tr")).size();
				System.out.println("Total No of Payments=" + PaymentCount);
				// To check if payment is present
				for (int paymentrows = 1; paymentrows <= PaymentCount; paymentrows++) {
					WebElement PaymentID = wd
							.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[1]"));
					WebElement OriPaymentRef = wd
							.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[2]"));
					WebElement MOP = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[3]"));
					WebElement ValueDate = wd
							.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[4]"));
					WebElement ExecDate = wd
							.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[5]"));
					WebElement Currency = wd
							.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[6]"));
					WebElement PaymentAmount = wd
							.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[7]"));
					WebElement PaymentStatus = wd
							.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[8]"));
					String GetPaymentID = PaymentID.getText();
					String GetOriPaymentRef = OriPaymentRef.getText();
					String GetMOP = MOP.getText();
					String GetValueDate = ValueDate.getText();
					String GetExecDate = ExecDate.getText();
					String GetCurrency = Currency.getText();
					String GetPaymentAmount = PaymentAmount.getText();
					String GetPaymentStatus = PaymentStatus.getText();
					System.out.println("Payment Details= " + GetPaymentID + GetOriPaymentRef + GetMOP + GetValueDate
							+ GetExecDate + GetCurrency + GetPaymentAmount + GetPaymentStatus);
					PaymentID.click();
				}
			}
		}
		// Need to updated

		catch (NoSuchElementException e) {
			System.out.println("no elem found");
		} catch (Exception e) {
			System.out.println("Run time exp");
		}
	}
	

}