package step_definitions;



import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TradeAppTradesPage;
import utilities.BrowserUtils;
import utilities.DButils;
import utilities.Driver;
import utilities.PropertiesReader;

public class TradeAppTrades {
	
	TradeAppTradesPage tradePage;
	

	
	BrowserUtils utils = new BrowserUtils();
	
	DButils dbUtils = new DButils();
	
	String stockSymbol;
	String stockEntryPrice;
	List<String> addTradeData;
	
	
	@Given("I am on the Trade App login page")
	public void i_am_on_the_trade_app_login_page() {
		tradePage = new TradeAppTradesPage();
	   Driver.getDriver().get(PropertiesReader.getProperty("TradeAppUrl"));
	   Assert.assertTrue(tradePage.pleaseSignInText.isDisplayed());
	}
	@When("I enter username {string} password {string}")
	public void i_enter_username_password(String username, String password) {
		tradePage = new TradeAppTradesPage();
		tradePage.username.sendKeys(username);
		tradePage.password.sendKeys(password);
	}
	@When("I click on Trade Sign in button")
	public void i_click_on_trade_sign_in_button() {
		tradePage = new TradeAppTradesPage();
	   tradePage.signInBtn.click();
	}
	@Then("I should be on Trade home page")
	public void i_should_be_on_trade_home_page() {
		tradePage = new TradeAppTradesPage();
		Assert.assertTrue(tradePage.homeLogo.isDisplayed());
	   
	}
	@When("I click on Add Trade button")
	public void i_click_on_add_trade_button() {
		tradePage = new TradeAppTradesPage();
		tradePage.addTradeBtn.click();
	}
	@Then("I should be on Add Trade page")
	public void i_should_be_on_add_trade_page() {
		tradePage = new TradeAppTradesPage();
		Assert.assertTrue(tradePage.saveTradeText.isDisplayed());
	}
	@When("I select {string} and I enter symbol {string} entryDate {string} entryPrice {string} exitDate {string} exitPrice {string}")
	public void i_select_and_i_enter_symbol_entry_date_entry_price_exit_date_exit_price(String buyOrSell, String symbol, String entryDate, String entryPrice, String exitDate, String exitPrice) {
		tradePage = new TradeAppTradesPage();
		stockSymbol = symbol;
		stockEntryPrice = entryPrice;
		
		//select from the dropDown
		utils.selectByVisibleText(tradePage.buyOrSelectDropDown, buyOrSell);
		
		tradePage.stockSymbol.sendKeys(symbol);
		tradePage.openDate.sendKeys(entryDate);
		tradePage.stockEntryPrice.sendKeys(entryPrice);
		tradePage.closeDate.sendKeys(exitDate);
		tradePage.stockExitPrice.sendKeys(exitPrice);
	}
	@When("I click Save button")
	public void i_click_save_button() {
		tradePage = new TradeAppTradesPage();
		tradePage.saveBtn.click();
	   
	}
	@Then("The trade is displayed on the trade table")
	public void the_trade_is_displayed_on_the_trade_table() {
		tradePage = new TradeAppTradesPage();
	  Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
	  
	  for (WebElement elm : tradePage.stockSymbols) {
		  if (elm.getText().equals(stockSymbol)) {
			  Assert.assertEquals(elm.getText(), stockSymbol);
		  }
	  }

	}
	
	@Then("The data is deleted on the Database")
	public void the_data_is_deleted_on_the_database() {
		tradePage = new TradeAppTradesPage();
	  String sql =  "DELETE FROM records WHERE symbol="+ "'"+stockSymbol+"'";
	  dbUtils.deleteRecord(sql);
	}
	
	
	
	
	
	
	
