package stepDifinitions;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CucumberOptions.Hooks;
import PageObjects.PageFactoryManager;
import PageObjects.RegisterPageObject;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterPageSteps {
	WebDriver driver;
	private String email;
	private RegisterPageObject registerPage;
	
	public RegisterPageSteps() {
		//map driver
		driver = Hooks.openAndQuitBrowser();

		//khai bao cho class RegisterPageSteps
		registerPage = PageFactoryManager.getRegisterPage(driver);
	}
	

	
	@Given("^I input to email textbox with data \"([^\"]*)\"$")
	public void iInputToEmailTextboxWithData(String emailValue) {
		email = emailValue + randomValue() + "@gmail.com";
		registerPage.intputToEmailIDTextbox(email);
	//	driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);

	}

	@Given("^I click to submit button at Register page$")
	public void iClickToSubmitButtonAtRegisterPage() {
		registerPage.clickToSubmitButton();
//		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

	}

	@Then("^I get userID infor$")
	public void iGetUserIDInfor() {
		ShareData.USER_ID = registerPage.getUserIDText();
	//	userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();

	}

	@Then("^I get Password infor$")
	public void iGetPasswordInfor() {
		ShareData.PASSWORD = registerPage.getPasswordText();
	//	password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

	}
	@When("^I open Login page again$")
	public void iOpenLoginPageAgain() {
		registerPage.openLoginPage(ShareData.LOGIN_PAGE_URL);
		
	//	driver.get(loginPageUrl);
	}
	public int randomValue() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}
