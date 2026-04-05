package Frameworks.TestNG_Frameworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCatalogue extends AbstractMethods{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver){
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="#toast-container")
	   WebElement toast_message;
	 
	@FindBy(css=".col-sm-10")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement ele;
	
	By productsBy = By.cssSelector(".mb-3");
	By byToast = By.cssSelector("#toast-container");
	
	public WebElement getProduct(String productName) {
	WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
	return prod;
	}
	
	
	public CartPage AddProductToCart(String productName) {
	waitForElementToAppearByLocator(productsBy);
	WebElement prod = getProduct(productName);
	prod.findElement(By.cssSelector("button:last-of-type")).click();
	waitForElementToAppearByLocator(byToast);
	waitForElementToDisappearByElement(ele);
	goToCartIcon();
	return new CartPage(driver);
	}
}
