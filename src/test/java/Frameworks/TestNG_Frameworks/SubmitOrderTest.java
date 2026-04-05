package Frameworks.TestNG_Frameworks;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest{
	
	    @Test(dataProvider="getData")
	    public void submitOrderTest(HashMap<String,String> input) throws IOException {
		String productName = input.get("productName");
		LandingPage lp =browserInvocation("https://rahulshettyacademy.com/client/");
		
		ProductCatalogue pc= lp.loginToApplication(input.get("username"), input.get("password"));
		pc.getProduct(productName);
		CartPage cart = pc.AddProductToCart(productName);
		
		Assert.assertTrue(cart.verifyCartItems(productName));
		CheckoutPage cp=cart.goToCheckoutPage();
		ConfirmationMessagePage cmp=cp.selectCountry("ind", "India");
		String message= cmp.verifyConfirmationMessage();
		Assert.assertTrue(message.equalsIgnoreCase("Thankyo for the order."));
	    }
	    
	    @DataProvider
	    public Object[][] getData() throws IOException{
	    	
			List<HashMap<String,String>> data = jsonMapper(System.getProperty("user.dir")+"//src//test//java//Frameworks//TestNG_Frameworks//data.json");
			return new Object[][] {{data.get(0)},{data.get(1)}};
			
		}
		
	

}
