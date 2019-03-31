package stepDifinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import CucumberOptions.Hooks;
import PageObjects.LoginPageObject;
import PageObjects.PageFactoryManager;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageSteps {
	private WebDriver driver;
	
	private LoginPageObject loginPage;
	
	public LoginPageSteps() {
		//Map driver
		driver = Hooks.openAndQuitBrowser();
		//khoi tao doi tuong cho  class LoginPageObject
		loginPage = PageFactoryManager.getLoginPage(driver);
	}

	
	@Given("^I get Login page Url$")
	public void iGetLoginPageUrl() {
		ShareData.LOGIN_PAGE_URL = loginPage.getLoginPageUrl();
	//	loginPageUrl = driver.getCurrentUrl();

	}
	@Given("^I click to here link$")
	public void iClickToHereLink() {
		loginPage.clickToHereLink();
	//	driver.findElement(By.xpath("//a[text()='here']")).click();

	}


	@Given("^Input to Username textbox$")
	public void inputToUsernameTextbox() {
		loginPage.inputToUserIDTextbox(ShareData.USER_ID);
	//	driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userID);

	}

	@Given("^I input to Password textbox$")
	public void iInputToPasswordTextbox() {
		loginPage.inputToPasswordTextbox(ShareData.PASSWORD);
	//	driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

	}

	@Given("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage() {
		loginPage.clickToLoginButton();
	//	driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

	}

	

	public int randomValue() {
		Random random = new Random();
		return random.nextInt(9999);
	}

	
}
