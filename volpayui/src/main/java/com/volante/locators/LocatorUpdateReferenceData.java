/*package com.volante.locators;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class UpdateReferenceData
{  

public static void ListView(WebDriver wd, String pr, String dt, String strTCNum, String strStep, int ScenarioNum) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
		 
		try {
			   //List View
			    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				System.out.println("List View Selection.......");
				// wd.findElement(By.id("btn_1")).click();
			    List<WebElement> e=wd.findElements(By.xpath("//div[starts-with(@id,'listViewPanelHeading_')]"));
			     //System.out.println("Size of Row"+e.size());
			    for(int i=0;i<e.size();i++)
			    {
				 WebElement val=e.get(i).findElement(By.cssSelector(pr));
				 System.out.println("Values..... "+val.getText());
				 String code=val.getText();
				 System.out.println("Code is........."+code);
				 System.out.println("Code ="+code);
				if(code.contains(dt))
				{   
					if(!val.isDisplayed())
					{
						((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", val);
					}
					val.click();
					System.out.println("Final Value ....."+val);
					break;
			}
			}
			    
			      GenerateReport.test.log(LogStatus.PASS, strStep,"Value Selected Successfully");
		              
			} 
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
		}
}

public static void GridView(WebDriver wd, String pr, String dt, String strTCNum, String strStep, int ScenarioNum) throws InterruptedException, RowsExceededException, BiffException, WriteException, IOException{
	 
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    Thread.sleep(3000);
	try {
		   //Grid View

  	   System.out.println("Grid View=");  
  	   System.out.println("Grid View Selection.......");
  	   wd.findElement(By.id("btn_2")).click();
       List<WebElement> row=wd.findElements(By.xpath("//tr[starts-with(@id,'displayingWindow_')]"));
	   System.out.println("Size of Row"+row.size());
	   for(int i=0;i<row.size();i++)
	   {
		   System.out.println("Coming into loop..");
		List<WebElement> col=row.get(i).findElements(By.xpath(pr));
		for(WebElement a:col)
		{
			 System.out.println("Coming into Next loop..");
			System.out.println("Selected Before Text Value..."+a.getText());
			if(a.getText().equals(dt))
			{
				System.out.println("Selected Text Value..."+a.getText());
				if(!a.isDisplayed())
				{
					((JavascriptExecutor) wd).executeScript("arguments[0].scrollIntoView();", a);	
				}
				Thread.sleep(1000);
			    a.click();
			    break;
		}
	  }
		}
	          
		      GenerateReport.test.log(LogStatus.PASS, strStep,"Value Selected Successfully");
	              
		} 
	catch (NoSuchElementException e) {
		// TODO Auto-generated catch block
		
		GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		
		GenerateReport.test.log(LogStatus.FAIL, strStep,e.getMessage());
	}
}
}
*/