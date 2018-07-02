package com.qait.automation.futureFuel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class openingTab {
	JavascriptExecutor jsDriver;
	WebDriverWait wait;
	WebDriver driver;
	public openingTab(JavascriptExecutor jsDriver,WebDriver driver) {
		this.jsDriver=jsDriver;
		this.driver=driver;
	}
	public void opening_tab()  {
		driver.findElement(By.cssSelector("button[data-target='#videoModal']")).click();
		}
	
	public void making_Elements_Visible() {
		driver.switchTo().frame("iframeVideo");
		wait=new WebDriverWait(driver, 10);
		WebElement element=driver.findElement(By.className("play"));
		wait.until(ExpectedConditions.invisibilityOf(element));
		jsDriver.executeScript("document.querySelector(\".vp-sidedock\").removeAttribute(\"hidden\")");
		jsDriver.executeScript("document.querySelector(\".vp-sidedock\").classList.remove(\'invisible\')");
		jsDriver.executeScript("document.querySelector(\".vp-sidedock\").classList.remove(\'hidden\')");
		jsDriver.executeScript("document.querySelector(\".vp-controls\").removeAttribute(\"hidden\")");
		jsDriver.executeScript("document.querySelector(\".vp-controls\").classList.remove(\'invisible\')");
		jsDriver.executeScript("document.querySelector(\".vp-controls\").classList.remove(\'hidden\')");
	}
	
	
	public void like_Button() {
		driver.findElement(By.className("like-button")).isDisplayed();
		}
	
	
	public void watch_later_Button() {
		driver.findElement(By.className("watch-later-button")).isDisplayed();
		}
	
	
	public void share_Button() {
		driver.findElement(By.className("share-button")).isDisplayed();
		}
	
	
	public void closing_Video() {
		driver.switchTo().defaultContent();
		driver.findElement(By.className("close")).click();
		}
	
	
	public void assertion() {
		WebElement response=driver.findElement(By.id("logo"));
		Assert.assertEquals(true, response.isDisplayed());
		}

}
