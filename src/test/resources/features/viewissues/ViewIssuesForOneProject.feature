Feature: List and search issues for one specific project in view issues

  Background:
    Given user is logged
    And project has one or more issues
    And user selects a project
    And user navigates to view issues

  Scenario: Search without using filters table
    When user list all issues for the project
    Then system lists corresponding issues for the project

  Scenario: Search specific issue
    When user search a specific project's issue
    Then system list corresponding issue
    And user access issue details
    And system shows page with issue details

  Scenario: Search other project's issue
    When user search an issue not belonging to selected project
    Then system does not list corresponding issue