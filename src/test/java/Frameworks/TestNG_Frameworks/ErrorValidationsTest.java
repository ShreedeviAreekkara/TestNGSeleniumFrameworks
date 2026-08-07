package Frameworks.TestNG_Frameworks;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ErrorValidationsTest extends BaseTest{
	    @Parameters ({"url"})
	    @Test(retryAnalyzer=Retry.class)
	    public void ValidationOrderTest(String url) throws IOException {
		String productName = "ZARA COAT 3";
		LandingPage lp =browserInvocation(url);
		
		lp.loginToApplication("ichu@gmail.com", "Kichu123");
		String actualMessage=lp.returnErrorMessage();
		
		Assert.assertEquals(actualMessage,"Incorrect email or password.");
		
	    }
	    
	    
		
		
	

}
