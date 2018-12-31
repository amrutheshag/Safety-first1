package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest implements IAutoConst{
		public WebDriver driver;
		
			@BeforeSuite
			public void initDriver()
			{
				System.setProperty(CHROME_KEY, CHROME_VALUE);
				System.setProperty(FIREFOX_KEY,FIREFOX_VALUE);

			}

			@BeforeMethod
			public void openApplication() throws Exception{
				driver=new ChromeDriver();
//				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
			}
			
//			@AfterMethod
//			public void closeApplication(){
//				driver.quit();
//			}
			
						
			@AfterMethod
			public void closeApplication(ITestResult result){
				String name=result.getName();
				int status = result.getStatus();
				if(status==2){
					Reporter.log("TestName:"+name +" Status:FAIL",true);
				}
				else{
					Reporter.log("TestName:"+name +" Status:PASS",true);
				}
				//driver.quit();
			}
	}