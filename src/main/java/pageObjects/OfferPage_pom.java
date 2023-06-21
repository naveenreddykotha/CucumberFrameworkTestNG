package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage_pom {
	WebDriver driver;
	By search=By.id("search-field");
	By productName=By.cssSelector("tr td:nth-child(1)");
	public OfferPage_pom(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void searchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}

}
