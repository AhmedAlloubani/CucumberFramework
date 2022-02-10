package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoQAPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class DemoQASteps {
	
	BrowserUtils utils;
	DemoQAPage demoPage;
	
	@Given("I am on the radio button webpage {string}")
	public void i_am_on_the_radio_button_webpage(String url) {
		utils = new BrowserUtils();
		demoPage = new DemoQAPage();
	    Driver.getDriver().get(url);
	    utils.waitUntilElementVisible(demoPage.doYouLikeText);
	    Assert.assertTrue(demoPage.doYouLikeText.isDisplayed());
	}
	@When("I select {string}")
	public void i_select(String radioOption) {
		demoPage = new DemoQAPage();
		utils = new BrowserUtils();
		Assert.assertFalse(demoPage.noRadio.isEnabled());
		
	    if (radioOption.equals("Yes") && demoPage.yesRadioLabel.isEnabled()) {
	    	demoPage.yesRadioLabel.click();
		}
	    
	    if (radioOption.equals("Impressive") && demoPage.impressiveRadioLabel.isEnabled()) {
	    	demoPage.impressiveRadioLabel.click();
		}
	    
	}
	@Then("A text {string} displays")
	public void a_text_displays(String textResult) {
		utils = new BrowserUtils();
		demoPage = new DemoQAPage();
	    utils.waitUntilElementVisible(demoPage.radioSelectText);
	    System.out.println(demoPage.radioSelectText.getText());
	    Assert.assertEquals(demoPage.radioSelectText.getText(), textResult);
	}
	
	
	// Alert 1 steps 
	@Given("I am on the Alerts page {string}")
	public void i_am_on_the_alerts_page(String url) {
		utils = new BrowserUtils();
		demoPage = new DemoQAPage();
	    Driver.getDriver().get(url);
	    utils.waitUntilElementClickable(demoPage.Alert1);
	    Assert.assertTrue(demoPage.Alert1.isDisplayed());
	}
	@When("I click on AlertButton element")
	public void i_click_on_alert_button_element() {
		utils = new BrowserUtils();
		demoPage = new DemoQAPage();
		demoPage.Alert1.click();
	}
	@Then("I am able to accept the Alert")
	public void i_am_able_to_accept_the_alert() {
		utils = new BrowserUtils();
		demoPage = new DemoQAPage();
	    utils.alertAccept();
	    utils.waitUntilElementVisible(demoPage.Alert1);
	}
	
	// Alert 1 steps Ends
	
	
	

}
