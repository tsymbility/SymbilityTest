package com.navigation.button;

import com.base.TestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavigationButton extends TestBase {

	WebDriverWait wait;

	// WebElement for Add to cart button
	@FindBy(id = "add-to-cart-button")
	WebElement addToCartBtn;

	// WebElement for check out button
	@FindBy(id = "hlb-ptc-btn-native")
	WebElement checkOutBtn;

	// Initializing the Page Objects
	public NavigationButton() { 
		PageFactory.initElements(driver, this);	 
		wait = new WebDriverWait(driver,10);
	}

	/// <summary>
	/// Click on cart 
	/// </summary>
	public void clickOnAddToCartButton() {
		wait.until(ExpectedConditions.visibilityOf(addToCartBtn));
		addToCartBtn.click();	
	}

	/// <summary>
	/// Click on cart 
	/// </summary>
	public void clickOnCheckOutButton() {
		wait.until(ExpectedConditions.visibilityOf(checkOutBtn));
		checkOutBtn.click();	
	}

}
