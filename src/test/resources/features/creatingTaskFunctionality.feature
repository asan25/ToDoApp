@US_1
  Feature: Task creation functionality verification


    @TC001
    Scenario: MyTask link verification
      Given user is on the home page
      Then user should see MyTasks link on the NavBar

    @TC002
    Scenario: Verify created tasks in MyTasks page
        Given user is on the home page
        When user click to MyTasks
        Then user should be see created tasks

    @TC003
    Scenario: Validate singIn message
      Given user is on the home page
      When user clicks to MyTask link
      Then user should be able to see displayed message

    @TC004
    Scenario: Task creation with valid input
      Given user on the MyTasksPage
      When user inputs valid characters
      And user hits enter or clicking on the add task button
      Then user should be create task

    @TC005
    Scenario: Task creation with invalid input
      Given user on the MyTasksPage
      When user inputs invalid characters
      And And user hits enter or clicking on the add task button
      Then user should not to create task





