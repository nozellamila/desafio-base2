Feature: List and search issues for all projects in view issues

  Background:
    Given user is logged
    And default project is selected
    And user goes to view issues

  Scenario: Search using filters table
    When user list issues using filters
    Then system lists corresponding issues for applied filters

  Scenario: Search using searching area
    When user search a specific issue
    Then system list corresponding issue searched

  Scenario: Reset filters
    Given there is applied filters
    When user reset applied filters
    Then system lists all issues