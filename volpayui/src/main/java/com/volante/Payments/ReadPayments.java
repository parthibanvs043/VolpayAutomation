package com.volante.Payments;

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

public class ReadPayments {

	// static String PaymentStatusAfterAccept;
	public static void PaymentProcessing(WebDriver wd, String pr,String dt, String strStep,String destFile,int Sheetname)
			throws InterruptedException, IOException {
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		try {
			/*String Actions = dt;
			Boolean RvcdInstr = wd.findElements(By.xpath(".//*[@id='ReceivedInstructions']/a/span")).size() != 0;
			System.out.println(" ------ Rvcdintrs is " + RvcdInstr);*/
			/* Read the Instructions in Received Instructions Page */
			WebDriverWait wait = new WebDriverWait(wd, 20);
			WebElement ClickReceivedInst = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='ReceivedInstructions']/a/span")));
			ClickReceivedInst.click();
			GenerateReport.test.log(LogStatus.PASS, strStep, ""+Methodname+" : Received Instruction Clicked");
			//System.out.println("instr clicked");
			Thread.sleep(1500);
			WebElement gridview = wd.findElement(By.id("btn_2"));
			String gridclass = gridview.getAttribute("class");
			// Check if grid view is enabled
			boolean gridV = gridclass.contains("disabledBtnColor");
			if (!gridV) {
				gridview.click();
				System.out.println("grid view enabled");
				GenerateReport.test.log(LogStatus.PASS, strStep, ""+Methodname+ " :Grid view enabled succesfully");
			}
			// Thread.sleep(1500);
			/* Get no of Instructions in Received Instructions Page */
			int Row_count = wd.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/tbody/tr")).size();
			System.out.println("Number Of Rows = " + Row_count);
			/* Get no of Columns in Received Instructions Page */
			int Col_count = wd.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr[1]/th")).size();
			System.out.println("Number Of Columns = " + Col_count);
			/* Loop the instructions in Received Instructions Page */
			for (int filerows = 1; filerows <= Row_count; filerows++) {
				WebElement InstrId = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+filerows+"]/td[2]"));
				WebElement InstructionType = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+filerows+"]/td[3]"));
				WebElement EntryDate = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+filerows+"]/td[4]"));
				WebElement PSACode = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+ filerows+"]/td[5]"));
				WebElement PymtStatus = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+filerows+"]/td[6]"));
				WebElement InstrStatus = wd.findElement(By.xpath("//table[contains(@class,'table-hover floatThead stickyheader')]/tbody/tr["+filerows+"]/td[7]"));
				String GetInstrID = InstrId.getText();
				String GetInstructionType = InstructionType.getText();
				String GetEntryDate = EntryDate.getText();
				String GetPSACode = PSACode.getText();
				String GetPymtStatus = PymtStatus.getText();
				String GetInstrStatus = InstrStatus.getText();
				System.out.println(" is " + GetInstrStatus);
				// System.out.println("---------------File Status for File =
				// " + InstrStatus);
				// get file details
				GenerateReport.test.log(LogStatus.PASS, strStep,
						"Instruction Deatils are  as follows : 1.GetInstrID =  " + GetInstrID
								+ " 2.GetInstructionType = " + GetInstructionType + " 3.GetEntryDate = "
								+ GetEntryDate + " 4.GetPSACode= " + GetPSACode + " 5.GetPaymentStatus = "
								+ GetPymtStatus + " 6.GetInstrStatus = " + GetInstrStatus + ".");
				//		InstrId.click();
				Thread.sleep(1500);
				String InstructionTypeText=InstructionType.getText();
				if(InstructionTypeText.equalsIgnoreCase("Customer Credit Transfer"))
				{
				   InstructionType.click();
				Thread.sleep(1500);
				/* Get the Payment Details */
				wd.findElements(By.id("tableExport"));
				// Thread.sleep(1500);
				/* Get the no of Payments in Payments Details tab */
				int PaymentCount = wd.findElements(By.xpath(".//*[@id='tab1']/tbody/tr")).size();
				System.out.println("Total No of Payments=" + PaymentCount);
				// To check if payment is present
				for (int paymentrows = 1; paymentrows <= PaymentCount; paymentrows++) {
					System.out.println("Payment no : -----------" +paymentrows);
					WebElement PaymentID = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[1]"));
					WebElement OriPaymentRef = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[2]"));
					WebElement MOP = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[3]"));
					WebElement ValueDate = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[4]"));
					WebElement ExecDate = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[5]"));
					WebElement Currency = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[6]"));
					WebElement PaymentAmount = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[7]"));
					WebElement PaymentStatus = wd.findElement(By.xpath(".//*[@id='tab1']/tbody/tr[" + paymentrows + "]/td[8]"));
					String GetPaymentID = PaymentID.getText();
					String GetOriPaymentRef = OriPaymentRef.getText();
					String GetMOP = MOP.getText();
					String GetValueDate = ValueDate.getText();
					String GetExecDate = ExecDate.getText();
					String GetCurrency = Currency.getText();
					String GetPaymentAmount = PaymentAmount.getText();
					String GetPaymentStatus = PaymentStatus.getText();
					//System.out.println("Payment Details= " + GetPaymentID + GetOriPaymentRef + GetMOP + GetValueDate+ GetExecDate + GetCurrency + GetPaymentAmount + GetPaymentStatus);
					GenerateReport.test.log(LogStatus.PASS, strStep,"Payment Deatils are  as follows : 1.GetPaymentID =  " + GetPaymentID+ " 2.GetOriPaymentRef = " + GetOriPaymentRef + " 3.GetMOP = " + GetMOP
									+ " 4.GetValueDate= " + GetValueDate + " 5.GetExecDate = " + GetExecDate
									+ " 6.GetCurrency = " + GetCurrency + "7.GetPaymentAmount = " + GetPaymentAmount
									+ "8.GetPaymentStatus = " + GetPaymentStatus + ".");
					Thread.sleep(3000);
					PaymentID.click();
					Thread.sleep(2500);
					// System.out.println("Action to be performed is =========="
					// + Actions);
					if (!(GetPymtStatus=="REJECTED")){				
					switch (dt) {
					case "ReadOnly":
						GenerateReport.test.log(LogStatus.PASS, "Read only Payments",
								"Payment Processing to Only read the payments completed");
						break;
					case "PaymentConfirmationAllStatus":
						Confirmation.AllConfirmationStatus(wd, "Raw message for " + paymentrows + " with status ", paymentrows,GetPaymentStatus, strStep);
						break;
					case "PaymentConfirmationWithStatus":
						Confirmation.PaymentConfirmation(wd, pr, GetPaymentStatus,strStep);
						break;
					case "AddNotes":
						AddingNotes.PmtAddnotes(wd,"Notes added for " + paymentrows + " with payment status as " + GetPaymentStatus,strStep);
						GenerateReport.test.log(LogStatus.PASS, "Add Notes","Payment Processing for Add Notes completed for " + paymentrows + " Payment");
						break;
					case "PaymentAccept":
						if (GetPaymentStatus.equalsIgnoreCase("DUPLICATE")) {
							PaymentAcceptReject.Paymentaccept(wd, "Payment ID", GetPaymentID, paymentrows, strStep);
							GenerateReport.test.log(LogStatus.PASS,"Accept Duplicate Payment and searched the payment eith updated Status ","Payment duplicate check completed successfuly");
						}
						break;
					case "PaymentReject":
						if (GetPaymentStatus.equalsIgnoreCase("DUPLICATE")) {
							PaymentAcceptReject.Paymentreject(wd, "Payment ID", GetPaymentID, paymentrows, strStep);
							GenerateReport.test.log(LogStatus.PASS, "Reject Duplicate Payment ","Duplicate Payment Rejected");
						}
						break;
					case "PaymentEvent":
						GetPaymentEventLog.PaymentEventlog(wd, strStep);
						GenerateReport.test.log(LogStatus.PASS, "Payment PaymentEventlog ",
								"Payment PaymentEventlog Completed successfully ");
						break;
					case "SystemInteraction":
						SystemInteractions.SystemInteraction(wd, strStep);
						GenerateReport.test.log(LogStatus.PASS, "Payment SystemInteraction ",
								"Payment SystemInteraction Completed successfully ");
						break;
					case "ExternalCommunications":
						Communications.ExternalCommunications(wd, strStep);
						//GenerateReport.test.log(LogStatus.PASS, "Payment External Communication","Payment External Communication Completed successfully ");
						break;
					case "AccountPosting":
						AccountPostings.AccountPosting(wd, strStep);
						GenerateReport.test.log(LogStatus.PASS, "Payment Account Posting ",
								"Payment Account Posting Completed successfully ");
						break;
					case "IssueInformation":
						IssueInformation.PaymentErrorInfo(wd, strStep);
						GenerateReport.test.log(LogStatus.PASS, "Payment PaymentErrorInfo ",
								"Payment PaymentErrorInfo Completed successfully ");
						break;
					case "LinkedMessage":
						LinkedMsgs.LinkedMessages(wd, strStep);
						GenerateReport.test.log(LogStatus.PASS, "Payment External Communication",
								"Payment External Communication Completed successfully ");
						break;
						//InterfaceOverride
					case "Override":
						InterfaceOverride.Override(wd, dt, GetPaymentStatus, strStep,destFile,Sheetname);
						GenerateReport.test.log(LogStatus.PASS, "Interface override","Interface overriden Completed successfully ");
						break;
					   default:
						break;
					}}
					// Switch to Payments Page
					WebElement fileid = wd.findElement(By.xpath("//span[@class ='ng-scope']/li/a"));
					System.out.println("fileid is =====" + fileid.getText());
					fileid.click();
				}
					
					 System.out.println("to go to next instruct");
					 
				}
				// System.out.println("No Payments found for this instruction
				// file");
				wd.findElement(By.xpath(".//*[@id='ReceivedInstructions']/a/span")).click();
				wd.findElement(By.cssSelector("div[tooltip='Refresh']")).click();
				Thread.sleep(1500);
			}
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
