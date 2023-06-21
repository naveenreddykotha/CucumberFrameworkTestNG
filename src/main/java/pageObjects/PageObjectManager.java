package pageObjects;

import org.openqa.selenium.WebDriver;
//Factory design model
public class PageObjectManager {
	public LandingPagePOM landing;
	public OfferPage_pom offerPage;
	public CheckoutPagePOM checkoutPage;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	public  LandingPagePOM getLandingPage() {
		landing=new LandingPagePOM(driver);
		return landing;
	}
	
	public  OfferPage_pom getOfferPage() {
		offerPage=new OfferPage_pom(driver);
		return offerPage;
	}
	
	public CheckoutPagePOM getCheckoutPage() {
		checkoutPage=new CheckoutPagePOM(driver);
		return checkoutPage;
	}

}
