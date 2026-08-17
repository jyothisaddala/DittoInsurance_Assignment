package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baselayer.BasePage;

public class PlanPage extends BasePage{
	public PlanPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//input[@placeholder='Your age']")
	WebElement age;
	
	@FindBy(xpath="//input[@placeholder='Enter your pin code']")
	WebElement pincode;
	@FindBy(xpath="//p[contains(@id,'-error') and normalize-space()='Enter a valid pincode']")
	WebElement pincodeError;
	@FindBy(xpath="//input[@type='radio' and @value='false']")
	WebElement radiobtn;
	
	@FindBy(xpath="//form[@id='health-quote-plan-form']//span[normalize-space()='Calculate Premium']/ancestor::button")
	WebElement calpremium;
	
	public void Agenum(String ages) {
		 wait.until(ExpectedConditions.visibilityOf(age));
		 age.click();
		    age.clear();
		 age.sendKeys(ages);
		 System.out.println("Age field value: " + age.getAttribute("value"));
			
					
		}
		public void PinCode(String pincd) {
		wait.until(ExpectedConditions.visibilityOf(pincode));
		 pincode.sendKeys(pincd);
			
					
		}
		

		
	public void loyaltydsct() {
		wait.until(ExpectedConditions.elementToBeClickable(radiobtn));
		radiobtn.click();
	}

	public void CalculatePremiumClick() {
		wait.until(ExpectedConditions.visibilityOf(calpremium));
		calpremium.click();
	}
	 

}
