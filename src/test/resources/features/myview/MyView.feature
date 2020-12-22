Feature: Home page mantis

  Scenario: Check login redirect correctly to my view
    Given user is able to view main page
    When user enter valid login
    Then user is redirected to my view
    And default project is selected