package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://amazon.com");
	}
	
//	@BeforeMethod
//	public void perTestSetup() {
//		driver.navigate().to("https://amazon.com");
//	}
	
//	@AfterMethod
//	public void tear() {
//		driver.close();
//	}
//	
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
