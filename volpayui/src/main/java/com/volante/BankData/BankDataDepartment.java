package com.volante.BankData;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.volante.locators.LocatorByCSS;
import com.volante.locators.LocatorByID;
import com.volante.locators.LocatorByLinks;
import com.volante.locators.LocatorByName;
import com.volante.locators.LocatorGetDate;
import com.volante.locators.LocatorRadioButton;
import com.volante.locators.LocatorStatusBox;
import com.volante.locators.LocatorTextValidation;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class BankDataDepartment 
{
	
	   static Sheet BRSheet;

public static void ExecuteDepartment( WebDriver wd,String Sheetname,String destFile)  throws Exception 
	{
		    try
		    {
		    	 BankDataObjectsList.BankDataObject();
	    	     Workbook wb = Workbook.getWorkbook(new File(destFile));
	             BRSheet=wb.getSheet(Sheetname);
	        int rows_count=BRSheet.getRows();
	        int newrowscount=rows_count-1;
	        System.out.println("No of Rows in Region Page="+newrowscount);
	        WebDriverWait wait = new WebDriverWait(wd, 30);
	       // WebElement BankData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(BankDataObjectsList.BankData)));
	        WebElement BDView = wd.findElement(By.xpath("//*[@id='BankData']/a/i[2]"));
            Boolean BDviewed = BDView.isDisplayed();
            Boolean BDViewVal = BDView.getAttribute("class").contains("-plus");
            if ((BDViewVal)&&(BDviewed)){
           	 BDView.click();
           	 System.out.println("Clicked");
           	 Thread.sleep(2000);
            }
		    WebElement Department = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(BankDataObjectsList.DepartmentLinkVal)));
		    Department.click();
			WebElement GridView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BankDataObjectsList.GridView)));
			 String gridclass = GridView.getAttribute("class");
			 boolean gridV = gridclass.contains("disabledBtnColor");
				if (!gridV) 
				{
					GridView.click();
					System.out.println("grid view enabled");
				}
	        Thread.sleep(3000);
		    for (int row=1; row<=newrowscount; row++)
		       {    
			        Cell TestName=BRSheet.getCell(1,row);
			        ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents()).assignCategory(ReferenceDataDriver.Sheetname);
	       	        Cell DepartmentCode=BRSheet.getCell(2,row);
	                Cell DepartmentName=BRSheet.getCell(3,row);
	                Cell CanReroute=BRSheet.getCell(4,row);
	                Cell Status=BRSheet.getCell(5,row);
	               //Cell EffectiveFromDate=BRSheet.getCell(6,row);
	                Cell EffectiveTillDate=BRSheet.getCell(7,row);
	                // Execution Part          
	                LocatorByCSS.Click_CSS(wd, BankDataObjectsList.GridViewAddButton, "Clicked the Grid view button to create Department");
	                Thread.sleep(2000);
	                LocatorTextValidation.Text_XPath(wd, BankDataObjectsList.AddnewText, "Onboarding New Department", "Text Value matched in Add New Department Page");
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.DepartmentCodeVal, DepartmentCode.getContents(), "Entered the Department Code as "+DepartmentCode.getContents());
	                Thread.sleep(2000);
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.DepartmentNameVal, DepartmentName.getContents(), "Entered the Department Name as "+DepartmentName.getContents());
	                Thread.sleep(3000);
	                LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.CanReroute, CanReroute.getContents(), "CanReroute set as "+CanReroute.getContents());
	                LocatorByName.DropDown_Text_Name(wd, BankDataObjectsList.StatusVal, Status.getContents(), "Select the status as "+Status.getContents());
	                LocatorGetDate.SelectDate(wd, BankDataObjectsList.EffectiveFromDateVal, "Selected the Effective From Date as today");
	                LocatorByID.Enter_ID(wd, BankDataObjectsList.EffectiveTillDateVal, EffectiveTillDate.getContents(), "Entered the Till Date as "+EffectiveTillDate.getContents());
	                LocatorByCSS.Click_CSS(wd, BankDataObjectsList.SubmitButton, "Save the details by Clicking the Submit button");
	                LocatorStatusBox.GetStatusByID(wd, BankDataObjectsList.SuccessMsg, "Department successfully added.", "Success Message Matched Successfully");
	            	Thread.sleep(3000);
	                LocatorByLinks.Click_Link(wd, BankDataObjectsList.DepartmentLinkVal, "Click the Department link");
	                ChangesLostPopUP.ChangesLost(wd,"Department ");
	                Thread.sleep(2000);
	           }
		    }
		    catch (NoSuchElementException e) {
				
			} 
		     catch (Exception e) 
				{
					
				}
}
}
