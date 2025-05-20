package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LanguageLearningCourse {
    WebDriver driver;

    public LanguageLearningCourse(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "(//button[contains(@class,'cds-button-disableElevation')])[2]") 
    WebElement languageButton;

    @FindBy(xpath = "(//div[@class='cds-176 cds-formGroup-groupWrapper'])[2]/div/div//div/span/span") 
    List<WebElement> languages;

    @FindBy(xpath = "//div[contains(@data-testid,'productDiff')]//div[contains(@class,'cds-checkboxAndRadio-labelText')]/span/span") 
    List<WebElement> levels;
    

    public void getTotalLanguages() {
        languageButton.click();
        System.out.println("The total Languages are listed below : ");
        System.out.println();
        for (WebElement x : languages) {
        	System.out.println(x.getText());
        }
        System.out.println();
    }

    public void getTotalLevels() {
    	System.out.println("Number of Levels are defined below :");
        System.out.println(levels.size());
        System.out.println();
        System.out.println("The total list of levels are :");
        for (WebElement x : levels) {
        	System.out.println(x.getText());
        }
        System.out.println();
    }
}
