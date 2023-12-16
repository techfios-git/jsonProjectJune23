package test;

import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {

	WebDriver driver;
	JsonElement jsonEleObj;

	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	public void readJson() {

		try {

			FileReader reader = new FileReader("src\\main\\java\\testData\\TF_TestData.json");
			JsonParser parserObj = new JsonParser();
			jsonEleObj = parserObj.parse(reader);
			jsonEleObj.isJsonObject();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Test(groups = {"smoke", "regression"})
	public void validUserShouldBeAbleToLogin() {

		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.insertPassword(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginPage.clickOnSigninButton();
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("ValidationTextLogin").getAsString());
		BrowserFactory.tearDown();
	}

	@Test(groups = {"regression"})
	public void validateLoginAlertMesg() {
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.clickOnSigninButton();
		loginPage.validateUserAlertMsg(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("alertUserValidationText").getAsString());
		loginPage.insertUserName(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.clickOnSigninButton();
		loginPage.validatePasswordAlertMsg(jsonEleObj.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("alertPasswordValidationText").getAsString());
		BrowserFactory.tearDown();
	}
	
	@Test(groups = {"smoke"})
	public void smokeTest() {
		System.out.println("Smoke");
	}
	
	@Test(groups = {"regression"})
	public void regressionTest() {
		System.out.println("smoke");
	}

}
