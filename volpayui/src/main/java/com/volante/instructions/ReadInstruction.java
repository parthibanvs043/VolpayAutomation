package com.volante.instructions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class ReadInstruction {

	public static void InstructionProcessing(WebDriver wd, String dt, String strStep)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			/*
			 * String firsthalfrow =
			 * "html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/tbody/tr[";
			 * String fileDetCol = "]/td[7]";
			 */
			WebDriverWait wait = new WebDriverWait(wd, 20);
			WebElement ClickReceivedInst = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ReceivedInstructions']/a/span")));
			ClickReceivedInst.click();
			GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " : Received Instruction Clicked");
			Thread.sleep(3000);
			Thread.sleep(1500);
			WebElement gridview = wd.findElement(By.id("btn_2"));
			String gridclass = gridview.getAttribute("class");
			// Check if grid view is enabled
			boolean gridV = gridclass.contains("disabledBtnColor");
			if (!gridV) {
				gridview.click();
				System.out.println("grid view enabled");
				GenerateReport.test.log(LogStatus.PASS, strStep, "" + Methodname + " :Grid view enabled succesfully");
			}
			// Read the Instructions
			// Get number of rows In table.
			int Row_count = wd
					.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/tbody/tr"))
					.size();
			System.out.println("Number Of Rows = " + Row_count);
			// Get number of columns In table.
			int Col_count = wd
					.findElements(
							By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr[1]/th"))
					.size();
			System.out.println("Number Of Columns = " + Col_count);
			//for (int i = 1; i <= Col_count; i++) {
				//Sorting.sortcolumn(wd, i,"html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr/th[" + i + "]","Entry Date & Time");
				for (int j = 1; j <= Row_count; j++) {
					WebElement InstrId = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+j+"]/td[2]"));
					WebElement InstructionType = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+j+"]/td[3]"));
					WebElement EntryDate = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+j+"]/td[4]"));
					WebElement PSACode = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+ j+"]/td[5]"));
					WebElement PaymentStatus = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+j+"]/td[6]"));
					WebElement InstrStatus = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+j+"]/td[7]"));
					String GetInstrID = InstrId.getText();
					String GetInstructionType = InstructionType.getText();
					String GetEntryDate = EntryDate.getText();
					String GetPSACode = PSACode.getText();
					String GetPaymentStatus = PaymentStatus.getText();
					String GetInstrStatus = InstrStatus.getText();
					System.out.println(" is " + GetInstrStatus);
					// System.out.println("---------------File Status for File =
					// " + InstrStatus);
					// get file details
					GenerateReport.test.log(LogStatus.PASS, strStep,
							"Instruction Deatils are  as follows : 1.GetInstrID =  " + GetInstrID
									+ " 2.GetInstructionType = " + GetInstructionType + " 3.GetEntryDate = "
									+ GetEntryDate + " 4.GetPSACode= " + GetPSACode + " 5.GetPaymentStatus = "
									+ GetPaymentStatus + " 6.GetInstrStatus = " + GetInstrStatus + ".");
					InstrId.click();
					// To get Accept & Reject
					Thread.sleep(1500);
					switch (dt) {
					case "ReadOnly":
						if (GetInstrStatus.equalsIgnoreCase("DUPLICATE")) {
							//InstrStatus.click();
							Thread.sleep(3000);
							String instrId = wd.findElement(By.xpath("//span[@tooltip='Instruction ID']")).getText();
							AcceptReject.Fileaccept(wd, instrId, strStep);
							GenerateReport.test.log(LogStatus.PASS,
									"Accept Duplicate File and searched the InstructionId with updated Status ",
									"Instruction duplicate check completed successfuly");
						}
						break;
					case "FileAccept":
						if (GetInstrStatus.equalsIgnoreCase("DUPLICATE")) {
							//InstrStatus.click();
							Thread.sleep(3000);
							String instrId = wd.findElement(By.xpath("//span[@tooltip='Instruction ID']")).getText();
							AcceptReject.Fileaccept(wd, instrId, strStep);
							GenerateReport.test.log(LogStatus.PASS,
									"Accept Duplicate File and searched the InstructionId with updated Status ",
									"Instruction duplicate check completed successfuly");
						}
						break;
					case "FileReject":
						if (GetInstrStatus.equalsIgnoreCase("DUPLICATE")) {
							//InstrStatus.click();
							Thread.sleep(3000);
							String instrId = wd.findElement(By.xpath("//span[@tooltip='Instruction ID']")).getText();
							AcceptReject.Filereject(wd, instrId, strStep);
							GenerateReport.test.log(LogStatus.PASS,
									"Reject Duplicate File and searched the InstructionId with updated Status ",
									"Instruction duplicate check completed successfuly");
						}
						break;
					default:
						break;
					}
					System.out.println("reached/......");
					WebElement fileid = wd.findElement(By.xpath("//span[@class ='ng-scope']/li/a"));
					System.out.println("fileid is =====" + fileid.getText());
					Thread.sleep(2000);
					fileid.click();
					Thread.sleep(2000);
					wd.findElement(By.cssSelector("div[tooltip='Refresh']")).click();
					System.out.println("to go to next instruct");
					

				}
				wd.findElement(By.xpath(".//*[@id='ReceivedInstructions']/a/span")).click();
				wd.findElement(By.cssSelector("div[tooltip='Refresh']")).click();
				Thread.sleep(2500);
			//}
		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Run time exception Occured :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,
					"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}

}
