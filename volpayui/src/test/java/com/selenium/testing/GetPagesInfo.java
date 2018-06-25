package com.selenium.testing;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.excel.OutputtoFile;
import com.volante.reports.GenerateReport;


public class GetPagesInfo 
{
	       static OutputtoFile out = new OutputtoFile();
	       static WebDriver wd;
@Parameters({ "strPath" })
	public static void ReadPage(@Optional String strPath) throws RowsExceededException, BiffException, WriteException, IOException
	{
	try
	{
	      WebElement bodyTextnew = wd.findElement(By.tagName("body"));
	      String AllTextOnPagenew = bodyTextnew.getText();
	      GenerateReport.getmethodname();
		  GenerateReport.test.log(LogStatus.PASS,"Value Selected Successfully");
	      out.writeoutputtofile(strPath,AllTextOnPagenew);
 } 
	catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		GenerateReport.getmethodname();
		GenerateReport.test.log(LogStatus.FAIL,e.getMessage());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		GenerateReport.getmethodname();
		GenerateReport.test.log(LogStatus.FAIL,e.getMessage());
	}
	}
}
