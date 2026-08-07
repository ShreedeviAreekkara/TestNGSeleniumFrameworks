package Frameworks.TestNG_Frameworks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractMethods {
	WebDriver driver;
	public AbstractMethods(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button [contains(@routerlink,'cart')]")
	WebElement cartIcon;
	
	@FindBy(css="[routerlink='/dashboard/myorders']")
	WebElement orders;
	
	
	
	public void waitForElementToDisappearByElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	wait.until(ExpectedConditions.invisibilityOf(ele));
	}
	
	public void waitForElementToDisappearByLocator(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		}
	
	public void waitForElementToAppearByLocator(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		}
	
	public void waitForElementToAppearByElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.visibilityOf(ele));
		}
	
	public void goToCartIcon() {
		cartIcon.click();
	}
	
	public void gotoOrders() {
		orders.click();
	}

}
