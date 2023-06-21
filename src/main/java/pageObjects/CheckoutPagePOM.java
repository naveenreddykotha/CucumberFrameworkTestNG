package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPagePOM {
	public WebDriver driver;
	
	public CheckoutPagePOM(WebDriver driver) {
		this.driver=driver;
	}
	
	By cartBag=By.cssSelector("img[alt='Cart']");
	By checkoutPage=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn=By.xpath("//button[@class='promoBtn']");
	By placeOrderBtn=By.xpath("//button[normalize-space()='Place Order']");
	
	public void checkOutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkoutPage).click();
	}
	
	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyPlaceOrderBtn() {
		return driver.findElement(placeOrderBtn).isDisplayed();
	}

}
