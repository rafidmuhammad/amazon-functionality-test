package pages;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.DataModel;
import tests.UtilityFunction;

public class TelevisionsPage {


	WebDriver driver;
	
	public TelevisionsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public String getPageContentTelevisions() {
			WebElement content = driver.findElement(By.id("n/172659")).findElement(By.className("a-text-bold"));
			return content.getText();
		
	}
	
	public void Select32Inch() throws InterruptedException {
		WebElement section = driver.findElement(By.xpath("//ul[@aria-labelledby='p_n_size_browse-bin-title']"));
		WebElement checkbox = section.findElement(By.linkText("32 Inches & Under"));
		Actions act = new Actions(driver);
		act.scrollToElement(checkbox);
		act.perform();
		checkbox.click();
		Thread.sleep(2000);
		}
	

	public void sort() throws InterruptedException {
		Select selectObject;
		By option = By.name("s");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(option)));
		WebElement dropdown = UtilityFunction.waitAnElement(option, driver);
		selectObject = new Select(dropdown);
		selectObject.selectByValue("price-desc-rank");
		Thread.sleep(2000);
	}
	
	public void listOfItemAndPrice() {
		 ArrayList<DataModel> result = UtilityFunction.nameAndPrice(driver);
		 if (result.isEmpty()) {
			System.out.println("No Item Available");
		} else {
			for (DataModel dataModel : result) {
				 System.out.println(dataModel.itemPrice + " " + dataModel.itemName);
			} 
		}			 
    }
	
	public void listOfFilteredItem() throws InterruptedException {
		ArrayList<DataModel> result = UtilityFunction.filterItem(driver);
		if (result.isEmpty()) {
			System.out.println("No Item Available");
		} else {
			for (DataModel dataModel : result) {
				 System.out.println(dataModel.itemPrice + " " + dataModel.itemName);
			} 
		}
	}
	
	public void addToList() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		By Locator = By.cssSelector("button[class='s-easy-mode-ingress-button s-no-js-hide aok-relative']");
		WebElement element = driver.findElement(By.cssSelector("div[data-index='1']"));
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
		WebElement menu = element.findElement(Locator);
		menu.click();
		By addItem = By.linkText("Add to List");
		driver.findElement(addItem).click();
	}
	
	
	
}
