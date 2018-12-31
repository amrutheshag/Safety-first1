package com.test;

import org.testng.annotations.Test;

import com.pages.LoginPage;

import generics.BaseTest;
import generics.DataDriven;

public class Login extends BaseTest {
	@Test

	public void LoginToApplication() throws InterruptedException{
		String un=DataDriven.getCellValue(XLPATH,"URL'S",2,2);
		String pwd=DataDriven.getCellValue(XLPATH,"URL'S",3,2);
		String E_HomePageUrl=DataDriven.getCellValue(XLPATH,"URL'S",1,2);
		LoginPage l=new LoginPage(driver);
		l.EnteringUserName(un);
		l.Enteringpassword(pwd);
//		l.ClickOnLoginBTN();
		l.VerifyHomePageUrl(E_HomePageUrl);
}
}