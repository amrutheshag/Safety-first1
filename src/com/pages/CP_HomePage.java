package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.util.OpenIntToFieldHashMap.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import generics.BasePage;
import generics.DataDriven;
public class CP_HomePage extends BasePage {
	
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100))
	        .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class).ignoring(WebDriverException.class);
	
	String XLPATH="./TestData/input.xlsx";
	int rc=DataDriven.getRowCount(XLPATH,"Screens");
	
	//WebDriverWait wait = new WebDriverWait(driver, 25);
	@FindBy(id="HomeScreen")
	private WebElement  HomePageBTN;
	
	@FindBy(xpath="//div[.='Lowestest']")
	private WebElement  Lowestest;
	
	@FindBy(xpath="//div[.='Lowestest']//..//button[@data-action-type='Manage']")
	private WebElement  ManageLink;
	
	@FindBy(xpath="//i[@class='fa fa-th-large']")
	private WebElement  Setup_Application_Module_Link;
	
	@FindBy(xpath="//p[.='Configure Category list']")
	private WebElement  Configure_Category_list_Link;
	
	@FindBy(xpath="(//select[@size='10'])[1]")
	private WebElement Empty_Values;
	
	@FindBy(xpath="(//select[@size='10'])[1]/..//option")
	private WebElement  Configure_Category_list_Values;
	
	@FindBy(xpath="//button[.='>>']")
	private WebElement  Left_To_Right_Arrow_BTN;
	
	@FindBy(xpath="//button[.='Configure']")
	private WebElement Configure_BTN;
	
	@FindBy(xpath="//img[@src='/assets/images/select-all.png']")
	private WebElement Select_All_BTN;
	
	
	/* store list values*/

	@FindBy(xpath="(//select[@size='10'])[2]/..//option")
	private WebElement Configured_listed_categories;
	
	@FindBy(xpath="//input[@class='btn-default btn-inside float-right mleft-sm ']|//input[@value='Save']")
	private WebElement SaveBTN;
	
	@FindBy(xpath="//a[@href='#/client-confighome']")
	private WebElement Setup_Application_Modules_BreadCrumb;
	
	@FindBy(xpath="//input[@class='btn-default float-left mleft-sm skin-color']")
	private WebElement BackBTN;
	
	
	@FindBy(xpath="//i[@class='fa fa-tag fa-cubes']")
	private WebElement Configure_Module_Link;
	
	@FindBy(xpath="(//span[.='EDF Module']|//div[.='Drivers'])[2]")
	private WebElement Driver;
	
	@FindBy(xpath="(//span[.='EDF Module']|//div[.='Drivers'])[2]/..//input")
	private WebElement Driver_Check_Box;
	
	@FindBy(xpath="//button[@data-tip='Configure']")
	private WebElement ConfigureBTN;
	
	@FindBy(xpath="(//span[.='EDF Screen']|//div[.='Driver'])[2]")
	private WebElement EDF_Screen_Driver;
	
	@FindBy(xpath="(//tree-viewport)[1]")
	private WebElement All_Screen_Attribute;
	
	@FindBy(xpath="((//tree-viewport)[1]/..//span)[3]")
	private WebElement All_Screen_Attribute_List_values;
	
	@FindBy(xpath="(//div[.='Saved successfully'])[2]")
	private WebElement Saved_successfully_Msg;
	
	@FindBy(xpath="//button[.='OK']")
	private WebElement OK_BTN;
	
	@FindBy(xpath="//p[.='Configure Workflow']")
	private WebElement Configure_Workflow_Link;
	
	@FindBy(xpath="//select[@formcontrolname='selectedModuleId']")
	private WebElement Module_ListBox;
	
	@FindBy(xpath="//input[@data-action-type='ISCONFIGURED']")
	private WebElement CONFIGURE_MODULE_SCREENS_CheckBox;
	
