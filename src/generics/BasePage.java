package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver=driver;
	}

	
		public void sleep(int i){
			try {
				Thread.sleep(i*1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}