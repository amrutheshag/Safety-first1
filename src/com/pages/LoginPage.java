package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generics.BasePage;
public class LoginPage extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, 25);
	
	@FindBy(id="userName")
	private WebElement  username;
	
	@FindBy(id="password")
	private WebElement  password;
	
	@FindBy(xpath="//button[.='Login']")
	private WebElement  loginBTN;
		
	@FindBy(id="HomeScreen")
	private WebElement  HomePageBTN;
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void EnteringUserName(String un){
		
		System.out.println("\n*****************************************************");
		System.out.println("Login To Application");
		System.out.println("*****************************************************");
		username.sendKeys(un);
	}
	
	public void Enteringpassword(String pwd){
		password.sendKeys(pwd);
		sleep(6);
		
	}
	
//	public void ClickOnLoginBTN(){
//		if(loginBTN.isDisplayed())
//		{
//			loginBTN.click();
//			System.out.println("found clicked");
//		}
//		else{
//			System.out.println("not found");
//		}
//		sleep(6);
//		System.out.println("found");
//		loginBTN.click();
//		System.out.println("clicked");
//	}
	
	public void VerifyHomePageUrl(String E_HomePageUrl){
		wait.until(ExpectedConditions.urlContains(E_HomePageUrl));
		driver.getCurrentUrl().equals(E_HomePageUrl);
		Assert.assertTrue(true);
		System.out.println("home page displayed");
	}
	
}
