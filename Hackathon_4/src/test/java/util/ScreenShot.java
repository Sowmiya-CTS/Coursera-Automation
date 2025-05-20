package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenShot {
	public static WebDriver driver;
	
	public ScreenShot(WebDriver driver) {
		ScreenShot.driver = driver;
	}
    
	public static String takeScreenshot(String testCaseName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        if(ts == null) return  "";
        
        File source = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destination = System.getProperty("user.dir") + "/screenshots/" + testCaseName + "_" + timestamp + ".png";
        File finalDestination = new File(destination);
        try {
            FileUtils.copyFile(source, finalDestination);
            return destination;
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        
    }
}