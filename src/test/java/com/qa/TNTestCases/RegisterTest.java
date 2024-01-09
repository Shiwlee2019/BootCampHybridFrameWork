package com.qa.TNTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TN.Utilites.Util;
import com.qa.TNPages.AccountPage;
import com.qa.TNPages.AccountSuccessPage;
import com.qa.TNPages.HomePage;
import com.qa.TNPages.RegisterPage;
import com.qaTNTestBase.TestBase;

public class RegisterTest extends TestBase {

	public RegisterTest() throws Exception {
		super();

	}

	public WebDriver driver;
	public HomePage homepage;
	public RegisterPage registerpage;
	public AccountSuccessPage accountsucesspage;
	public AccountPage accountpage;

	@BeforeMethod
	public void setup() {
		driver = InitialiazeBrowserAndOpenApp("browser");
		homepage = new HomePage(driver);
		homepage.clickMyAccountDropdown();
		registerpage = homepage.clickOnRegister();

	}

	@Test
	public void verifyRegisterWithAllFields() {

		registerpage.enterFirstname(dataprop.getProperty("firstName"));
		registerpage.enterLastName(dataprop.getProperty("lastName"));
		registerpage.enterEmail(Util.emailWithDateTimeStamp());
		registerpage.enterTelephone(dataprop.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("validPassword"));
		registerpage.enterConfirmPassword(dataprop.getProperty("confirmPassword"));
		registerpage.clickOnNewsLetterButton();
		registerpage.clickOnPrivacycheckbox();
		accountsucesspage = registerpage.clickOnContinueButton();

		AssertJUnit.assertEquals(accountsucesspage.retrieveAccountSuccessMessage(),
				dataprop.getProperty("accountSuccessMessage"));

		driver.quit();

	}
}