package com.amazon.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void homePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "Amazon.com. Spend less. Smile more.");
	}
	
	@Test(priority = 2)
	public void verifySeachProductAndPurchase() throws InterruptedException{
		int number = homePage.AmazonSearchPurchaseProductAutomation();
		if (number >= 1) {
            System.out.println("Product added to the cart successfully.");
        } else {
            System.out.println("Product could not be added to the cart.");
        }
	}
	
	@Test(priority = 3)
	public void verifyAddToCartProductFromListingPage() throws InterruptedException{
		int number = homePage.ProductListingsPurchaseAutomation();
		if (number >= 1) {
            System.out.println("Product added to the cart successfully.");
        } else {
            System.out.println("Product could not be added to the cart.");
        }
	}
	
	@Test(priority = 4)
	public void verifyThreeProductsAdded() throws InterruptedException {
		int number = homePage.ProductListingsAddThreeProducts();
		if (number >= 1) {
            System.out.println("Product added to the cart successfully.");
        } else {
            System.out.println("Product could not be added to the cart.");
        }
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
