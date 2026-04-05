package Frameworks.TestNG_Frameworks;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractMethods{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartItems;
	
	@FindBy(css=".subtotal button")
	WebElement checkoutButton;
	
	public boolean verifyCartItems(String productName) {
    
	Boolean match = cartItems.stream().anyMatch(cartItem-> cartItem.getText().equalsIgnoreCase(productName));
	return match;
	}
	
	public CheckoutPage goToCheckoutPage() {
		checkoutButton.click();
		return new CheckoutPage(driver);
	}
	
	
}