//	@FindBy(xpath="//div[@col-id='screenTitle']")
//	private WebElement Screen_names;
	
	
	
	public CP_HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void Searching_Lowestest(){
		Actions  a= new Actions(driver);
		a.moveToElement(Lowestest).perform();
		Reporter.log("Lowestest Is Existing",true);
		if(Lowestest.isDisplayed())
		{
			Lowestest.click();
		}
		else{
			Reporter.log("Lowestest not available",true);
			/* need to add logo*/
		}
	}
	
	public void Click_On_Manage_Link(){
		wait.until(ExpectedConditions.elementToBeClickable(ManageLink));
		ManageLink.click();
		Reporter.log("Cliked On Manage Link",true);
			
	}
	
	public void Click_On_Setup_Application_Module_Link(){
		wait.until(ExpectedConditions.elementToBeClickable(Setup_Application_Module_Link));
		Setup_Application_Module_Link.click();
		Reporter.log("Cliked On Setup Application Module Link",true);

	}
	
	public void Click_On_Configure_Category_list_Link() throws InterruptedException{
		wait.until(ExpectedConditions.elementToBeClickable(Configure_Category_list_Link));
		Configure_Category_list_Link.click();
		Reporter.log("Cliked Configure_Category_list_Link",true);
		Thread.sleep(1000);
	}
	
	public void Click_On_Configure_Category_list_Values() throws InterruptedException, AWTException{
		 if(Empty_Values.isDisplayed()){
		List<WebElement> dropdown=driver.findElements(By.xpath("(//select[@size='10'])[1]/..//option"));
		
				while(dropdown.isEmpty()) {
				Reporter.log("values not available",true);
				return;
					}
						for(int i=0; i<dropdown.size(); i++) {
						Reporter.log("Configuring Category list",true);
						dropdown.get(i).click();
						Thread.sleep(1000);
						wait.until(ExpectedConditions.elementToBeClickable(Left_To_Right_Arrow_BTN));
						Left_To_Right_Arrow_BTN.click();
							
						List<WebElement>  dropdown2 = driver.findElements(By.xpath("(//select[@size='10'])[2]/..//option"));
						
								dropdown2.get(1).click();
								Robot r = new Robot();
								r.keyRelease(KeyEvent.VK_SHIFT);
								r.keyPress(KeyEvent.VK_END);
								r.keyRelease(KeyEvent.VK_END);
								wait.until(ExpectedConditions.elementToBeClickable(Configure_BTN));
								Configure_BTN.click();
								Thread.sleep(3000);
								wait.until(ExpectedConditions.elementToBeClickable(Select_All_BTN));
								Select_All_BTN.click();
								wait.until(ExpectedConditions.elementToBeClickable(SaveBTN));
								SaveBTN.click();
								Thread.sleep(5000);
							
								}
		 					}

		}

		public void Click_On_BackBTN(){
		wait.until(ExpectedConditions.elementToBeClickable(BackBTN));
		Actions c= new Actions(driver);
		c.moveToElement(BackBTN).perform();
		BackBTN.click();
		Reporter.log("Cliked on BackBTN",true);
	}
		public void Click_On_Configure_Module_Link(){
			wait.until(ExpectedConditions.elementToBeClickable(Configure_Module_Link));
			Configure_Module_Link.click();
			Reporter.log("Cliked Configure_Module_Link",true);
		}
		
		public void Click_On_Driver(){
			
			Actions c= new Actions(driver);
			c.moveToElement(Driver).perform();
			wait.until(ExpectedConditions.elementToBeClickable(Driver));
			Driver.click();
			Reporter.log("Found Driver And Cliked On Driver",true);
		}
		
