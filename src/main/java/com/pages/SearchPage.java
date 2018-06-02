package com.pages;

import com.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends TestBase {

	WebDriverWait wait;

	// WebElement for "memory card" search result found 
	@FindBy(xpath = "//h2[text()='Sandisk Ultra 32GB Class 10 SDHC UHS-I Memory Card Up to 80MB, Grey/Black (SDSDUNC-032G-GN6IN)']")
	WebElement searchResultFound;

	// WebElement for Address page header
	@FindBy(xpath = "//h1[text()='Select a shipping address']")
	WebElement addressPage;

	// Initializing the Page Objects
	public SearchPage() { 
		PageFactory.initElements(driver, this);	 
		wait = new WebDriverWait(driver,10);
	}

	/// <summary>
	/// Click on search button
	/// </summary>
	public void clickOnMemoryCardLink() {
		wait.until(ExpectedConditions.visibilityOf(searchResultFound));
		searchResultFound.click();	
	}

	/// <summary>
	/// <returns>text dispalyed on the element</returns>
	/// </summary>
	public String validateMemoryCardSearchResultFound() {
		String actualText = searchResultFound.getText();
		return (actualText);	
	}

	/// <summary>
	/// <returns>text dispalyed on the element</returns>
	/// </summary>
	public String validateAddressPage() {
		String actualText = addressPage.getText();
		return (actualText);	
	}

}
