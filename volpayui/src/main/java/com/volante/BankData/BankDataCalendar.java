package com.volante.BankData;

import java.io.File;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
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
import com.volante.locators.LocatorCalenderFromDate;
import com.volante.locators.LocatorGetDate;
import com.volante.locators.LocatorRadioButton;
import com.volante.locators.LocatorStatusBox;
import com.volante.locators.LocatorTextValidation;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ChangesLostPopUP;
import com.volante.volpayui.ReferenceDataDriver;

public class BankDataCalendar {


      static Sheet BRSheet;

@SuppressWarnings("unused")
public static void ExecuteCalendar( WebDriver wd,String Sheetname,String destFile) throws Exception 
    {
    	    try
    	    {
    	     BankDataObjectsList.BankDataObject();
    	     Workbook wb = Workbook.getWorkbook(new File(destFile));
             BRSheet=wb.getSheet(Sheetname);
             int rows_count=BRSheet.getRows();
             int newrowscount=rows_count-1;
             System.out.println("No of Rows in Calendar Page="+newrowscount);
             WebDriverWait wait = new WebDriverWait(wd, 30);
             WebElement BankData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(BankDataObjectsList.BankData)));
             WebElement BDView = wd.findElement(By.xpath("//*[@id='BankData']/a/i[2]"));
             Boolean BDviewed = BDView.isDisplayed();
             Boolean BDViewVal = BDView.getAttribute("class").contains("-plus");
             if ((BDViewVal)&&(BDviewed)){
            	 BDView.click();
            	 System.out.println("Clicked");
            	 Thread.sleep(2000);
             }
    	     WebElement CalendarMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(BankDataObjectsList.CalendarLinkVal)));
    	     CalendarMenu.click();
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
            	    Cell CalendarCode=BRSheet.getCell(2,row);
                    Cell CalendarName=BRSheet.getCell(3,row);
                    Cell CalendarValidTill=BRSheet.getCell(4,row);
                    Cell IsSaturday =BRSheet.getCell(5,row);
                    Cell IsSunday =BRSheet.getCell(6,row);
                    Cell IsMonday =BRSheet.getCell(7,row);
                    Cell IsTuesday =BRSheet.getCell(8,row);
                    Cell IsWednesday =BRSheet.getCell(9,row);
                    Cell IsThursday =BRSheet.getCell(10,row);
                    Cell IsFriday =BRSheet.getCell(11,row);
                    Cell Status=BRSheet.getCell(12,row);
                    //Cell EffectiveFromDate=BRSheet.getCell(1,row);
                    Cell EffectiveTillDate=BRSheet.getCell(14,row);
                    Cell HolidayDate=BRSheet.getCell(15,row);
                    Cell HolidayDescription=BRSheet.getCell(16,row);
                    
           // Execution Part          
        	LocatorByCSS.Click_CSS(wd, BankDataObjectsList.GridViewAddButton, "Clicked the Grid view button to create Calendar");
        	Thread.sleep(500);
        	LocatorTextValidation.Text_XPath(wd, BankDataObjectsList.AddnewText, "Onboarding New Calendar", "Text Value matched in Add New Calendar Page");
        	LocatorByID.Enter_ID(wd, BankDataObjectsList.CalendarCodeVal_C, CalendarCode.getContents(), "Entered the Calendar Code as "+CalendarCode.getContents());
        	Thread.sleep(500);
        	LocatorByID.Enter_ID(wd, BankDataObjectsList.CalendarNameVal, CalendarName.getContents(), "Entered the Calendar Name as "+CalendarName.getContents());
        	Thread.sleep(500);
        	LocatorGetDate.SelectDate(wd, BankDataObjectsList.EffectiveFromDateVal, "Selected the calendar valid data as today");
        	Thread.sleep(500);
        	LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.IsSaturdayVal, IsSaturday.getContents(), "IsSaturday selected as "+IsSaturday.getContents());
        	LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.IsSundayVal,   IsSunday.getContents(), "IsSunday selected as "+IsSunday.getContents());
        	LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.IsMondayVal, IsMonday.getContents(), "IsMonday selected as "+IsMonday.getContents());
        	LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.IsTuesdayVal, IsTuesday.getContents(), "IsTuesday selected as "+IsTuesday.getContents());
        	LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.IsWednesdayVal, IsWednesday.getContents(), "IsWednesday selected as "+IsWednesday.getContents());
        	LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.IsThursdayVal, IsThursday.getContents(), "IsThursday selected as "+IsThursday.getContents());
        	LocatorRadioButton.RadioEnter_name(wd, BankDataObjectsList.IsFridayVal, IsFriday.getContents(), "IsFriday selected as "+IsFriday.getContents());	
        	LocatorByName.DropDown_Text_Name(wd, BankDataObjectsList.StatusVal, Status.getContents(), "Select the Status as "+Status.getContents());
        	LocatorCalenderFromDate.FromDate(wd, BankDataObjectsList.EffectiveFromDateVal, "Selected the Effective From Date as today");
        	LocatorByID.Enter_ID(wd, BankDataObjectsList.EffectiveTillDateVal, EffectiveTillDate.getContents(), "Entered the Till Date as "+EffectiveTillDate.getContents());
        	if(HolidayDate.getContents().length() >0)
        	{
        	Thread.sleep(2000);
        	LocatorByID.Enter_ID(wd, BankDataObjectsList.HolidayDateVal, HolidayDate.getContents(), "Entered the Holiday Date as "+HolidayDate.getContents());
        	Thread.sleep(2000);
        	LocatorByID.Enter_ID(wd, BankDataObjectsList.HolidayDescriptionVal, HolidayDescription.getContents(), "Entered the Holiday Description as "+HolidayDescription.getContents());
        	}
        	LocatorByCSS.Click_CSS(wd, BankDataObjectsList.SubmitButton, "Save the details by Clicking the Submit button");
        	LocatorStatusBox.GetStatusByID(wd, BankDataObjectsList.SuccessMsg, "Calendar successfully added.", "Success Matched Successfully");
        	Thread.sleep(3000);
        	LocatorByLinks.Click_Link(wd, BankDataObjectsList.CalendarLinkVal, "Click the Calendar link");
        	ChangesLostPopUP.ChangesLost(wd,"Calendar ");
     	       }
    	    }
 catch (NoSuchElementException e) {
				
			} 
		     catch (Exception e) 
				{
					
				}
    }
}
