package Frameworks.TestNG_Frameworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends AbstractMethods{

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}



	@FindBy (xpath="//input[@placeholder='Select Country']")
	WebElement countryTab;
	
	@FindBy (css="section .ng-star-inserted:nth-child(3)")
	WebElement india;
	
	@FindBy (css="span.ng-star-inserted")
	List<WebElement> countries;
	
	@FindBy(css=".ta-results")
	WebElement countrysection;
	
	@FindBy (css=".action__submit")
	WebElement placeOrderButton;
	
	public ConfirmationMessagePage selectCountry(String countryText, String countryName) {
				
		Actions a = new Actions(driver);
		a.sendKeys(countryTab,countryText).build().perform();
		waitForElementToAppearByElement(countrysection);
		india.click();
		placeOrderButton.click();
		return new ConfirmationMessagePage(driver);
		
	}
	
	


}
