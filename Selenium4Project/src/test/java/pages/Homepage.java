package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.UtilityFunction;


public class Homepage {

	WebDriver driver;
	
	public Homepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void toTelevisionAndVideo() {
		By sideBar = By.id("nav-hamburger-menu");
		By electronics = By.xpath("//a[@data-ref-tag='nav_em_1_1_1_6']");
		By tAV = By.linkText("Television & Video");
		UtilityFunction.waitAnElement(sideBar, driver).click();
		UtilityFunction.waitAnElement(electronics, driver).click();
		UtilityFunction.waitAnElement(tAV, driver).click();
		}


}
	

