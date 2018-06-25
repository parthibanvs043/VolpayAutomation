package com.volante.volpayui;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.volante.reports.ReportGeneration;
import com.volante.utilities.GetScreenShot;

public class ChangesLostPopUP {
	public static void ChangesLost(WebDriver wd,String strStep) throws IOException {
		//String pr = "//div[@id='changesLostModal']/div/div";
		String screenShotPath = GetScreenShot.capture(wd, strStep);
		try {
			/*WebElement popupbody = wd.findElement(By.xpath("//div[@id='changesLostModal']/div/div/div[1]"));
			String HeaderText = popupbody.getText();
			//WebElement popupfooter = wd.findElement(By.xpath(pr+"/div[2]"));
*/			WebElement YesButton = wd.findElement(By.xpath("(//button[contains(text(),'Yes')])[1]"));
			if (YesButton.isDisplayed()){
				Thread.sleep(2000);
				ReportGeneration.test.pass(strStep + " Submit skipped. Hence Changes will be lost", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());				
				YesButton.click();
			}
			/*else {
				ReportGeneration.test.pass(strStep + "Changes submited ", MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
			}*/

		} catch (Exception e) {
			System.out.println("Exception=" + e.getMessage());
			ReportGeneration.test.fail(strStep, MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		}
	}

}
