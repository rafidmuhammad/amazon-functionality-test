package tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityFunction {
	
	
	public static WebElement waitAnElement(By locator, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element =  driver.findElement(locator);
		return element;
	}
	
	
	public static ArrayList<DataModel> nameAndPrice(WebDriver driver){
		ArrayList<DataModel> result = new ArrayList<DataModel>();
		
		String itemName;
		String price;
		WebElement element = driver.findElement(By.cssSelector("div.s-result-list"));
		List<WebElement> elements = element.findElements(By.cssSelector("div[data-component-type='s-search-result']"));
		
		 for (WebElement e : elements) {
			 itemName = e.findElement(By.cssSelector("span[class='a-size-base-plus a-color-base a-text-normal']")).getText();
			 price = e.findElement(By.cssSelector("span.a-price > span.a-offscreen")).getAttribute("innerHTML");
			 DataModel input = new DataModel(price, itemName);
			 result.add(input);
		 }
		return result;
	}
	
	public static ArrayList<DataModel> filterItem(WebDriver driver){
		WebElement section = driver.findElement(By.xpath("//ul[@aria-labelledby='p_n_feature_nine_browse-bin-title']"));
		WebElement checkbox = section.findElement(By.linkText("2017"));
		Actions act = new Actions(driver);
		act.scrollToElement(checkbox);
		act.perform();
		checkbox.click();

		WebElement priceField = driver.findElement(By.cssSelector("input[id='high-price']"));
		priceField.sendKeys("150",Keys.RETURN);
		
		ArrayList<DataModel> result = nameAndPrice(driver);

		return result;
	}
}
