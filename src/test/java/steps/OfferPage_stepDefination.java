package steps;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPagePOM;
import pageObjects.OfferPage_pom;
import pageObjects.PageObjectManager;
import utils.ContextSetup;

public class OfferPage_stepDefination {
	//public WebDriver driver;
	//String landingPageproductName;
	String offerPageProductName;
	public ContextSetup contextSetup;
	public PageObjectManager pageObjectManager;
	
	public OfferPage_stepDefination(ContextSetup contextSetup) {
		this.contextSetup=contextSetup;
		
	}
	
	@Then("^user searched with same shortname (.+) in offerspage to check if product has same name$")
	public void user_searched_with_same_shortname_in_offerspage_to_check_if_product_has_same_name(String shortName) throws InterruptedException {
		switchToOfferPage();
		OfferPage_pom offerPage=contextSetup.pageObjectManager.getOfferPage();
		   offerPage.searchItem(shortName);
		   Thread.sleep(2000);
		   offerPageProductName=offerPage.getProductName();
	}
	
	public void switchToOfferPage() {
		//pageObjectManager=new PageObjectManager(contextSetup.driver);
		
		//LandingPagePOM landing=new LandingPagePOM(contextSetup.driver);
		LandingPagePOM landing=contextSetup.pageObjectManager.getLandingPage();
		landing.gotoOfferPage();
		contextSetup.genericUtils.switchToChildWindow();
		   
	}
	
	@And("Validating offers page productName with home page productName")
	public void validating_offers_page_product_name_with_home_page_product_name() {
		Assert.assertEquals(contextSetup.landingPageproductName,offerPageProductName);


	}

}
