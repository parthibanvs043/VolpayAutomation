package com.volante.businessrules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.volante.param.utilities.*;
import com.volante.utilities.LoadFile;

public class RuleBuilder 
{
                 WebDriver driver =new FirefoxDriver();
                 public ObjectMap objmap;
             	 public LoadFile load;
	
	public void AddCondition() throws Exception
	{
		   Launchbrowser.driver.findElement(objmap.getLocator("Submit_Register")).click();
	}
}
