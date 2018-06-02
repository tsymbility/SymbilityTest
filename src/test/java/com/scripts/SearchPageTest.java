package com.scripts;

import com.base.TestBase;
import com.pages.SearchPage;
import com.pages.SignInPage;
import com.top.menu.TopMenuSearchBar;
import com.navigation.button.NavigationButton;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeMethod;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SearchPageTest extends TestBase {
	private TopMenuSearchBar searchBar;
	private SearchPage searchPage;
	private SignInPage signInPage;
	private NavigationButton navigationBtn;
		
	// super keyword will call the superclass constructor
	public SearchPageTest() {
		super();
	}

	@BeforeMethod 
	public void Initialization() {
		searchBar = new TopMenuSearchBar();
		searchPage = new SearchPage();
		signInPage = new SignInPage();
		navigationBtn = new NavigationButton();			
	}
	
	@Test(priority=2)
	public void EnterValidItemAndClickOnSearchButton() {
		searchBar.enterTextInSearchBbox("memory card");
		searchBar.clickOnSearchButton();
		assertTrue(searchBar.validateSearchResultFound().indexOf("memory card")> 0, "Search result is not matching");
	}
	
	@Test(priority=3)
	public void EnterInvalidItemAndClickOnSearchButton() {
		searchBar.enterTextInSearchBbox("[alpja]");
		searchBar.clickOnSearchButton();
		assertEquals("Strings are not matching", "Your search \"[alpja]\" did not match any products.", searchBar.validateSearchResultNotFound());
	}
	
	@Parameters({"email", "password"})
	@Test(priority=4)
	public void VerifyCheckOutPageAfterAddItemToCart(String email, String password) {
		EnterValidItemAndClickOnSearchButton();
		assertEquals("Strings are not matching", "Sandisk Ultra 32GB Class 10 SDHC UHS-I Memory Card Up to "
				+ "80MB, Grey/Black (SDSDUNC-032G-GN6IN)", searchPage.validateMemoryCardSearchResultFound());
		searchPage.clickOnMemoryCardLink();
		navigationBtn.clickOnAddToCartButton();
		navigationBtn.clickOnCheckOutButton();
		signInPage.SignInWithCredential(email, password);
		assertEquals("Strings are not matching", "Select a shipping address", searchPage.validateAddressPage());
	}
	
}
