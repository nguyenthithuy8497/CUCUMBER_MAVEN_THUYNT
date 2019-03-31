package stepDifinitions;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import CucumberOptions.Hooks;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NewCustomerPageSteps {


	WebDriver driver;
	public NewCustomerPageSteps() {
		driver = Hooks.openAndQuitBrowser();

	}

	@When("^Input to New Customer form with data$")
	public void inputToNewCustomerFormWithData(DataTable newCustomer_Table) {
		List<Map<String, String>> customer = newCustomer_Table.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(customer.get(0).get("Name"));
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(customer.get(0).get("Address"));
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(customer.get(0).get("City"));
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(customer.get(0).get("State"));
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(customer.get(0).get("Pin"));
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(customer.get(0).get("Phone"));
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(customer.get(0).get("Email")+randomValue()+"@gmail.com");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customer.get(0).get("Password"));
		WebElement inputs = driver.findElement(By.xpath("//input[@id='dob']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('type')", inputs);
		driver.findElement(By.xpath("//input[@id='dob']")).sendKeys(customer.get(0).get("DateOfBirth"));

	}

	@When("^I click to Submit button at New Customer page$")
	public void iClickToSubmitButtonAtNewCustomerPage() {
		driver.findElement(By.xpath("//input[@name='sub']")).click();
	}

	@Then("^Verify message displayed with data \"([^\"]*)\"$")
	public void verifyMessageDisplayedWithData(String arg1) {
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='Customer Registered Successfully!!!']")).isDisplayed());
	}

	@Then("^I verify all above infomation created success$")
	public void iVerifyAllAboveInfomationCreatedSuccess(DataTable getCustomer_Table) {
		List<Map<String, String>> customer = getCustomer_Table.asMaps(String.class, String.class);
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customer.get(0).get("Name"));
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), customer.get(0).get("Address"));
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), customer.get(0).get("City"));
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), customer.get(0).get("State"));
	}


	public int randomValue() {
		Random random = new Random();
		return random.nextInt(9999);
	}
}
