package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generics.BasePage;
public class Stale extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, 25);
	By username = By.id("userName");
	By password = By.id("password");
	By loginBTN = By.xpath("//button[.='Login']");
	
	
	public Stale(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void LoginToApplication(String un,String pwd,String HomePageUrl) throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(username));
		driver.findElement(username).sendKeys(un);
		System.out.println(un);
		driver.findElement(password).sendKeys(pwd);
		System.out.println(pwd);
		wait.until(ExpectedConditions.elementToBeClickable(loginBTN));
		driver.findElement(loginBTN).click();
		wait.until(ExpectedConditions.titleContains(HomePageUrl));
		driver.getCurrentUrl().equals(HomePageUrl);
		Assert.assertEquals(true, HomePageUrl);
	}

}
