package Grid;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class testGrid {

	public static void main(String[] args) throws MalformedURLException , InterruptedException {
			String node = "http://10.0.3.79:5555/wd/hub";
			System.setProperty("webdriver.gecko.driver","E:\\Automation\\Driver\\geckodriver\\geckodriver.exe");
			Thread.sleep(3000);				
				WebDriver driver = new FirefoxDriver();
				System.out.println("***1");
				Thread.sleep(2000);
				System.out.println("****2");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			System.out.println("****3");
			capabilities.setBrowserName("firefox");
			System.out.println("****4");
			capabilities.setVersion("54.0");
			System.out.println("****5");
			capabilities.setPlatform(Platform.WIN10);
			System.out.println("****6");
			Thread.sleep(10000);
			System.out.println("****7");
			capabilities.setCapability("marionette", true);
			System.out.println("****7*******");
			driver = new RemoteWebDriver(new URL(node), capabilities);
			System.out.println("***8");
			driver.get("http://google.com");
			driver.findElement(By.name("q")).sendKeys("Selenium Grid Tutorial");
			System.out.println("****9");
			driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
			System.out.println("****10");
		}
	}

