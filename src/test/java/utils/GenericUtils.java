package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	WebDriver driver;
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void switchToChildWindow() {
		Set<String> s1=driver.getWindowHandles();
		   Iterator<String> li=s1.iterator();
		   String parentWindow=li.next();
		   String childWindow=li.next();
		   driver.switchTo().window(childWindow);
	}

}
