package Frameworks.TestNG_Frameworks;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractMethods{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id ="userEmail")
	WebElement email;
	
	@FindBy(id="userPassword")
	WebElement password;
		
	@FindBy(id="login")
	WebElement login_button;
	
	@FindBy (css="div[aria-label='Incorrect email or password.']")
	WebElement errorMessage;
	
	public void goTo(String url) {
		driver.get(url);
	}
	public ProductCatalogue loginToApplication(String user, String pass){
		email.sendKeys(user);
		password.sendKeys(pass);
		login_button.click();
		return new ProductCatalogue(driver);
	}
	
	public String returnErrorMessage() {
		waitForElementToAppearByElement(errorMessage);
		String message=errorMessage.getText();
		return message;
	}
	


}
