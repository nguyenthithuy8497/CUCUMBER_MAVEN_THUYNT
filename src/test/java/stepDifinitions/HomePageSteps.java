package stepDifinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import CucumberOptions.Hooks;
import PageObjects.HomePageObject;
import PageObjects.PageFactoryManager;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class HomePageSteps {
	private HomePageObject homePage;
	
	private WebDriver driver;
	public HomePageSteps() {
		driver = Hooks.openAndQuitBrowser();
		homePage = PageFactoryManager.getHomePage(driver);

	}

	@Then("^Verify Home Page displayed with message \"([^\"]*)\"$")
	public void verifyHomePageDisplayedWithMessage(String welcomeMessage) {
		
		Assert.assertTrue(homePage.isHomePageDisplayed(welcomeMessage));

	}
	@Given("^I open New Customer page$")
	public void iOpenNewCustomerPage() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();
	}

}
