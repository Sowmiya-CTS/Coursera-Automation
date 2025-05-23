package testing;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FormValidation;
import pages.LanguageLearningCourse;
import pages.WebDevelopmentCourses;
import util.Prophandle;
import util.ScreenShot;

@Listeners(CustomHTMLListener.class)

public class CourseraTestNG {
    WebDriver driver;
    Actions actions;
    WebDevelopmentCourses webdevcourse;
    LanguageLearningCourse langlearncourse;
    FormValidation formval;
    Prophandle ph=new Prophandle();
    
    
    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {

    	if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        	
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        driver.get(ph.getUrl());
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        webdevcourse = new WebDevelopmentCourses(driver);
        langlearncourse = new LanguageLearningCourse(driver);
        formval = new FormValidation(driver);
        new ScreenShot(driver);
    }
    
   
    @Test
    public void testHomePageLoad() throws InterruptedException {
    	Thread.sleep(2000);  
    	Assert.assertEquals(driver.getTitle(), "Coursera | Degrees, Certificates, & Free Online Courses");
    }
    

	

    @Test(priority=1)
    public void testWebDevelopmentCourses() {
    	String courese_name=ph.getCourseName();
    	webdevcourse.searchCourses(courese_name);
        actions.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        webdevcourse.selectLanguage();
        webdevcourse.selectLevel();
        webdevcourse.displayCourseDetails(2);
       
    }

    @Test(priority=2)
    public void testLanguageLearningCourses() {
    	langlearncourse.getTotalLanguages();
    	langlearncourse.getTotalLevels();
    	 
    }

    @Test(priority=3)
    public void testFormValidation() throws IOException {
    	formval.validateForm();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
