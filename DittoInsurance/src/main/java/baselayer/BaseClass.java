package baselayer;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@Parameters({"os","browser"})
	
	
	@BeforeTest
	public void setup(String os,String browser) throws IOException {
		FileReader file=new FileReader("./src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		if(browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("baseUrl"));
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
