package com.qa.TNTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TNPages.HomePage;
import com.qa.TNPages.ProductCheckOutPage;
import com.qa.TNPages.ProductInfoPage;
import com.qa.TNPages.SearchPage;
import com.qaTNTestBase.TestBase;

public class AddToCartTest extends TestBase {

	public AddToCartTest() throws Exception {
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
		homepage = new HomePage(driver);
		searchpage = new SearchPage(driver);
		productcheckoutpage = new ProductCheckOutPage(driver);

	}

	@Test
	public void addingProductsToCart() {
		homepage.enterProductDetail(dataprop.getProperty("validProduct"));
		searchpage = homepage.clickOnSearch();
		Assert.assertTrue(searchpage.verifyDisplayStatusOfValidProduct());
		productinfopage = searchpage.clickOnAddToCartButton();
		Assert.assertTrue(productinfopage.validateDisplayStatusProdInfo());
		productinfopage.clickOnAddtoCartButton();
		Assert.assertTrue(productinfopage.addToCartsuccessMessage(),
				dataprop.getProperty("productAddedSuccessfullyToCartMessage"));

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}