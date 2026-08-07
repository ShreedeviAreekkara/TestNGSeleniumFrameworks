package StepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import Frameworks.TestNG_Frameworks.BaseTest;
import Frameworks.TestNG_Frameworks.CartPage;
import Frameworks.TestNG_Frameworks.CheckoutPage;
import Frameworks.TestNG_Frameworks.ConfirmationMessagePage;
import Frameworks.TestNG_Frameworks.LandingPage;
import Frameworks.TestNG_Frameworks.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition extends BaseTest {
	LandingPage lp;
	ProductCatalogue pc;
	CartPage cart;
	CheckoutPage cp;
	ConfirmationMessagePage cmp;
	@Given("I Landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException {
		lp =browserInvocation("https://rahulshettyacademy.com/client/");
	}
	@Given("^I logged in with username (.+) and password (.+)$")
	public void i_logged_in_with_username_and_password(String username, String password) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		pc= lp.loginToApplication(username, password);
	}
	@When("^I select the product with productname (.+)$")
	public void i_select_the_product_with_productname(String productName) {
	    // Write code here that turns the phrase above into concrete actions
		cart=pc.AddProductToCart(productName);
	}
	@When("^verify if the cart has product with (.+) and checkout to Checkout page and place the order$")
	public void verify_if_the_cart_has_product_with_product_name_and_checkout_to_checkout_page_and_place_the_order(String productName) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(cart.verifyCartItems(productName));
		cp=cart.goToCheckoutPage();
		cmp=cp.selectCountry("ind", "India");
	}
	@Then("{string} message is displayed.")
	public void message_is_displayed(String string) {
	    // Write code here that turns the phrase above into concrete actions
		String message= cmp.verifyConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyou for the order."));
	}
}
