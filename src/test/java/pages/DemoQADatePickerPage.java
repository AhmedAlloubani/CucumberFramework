package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BrowserUtils;
import utilities.Driver;

public class DemoQADatePickerPage {
	BrowserUtils utils;
	int month;
	String day;
	String year;
	
	public DemoQADatePickerPage() {
		PageFactory.initElements(Driver.getDriver(), this);
		
	}
	
	
	@FindBy  (id = "datePickerMonthYearInput")
	public WebElement firstDatePicker;
	
	@FindBy  (css = ".react-datepicker__year-select")
	public WebElement yearDropDown;
	
	@FindBy  (css = ".react-datepicker__month-select")
	public WebElement monthDropDown;
	
	@FindBy  (css = ".react-datepicker__day")
	public List <WebElement> days;
	
	
	
	public void  pickADate(String date) {
		
		String [] dates = date.split("/");
		
		//turn the month into int
		String monthOutofArray = dates[0];
		
		if (monthOutofArray.contains("0")) {
			 month =	Integer.parseInt(monthOutofArray.substring(1));
		}else {
			month = Integer.parseInt(monthOutofArray);
		}
		
		// get the date out of String array
		if (dates[1].contains("0")) {
			day = dates[1].substring(1);
		}else {
			day = dates[1];
		}
		// year from the String array
		 year = dates[2];
		
		utils = new BrowserUtils();
		utils.selectByValue(yearDropDown, year);
		utils.selectByIndex(monthDropDown, month -1);
		
		for (WebElement day1 : days) {
			if (day1.getText().equals(day)) {
				day1.click();
				break;
			}
		}
		
	}
	
	
	public void dateFormatter(String date) {

		
		 
	}
	
}
