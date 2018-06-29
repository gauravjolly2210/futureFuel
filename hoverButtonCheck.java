package com.qait.automation.futureFuel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class hoverButtonCheck {
	
	WebDriver driver;
	JavascriptExecutor jsDriver;
	openingTab tab;
	WebDriverWait wait;
	
	@BeforeClass
	public void LaunchBrowser() {
		driver=new ChromeDriver();
		jsDriver=(JavascriptExecutor) driver;
		driver.get("https://futurefuel.io/");
	}

	@Test
	public void Step_01_opening_Video_tab() throws InterruptedException {
		tab=new openingTab(jsDriver);
		tab.opening_tab(driver);	
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
