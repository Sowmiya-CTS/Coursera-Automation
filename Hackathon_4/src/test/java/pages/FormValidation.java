package pages;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.ExcelUtils;

public class FormValidation {
    WebDriver driver;
    WebDriverWait wait;

    public FormValidation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15)); 
    }

    @FindBy(xpath = "(//li[contains(@class,'SubFooterSection')])[50]/a") 
    WebElement forEnterpriseLink;
    
    @FindBy(id = "FirstName") 
    WebElement firstNameInput;
    
    @FindBy(id = "LastName") 
    WebElement lastNameInput;
    
    @FindBy(id = "Email") 
    WebElement emailInput;
    
    @FindBy(className = "mktoButton") 
    WebElement submitButton;
    
    @FindBy(id = "ValidMsgEmail") 
    WebElement errorMsg;


    public void validateForm() throws IOException {
        forEnterpriseLink.click();

        ExcelUtils excel= new ExcelUtils();
        String data[]=excel.readExcelData();
        firstNameInput.sendKeys(data[0]);
        lastNameInput.sendKeys(data[1]);
        emailInput.sendKeys(data[2]);

        submitButton.click();

        System.out.println("The displayed Error Message are :");
        System.out.println(errorMsg.getText());
    }
}