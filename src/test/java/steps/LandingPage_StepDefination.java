package steps;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LandingPagePOM;
import utils.ContextSetup;

public class LandingPage_StepDefination {
	//public WebDriver driver;
	//String landingPageproductName;
	String offerPageProduvtName;
	public ContextSetup contextSetup;
	LandingPagePOM landing;
	public LandingPage_StepDefination(ContextSetup contextSetup) {
		this.contextSetup=contextSetup;
		this.landing=contextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("user landed on GreenKart landing page")
	public void user_landed_on_green_kart_landing_page() throws IOException {
		contextSetup.testBase.webDriverManager();
	    
	}
	@When("^user searched with shortname (.+) and extracted actual product name$")
	public void user_searched_with_shortname_and_extracted_actual_product_name(String shortName) throws InterruptedException {
		//LandingPagePOM landing=contextSetup.pageObjectManager.getLandingPage();
		landing.SearchItem(shortName);
		Thread.sleep(2000);
		contextSetup.landingPageproductName=landing.getProductName().split("-")[0].trim();
		
		
	}
	
	@When("added {string} items of selected product to the cart")
	public void added_items_of_selected_product_to_the_cart(String number) {
		landing.incrementQuatity(Integer.parseInt(number));
	    landing.addToCart();
	}
	
	
	

}
