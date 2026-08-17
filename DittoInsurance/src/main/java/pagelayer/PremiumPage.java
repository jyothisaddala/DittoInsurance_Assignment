package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baselayer.BasePage;

public class PremiumPage extends BasePage{

	public PremiumPage(WebDriver driver) {
		super(driver);
		
		
	}
	@FindBy(xpath = "//span[normalize-space()='Base Premium']/following-sibling::span")
    private WebElement basePremium;
    @FindBy(xpath = "//span[normalize-space()='Total Premium']/following-sibling::span")
    private WebElement totalPremium;
   @FindBy(xpath = "//input[@type='checkbox' and @name='Unlimited Restoration']")
    private WebElement unlimitedRestoration;
    @FindBy(xpath = "//input[@name='Unlimited Restoration']/ancestor::div[contains(@class,'Grid-col')]/following-sibling::div[contains(@class,'Grid-col')]//span")
    private WebElement unlimitedRestorationPremium;
    @FindBy(xpath = "//input[@type='checkbox' and @name='Optima Well-being']")
    private WebElement optimaWellBeing;
    @FindBy(xpath = "//input[@name='Optima Well-being']/ancestor::div[contains(@class,'Grid-col')]/following-sibling::div[contains(@class,'Grid-col')]//span")
    private WebElement optimaWellBeingPremium;
    
    public double getBasePremium() {
    	wait.until(ExpectedConditions.visibilityOf(basePremium));
        return getAmount(basePremium);
    }


    public double getTotalPremium() {

        return getAmount(totalPremium);
    }


    public double getUnlimitedRestorationPremium() 
    { 
    	wait.until(ExpectedConditions.elementToBeClickable(unlimitedRestorationPremium));
    	return getAmount(unlimitedRestorationPremium); 
    	} 
    public double getOptimaWellBeingPremium()
    { 
    	return getAmount(optimaWellBeingPremium); 
    } 
    public void selectUnlimitedRestoration() { 
    	wait.until(ExpectedConditions.elementToBeClickable(unlimitedRestoration));

    	click(unlimitedRestoration); 
    	}
    public void selectOptimaWellBeing() {
    	click(optimaWellBeing); 
    	}
    


	
    private double getAmount(WebElement element) {

        String value = getText(element);

        value = value
                .replace("₹", "")
                .replace(",", "")
                .trim();

        return Double.parseDouble(value);
    }


	
}

