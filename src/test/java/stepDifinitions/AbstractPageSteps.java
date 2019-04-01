 package stepDifinitions;


import org.openqa.selenium.WebDriver;

import CucumberOptions.Hooks;
import PageObjects.AbstractPageObject;
import PageObjects.PageFactoryManager;
import commons.AbstractPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class AbstractPageSteps extends AbstractPage {
	private AbstractPageObject abstractPage;
	
	private WebDriver driver;
	public AbstractPageSteps() {
		driver = Hooks.openAndQuitBrowser();
		abstractPage = PageFactoryManager.getAbstbractPage(driver);

	}
	
	@Given("^I input to dynamic textbox \"([^\"]*)\" with data \"([^\"]*)\"$")
    public void i_input_to_dynamic_textbox_with_data(String textboxNameID, String DynamicValue) {
       abstractPage.inputToDynamicTextbox(textboxNameID, DynamicValue);
    }
	 

	@Given("^I input to dynamic textbox \"([^\"]*)\" with data \"([^\"]*)\"$")
    public void i_input_to_dynamic_textarea_with_data(String textareaNameID, String DynamicValue) {
       abstractPage.inputToDynamicTextArea(textareaNameID, DynamicValue);
    }

	
}
