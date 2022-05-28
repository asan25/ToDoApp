package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.nio.charset.StandardCharsets;

public class LoginPage {

    WebDriver driver = Driver.getDriver();
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    String emailId = "asenahmedli@gmail.com";
    String baseURL = "https://qa-test.avenuecode.io/";
    String passwordText = "Qualityassurance";

    @FindBy(css = "a.btn.btn-lg.btn-primary")
    public WebElement signIn;

    @FindBy(css = "#user_email")
    public WebElement email;

    @FindBy(css = "#user_password")
    public WebElement password;

    @FindBy(css = "[name='commit']")
    public WebElement signToPage;

    @FindBy(css = "div.alert.alert-warning")
    public WebElement errorMessage;

    public void loginToHomePage(){
        driver.get(baseURL);
        signIn.click();
        email.sendKeys(emailId);
        password.sendKeys(passwordText);
        signToPage.click();
    }


}
