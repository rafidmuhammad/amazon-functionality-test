package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageContent() {
		return driver.getTitle();
	}
	
	public void randomUsernameInput() {
		String input = "abcdefg";
		driver.findElement(By.name("email")).sendKeys(input,Keys.RETURN);
	}
	
	public String getErrorMessage() {
		By locator = By.cssSelector("h4[class='a-alert-heading']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		String message = driver.findElement(locator).getText();
		return message;
	}
	
}
