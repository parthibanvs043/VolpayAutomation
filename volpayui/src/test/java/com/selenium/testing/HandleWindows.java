package com.selenium.testing;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HandleWindows 
{
  public static void Handlingwindow(WebDriver wd)
     {
	        String Parentwindow = wd.getWindowHandle();
	        Set<String> ChildWindow = wd.getWindowHandles();
	         for(String hnd:ChildWindow)
	         {
	        	 if(hnd.equals(Parentwindow))
	        	 {
	        		 wd.switchTo().window(hnd);
	        		 System.out.println("Print Title name:="+wd.getTitle());
	        	 }
	        	 else
	        	 {
	        		 System.out.println("No windows to handle");
	        	 }
	         } 
     }
public static void Handletab(WebDriver wd,String url) throws AWTException, InterruptedException
  {
	      /* String windowHandle = wd.getWindowHandle();
	       System.out.println("Current windowhandler before create tab : " + windowHandle);
	       WebElement bodyElement = wd.findElement(By.tagName("body"));
	  Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);
		  String OperatorwindowHandle = wd.getWindowHandle();
	       System.out.println("Operator windowhandler before create tab : " + OperatorwindowHandle);
		//ArrayList<String> tabs = new ArrayList<String> (wd.getWindowHandles());
        //System.out.println("Total No of tabs Present="+tabs.size());
		 
		 bodyElement.sendKeys(Keys.CONTROL+"2");
		  //wd.get("http://www.google.com");
		
		//wd.switchTo().window(tabs.get(1)); 
        

            wd.get(url);
            wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		wd.manage().window().maximize();
            System.out.println("Going to Super Admin login");
            //Switch to the old tab using Ctrl + Tab 
            //wd.switchTo().window(windowHandle);
            //wd.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
            //wd.switchTo().defaultContent();
*/
	 /* String oldTab=wd.getWindowHandle();
	  System.out.println("Admin windowhandler before create tab : " + oldTab);
	  Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_CONTROL); 
		r.keyPress(KeyEvent.VK_T); 
		r.keyRelease(KeyEvent.VK_CONTROL); 
		r.keyRelease(KeyEvent.VK_T);
	     ArrayList<String> newTab = new ArrayList<String>(wd.getWindowHandles());
	     System.out.println("Total No of tabs Present="+newTab.size());
	     System.out.println("Operator windowhandler before create tab : " + oldTab);
	        newTab.remove(oldTab);
	        wd.switchTo().window(newTab.get(1));
	        Thread.sleep(2000);
	        wd.get(url);
	        System.out.println("Coming back to Admin Window");
	                 wd.switchTo().window(oldTab);
	   */
	
	  /*
	  String Adminwindow = wd.getWindowHandle();
	  System.out.println("Admin WindowHandler : " + Adminwindow);
	  
	  WebElement bodyElement = wd.findElement(By.tagName("body"));
	  for(int i=0;i<6;i++)
	  {
		  bodyElement.sendKeys(Keys.CONTROL + "t");
		  Thread.sleep(1000);
		  System.out.println("Open a newtab.");
	  }
	  bodyElement.sendKeys(Keys.CONTROL+"2");
	  wd.get(url);
	  Thread.sleep(3000);
	  System.out.println("Current windowhandler after go to tab 2 : " + Adminwindow);
	  */
	  
	  Set<String> windows = wd.getWindowHandles();
      String AdminWindow = wd.getWindowHandle();
      ((JavascriptExecutor) wd).executeScript("window.open();");
      Set<String> OpertorWindow = wd.getWindowHandles();
      OpertorWindow.removeAll(windows);
      String customerSiteHandle = ((String) OpertorWindow.toArray()[0]);
      wd.switchTo().window(customerSiteHandle);
      wd.get(url);
      //wd.switchTo().window(AdminWindow);
      Thread.sleep(3000); 
  }

  public static void Parentwindow(WebDriver wd)
  {
	  String AdminWindow = wd.getWindowHandle();
	  System.out.println("Coming to AdminWindow:Please Confirm");
	  wd.switchTo().window(AdminWindow);
  }
public static void SwitchWindow(WebDriver wd) throws AWTException, InterruptedException
  {
	       //Robot r = new Robot(); 
		   //r.keyPress(KeyEvent.VK_CONTROL); 
		   //r.keyPress(KeyEvent.VK_T); 
		   //r.keyRelease(KeyEvent.VK_CONTROL); 
		   //r.keyRelease(KeyEvent.VK_TAB);
	    Thread.sleep(3000); 
	    ArrayList<String> tabs2 = new ArrayList<String> 
	    (wd.getWindowHandles());wd.switchTo().window(tabs2.get(0));
	
  }
public static void ApproverWindow(WebDriver wd) throws AWTException, InterruptedException
{
	       //Robot r = new Robot(); 
		   //r.keyPress(KeyEvent.VK_CONTROL); 
		   //r.keyPress(KeyEvent.VK_T); 
		   //r.keyRelease(KeyEvent.VK_CONTROL); 
		   //r.keyRelease(KeyEvent.VK_TAB);
	     Thread.sleep(3000); 
	    ArrayList<String> tabs2 = new ArrayList<String> 
	    (wd.getWindowHandles());wd.switchTo().window(tabs2.get(1));
	
}
}
