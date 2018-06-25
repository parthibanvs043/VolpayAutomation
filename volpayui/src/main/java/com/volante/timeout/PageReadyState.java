package com.volante.timeout;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.LogStatus;
import com.volante.reports.GenerateReport;

public class PageReadyState {
	

public static void IsPageReady(WebDriver wd)
{
	try 
    { 
		  JavascriptExecutor js = (JavascriptExecutor)wd;
	      //Initially bellow given if condition will check ready state of page.
	     /* if (js.executeScript("return document.readyState").toString().equals("complete"))
	      { 
	         System.out.println("Page Is loaded.");
	       return; 
	      } */
	      
	      //This loop will rotate for 25 times to check If page Is ready after every 1 second.
	      //You can replace your value with 25 If you wants to Increase or decrease wait time.
	      for (int i=0; i<25; i++)
	      { 	          
	             Thread.sleep(1000);
	             System.out.println("Page Ready values="+i);
	             if (js.executeScript("return document.readyState").toString().equals("complete"))
	  	          { 
	            	 System.out.println("Page Ready values with Condition="+i);
	            	 break; 
	  	          }   
	        }
    }
	       catch (InterruptedException e) {
	    	   
	    	   GenerateReport.test.log(LogStatus.FAIL, "PageNotReady","PageNotReady");
	       } 
	       //To check page ready state.
	      
	      }
	      
}
