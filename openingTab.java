package com.qait.automation.futureFuel;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class openingTab {
	JavascriptExecutor jsDriver;
	WebDriverWait wait;
	public openingTab(JavascriptExecutor jsDriver) {
		this.jsDriver=jsDriver;
	}
	public void opening_tab(WebDriver driver) throws InterruptedException {
		jsDriver.executeScript("document.querySelector('button[data-target=\"#videoModal\"]').click()");
		Thread.sleep(3000);
		driver.switchTo().frame("iframeVideo");
		Actions builder = new Actions(driver);
		Thread.sleep(2000);
		builder.moveToElement(driver.findElement(By.className("share-button"))).click().build().perform();
		builder.moveToElement(driver.findElement(By.className("vp-nav-closeButton"))).click().build().perform();
		Thread.sleep(2000);
		builder.moveToElement(driver.findElement(By.className("like-button"))).click().build().perform();
		windowSwitching(driver);
		 driver.switchTo().frame("iframeVideo");
		builder.moveToElement(driver.findElement(By.className("watch-later-button"))).click().build().perform();
		windowSwitching(driver);
		driver.findElement(By.className("close")).click();
		WebElement response=driver.findElement(By.id("logo"));
		Assert.assertEquals(true, response.isDisplayed());
	}
	public void windowSwitching(WebDriver driver) {
		String parentWindow=driver.getWindowHandle();
	     String subWindow=null;
	     Set<String> handles=driver.getWindowHandles();
	     for(String h:handles) {
	    	 subWindow=h;
	     }	     
	     driver.switchTo().window(subWindow);
	     driver.close();
	     driver.switchTo().window(parentWindow);    
	}
}
