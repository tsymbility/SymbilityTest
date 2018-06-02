package com.top.menu;

import com.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuValidation extends TestBase {

	// WebElement for Home page LOGO after launch the URL
	@FindBy(id = "nav-logo")
	WebElement homePageLogo;

	// WebElement for “Hello. Sign In Your Account” Text
	@FindBy(id = "nav-link-yourAccount")
	WebElement helloSignIn;

	// WebElement for Sign in button 
	@FindBy(id = "nav-signin-tooltip")
	WebElement signIn;

	// WebElement for Sign out button 
	@FindBy(id = "nav-item-signout-sa")
	WebElement signOut;

	// Initializing the Page Objects
	public TopMenuValidation() { 	
		PageFactory.initElements(driver, this);	 
	}

	/// <summary>
	/// <returns>true if displayed otherwise false</returns>
	/// </summary>
	public boolean validateHomePage_Logo() {
		homePageLogo.isDisplayed();
		return(true);
	}

	/// <summary>
	/// <returns>text dispalyed on the element</returns>
	/// </summary>
	public String validateHomePage_SignInText() {
		String actualText = helloSignIn.getText();
		return (actualText);
	}

	/// <summary>
	/// <returns>true if displayed otherwise false</returns>
	/// </summary>
	public boolean validateHomePage_SignInButton() {
		signIn.isDisplayed();
		return(true);
	}	
	
	/// <summary>
	/// <returns>true if displayed otherwise false</returns>
	/// </summary>
	public boolean validateSignOutButton() {
		signOut.isDisplayed();
		return(true);
	}

}
