package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	WebDriver driver;
	public WebDriver webDriverManager() throws IOException {
		
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String url=prop.getProperty("url");
		String browser_properties=prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		//here we use ternary operator to give first priority to maven command
		//test=testExecution ? value1 : value2
		String browser=browser_maven != null ?browser_maven:browser_properties;
		
		if(driver == null) {
			if(browser.equalsIgnoreCase("chrome")) {
		        WebDriverManager.chromedriver().setup();
		        driver=new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.get(url);
		
		}
		return driver;
	}

}
