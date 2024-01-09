package com.qa.TNTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TNPages.AccountPage;
import com.qa.TNPages.HomePage;
import com.qa.TNPages.LoginPage;
import com.qaTNTestBase.TestBase;

public class LoginTest extends TestBase {
	public LoginTest() throws Exception {
		super();

	}

	public WebDriver driver;
	public LoginPage loginpage;
	public HomePage homepage;
	public AccountPage accountpage;

	@BeforeMethod
	public void setup() {
		driver = InitialiazeBrowserAndOpenApp(prop.getProperty("browser"));
		homepage = new HomePage(driver);
		homepage.clickMyAccountDropdown();
		loginpage = homepage.clickOnLogin();

	}

	@Test
	public void verifyLoginWithValidCredentials() {
		loginpage.enterEmail(prop.getProperty("validEmail"));
		loginpage.enterPassword(prop.getProperty("validPassword"));
		accountpage = loginpage.clickOnLogin();

		AssertJUnit.assertTrue(accountpage.displayStatusOfAccountEditInfo());

		driver.quit();

	}
}