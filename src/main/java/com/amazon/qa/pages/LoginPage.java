package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - Object Repository
	
		@FindBy(xpath="//input[@id='ap_email']")
		WebElement email;
		
		@FindBy(xpath="//input[@id='continue']")
		WebElement continueButton;
		
		@FindBy(xpath="//input[@id='ap_password']")
		WebElement password;
		
		@FindBy(xpath="//input[@id='signInSubmit']")
		WebElement signInButton;
		
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}
		
		public HomePage login(String Em, String Ps) {
			email.sendKeys(Em);
			continueButton.click();
			password.sendKeys(Ps);
			signInButton.click();
			
			return new HomePage();		
		}
}
