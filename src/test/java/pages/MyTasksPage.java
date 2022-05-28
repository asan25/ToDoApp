package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MyTasksPage {
    WebDriver driver = Driver.getDriver();
    public MyTasksPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#my_task")
    public WebElement myTasksLink;

    @FindBy(css = "#new_task")
    public WebElement taskBar;

    @FindBy(css = "span.input-group-addon.glyphicon.glyphicon-plus")
    public WebElement addButton;






}
