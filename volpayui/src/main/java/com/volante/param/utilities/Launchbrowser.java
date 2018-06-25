package com.volante.param.utilities;

import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.volante.utilities.LoadFile;

public class Launchbrowser {

	public static WebDriver driver;
	public LoadFile load;
	/*public Launchbrowser(WebDriver driver)
	{
		Launchbrowser.driver=driver;
		
	}*/

public void LoadData() throws IOException {
		String workingDir = System.getProperty("user.dir");
		load = new LoadFile(workingDir + "/src/main/resources/class/VolPayUI.properties");
		load = new LoadFile (workingDir+"/src/test/resources/Login.properties");
	}
	
@SuppressWarnings("deprecation")
@Parameters({"browser"})
public static void Setup(@Optional String browser) throws MalformedURLException,InterruptedException {
		{
			if (browser.equalsIgnoreCase("Firefox")) {
				System.out.println("Running Firefox");
				System.setProperty("webdriver.gecko.driver",LoadFile.prop.getProperty("FireFox"));
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.out.println("Running Chrome");
				System.setProperty("webdriver.chrome.driver",LoadFile.prop.getProperty("Chrome"));
				driver = new ChromeDriver();

			} else if (browser.equalsIgnoreCase("InternetExplorer")) {
				System.out.println("Running Internet Explorer");
				System.setProperty("webdriver.ie.driver",LoadFile.prop.getProperty("InternetExplorer"));
				DesiredCapabilities capabilities = DesiredCapabilities
						.internetExplorer();
				capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS,
						true);
				driver = new InternetExplorerDriver(capabilities);
			}}
		driver.get(LoadFile.prop.getProperty("URL"));
		Thread.sleep(3000);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		driver.navigate().to(
				"javascript:document.getElementById('overridelink').click()");
		}
}
