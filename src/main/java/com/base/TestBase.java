package com.base;

import com.util.TestUtil;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver;
	protected String server;
	
	@Parameters({"browser", "server"})	 
	@BeforeMethod
	public void Setup(String browser, String server) {

		this.server = server;
		
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver" , "geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if (browser.equalsIgnoreCase("chrome")) { 
			System.setProperty("webdriver.chrome.driver" , "chromedriver.exe");
			driver = new ChromeDriver();
		}
			
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(server);		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}