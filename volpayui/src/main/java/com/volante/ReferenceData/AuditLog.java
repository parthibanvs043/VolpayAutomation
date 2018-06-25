package com.volante.ReferenceData;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.volante.BankData.BankDataObjectsList;
import com.volante.reports.ReportGeneration;
import com.volante.volpayui.ReferenceDataDriver;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class AuditLog {
	static Sheet BRSheet;

	public static void AuditLogDetails(WebDriver wd, String Sheetname, String destFile) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			BankDataObjectsList.BankDataObject();
			Workbook wb = Workbook.getWorkbook(new File(destFile));
			BRSheet = wb.getSheet(Sheetname);
			int rows_count = BRSheet.getRows();
			int newrowscount = rows_count - 1;
			System.out.println("No of Rows in =" + newrowscount);

			for (int row = 1; row <= newrowscount; row++) {
				Cell TestName = BRSheet.getCell(1, row);
				ReportGeneration.test = ReportGeneration.extent.createTest(TestName.getContents())
						.assignCategory(ReferenceDataDriver.Sheetname);
				Cell Module = BRSheet.getCell(2, row);
				Cell SubModule = BRSheet.getCell(3, row);
				Cell SearchKey = BRSheet.getCell(4, row);
				Cell Expected = BRSheet.getCell(5, row);
				WebElement moduleName = wd.findElement(By.cssSelector("li[id='" + Module.getContents() + "']"));
				Boolean Moduleviewed = moduleName.isDisplayed();
				Boolean ModuleAttVal = moduleName.getAttribute("class").contains("-plus");
				if ((ModuleAttVal) && (Moduleviewed)) {
					moduleName.click();
					System.out.println("Clicked");
					Thread.sleep(2000);
				}
				Thread.sleep(5000);
				wd.findElement(By.cssSelector("a[title='" + SubModule.getContents() + "']")).click();
				Thread.sleep(5000);
				wd.findElement(By.cssSelector("button[tooltip='Grid View']")).click();
				Thread.sleep(5000);
				wd.findElement(By.cssSelector("button[tooltip='Filter']")).click();
				Thread.sleep(5000);
				WebElement e1 = wd.findElement(By.cssSelector("input[name='keywordSearch']"));
				e1.sendKeys(SearchKey.getContents());
				Thread.sleep(5000);
				wd.findElement(By.cssSelector("button[tooltip='Search']")).click();
				Thread.sleep(5000);
				wd.findElement(By.xpath("//td[starts-with(@id,'CalendarCode_')]")).click();
				Thread.sleep(6000);
				List<WebElement> auditlog = wd.findElements(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div[5]/div[2]/ul/li"));
				System.out.println((auditlog.size()));
				Thread.sleep(3000);
				JavascriptExecutor js = (JavascriptExecutor) wd;
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				for (int i = 1; i <= auditlog.size(); i++) {
					WebElement log = wd.findElement(By.xpath("//li[" + i + "]/div/span/u"));
					String logtext = log.getText();
					System.out.println("logtext=" + logtext);
					Thread.sleep(3000);
					log.click();
					Thread.sleep(3000);
					WebElement close = wd.findElement(By.xpath("//button[contains(text(),'×')]"));
					Thread.sleep(3000);
					close.click();
					System.out.println("log value =" + log.getText());
				}
			}
		} catch (NoSuchElementException e) {

		} catch (Exception e) {

		}

	}
}