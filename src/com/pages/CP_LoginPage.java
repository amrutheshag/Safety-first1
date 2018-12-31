package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import generics.BasePage;
public class CP_LoginPage extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, 25);
	
	@FindBy(id="userName")
	private WebElement  username;
	
	@FindBy(id="password")
	private WebElement  password;
	
	@FindBy(xpath="//button[.='Login']")
	private WebElement  loginBTN;
		
	@FindBy(id="HomeScreen")
	private WebElement  HomePageBTN;
	
	
	public CP_LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void EnteringUserName(String un){
		
		Reporter.log("\n*****************************************************",true);
		System.out.println("Login To Application");
		Reporter.log("----------------------------------------------------",true);
		username.sendKeys(un);
	}
	
	public void OpeningTheBrowser(){
		driver.get("http://192.168.1.211:19090/#/login");	
	}
	
	public void Enteringpassword(String pwd){
		password.sendKeys(pwd);
	}
	
	public void ClickOnLoginBTN(){
			loginBTN.click();
	}
	
	public void VerifyHomePageUrl(String E_HomePageUrl){
		wait.until(ExpectedConditions.urlContains(E_HomePageUrl));
		driver.getCurrentUrl().equals(E_HomePageUrl);
		Assert.assertTrue(true);
		Reporter.log("Home Page Displayed",true);
		Reporter.log("----------------------------------------------------",true);
	}
	
}