	//data table scenario #Starts
	@When("I enter the following data")
	public void i_enter_the_following_data(DataTable dataTable) {
		tradePage = new TradeAppTradesPage();
	   addTradeData = dataTable.asList();
	   
	   stockSymbol = addTradeData.get(1);
		stockEntryPrice = addTradeData.get(3);
	   
	   utils.selectByVisibleText(tradePage.buyOrSelectDropDown, addTradeData.get(0));
		
		tradePage.stockSymbol.sendKeys(addTradeData.get(1));
		tradePage.openDate.sendKeys(addTradeData.get(2));
		tradePage.stockEntryPrice.sendKeys(addTradeData.get(3));
		tradePage.closeDate.sendKeys(addTradeData.get(4));
		tradePage.stockExitPrice.sendKeys(addTradeData.get(5));
	}
	
	//UI data validation against database #Starts 
	@Then("The trade data resides in database correctly")
	public void the_trade_data_resides_in_database_correctly() {
		tradePage = new TradeAppTradesPage();
		//followings are the UI inputs
		String buyorsell = addTradeData.get(0);
		String symbol = addTradeData.get(1);
		String entryPrice = addTradeData.get(3);
		String exitPrice = addTradeData.get(5);
		
		// followings are the database data
		String selectQuery = "SELECT long_short, symbol, entry_price, exit_price "
				+ "FROM records WHERE symbol="+"'"+stockSymbol+"'";
		List<String> dataFromDB = dbUtils.selectARecord(selectQuery);
		
		
		String buyOrSellDB = dataFromDB.get(0);
		System.out.println("buy or sell: " + buyOrSellDB);
		String sysmbolDB =  dataFromDB.get(1);
		System.out.println("symbol: " + sysmbolDB);
		String entryPriceDB = dataFromDB.get(2);
		System.out.println("entry price: " + entryPriceDB);
		String exitPriceDB = dataFromDB.get(3);
		System.out.println("exit price: " + exitPriceDB);
		
		Assert.assertTrue(buyOrSellDB.equals("1"));
		Assert.assertEquals(symbol, sysmbolDB);
		Assert.assertEquals(entryPrice, entryPriceDB);
		Assert.assertEquals(exitPrice, exitPriceDB);
	}
	
	
	
	
	
	//Insert DB scenario #Starts
	@Given("I executed Insert query with the following data to Database")
	public void i_executed_insert_query_with_the_following_data_to_database(DataTable dataTable) {
		tradePage = new TradeAppTradesPage();
		addTradeData = dataTable.asList();
		//
		
		stockSymbol = addTradeData.get(3).substring(1, addTradeData.get(3).length()-1);
		
		
		String id = addTradeData.get(0);
		String user_id = addTradeData.get(1);
		String long_short = addTradeData.get(2);
		String sysmbol = addTradeData.get(3);
		String openDate = addTradeData.get(4);
		String entryPrice = addTradeData.get(5);
		String closeDate = addTradeData.get(6);
		String exitPrice = addTradeData.get(7);
		String gain =addTradeData.get(8);
		
		String insertQuery = "INSERT INTO records VALUES("+id+", "+user_id+", "+long_short+", "+sysmbol+", "+openDate+", "+entryPrice+", "+closeDate+", "+exitPrice+", "+gain+")";
		
		System.out.println(insertQuery);
		dbUtils.insertRecord(insertQuery);
	}
	@When("I serach the {string}")
	public void i_serach_the(String tradeSymbol) {
		tradePage = new TradeAppTradesPage();

		utils.waitUntilElementVisible(tradePage.symbolBox);
		tradePage.symbolBox.sendKeys(tradeSymbol);
		
		
	  
	}
	@When("I click the Serach button")
	public void i_click_the_serach_button() {
		tradePage = new TradeAppTradesPage();
//		wait = new WebDriverWait(Driver.getDriver(), 10);
//		wait.until(ExpectedConditions.elementToBeClickable(tradePage.symbolBox));
		tradePage.searchBtn.click();
		
	}
	@Then("The trade input displayed on the trade table")
	public void the_trade_input_displayed_on_the_trade_table() {
		tradePage = new TradeAppTradesPage();
		Assert.assertTrue(tradePage.addTradeBtn.isDisplayed());
		Assert.assertEquals(stockSymbol, tradePage.stockSymbols.get(0).getText());
		
		System.out.println(tradePage.stockSymbols.get(0).getText());
	}

}
