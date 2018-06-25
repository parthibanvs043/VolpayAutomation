package com.volante.utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class GetScreenShot
{
	
	             Logger logger=Logger.getLogger("GetScreenShot");
     
    public static String capture(WebDriver driver,String screenShotName) throws IOException
    {
    	String path = System.getProperty("user.dir");
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = path+"/VolPayoutput/Screenshots/"+screenShotName+".jpg";
        File destination = new File(dest);
        FileUtils.copyFile(source, destination);        
                     
        return dest;
    }
}