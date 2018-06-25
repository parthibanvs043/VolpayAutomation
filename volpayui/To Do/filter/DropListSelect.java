package com.volante.filter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;

import com.volante.reports.GenerateReport;
import com.volante.status.SetStatus;
import com.volante.status.SetStatusforData;
import com.volante.volpayui.VolPayDriver;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class DropListSelect {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	static SetStatus st = new SetStatus();
	static SetStatusforData stdata = new SetStatusforData();

	public static void DropListText_Xpath(WebDriver wd, String pr, String dt, String strTCNum, String strStep,
			int ScenarioNum, @Optional String strPath)
					throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {
		try {
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement ul = wd.findElement(By.xpath(pr));
			List<WebElement> DropList = ul.findElements(By.tagName("li"));
			for (WebElement drop : DropList) {
				System.out.println("List text is ------" + drop.getText());
				String valText = drop.getText();
				System.out.println("Val text is   " + valText);
				Thread.sleep(3000);
				if (drop.getText().equals(dt)) {
					drop.click();
					Thread.sleep(2000);
        	        String Methodname=Thread.currentThread().getStackTrace()[1].getMethodName();
        	        GenerateReport.getmethodname(Methodname,VolPayDriver.scenario,strStep);
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
