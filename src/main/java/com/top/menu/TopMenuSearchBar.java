package com.top.menu;

import com.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuSearchBar extends TestBase {

	WebDriverWait wait;

	// WebElement for Search textbox
	@FindBy(xpath = "//input[@type='text']")
	WebElement searchTextbox;

	// WebElement for Search button
	@FindBy(xpath = "//input[@type='submit']")	
	WebElement searchButton;
	
	// WebElement for search result found text
	@FindBy(id = "s-result-count")
	WebElement searchFound;

	// WebElement for search result not found text
	@FindBy(id = "noResultsTitle")
	WebElement searchNotFound;

	// Initializing the Page Objects
	public TopMenuSearchBar() { 
		PageFactory.initElements(driver, this);	 
		wait = new WebDriverWait(driver,10);
	}

	/// <summary>
	/// <param name="text">text to type into element</param>
	/// </summary>
	public void enterTextInSearchBbox(String text) {
		wait.until(ExpectedConditions.visibilityOf(searchTextbox));
		searchTextbox.clear();  	
		searchTextbox.sendKeys(text);
	}

	/// <summary>
	/// Click on search button
	/// </summary>
	public void clickOnSearchButton() {
		wait.until(ExpectedConditions.visibilityOf(searchButton));
		searchButton.click();	
	}

	/// <summary>
	/// <returns>text dispalyed on the element</returns>
	/// </summary>
	public String validateSearchResultFound() {
		String actualText = searchFound.getText();
		return (actualText);	
	}

	/// <summary>
	/// <returns>text dispalyed on the element</returns>
	/// </summary>
	public String validateSearchResultNotFound() {
		String actualText = searchNotFound.getText();
		return (actualText);	
	}

}
