package testlayer;


import org.testng.annotations.Test;

import baselayer.BaseClass;

import pagelayer.DittoHomePage;
import pagelayer.InsuranceBuyPage;
import pagelayer.PlanPage;
import pagelayer.PremiumPage;


public class DittoHomeTest extends BaseClass{
	@Test
	public void Test() {
		
	DittoHomePage page=new DittoHomePage(driver);
	page.optima();
	logger.info("Successfully clicked on HDFCERGO OptimaSecure");
	page.Next();
	logger.info("Successfully clicked on MainBenefits");
	page.clickFullList();
	logger.info("Successfully clicked on FullList");
	page.closeFullList();
	logger.info("Successfully clicked on closed");
	page.clickNext1();
	logger.info("Successfully clicked on WhatsNotCovered");

	page.clickNext2();
	logger.info("Successfully clicked on ExtraBenefits");
	page.Continue();
	logger.info("Successfully clicked on ContinueButton");
	InsuranceBuyPage buy=new InsuranceBuyPage(driver);
	buy.selfclick();
	logger.info("Successfully clicked on female member type");
	buy.NextStepClick();
	logger.info("Successfully clicked on Nextstep");
	PlanPage ppage=new PlanPage(driver);
	ppage.Agenum(p.getProperty("enterage"));
	logger.info("Successfully Entered on Age");
	ppage.PinCode(p.getProperty("enterpincode"));
	logger.info("Successfully Entered on pincode");
	ppage.loyaltydsct();
	logger.info("Successfully clicked on radiobtn");
	ppage.CalculatePremiumClick();
	logger.info("Successfully clicked on premium");
	
	
	PremiumPage premiumPage =new PremiumPage(driver);
    premiumPage.selectUnlimitedRestoration();
    double basePremium =premiumPage.getBasePremium();
    double riderPremium =premiumPage.getUnlimitedRestorationPremium();
    double optimaPremium=premiumPage.getOptimaWellBeingPremium();
    double totalPremium =premiumPage.getTotalPremium();
    System.out.println("Base Premium : " + basePremium);
    System.out.println("Rider Premium : " + riderPremium);
    System.out.println("OptimaPremium :"+optimaPremium);
    System.out.println("Total Premium : " + totalPremium);
   
}
}

