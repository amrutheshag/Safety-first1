package com.test;

import org.testng.annotations.Test;

import com.pages.CP_LoginPage;

import generics.BaseTest;
import generics.DataDriven;

public class CP_LoginTest extends BaseTest {
	@Test

	public void LoginToApplication() throws InterruptedException{
		String un=DataDriven.getCellValue(XLPATH,"Safety first CP",2,2);
		String pwd=DataDriven.getCellValue(XLPATH,"Safety first CP",3,2);
		String E_HomePageUrl=DataDriven.getCellValue(XLPATH,"Safety first CP",1,2);
		CP_LoginPage l=new CP_LoginPage(driver);
		l.OpeningTheBrowser();
		l.EnteringUserName(un);
		l.Enteringpassword(pwd);
		l.ClickOnLoginBTN();
		l.VerifyHomePageUrl(E_HomePageUrl);
		
}
}