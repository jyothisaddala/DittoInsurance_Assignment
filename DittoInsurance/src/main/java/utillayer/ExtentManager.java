package utillayer;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static ExtentReports getExtentReports() {
		if (extent == null) {
	String timeStamp=new SimpleDateFormat("yyyy.MM.d.HH.mm.ss").format(new Date());
	String repName="Test_Report_"+timeStamp+".html";
	String reportPath = ".\\reports\\" + repName;
	 ExtentSparkReporter sparkReporter =new ExtentSparkReporter(reportPath);
	sparkReporter.config().setReportName("Ditto Automation Report");
    sparkReporter.config().setDocumentTitle("Ditto Health Insurance Automation");
     
    extent = new ExtentReports();
    extent.attachReporter(sparkReporter);

    extent.setSystemInfo("Application", "DittoInsurance");
    extent.setSystemInfo("Browser", "Chrome");
    extent.setSystemInfo( "Framework","Selenium + Java + TestNG + POM");
		}
		return extent;      
    
     

	
}
}
	
