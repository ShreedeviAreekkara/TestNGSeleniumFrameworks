package Frameworks.TestNG_Frameworks;

import java.util.List;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifyOrders extends AbstractMethods{
WebDriver driver;
	public VerifyOrders(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css=".ng-star-inserted td:nth-of-type(2)")
	List<WebElement> OrderedItems;
	
	
	
	
	public boolean VerifyOrderItems() {
		gotoOrders();
		
	for(WebElement product:OrderedItems) {
		if(product.getText().equalsIgnoreCase("ZARA COAT 3")) {
			return true;
		}
	}
	return false;
		
	}
	
	
}
