
@US_2
Feature: Validate SubTask Creation functionality

  @TC001
  Scenario: Validate button labeled as ‘Manage Subtasks’
    Given user on the MyTasksPage
    When user creates task
    Then user should see a button labeled as ‘Manage Subtasks’

  @TC002
  Scenario: Validate number of subtasks created
    Given user on the MyTasksPage
    When user creates task and subtask
    Then user should see number of subtasks created for those task

  @TC003
  Scenario: Validate modal dialog pop up
    Given user on the MyTasksPage
    When user click ‘Manage Subtasks’ button
    Then user should see modal dialog pop up

  @US_2
  Scenario: Validate task ID in the pop up
    Given user on the MyTasksPage
    When user click ‘Manage Subtasks’ button
    Then user should see taskID in the pop up
  @TC005
  Scenario: Validate subTasks creation
    Given user on the MyTasksPage
    When user click ‘Manage Subtasks’ button
    And user input data to SubTask Description and Due Date fields
    And user clicks Add button
    Then user should be able to create subTask
  @TC006
  Scenario: Verify subTask creation with empty required fields
    Given user on the MyTasksPage
    When user click ‘Manage Subtasks’ button
    And user left required fields with empty data
    And user clicks Add button
    Then user shouldn't be able to create subTask









