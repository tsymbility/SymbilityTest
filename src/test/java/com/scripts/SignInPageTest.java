package com.scripts;

import com.base.TestBase;
import com.pages.SignInPage;
import com.top.menu.TopMenuValidation;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SignInPageTest extends TestBase {

	private SignInPage signInPage;
	private TopMenuValidation validation;

	// super keyword will call the superclass constructor
	public SignInPageTest() {
		super();
	}

	@BeforeMethod 
	public void Initialization() {
		signInPage = new SignInPage();
		validation = new TopMenuValidation();			
	}

	@Test(priority=0)
	public void VerifyHomePageSignInTextAndButton() {
		assertTrue(validation.validateHomePage_Logo(), "User unable to load the home page");
		assertEquals("Strings are not matching", "Hello. Sign in\n" + "Your Account", validation.validateHomePage_SignInText());
		assertTrue(validation.validateHomePage_SignInButton(), "User unable to locate sign in button"); 	
	}	
	
	@Parameters({"email", "password"})
	@Test(priority=1)
	public void VerifyHomePageSignInTextAndSignInWithCredential(String email, String password) {
		VerifyHomePageSignInTextAndButton();
		signInPage.clickOnHomePageSignInButton();
		signInPage.SignInWithCredential(email, password);
		assertTrue(validation.validateSignOutButton(), "User unable to logout");
	}
	
}
