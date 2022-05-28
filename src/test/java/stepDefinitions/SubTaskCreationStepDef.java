package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import pages.MyTasksPage;
import pages.SubTasksPage;
import utilities.Driver;
import utilities.ReUsefulMethods;

public class SubTaskCreationStepDef {

    WebDriver driver  = Driver.getDriver();
    SubTasksPage subTask = new SubTasksPage(driver);
    MyTasksPage page = new MyTasksPage(driver);
    ReUsefulMethods method = new ReUsefulMethods();
    //creation of random string
    String random=method.createRandomString();

    @When("user creates task")
    public void user_creates_task() {
        String task="example";
        page.taskBar.sendKeys(task, Keys.ENTER);
    }
    @Then("user should see a button labeled as ‘Manage Subtasks’")
    public void user_should_see_a_button_labeled_as_manage_subtasks() {
        String actualText = subTask.manageSubtaskButton.getText();
        String expectedText = "Manage Subtasks";
        boolean contains = actualText.contains(expectedText);
        System.out.println(actualText);
        Assert.assertTrue("Manage Subtasks button doesn't created", contains);
    }

    @When("user creates task and subtask")
    public void user_creates_task_and_subtask() {

        page.taskBar.sendKeys(random, Keys.ENTER);


    }
    @Then("user should see number of subtasks created for those task")
    public void user_should_see_number_of_subtasks_created_for_those_task() {


        if ((subTask.editableText).getText().equals(random)) {
            WebElement element = subTask.clickManageSubtaskButton;
            String subTaskNumbers=element.getText().substring(1,4).replace(")","").trim();
            System.out.println(subTaskNumbers);
            Assert.assertNotNull("SubTasks number is not displayed",subTaskNumbers);
        }




    }
    @When("user click ‘Manage Subtasks’ button")
    public void user_click_manage_subtasks_button() {
        page.taskBar.sendKeys(random, Keys.ENTER);
        if ((subTask.editableText).getText().equals(random)) {
            WebElement element = subTask.clickManageSubtaskButton;
            element.click();
        }


    }
    @Then("user should see modal dialog pop up")
    public void user_should_see_modal_dialog_pop_up() {
        String expected = "Create a SubTask";
        String actual = driver.findElement(By.xpath("//*[text()='Create a SubTask']")).getText();
        System.out.println(actual);
        Assert.assertEquals("SubTask pop up did not opened",expected,actual);
    }

    @Then("user should see taskID in the pop up")
    public void user_should_see_task_id_in_the_pop_up() {
        WebElement taskID1 = subTask.taskID;
        String taskID = taskID1.getText();
        Assert.assertNotNull("Task Id is not displayed",taskID);
    }

    @When("user input data to SubTask Description and Due Date fields")
    public void user_input_data_to_and_fields() {
    subTask.subTaskDescription.sendKeys("subtask_1");
    subTask.dueDate.sendKeys("05/27/2022");

    }
    @When("user clicks Add button")
    public void user_clicks_button() {
    subTask.addButton.click();
    }
    @Then("user should be able to create subTask")
    public void user_should_be_able_to_create_sub_task() {
        String text = driver.findElement(By.cssSelector("td.task_body.col-md-8.limit-word-size")).getText();
        Assert.assertNotNull("Sub task didn't created",text);
    }



    @When("user left required fields with empty data")
    public void user_left_required_fields_with_empty_data() {
        subTask.subTaskDescription.sendKeys("");
        subTask.dueDate.sendKeys("");
    }

    @Then("user shouldn't be able to create subTask")
    public void user_shouldn_t_be_able_to_create_sub_task() {
        String actual = driver.findElement(By.cssSelector("td.task_body.col-md-8.limit-word-size")).getText();
        System.out.println(actual);
        String expected = null;
        String text2 = driver.findElement(By.xpath("//*[@ng-show='task.sub_tasks.length']")).getText();
        if(!text2.contains("Remove SubTask")){
            System.out.println("Sub task not get created");
        }
        else {
            Assert.assertEquals("Sub task should't be created",expected,actual);
        }
    }
}
