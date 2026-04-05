package Frameworks.TestNG_Frameworks;

import java.io.IOException;

import io.cucumber.java.en.Given;

public class StepDefinitions extends BaseTest{
	LandingPage lp;
	@Given("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page() throws IOException{
		lp=browserInvocation("https://rahulshettyacademy.com/client/");
	}
	

}
