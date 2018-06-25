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

public class RecordsBox {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	static SetStatus st = new SetStatus();
	static SetStatusforData stdata = new SetStatusforData();

	@Parameters({ "strPath" })
	public static void RecordByText_css(WebDriver wd, String pr, String dt, String strTCNum, String strStep, int ScenarioNum,
			@Optional String strPath)
					throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {

		try {
			// List View
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("List View Selection.......");
			// wd.findElement(By.id("btn_1")).click();
			List<WebElement> e = wd.findElements(By.xpath("//div[starts-with(@id,'listViewPanelHeading_')]"));
			// System.out.println("Size of Row"+e.size());
			for (int i = 0; i < e.size(); i++) {
				WebElement val = e.get(i).findElement(By.cssSelector(pr));
				System.out.println("Values..... " + val.getText());
				String code = val.getText();
				System.out.println("Code is........." + code);
				System.out.println("Code =" + code);
				if (code.contains(dt)) {
					if (!val.isDisplayed()) {
						((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", val);
					}
					System.out.println("Final Value ....." + val);
					String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
					GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
					st.Pass(wd, pr, strTCNum, strStep, ScenarioNum,strPath);
					break;
				}
			}
			

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
			stdata.DataFail(wd, pr, dt, strTCNum, strStep, ScenarioNum, strPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
			stdata.DataException(wd, pr, dt, strTCNum, strStep, ScenarioNum, strPath);

		}
	}
	
}