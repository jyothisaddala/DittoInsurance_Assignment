package utillayer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.nio.file.Files;


public class Screenshot {
	 
    public static String captureScreenshot(WebDriver driver, String testName) {

    	String timestamp =new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        Path folder = Path.of(System.getProperty("user.dir"), "screenshots");
        try {
            Files.createDirectories(folder);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Unable to create screenshot folder", e
            );
        }

        String filePath = folder.resolve( testName + "_" + timestamp + ".png").toString();
        File source = ((TakesScreenshot) driver) .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source,new File(filePath));
            } catch (IOException e) {
            throw new RuntimeException( "Unable to save screenshot", e);
                   
          
        }

        return filePath;
    }
        
    }
	


