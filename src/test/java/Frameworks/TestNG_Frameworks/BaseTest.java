package Frameworks.TestNG_Frameworks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	
	@BeforeMethod
	public WebDriver driverInitialisation() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//resources//globalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		if (browserName.contains("Edge")){
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	
	
	public List<HashMap<String,String>> jsonMapper(String jsonPath) throws IOException{
		//Convert the jsonFile into String
		String jsonToString = FileUtils.readFileToString(new File(jsonPath),StandardCharsets.UTF_8);
		//Convert String into list of Hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonToString, new TypeReference<List<HashMap<String,String>>>(){});
		return data;
		
	}
	
	
	
	public LandingPage browserInvocation(String url) throws IOException {
		driver= driverInitialisation();
		LandingPage lp= new LandingPage(driver);
		lp.goTo(url);
		return lp;
	}

	public String getScreenshot(String methodName, WebDriver driver) throws IOException {
		// TODO Auto-generated method stub
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"//reports//"+methodName+".png");
		FileUtils.copyFile(src, dest);
		return (System.getProperty("user.dir")+"//reports//"+methodName+".png");
	}

	
	

}
