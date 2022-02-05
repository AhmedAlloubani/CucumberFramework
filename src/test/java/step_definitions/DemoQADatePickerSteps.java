package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoQADatePickerPage;
import utilities.BrowserUtils;
import utilities.Driver;

public class DemoQADatePickerSteps {
	
	DemoQADatePickerPage datePickerPage;
	BrowserUtils utils;
	
	@Given("I am on the date picker page {string}")
	public void i_am_on_the_date_picker_page(String url) {
		datePickerPage = new DemoQADatePickerPage();
		
	  Driver.getDriver().get(url);
	  Assert.assertTrue(datePickerPage.firstDatePicker.isDisplayed());
	}
	@When("I enter {string} to date picker")
	public void i_enter_to_date_picker(String date) {
		utils = new BrowserUtils();
		datePickerPage = new DemoQADatePickerPage();
		utils.clearValueOnTheField(datePickerPage.firstDatePicker);
		
		// first approach is to send the date into the input
		//datePickerPage.firstDatePicker.sendKeys(date);
		// second approach is to pick up a date
		datePickerPage.firstDatePicker.click();
		
		
		datePickerPage.pickADate(date);
		
	}
	@Then("Date entered should be selected")
	public void date_entered_should_be_selected() {
		System.out.println("entered date is " + datePickerPage.firstDatePicker.getAttribute("value"));
	}

}
