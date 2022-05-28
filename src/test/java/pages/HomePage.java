package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HomePage {


    WebDriver driver = Driver.getDriver();
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class='container']//h1")
    public WebElement myTasksMessage;

    @FindBy(css = "#my_task")
    public WebElement myTaskLink;





}//class
