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
		tab=new openingTab(jsDriver,driver);
	}

	@Test
	public void Step_01_opening_Video()  {
		tab.opening_tab();	
	}
	
	
	@Test
	public void Step_02_making_Elements_Permanent() {
		tab.making_Elements_Visible();
	}
	
	@Test
	public void Step_03_checking_LIKE_Button() {
		tab.like_Button();
	}
	
	@Test
	public void Step_04_checking_Watch_Later_Button() {
		tab.watch_later_Button();
	}
	
	@Test
	public void Step_05_checking_SHARE_Button() {
		tab.share_Button();
	}
	
	@Test
	public void Step_06_video_Closing_and_Assertion() {
		tab.closing_Video();
		tab.assertion();
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
