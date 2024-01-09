package com.qa.TNTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TNPages.HomePage;
import com.qa.TNPages.ProductCheckOutPage;
import com.qa.TNPages.ProductInfoPage;
import com.qa.TNPages.SearchPage;
import com.qaTNTestBase.TestBase;

public class CheckOutTest extends TestBase{

	
	public CheckOutTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;
	public ProductInfoPage productinfopage;
	public ProductCheckOutPage productcheckoutpage;

	
	@BeforeMethod
	public void setup() {
		driver = InitialiazeBrowserAndOpenApp(prop.getProperty("browser"));
		homepage= new HomePage(driver);
		searchpage = new SearchPage(driver); 
		productcheckoutpage = new ProductCheckOutPage(driver);
		
		
	}
	
	@Test
	public void checkoutProduct()  {
		homepage.enterProductDetail(dataprop.getProperty("validProduct"));
		searchpage = homepage.clickOnSearch();
		productinfopage = searchpage.clickOnAddToCartButton();
		productinfopage.clickOnAddtoCartButton();
		Assert.assertTrue(productinfopage.addToCartsuccessMessage(),dataprop.getProperty("productAddedSuccessfullyToCartMessage"));
		productcheckoutpage = productinfopage.clickOnCheckOut();
		productcheckoutpage.emailfield(prop.getProperty("validEmail"));
		productcheckoutpage.passwordField(prop.getProperty("validPassword"));
		productcheckoutpage.loginButton();
		productcheckoutpage.newAddressRadioButton();
		productcheckoutpage.firstNamefield(dataprop.getProperty("firstName"));
		productcheckoutpage.lastNameField(dataprop.getProperty("lastName"));
		productcheckoutpage.addressfield(prop.getProperty("Address"));
		productcheckoutpage.cityField(prop.getProperty("city"));
		productcheckoutpage.postcodeField(prop.getProperty("PostCode"));
		
		Select select = new Select(driver.findElement(By.id("input-payment-country")));
    	select.selectByVisibleText("United States");
    	
    	Select select1 = new Select(driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
    	select1.selectByVisibleText("Michigan");
    	
    	productcheckoutpage.continueButtonAddress();
    	productcheckoutpage.continueButtonShipping();
    	productcheckoutpage.continueButtonShippingmethod();
    	productcheckoutpage.termsAndConditionButton();
    	productcheckoutpage.continueButtonPaymentMethod();
    	productcheckoutpage.confirmOrder();
    	Assert.assertTrue(productcheckoutpage.orderSucessMessage(),dataprop.getProperty("orderPlacedMessage"));
    	
    	
		
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}