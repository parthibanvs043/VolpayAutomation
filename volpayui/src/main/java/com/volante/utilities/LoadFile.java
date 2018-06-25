package com.volante.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class LoadFile 
{
	 public WebDriver driver;
	 public static Properties prop = new Properties();
		public LoadFile(WebDriver driver)
		{
			this.driver=driver;
			
		}
		

		public  LoadFile(String outFile)
		  {
		      
		    try 
		    {
		      FileInputStream fileInput = new FileInputStream(outFile);
		      prop.load(fileInput);
		      }
		  catch (IOException e) 
				  {
		            System.out.println(e.getMessage());
		         }
		     
}
}