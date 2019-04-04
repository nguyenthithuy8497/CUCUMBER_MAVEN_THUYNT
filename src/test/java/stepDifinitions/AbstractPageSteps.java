 package stepDifinitions;


import org.openqa.selenium.WebDriver;

import CucumberOptions.Hooks;
import PageObjects.AbstractPageObject;
import PageObjects.PageFactoryManager;
import commons.AbstractPage;
import commons.AbstractTest;
import commons.Constants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AbstractPageSteps extends AbstractPage {
	private AbstractPageObject abstractPage;
	private AbstractTest abstractTest;
	private WebDriver driver;
	public AbstractPageSteps() {
		driver = Hooks.openAndQuitBrowser();
		abstractPage = PageFactoryManager.getAbstbractPage(driver);
		abstractTest = new AbstractTest();
	}
	
	@Given("^I input to dynamic textbox \"([^\"]*)\" with data \"([^\"]*)\"$")
	public void i_input_to_dynamic_textbox_with_data(String textboxNameID, String DynamicValue) {
		abstractPage.inputToDynamicTextbox(textboxNameID, DynamicValue);
	}
	
	@Given("^I input to dynamic textbox \"([^\"]*)\" with random data \"([^\"]*)\"$")
    public void i_input_to_dynamic_textbox_with_random_data(String textboxNameID, String DynamicValue) {
      if(textboxNameID.contains("email")) {
    	  DynamicValue = DynamicValue +abstractTest.randomNumber()+Constants.SUFFIX_EMAIL;
      }
      else {
    	  DynamicValue = DynamicValue +abstractTest.randomNumber();
      }
		abstractPage.inputToDynamicTextbox(textboxNameID, DynamicValue);
    }
	@And("^Wait some second \"([^\"]*)\"$")
    public void wait_some_second_something(String secondNumber){
		abstractPage.waitDynamicSecond(secondNumber);
    }
	
	@And("^I click to dynamic button \"([^\"]*)\"$")
	public void i_click_to_dynamic_button(String buttonNameValue){
		abstractPage.clickToDynamicButton(buttonNameValue);
		
	}
	 
	 @And("^I input (first|second) Account ID$")
	 public void i_input_to_account_id(String accountID){
	//	abstractPage.clickToDynamicButton(accountID);
        
    }
	@When("^I click to dynamic link with name \"([^\"]*)\"$")
	public void iClickToDynamicLinkWithName(String linkName){
		abstractPage.openDynamicPage(linkName);
        
    }

	@When("^I input to dynamic textarea \"([^\"]*)\" with data \"([^\"]*)\"$")
	public void iInputToDynamicTextareaWithData(String textareaNameID, String DynamicValue) {
       abstractPage.inputToDynamicTextArea(textareaNameID, DynamicValue);
    }

    @Then("^Verify data at \"([^\"]*)\" field matching with expected data \"([^\"]*)\"$")
    public void verifyDataAtFieldMatchingWithExpectedData(String dynamicRowName, String dynamicExpectData) {
		abstractTest.verifyEquals(abstractPage.getDynamicTextInTable(dynamicRowName),dynamicExpectData );
	}
	
	@And("^ Verify data at \"([^\"]*)\" field matching with expected random data \"([^\"]*)\"$")
	    public void verify_data_at_field_matching_with_expected_random_data(String dynamicRowName, String dynamicExpectData) {
		if(dynamicRowName.contains("Email")) {
			dynamicExpectData = dynamicExpectData + abstractTest.randomNumber()+Constants.SUFFIX_EMAIL;
		}else {
			dynamicExpectData = dynamicExpectData + abstractTest.randomNumber();
		}
	       abstractTest.verifyEquals(abstractPage.getDynamicTextInTable(dynamicRowName),dynamicExpectData );
	 }
	

    @And("^Verify dynamic page or message display with text =\"([^\"]*)\"$")
    public void verify_dynamic_page_or_message_display_with_text(String dyanamicText){
    	abstractTest.verifyTrue(abstractPage.isDynamicPageOrMessageDisplay(dyanamicText));
        
    }

	
}
