package Frameworks.TestNG_Frameworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationMessagePage extends AbstractMethods {
WebDriver driver;
	public ConfirmationMessagePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement message;
	
	
	public String verifyConfirmationMessage() {
		String confirmationMessage=message.getText();
		return confirmationMessage;
		
	}

}
