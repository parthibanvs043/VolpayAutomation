package com.volante.instructions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Sorting {
	// Method to sort the colum
		public static void sortcolumn(WebDriver wd ,int colno, String colpath, String ColValue) {
			String ColToSort = ColValue;
			WebElement CValue = wd.findElement(By.xpath("html/body/div[2]/div/div[3]/div/div[2]/div/div[4]/div[7]/table/thead/tr/th[" + colno + "]"));
			String coltxt = CValue.getText();
			System.out.println("sValue = " + coltxt);
			// To Match with Column Value
			if (coltxt.contains(ColToSort)) {
				System.out.println("To sort Col " +coltxt);
				CValue.click();
				System.out.println(coltxt + "Got Clicked");
			}
		}

}
