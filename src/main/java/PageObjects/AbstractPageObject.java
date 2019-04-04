package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUI.AbstractPageUI;
import commons.AbstractPage;

public class AbstractPageObject extends AbstractPage{
	WebDriver driver;

	public AbstractPageObject(WebDriver driverMapping) {
		driver= driverMapping;
	}
	
	public void inputToDynamicTextbox(String textboxNameID, String valueToSendkey) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXTBOX,textboxNameID);
		//remove attribute type=date =>textbox
		if(textboxNameID.equals("dob")) {
			removeAttributeInDOM(driver, AbstractPageUI.DYNAMIC_TEXTBOX,  "type",textboxNameID);
		}
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, valueToSendkey,textboxNameID);
	}
	
	//do date co dang calender
	public void inputDateTextbox( String textboxNameID, String valueToSendkey ) {
		
		WebElement inputs = driver.findElement(By.xpath(AbstractPageUI.DATE_TEXTBOX));
		    ((JavascriptExecutor) driver).executeScript(
		                "arguments[0].removeAttribute('type')",inputs);
		    sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXTBOX, valueToSendkey,textboxNameID);

		
	}
	
	
	public void inputToDynamicTextArea(String textAreaNameID, String valueToSendkey) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TEXT_AREA,textAreaNameID);
		sendkeyToElement(driver, AbstractPageUI.DYNAMIC_TEXT_AREA, valueToSendkey,textAreaNameID);
		
	}
	public void clickToDynamicRadioButton( String radioButtonValue) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON,radioButtonValue);
		clickToElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonValue);
		
	}
	
	public void clickToDynamicButton( String buttonNameValue) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_BUTTON,buttonNameValue);
		clickToElement(driver, AbstractPageUI.DYNAMIC_BUTTON,buttonNameValue);
		
	}
	public boolean isDynamicPageOrMessageDisplay( String pageHeadingName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_PAGEHAEDING,pageHeadingName);
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_PAGEHAEDING,pageHeadingName);
	}
	
	public String getDynamicTextInTable( String rowName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ROWNAME,rowName);
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ROWNAME, rowName);
	}

	//trường hợp có quá nhiều page (100-1000 page) k thể sử dụng switch... case
	public void openDynamicPage(String pageName) {
		waitToElementVisible(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, AbstractPageUI.DYNAMIC_LINK, pageName);
		
	}
	public void waitDynamicSecond(String secondNumber) {
		long number = Long.parseLong(secondNumber);
		try {
			Thread.sleep(number);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	

}
