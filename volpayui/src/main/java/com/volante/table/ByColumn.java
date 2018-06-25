package com.volante.table;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import com.volante.utilities.GetScreenShot;

public class ByColumn {
	public static void ByColumnName(WebDriver wd, String pr, String dt, String strStep)
			throws InterruptedException, IOException {
		wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		try {
			int rows = wd.findElements(By.xpath(pr)).size();
			// System.out.println("Total No of rows in table =" + rows);
			// To check if payment is present & Select the payment
			for (int r = 1; r <= rows; r++) {
				WebElement col = wd.findElement(By.xpath(pr + "[" + r + "]/td[1]/span"));
				String colval = col.getText();
				if (colval.equalsIgnoreCase(dt)) {
					col.click();
					System.out.println(" val clicked for ***" + col);
					GenerateReport.test.log(LogStatus.PASS, strStep,
							"" + Methodname + " : Column Value Selected Successfully");
					break;
				}
			}
		} catch (NoSuchElementException e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, " Failed to find element :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		} catch (Exception e) {
			GenerateReport.test.log(LogStatus.FAIL, strStep, "Run time exception Occured :- " + e.getMessage());
			String screenShotPath = GetScreenShot.capture(wd, strStep);
			GenerateReport.test.log(LogStatus.FAIL,"Fail-1 Snapshot below: " + GenerateReport.test.addScreenCapture(screenShotPath));
		}
	}

	/*
	 * //Need to updated public static void VerifyByColumnName(WebDriver wd,
	 * String pr, String dt, String module,String strTCNum, String strStep, int
	 * ScenarioNum) throws InterruptedException, IOException {
	 * wd.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); try { int
	 * rows = wd.findElements(By.xpath(pr)).size(); System.out.println(
	 * "Total No of rows in table =" + rows); // To check if payment is present
	 * & Select the payment for (int r = 1; r <= rows; r++) {
	 * System.out.println(" loop for row " +r); WebElement col =
	 * wd.findElement(By.xpath(pr+"["+r+"]/td["+module+"]/span")); String colval
	 * = col.getText(); System.out.println(" values for first col is ====="
	 * +colval); if (colval.equalsIgnoreCase(dt)) { col.click();
	 * System.out.println(" val clicked for ***" +col);
	 * GenerateReport.test.log(LogStatus.PASS, strStep,
	 * "Column Value is present in the specified column number" +module); break;
	 * } } } catch (NoSuchElementException e) {
	 * GenerateReport.test.log(LogStatus.FAIL, "Unable to find the module",
	 * e.getMessage()); String screenShotPath = GetScreenShot.capture(wd,
	 * "Failednoelement"); GenerateReport.test.log(LogStatus.FAIL,
	 * "Fail-1 Snapshot below: " +
	 * GenerateReport.test.addScreenCapture(screenShotPath)); } catch (Exception
	 * e) { GenerateReport.test.log(LogStatus.FAIL, "Run time exception",
	 * e.getMessage()); String screenShotPath = GetScreenShot.capture(wd,
	 * "Failednoelement"); GenerateReport.test.log(LogStatus.FAIL,
	 * "Fail-1 Snapshot below: " +
	 * GenerateReport.test.addScreenCapture(screenShotPath)); } }
	 */
}
