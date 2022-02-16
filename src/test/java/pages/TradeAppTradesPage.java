package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;

public class TradeAppTradesPage {
	
	public TradeAppTradesPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	
	
	@FindBy (xpath="//h2[text()='Please sign in']")
	public WebElement pleaseSignInText;
	
	@FindBy (id="username")
	public WebElement username;
	
	@FindBy (id="password")
	public WebElement password;
	
	@FindBy (css=".btn-primary")
	public WebElement signInBtn;
	
	@FindBy (xpath = "//a[@class='navbar-brand']")
	public WebElement homeLogo;
	
	@FindBy (linkText  = "Add trade")
	public  WebElement addTradeBtn;
	
	@FindBy (xpath  = "//p[contains(text(), 'Save Trade')]")
	public  WebElement saveTradeText;
	
	@FindBy (id = "longTrade")
	public  WebElement buyOrSelectDropDown;
	
	@FindBy (id = "symbol")
	public  WebElement stockSymbol;
	
	@FindBy (id = "openDate")
	public  WebElement openDate;
	
	@FindBy (id = "entry")
	public  WebElement stockEntryPrice;
	
	@FindBy (id = "closeDate")
	public  WebElement closeDate;
	
	@FindBy (id = "exit")
	public  WebElement stockExitPrice;
	
	@FindBy (xpath = "//button[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy (xpath = "//table[@class='table table-bordered table-striped']/tbody/tr/td[2]")
	public List<WebElement> stockSymbols;
	
	@FindBy (xpath = "//table[@class='table table-bordered table-striped']/tbody/tr/td[4]")
	public List<WebElement> stockEntryPrices;
	
	@FindBy (xpath = "//input[@placeholder='Symbol']")
	public  WebElement symbolBox;
	
	@FindBy (xpath = "//button[text()='Search']")
	public WebElement searchBtn;
	
	
	
}
