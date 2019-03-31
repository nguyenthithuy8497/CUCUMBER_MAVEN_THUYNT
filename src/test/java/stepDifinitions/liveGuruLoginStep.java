package stepDifinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class liveGuruLoginStep {

	WebDriver driver;

	@Given("^I open live guru login page$")
	public void iOpenLiveGuruLoginPage() {
	//	driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("start-maximize");
		driver= new ChromeDriver(options);
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@When("^I input to username textbox with data \"([^\"]*)\"$")
	public void iInputToUsernameTextboxWithData(String emailValue) {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailValue);
	}

	@When("^I input to password textbox with data \"([^\"]*)\"$")
	public void iInputToPasswordTextboxWithData(String passValue) {
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(passValue);

	}

	@When("^I click login button$")
	public void iClickLoginButton() {
		driver.findElement(By.xpath("//button[@id='send2']")).click();

	}

	@Then("^I quit browser$")
	public void iQuitBrowser() {
		driver.quit();

	}

}
