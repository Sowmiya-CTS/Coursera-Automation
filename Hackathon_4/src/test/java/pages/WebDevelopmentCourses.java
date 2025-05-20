package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebDevelopmentCourses {
    WebDriver driver;

    

    public WebDevelopmentCourses(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@class='react-autosuggest__input']")
    WebElement searchInput;

    @FindBy(xpath = "//div[contains(@data-testid,'language:English')]/label/span")
    WebElement languageEnglish;

    @FindBy(xpath = "//div[contains(@data-testid,'Beginner')]/label/span")
    WebElement levelBeginner;

    @FindBy(xpath = "//h3[@class='cds-CommonCard-title css-6ecy9b']")
    List<WebElement> courseNames;

    @FindBy(xpath = "//span[@class='css-6ecy9b']")
    List<WebElement> ratings;

    @FindBy(xpath = "//div[@class='cds-CommonCard-metadata']/p[@class='css-vac8rf']")
    List<WebElement> durations;

    public void searchCourses(String courseName) {
        searchInput.sendKeys(courseName);
     }

    public void selectLanguage() {
        languageEnglish.click();
    }

    public void selectLevel() {
        levelBeginner.click();
    }

    public void displayCourseDetails(int count) {
    	System.out.println("These are the list of courses : ");
        for (int i = 0; i < count; i++) {
            System.out.print(courseNames.get(i).getText() + " ");
            System.out.println();
            System.out.print("Rating  of the course : " + ratings.get(i).getText() + " ");
            System.out.println();
            String[] arr = durations.get(i).getText().split("·");
            System.out.println("Duration of the course :" + arr[2]);
            System.out.println();
        }

    }
}
