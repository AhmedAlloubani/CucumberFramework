package step_definitions;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.AmazonSearchPage;

public class AmazonSearchSteps {
	
	AmazonSearchPage searchPage;
	
	// Amazon search #Starts 
	@When("I search item {string}")
	public void i_search_item(String item) {
	   searchPage = new AmazonSearchPage();
	   searchPage.searchBox.sendKeys(item);
	}
	@When("I click search button")
	public void i_click_search_button() {
		searchPage = new AmazonSearchPage();
		searchPage.searchBtn.click();
	  
	}
	@Then("searched item {string} should be displayed in the search bar")
	public void searched_item_should_be_displayed_in_the_search_bar(String item) {
		searchPage = new AmazonSearchPage();
//		String wholeText = searchPage.searchedItemText.getText();
//		String trimmedText = wholeText.substring(1, wholeText.length()-1);
//		Assert.assertEquals(trimmedText, item);
		
		String actualText = searchPage.searchBox.getAttribute("value");
		
		Assert.assertEquals(actualText, item);
		
		
	}
	
	//Amazon search #Ends

}
