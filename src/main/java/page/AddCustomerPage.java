package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage{
	
WebDriver driver;
	
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[1]/section/div/div[2]/div/div[1]/div[1]/div/div/header/div/strong") WebElement addCustomerHeaderElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[1]/div/input") WebElement fullNameElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[2]/div/select") WebElement companyElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[3]/div/input") WebElement emailElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement phoneElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[5]/div/input") WebElement addressElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[6]/div/input") WebElement cityElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"port\"]") WebElement zipElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[8]/div[1]/select") WebElement countryElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"save_btn\"]") WebElement saveElement;
	@FindBy(how = How.XPATH, using = "//*[@id=\"yesBtn\"]") WebElement yesDeleteElement;

	
	public void validateAddCustomerPage(String addCustomerHeaderText) {
		validateElement(addCustomerHeaderElement.getText(), addCustomerHeaderText, "Add Customer Page is not available!!");
	}
	
	static String insertedName;
	public static String getInsertedName() {
		return insertedName;
	}

	public static void setInsertedName(String insertedName) {
		AddCustomerPage.insertedName = insertedName;
	}

	public void insertFullName(String fullName) {
		insertedName = fullName + generateRandomNum(999);
		fullNameElement.sendKeys(insertedName);
	}
	
	public void selectCompany(String company) {
		selectFromDropDown(companyElement, company);
	}
	
	public void insertEmail(String email) {
		emailElement.sendKeys(generateRandomNum(999) + email);
	}
	
	public void insertPhone(String phone) {
		phoneElement.sendKeys(phone + generateRandomNum(999));
	}
	public void insertAdderss(String address) {
		addressElement.sendKeys(address);
	}
	public void insertCity(String city) {
		cityElement.sendKeys(city);
	}
	public void insertZip(String zip) {
		zipElement.sendKeys(zip);
	}
	
	public void selectCountry(String country) {
		selectFromDropDown(countryElement, country);
	}
	
	public void clickOnSaveButton() {
		saveElement.click();
	}
	public void clickOnYesDeleteButton() {
		yesDeleteElement.click();
	}
	
	
	
}
