package steps;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPagePOM;
import utils.ContextSetup;

public class CheckoutPage_stepDefination {
	public ContextSetup contextSetup;
	public CheckoutPagePOM checkoutPage;
	public CheckoutPage_stepDefination(ContextSetup contextSetup) {
		this.contextSetup=contextSetup;
		this.checkoutPage=contextSetup.pageObjectManager.getCheckoutPage();
	}
	
	
	@Then("^user proceeds to checkout and validate the (.+) items in page$")
	public void user_proceeds_to_checkout(String name) {
		
		checkoutPage.checkOutItems();
		
		
	    
	}
	@Then("Verify user has ability to add promocode and place the order")
	public void verify_user_has_ability_to_add_promocode_and_place_the_order() {
		
		Assert.assertTrue(checkoutPage.verifyPromoBtn());
		Assert.assertTrue(checkoutPage.verifyPlaceOrderBtn());
	    
	}


}
