package com.qa.TNTestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TNPages.HomePage;
import com.qa.TNPages.SearchPage;
import com.qaTNTestBase.TestBase;

public class SearchProductTest extends TestBase{

	public SearchProductTest() throws Exception {
		super();
		
	}
	
	public WebDriver driver;
	public HomePage homepage;
	public SearchPage searchpage;
	
	@BeforeMethod
	public void setup() {
		driver = InitialiazeBrowserAndOpenApp(prop.getProperty("browser"));
	}
	@Test
	public void SearchWithValidProduct() {
		homepage = new HomePage(driver);
		homepage.enterProductDetail(dataprop.getProperty("validProduct"));
		searchpage = homepage.clickOnSearch();
	    AssertJUnit.assertTrue(searchpage.verifyDisplayStatusOfValidProduct()); 
	    
	    driver.quit();
}
}