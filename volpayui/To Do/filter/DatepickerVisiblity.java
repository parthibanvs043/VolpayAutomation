package com.volante.filter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class DatepickerVisiblity {
	Logger logger = Logger.getLogger(this.getClass().getSimpleName());
	static SetStatus st = new SetStatus();
	static SetStatus stdata = new SetStatus();
	static Functional func = new Functional();
	@Parameters({ "strPath" })
	public static void datepickerenabled(WebDriver wd, String pr, String strTCNum, String strStep,
			int ScenarioNum, @Optional String strPath)
					throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {

		try {
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement DP=wd.findElement(By.xpath(pr));
			Thread.sleep(3000);
			Boolean dtPick = DP.isEnabled();
			System.out.println("---------------"+dtPick);
			if (dtPick==true){
				DP.click();
				
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
				stdata.Pass(wd, pr, strTCNum, strStep, ScenarioNum, strPath);
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
	public static void datepickerdisabled(WebDriver wd, String pr, String strTCNum, String strStep,
			int ScenarioNum, @Optional String strPath)
					throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {

		try {
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement DP=wd.findElement(By.xpath(pr));
			Thread.sleep(3000);
			Boolean dtPick = DP.isEnabled();
			System.out.println("-------------"+dtPick);
			if (!dtPick==true){
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName();
				GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
				stdata.Pass(wd, pr, strTCNum, strStep, ScenarioNum, strPath);
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
	public static void datepickerenabledData(WebDriver wd, String pr,String dt, String strTCNum, String strStep,
			int ScenarioNum, @Optional String strPath)
					throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException {

		try {
			wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebElement DP=wd.findElement(By.xpath(pr));
			Thread.sleep(3000);
			//Boolean dtPick = DP.isEnabled();
			//System.out.println("-1rer-------------"+dtPick);
			//if (dtPick==true){
				DP.click();
				DP.clear();
				System.out.println("sfdsafdsf"+dt);
				DP.sendKeys(dt);
				DP.sendKeys(Keys.ENTER);
				String Methodname = Thread.currentThread().getStackTrace()[1].getMethodName(); 
				GenerateReport.getmethodname(Methodname, VolPayDriver.scenario, strStep);
				stdata.Pass(wd, pr, strTCNum, strStep, ScenarioNum, strPath);
			//	}
					
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
}
