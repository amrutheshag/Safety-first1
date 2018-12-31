package com.test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.pages.CP_HomePage;
import com.pages.CP_LoginPage;
import com.pages.LoginPage;

import generics.BaseTest;
import generics.DataDriven;

public class CP_DriverWorkFlow extends BaseTest {
//	int rc=DataDriven.getRowCount(XLPATH,"Screens");
//	for(int i=1;i<=rc;i++)
//	{
	@Test

	public void LoginToApplication() throws InterruptedException, AWTException{
		String un=DataDriven.getCellValue(XLPATH,"Safety first CP",2,2);
		String pwd=DataDriven.getCellValue(XLPATH,"Safety first CP",3,2);
		String E_HomePageUrl=DataDriven.getCellValue(XLPATH,"Safety first CP",4,2);
		CP_LoginPage l=new CP_LoginPage(driver);
		l.OpeningTheBrowser();
		l.EnteringUserName(un);
		l.Enteringpassword(pwd);
		l.ClickOnLoginBTN();
		l.VerifyHomePageUrl(E_HomePageUrl);
		CP_HomePage H= new CP_HomePage(driver);
		H.Searching_Lowestest();
		H.Click_On_Manage_Link();
		H.Click_On_Setup_Application_Module_Link();
		H.Click_On_Configure_Category_list_Link();
		H.Click_On_Configure_Category_list_Values();
		//H.Click_On_Setup_Application_Modules_BreadCrumb();
		H.Click_On_BackBTN();
		H.Click_On_Configure_Module_Link();
		H.Click_On_Driver();
		H.Click_On_Driver_CheckBox();
		H.configure_Screens();
		H.Click_On_BackBTN_In_configure_Screens();
		H.configure_WorkFlow_Link();
		
}	

}