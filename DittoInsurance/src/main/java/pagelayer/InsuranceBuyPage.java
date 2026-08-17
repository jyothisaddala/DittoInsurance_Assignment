package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baselayer.BasePage;

public class InsuranceBuyPage extends BasePage{
	
	public InsuranceBuyPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//label[.//span[normalize-space()='Self']]//div[normalize-space()='Female']")
	WebElement self;
	@FindBy(xpath="//span[normalize-space()='Next step']/ancestor::button")
	WebElement NextStep;
	public void selfclick() {
		wait.until(ExpectedConditions.elementToBeClickable(self));
		self.click();
				
	}
 public void NextStepClick() {
		wait.until(ExpectedConditions.elementToBeClickable(NextStep));
		NextStep.click();
				
	}
				
	}

