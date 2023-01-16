package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TelevisionsAndVideoPage {

	WebDriver driver;
	
	public TelevisionsAndVideoPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageContentTAV() {
		WebElement content = driver.findElement(By.id("n/1266092011")).findElement(By.className("a-text-bold"));
		return content.getText();
	}
	
	public void toTelevisions() {
		driver.findElement(By.id("n/172659")).findElement(By.className("a-link-normal")).click();
	}
	
	
}
