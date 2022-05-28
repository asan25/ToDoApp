package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;

public class HomePageDef {
    WebDriver driver = Driver.getDriver();
    LoginPage login = new LoginPage(driver);
    HomePage page = new HomePage(driver);


    @Given("user on the home page")
    public void user_on_the_home_page() {
    login.loginToHomePage();
    }
    @When("user click to MyTasks")
    public void user_click_to_my_tasks() {
    page.myTaskLink.click();
    }
    @Then("user should be see task creation tab")
    public void user_should_be_see_task_creation_tab() {
        String expectedText = "Asan Ahmadli's ToDo List";
    String actualText = page.myTasksMessage.getText();
        Assert.assertEquals("You failed to navigate to MyTasks",expectedText,actualText);
    }

}
