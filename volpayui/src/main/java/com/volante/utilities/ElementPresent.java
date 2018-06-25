package com.volante.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementPresent {
	
	                static WebDriver wd;
	
public static boolean isElementPresent(By by) {
	    try {
	    	
	      wd.findElement(by);
	      return true;
	    } 
	    catch (org.openqa.selenium.NoSuchElementException e)
	    {
	        System.out.println("No Element Found");
	    	return false;
	    }
}
}
