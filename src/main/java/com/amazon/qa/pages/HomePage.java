package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - Object Repository
	
			@FindBy(id="twotabsearchtextbox")
			WebElement searchBox;
			
			@FindBy(xpath="//div[@class='a-section aok-relative s-image-fixed-height']//img[@alt='Apple iPhone 12, 64GB, Red - Unlocked (Renewed Premium)']")
			WebElement productLink;
			
			@FindBy(id="add-to-cart-button")
			WebElement addToCartButton;
			
			@FindBy(id="nav-cart-count")
			WebElement cart;
			
			@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
			WebElement proceedToCheckout;
			
			@FindBy(xpath="//input[@data-testid='Address_selectShipToThisAddress']")
			WebElement useThisAddress;
			
			
			@FindBy(xpath="//img[@alt='Electronics']")
			WebElement electronicsListings;
			
			@FindBy(xpath="//span[contains(text(),'Accessories & Supplies')]")
			WebElement accessories;
			
			@FindBy(xpath="//img[@alt='Amazon Basics Clear Thermal Laminating Plastic Paper Laminator Sheets - 9 x 11.5-Inch, 200-Pack, 3mil']")
			WebElement product1;
			
			@FindBy(xpath="//img[@alt='SanDisk 128GB Extreme microSDXC UHS-I Memory Card with Adapter - Up to 190MB/s, C10, U3, V30, 4K, 5K, A2, Micro SD Card - ...']")
			WebElement product2;
			
			@FindBy(xpath="//img[@alt='Scotch Thermal Laminating Pouches, 200 Pack Laminating Sheets, 3 Mil, 8.9 x 11.4 Inches, Education Supplies & Craft Suppli...']")
			WebElement product3;
			
			
			@FindBy(xpath="//img[@alt='Amazon Basics 48-Pack AA Alkaline High-Performance Batteries, 1.5 Volt, 10-Year Shelf Life']")
			WebElement product;
			
			
			public HomePage() {
				PageFactory.initElements(driver, this);
			}
			
			public String validateHomePageTitle() {
				return driver.getTitle();
			}
			
			public int AmazonSearchPurchaseProductAutomation() throws InterruptedException {
				searchBox.sendKeys("iphone");
				Thread.sleep(2000);
				searchBox.submit();
				productLink.click();
				Thread.sleep(2000);
				addToCartButton.click();
				String cartItemCount = cart.getText();
				int productsInCart;
				try {
					productsInCart = Integer.parseInt(cartItemCount);
				}
				catch (NumberFormatException e) {
					productsInCart = 0;
				}
		        proceedToCheckout.click();
		        useThisAddress.click();
				
				return productsInCart;
			}
			

			public int ProductListingsPurchaseAutomation() throws InterruptedException {
				electronicsListings.click();
				Thread.sleep(2000);
				product.click();
				Thread.sleep(2000);
				addToCartButton.click();
				String cartItemCount = cart.getText();
				int productsInCart;
				try {
					productsInCart = Integer.parseInt(cartItemCount);
				}
				catch (NumberFormatException e) {
					productsInCart = 0;
				}
		        proceedToCheckout.click();
		        useThisAddress.click();
				
				return productsInCart;
			}
			
			public int ProductListingsAddThreeProducts() throws InterruptedException {
				electronicsListings.click();
				Thread.sleep(2000);
				accessories.click();
				Thread.sleep(2000);
				product1.click();
				addToCartButton.click();
				driver.navigate().back();
				Thread.sleep(2000);
				product2.click();
				addToCartButton.click();
				driver.navigate().back();
				Thread.sleep(2000);
				product3.click();
				Thread.sleep(2000);
				String cartItemCount = cart.getText();
				int productsInCart;
				try {
					productsInCart = Integer.parseInt(cartItemCount);
				}
				catch (NumberFormatException e) {
					productsInCart = 0;
				}
		        proceedToCheckout.click();
		        useThisAddress.click();
				
				return productsInCart;
			}
}
