package com.volante.filter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.volante.excel.WriteOutput;
import com.volante.reports.GenerateReport;
import com.volante.status.Functional;
import com.volante.status.SetStatus;
import com.volante.volpayui.VolPayDriver;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class SearchCancel {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	static SetStatus st = new SetStatus();
	static SetStatus stdata = new SetStatus();
	static Functional func = new Functional();
	@Parameters({ "strPath" })
	public static void SearchVisible(WebDriver wd, String pr, String strTCNum, String strStep,
			int ScenarioNum, @Optional String strPath)
					throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {

		try {
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement SC=wd.findElement(By.xpath(pr));
			Thread.sleep(3000);
			Boolean search = SC.isEnabled();
			System.out.println("----------------------"+search);
			if (search==true){
				
				SC.click();
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
				stdata.Pass(wd, pr, strTCNum, strStep, ScenarioNum, strPath);
				}
			else if(search==false){
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
				//func.functionalFail(wd, pr, strTCNum, strStep, ScenarioNum, strPath, "Button is disabled");
				WriteOutput.writeResult(strPath,strTCNum ,strStep,"Fail",ScenarioNum,"Button disabled");
			}
		
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
			//func.functionalFail(wd, pr, strTCNum, strStep, ScenarioNum, strPath, "No Element Found");
			WriteOutput.writeResult(strPath,strTCNum ,strStep,"Fail",ScenarioNum,"No Element");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
			//func.functionalExcep(wd, pr, strTCNum, strStep, ScenarioNum, strPath,"Unable to throw exception");
			WriteOutput.writeResult(strPath,strTCNum ,strStep,"Fail",ScenarioNum,"other exception");

		}
	}
	@Parameters({ "strPath" })
	public static void CancelVisible(WebDriver wd, String pr, String strTCNum, String strStep,
			int ScenarioNum, @Optional String strPath)
					throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {

		try {
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement CC=wd.findElement(By.xpath(pr));
			Boolean cancel = CC.isEnabled();
			System.out.println("----------------------"+cancel);
			if (cancel==true){
				
				CC.click();
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
				stdata.Pass(wd, pr, strTCNum, strStep, ScenarioNum, strPath);
			}
		
		
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
			stdata.Fail(wd, pr, strTCNum, strStep, ScenarioNum, strPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
			GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
			stdata.Exception(wd, pr, strTCNum, strStep, ScenarioNum, strPath);

		}
	}
}
