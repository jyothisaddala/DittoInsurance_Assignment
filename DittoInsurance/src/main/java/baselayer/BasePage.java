package baselayer;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	protected WebDriverWait wait;
	
	public  BasePage(WebDriver driver){
		this.driver=driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}
		 protected String getText(WebElement element) {
		        return element.getText();
		    }

		    protected void click(WebElement element) {
		        element.click();
		    }
		
	
	

}
