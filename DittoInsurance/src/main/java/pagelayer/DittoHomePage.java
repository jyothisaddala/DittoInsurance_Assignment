package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baselayer.BasePage;

public class DittoHomePage extends BasePage{
	
	public DittoHomePage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//div[contains(@class,'m_96bdd299 mantine-Grid-col __m__-r')]//span[normalize-space()='Optima Secure']")
	WebElement optimaSecure;
	@FindBy(xpath="//button[./span[normalize-space()='Next']]")
	WebElement NextButton;
	@FindBy(xpath="//button[.//span[normalize-space()='Full list']]")
	WebElement FullList;
	@FindBy(xpath=".//span[normalize-space()='Close']/ancestor::button")
	WebElement close;
	@FindBy(xpath="//button[./span[normalize-space()='Next']]")
	WebElement NextButton1;
	@FindBy(xpath="//button[./span[normalize-space()='Next']]")
	WebElement NextButton2;
	@FindBy(xpath="//span[normalize-space()='Continue']/ancestor::button")
	WebElement continuebtn;
	
	
	

 public void optima() {
	 optimaSecure.click();
 }
 public void Next() {
	 wait.until(ExpectedConditions.elementToBeClickable(NextButton));
	 NextButton.click();
 }
 public void clickFullList() {
	    wait.until(ExpectedConditions.elementToBeClickable(FullList));
	    FullList.click();
	}

	public void closeFullList() {
	    wait.until(ExpectedConditions.elementToBeClickable(close));
	    close.click();
	}

	public void clickNext1() {
	    wait.until(ExpectedConditions.elementToBeClickable(NextButton1));
	    NextButton1.click();
	}

	public void clickNext2() {
	    wait.until(ExpectedConditions.elementToBeClickable(NextButton2));
	    NextButton2.click();
	}
 public void Continue() {
	 wait.until(ExpectedConditions.elementToBeClickable(continuebtn));
	 continuebtn.click();
 }
 
 
}

