package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MyTasksPage;
import utilities.Driver;

import java.util.List;


public class MyTasksStepDef {
    WebDriver driver  = Driver.getDriver();
    LoginPage login = new LoginPage(driver);
    MyTasksPage myTasksPage = new MyTasksPage(driver);

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        login.loginToHomePage();
    }

    @Then("user should see MyTasks link on the NavBar")
    public void user_should_see_my_tasks_link_on_the_nav_bar() {
        String actualText = myTasksPage.myTasksLink.getText();
        String expectedText = "My Tasks";
        Assert.assertEquals("MyTask link on the HomePage is disable ",expectedText,actualText);
    }

    @Then("user should be see created tasks")
    public void user_should_be_see_created_tasks() {

        List<WebElement> elements = driver.findElements(By.cssSelector("[type='checkbox']"));

        int actualTaskCount = elements.size();
        Assert.assertTrue("Tasks are not visible",actualTaskCount>0);
    }


    @When("user clicks to MyTask link")
    public void user_clicks_to_my_task_link() {
        myTasksPage.myTasksLink.click();
    }

    @Then("user should be able to see displayed message")
    public void user_should_be_able_to_see_displayed_message() {
        String actualText = driver.findElement(By.cssSelector("div.container h1")).getText();
        String expectedText = "Hey Asan, this is your todo list for today:";
        Assert.assertEquals(expectedText,actualText);
    }

    @Given("user on the MyTasksPage")
    public void user_on_the_my_tasks_page() {
        login.loginToHomePage();
        myTasksPage.myTasksLink.click();
    }

    @When("user inputs valid characters")
    public void user_inputs_valid_characters() {

        String task_1="example_1";
        String task_2="example_2";
        myTasksPage.taskBar.sendKeys(task_1, Keys.ENTER);
        myTasksPage.taskBar.sendKeys(task_2);
        myTasksPage.addButton.click();
        String actual_1 = driver.findElement(By.xpath("//a[text()='example_1']")).getText();
        String actual_2 = driver.findElement(By.xpath("//a[text()='example_2']")).getText();
        Assert.assertEquals("User couldn't create task",task_1,actual_1);
        Assert.assertEquals("User couldn't create task",task_2,actual_2);

    }

    @When("user hits enter or clicking on the add task button")
    public void user_hits_enter_or_clicking_on_the_add_task_button() {

    }

    @Then("user should be create task")
    public void user_should_be_create_task() {

    }

    @When("user inputs invalid characters")
    public void user_inputs_invalid_characters() {

        String longText ="But I must explain to you how all this " +
                "mistaken idea of denouncing pleasure and praising " +
                "pain was born and I will give you a complete account of " +
                "he system, and expound the actual teachings of the great explorer " +
                "of the truth, the master-builder of human";

        String shortText ="ab";

        myTasksPage.taskBar.sendKeys(longText, Keys.ENTER);
        myTasksPage.taskBar.sendKeys(shortText);
        myTasksPage.addButton.click();
        String actual_1 = driver.findElement(By.xpath("//a[text()='"+ longText + "']")).getText();
        String actual_2 = driver.findElement(By.xpath("//a[text()='"+ shortText + "']")).getText();
        Assert.assertNotEquals("User shouldn't create task",longText,actual_1);
        Assert.assertNotEquals("User shouldn't create task",shortText,actual_2);


    }

    @When("And user hits enter or clicking on the add task button")
    public void and_user_hits_enter_or_clicking_on_the_add_task_button() {

    }

    @Then("user should not to create task")
    public void user_should_not_to_create_task() {

    }
}
