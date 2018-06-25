package com.volante.filter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.volante.reports.GenerateReport;
import com.volante.status.SetStatus;
import com.volante.status.SetStatusforData;
import com.volante.volpayui.VolPayDriver;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class FilterByDate {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	static SetStatus st = new SetStatus();
	static SetStatusforData stdata = new SetStatusforData();
	// FilterByDate
		@Parameters({ "strPath" })
		public static void FilterDay(WebDriver wd, String pr, String dt, String strTCNum, String strStep,
				int ScenarioNum, @Optional String strPath)
						throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {

			try {
				// List View
				wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("List View Selection.......");
				WebElement BL =wd.findElement(By.xpath(pr));
				List<WebElement> val = BL.findElements(By.tagName("button"));
				for (WebElement status : val) {
					/*String btnval = status.getAttribute("id");
					System.out.println("Button values are ---------" +btnval);*/
					System.out.println("Values..... " + status.getText());
					String code = status.getText();
					System.out.println("Code is........." + code);
					if (code.contains(dt) ) {
						if (!status.isDisplayed()) {
							((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", val);
						}
						status.click();
						//System.out.println("Final Value ....." + val);
						String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
						GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
						st.Pass(wd, pr, strTCNum, strStep, ScenarioNum, strPath);
						break;
					}
				}
				

			} catch (NoSuchElementException e) {
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
				stdata.DataFail(wd, pr, dt, strTCNum, strStep, ScenarioNum, strPath);
			} catch (Exception e) {
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
				stdata.DataException(wd, pr, dt, strTCNum, strStep, ScenarioNum, strPath);

			}
		}

}
