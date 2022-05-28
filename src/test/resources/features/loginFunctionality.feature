
Feature: Login functionality verification

  @TC_1
  Scenario: User logs in with valid credentials
  Given User lands on ToDo App
  When User enters valid emailID
  And User enters valid password
  And user click signIn button
  Then User should be able to land on home page


  @TC_2
  Scenario: User logs in with invalid credentials
    Given User lands on ToDo App
    When User enters invalid emailID
    And User enters invalid password
    And user click signIn button
    Then User should able to see error message



