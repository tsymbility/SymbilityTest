package com.pages;

import com.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends TestBase {
	
	WebDriverWait wait;
	
	// WebElement for Sign in button
	@FindBy(id = "nav-signin-tooltip")
	WebElement signIn;

	// WebElement for E-mail address 
	@FindBy(id = "ap_email")
	WebElement email;

	// WebElement for Continue button
	@FindBy(id = "continue")
	WebElement continueButton;

	// WebElement for Password
	@FindBy(id = "ap_password")
	WebElement password;

	// WebElement for Sign in button
	@FindBy(id = "signInSubmit")
	WebElement sinInButton;

	// Initializing the Page Objects
	public SignInPage() { 
		PageFactory.initElements(driver, this);	 
		wait = new WebDriverWait(driver,10);
	}

	/// <summary>
	/// Click on sign in button
	/// </summary>
	public void clickOnHomePageSignInButton() {
		wait.until(ExpectedConditions.visibilityOf(signIn));
		signIn.click();	
	}

	/// <summary>
	/// <param name="text">text to type into element</param>
	/// </summary>
	public void emailAddress(String text) {  
		wait.until(ExpectedConditions.visibilityOf(email));
		email.clear();  	
		email.sendKeys(text);	
	} 

	/// <summary>
	/// Click on continue button
	/// </summary>
	public void clickOnContinueButtonAtEmailSignInPage() {
		wait.until(ExpectedConditions.visibilityOf(continueButton));
		continueButton.click();	
	}

	/// <summary>
	/// <param name="text">text to type into element</param>
	/// </summary>
	public void password(String text) {
		wait.until(ExpectedConditions.visibilityOf(password));
		password.clear();  	
		password.sendKeys(text);	
	} 

	/// <summary>
	/// Click on continue button
	/// </summary>
	public void clickOnSignInButtonAtPasswordSignInPage() {
		wait.until(ExpectedConditions.visibilityOf(sinInButton));
		sinInButton.click();	
	}
	
	public void SignInWithCredential(String email, String password) {
		assertEquals("Amazon Sign In",driver.getTitle());
		emailAddress(email);
		clickOnContinueButtonAtEmailSignInPage();
		assertEquals("Amazon Sign In",driver.getTitle());
		password(password);
		clickOnSignInButtonAtPasswordSignInPage();		
	}
	
}