//		public void Click_On_Driver_CheckBox(){
//			if(Driver_Check_Box.isSelected())
//			{
//				Driver.click();
//				ConfigureBTN.click();
//			Reporter.log("Driver_CheckBox Already checked",true);
//			wait.until(ExpectedConditions.elementToBeClickable(EDF_Screen_Driver));
//			EDF_Screen_Driver.click();
//			wait.until(ExpectedConditions.elementToBeClickable(ConfigureBTN));
//			ConfigureBTN.click();
//
//			}
//			else{
//				Driver.click();
//				Driver_Check_Box.click();
//				wait.until(ExpectedConditions.elementToBeClickable(ConfigureBTN));
//				ConfigureBTN.click();
//				
//				for(int i=1;i<=rc;i++)
//				{
//					String values=DataDriven.getCellValue(XLPATH,"Screens",i,1);
//					System.out.println(values);
//					
//					if(Screen_names.equals(i)){
//						
//						Screen_names.click();
//					}
//				}
//				
//				wait.until(ExpectedConditions.elementToBeClickable(EDF_Screen_Driver));
//				EDF_Screen_Driver.click();
//				wait.until(ExpectedConditions.elementToBeClickable(ConfigureBTN));
//				ConfigureBTN.click();
//				}
//			}
		
		//Working fine
		
		public void Click_On_Driver_CheckBox(){
			
			if(Driver_Check_Box.isSelected())
			{
			Driver.click();
			ConfigureBTN.click();
			Reporter.log("Driver_CheckBox Already checked",true);				
				for(int i=1;i<=rc;i++)
				{
					List<WebElement>Screen_names=driver.findElements(By.xpath("//div[@col-id='screenTitle']"));

					for(WebElement ele :Screen_names) {
					    String s=ele.getText().toString();
					    System.out.println(s);
//					    s=s.substring(s.indexOf("(")+1, s.indexOf(")"));
//					    System.out.println("Number==>"+s);
					
					
				String values=DataDriven.getCellValue(XLPATH,"Screens",i,1);
				
				if(values.equals(s)){
					
					Screen_names.get(i).click();
					System.out.println(i);
//					wait.until(ExpectedConditions.elementToBeClickable(ConfigureBTN));
//					ConfigureBTN.click();
				}
				}
			}
			
			
//			wait.until(ExpectedConditions.elementToBeClickable(EDF_Screen_Driver));
//			EDF_Screen_Driver.click();
//			wait.until(ExpectedConditions.elementToBeClickable(ConfigureBTN));
//			ConfigureBTN.click();

			
//			else{
//				Driver.click();
//				Driver_Check_Box.click();
//				wait.until(ExpectedConditions.elementToBeClickable(ConfigureBTN));
//				ConfigureBTN.click();
//				
//	
//				wait.until(ExpectedConditions.elementToBeClickable(EDF_Screen_Driver));
//				EDF_Screen_Driver.click();
//				wait.until(ExpectedConditions.elementToBeClickable(ConfigureBTN));
//				ConfigureBTN.click();
//				}
			}
			}
		//--------------------------------
		
		
		public void configure_Screens() throws InterruptedException{
		if(All_Screen_Attribute.isDisplayed()){
			List<WebElement> dropdown=driver.findElements(By.xpath("(//tree-viewport)[1]//tree-node-content//span"));
			
			while(dropdown.isEmpty()) {
				Reporter.log("values not available",true);
				
				
				return;
			}
			 for(int i=0; i<dropdown.size(); i++) {
				dropdown.get(i).click();
				Thread.sleep(1000);
				wait.until(ExpectedConditions.elementToBeClickable(Left_To_Right_Arrow_BTN));
				Left_To_Right_Arrow_BTN.click();
				wait.until(ExpectedConditions.elementToBeClickable(SaveBTN));
				SaveBTN.click();
				wait.until(ExpectedConditions.elementToBeClickable(Saved_successfully_Msg));
				String msg=Saved_successfully_Msg.getText().toString();
				Reporter.log(msg,true);
				OK_BTN.click();
				//wait.until(ExpectedConditions.elementToBeClickable(Setup_Application_Modules_BreadCrumb));
				//Setup_Application_Modules_BreadCrumb.click();
				BackBTN.click();
				wait.until(ExpectedConditions.elementToBeClickable(BackBTN));
				BackBTN.click();
				wait.until(ExpectedConditions.elementToBeClickable(BackBTN));
				BackBTN.click();
			 }
		}
		else{
			
			}
		}
		public void Click_On_BackBTN_In_configure_Screens(){
			wait.until(ExpectedConditions.elementToBeClickable(BackBTN));
			Actions c= new Actions(driver);
			c.moveToElement(BackBTN).perform();
			Reporter.log("Screen already configured",true);
			BackBTN.click();
			wait.until(ExpectedConditions.elementToBeClickable(BackBTN));
			BackBTN.click();
			wait.until(ExpectedConditions.elementToBeClickable(BackBTN));
			BackBTN.click();
			Reporter.log("Navigated To configure_WorkFlow",true);
		}
		
public void configure_WorkFlow_Link(){
			Configure_Workflow_Link.click();
			wait.until(ExpectedConditions.visibilityOf(Module_ListBox));
			Select select= new Select(Module_ListBox);
			select.selectByVisibleText("Drivers");
			
			
			
		}		
		
}

