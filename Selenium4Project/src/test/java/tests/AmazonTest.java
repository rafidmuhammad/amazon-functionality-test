package tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Homepage;
import pages.SignInPage;
import pages.TelevisionsAndVideoPage;
import pages.TelevisionsPage;


public class AmazonTest extends BaseClass {
	@Test
	public void amazonHome() throws InterruptedException {
		Homepage home = new Homepage(driver);
		String expectedHomeTitle = "Amazon.com. Spend less. Smile more.";
		String actualHomeTitle = home.getPageTitle();
		Assert.assertEquals(actualHomeTitle, expectedHomeTitle);
		home.toTelevisionAndVideo();
	}
	
	@Test(dependsOnMethods = {"amazonHome"})
	public void amazonTAV() {
		TelevisionsAndVideoPage TAV = new TelevisionsAndVideoPage(driver);
		String expectedTAVContent = "Television & Video";
		String actualTAVContent = TAV.getPageContentTAV();
		Assert.assertEquals(actualTAVContent, expectedTAVContent);
		TAV.toTelevisions();
	}
	
	@Test(dependsOnMethods = {"amazonTAV"})
	public void amazonTV() throws InterruptedException {
		TelevisionsPage TV = new TelevisionsPage(driver);
		String expectedTVContent = "Televisions";
		String actualTVContent = TV.getPageContentTelevisions();
		Assert.assertEquals(actualTVContent, expectedTVContent);
		TV.Select32Inch();
		
		String expectedTVInchContent = "Amazon.com: 32 Inches & Under - Televisions: Television & Video";
		String actualTVInchContent = TV.getPageTitle();
		Assert.assertEquals(actualTVInchContent, expectedTVInchContent);
		TV.sort();
		TV.listOfItemAndPrice();
		TV.addToList();
	}
	
	@Test(dependsOnMethods = {"amazonTV"})
	public void amazonSignIn() {
		SignInPage signIn = new SignInPage(driver);
		String pageTitle = signIn.getPageContent();
		String expectedTitle = "Amazon Sign-In";
		Assert.assertEquals(pageTitle, expectedTitle);
		
		signIn.randomUsernameInput();
		String message = signIn.getErrorMessage();
		String expectedMessage = "There was a problem";
		Assert.assertEquals(message, expectedMessage);
	}
	
}
	


