Feature: Realizar login

  Scenario: Check login is working properly with credentials

    Given User is in login page
    When User enters username and password
    And Clicks on submission button
    Then user is able to view de main page

