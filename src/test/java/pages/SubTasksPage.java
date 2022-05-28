package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SubTasksPage {

    WebDriver driver = Driver.getDriver();

    public SubTasksPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[contains(text(), 'Manage Subtasks')]")
    public WebElement manageSubtaskButton;

    @FindBy(css = "button.btn.btn-xs.btn-primary.ng-binding")
    public WebElement clickManageSubtaskButton;

    @FindBy(xpath = "//*[@editable-text='task.body']")
    public WebElement editableText;

    @FindBy(xpath = "//*[contains(text(),'Editing Task')]")
    public WebElement taskID;

    @FindBy(id = "add-subtask")
    public WebElement addButton;

    @FindBy(css = "#new_sub_task")
    public WebElement subTaskDescription;

    @FindBy(css = "#dueDate")
    public WebElement dueDate;


}
