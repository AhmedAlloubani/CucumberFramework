package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonLoginPage;
import utilities.BrowserUtils;
import utilities.Driver;
import utilities.PropertiesReader;

public class AmazonLoginSteps {
	
	AmazonLoginPage amazonlp;
	BrowserUtils util;
	
	@Given("I am on Amazon home page")
	public void i_am_on_amazon_home_page() {
		amazonlp = new AmazonLoginPage();
	    System.out.println("On the home page");
	    
	    Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
	}
	@Given("The sign in button displays")
	public void the_sign_in_button_displays() {
		amazonlp = new AmazonLoginPage();
		util =new BrowserUtils();
		
		util.waitUntilElementVisible(amazonlp.signInBtn);
		Assert.assertTrue(amazonlp.signInBtn.isDisplayed());
		
	}
	@When("I click on the sign in button")
	public void i_click_on_the_sign_in_button() {
		amazonlp = new AmazonLoginPage();
		amazonlp.signInBtn.click();
	}
	@Then("I should be directed to login page")
	public void i_should_be_directed_to_login_page() {
		amazonlp = new AmazonLoginPage();
		Assert.assertTrue(amazonlp.emailBox.isDisplayed());
	}
	
	//invalid test starts here
	
	@Given("I am on the loging page")
	public void i_am_on_the_loging_page() {
		amazonlp = new AmazonLoginPage();
		util =new BrowserUtils();
		Driver.getDriver().get(PropertiesReader.getProperty("amazonUrl"));
		amazonlp.signInBtn.click();
		
		util.waitUntilElementVisible(amazonlp.emailBox);
		Assert.assertTrue(amazonlp.emailBox.isDisplayed());
	}
	@When("I enter invalid email {string}")
	public void i_enter_invalid_email(String email) {
		amazonlp = new AmazonLoginPage();
		amazonlp.emailBox.sendKeys(email);
	}
	@When("I click the continue button")
	public void i_click_the_continue_button() {
		amazonlp = new AmazonLoginPage();
		amazonlp.continueBtn.click();
	}
	@Then("I should get error message says {string}")
	public void i_should_get_error_message_says(String expectedErrorMessage) {
		amazonlp = new AmazonLoginPage();
		Assert.assertTrue(amazonlp.errorMessage.isDisplayed());
		String actualText = amazonlp.errorMessage.getText().trim();
		Assert.assertEquals(actualText, expectedErrorMessage);
	}
	@Then("I should still in the login page")
	public void i_should_still_in_the_login_page() {
		amazonlp = new AmazonLoginPage();
		Assert.assertTrue(amazonlp.emailBox.isDisplayed());
		//invalid test ends here
	}
	
	

	

}
