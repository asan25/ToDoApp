package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import utilities.Driver;




public class LoginPageStepDef {
    String emailId = "asenahmedli@gmail.com";
    String baseURL = "https://qa-test.avenuecode.io/";
    String password = "Qualityassurance";

    WebDriver driver = Driver.getDriver();
    LoginPage login = new LoginPage(driver);
    HomePage hPage = new HomePage(driver);

    @Given("User lands on ToDo App")
    public void user_lands_on_to_do_app() {
        Driver.getDriver().get(baseURL);
        login.signIn.click();

    }
    @When("User enters valid emailID")
    public void user_enters_valid_email_id() {
        login.email.sendKeys(emailId);
    }
    @When("User enters valid password")
    public void user_enters_valid_password() {
        login.password.sendKeys(password);

    }
    @When("user click signIn button")
    public void user_click_sign_in_button() {
    login.signToPage.click();
    }

    @Then("User should be able to land on home page")
    public void user_should_be_able_to_land_on_home_page() {
        String actualMessage = hPage.myTasksMessage.getText();
        String expectedMessage = "Signed in successfully.";
        Assert.assertEquals("User could not landing home page",actualMessage,expectedMessage);

    }

    @When("User enters invalid emailID")
    public void user_enters_invalid_email_id() {

        login.email.sendKeys("asasn@gmail");

    }
    @When("User enters invalid password")
    public void user_enters_invalid_password() {
    login.password.sendKeys("asdasdasd");
    }

    @Then("User should able to see error message")
    public void user_should_able_to_see_error_message() {
        String actualMessage = login.errorMessage.getText();
        String expectedMessage = "Invalid email or password.";
        Assert.assertEquals("User should not landing home page",actualMessage,expectedMessage);

    }


}
