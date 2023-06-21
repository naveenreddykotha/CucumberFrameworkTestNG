package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPagePOM {
	public WebDriver driver;
	
	By search=By.xpath("//input[@type='search']");
	By productName=By.xpath("//h4[@class='product-name']");
	By offerLink=By.linkText("Top Deals");
	By increment=By.cssSelector("a.increment");
	By addToCart=By.cssSelector(".product-action button");
	
	public LandingPagePOM(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SearchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}
	
	public void incrementQuatity(int quantity) {
		int i=quantity-1;
		while(i>0) {
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
	
	public void getSearchText() {
		driver.findElement(search).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void gotoOfferPage() {
		driver.findElement(offerLink).click();
	}

}
