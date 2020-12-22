Feature: Search issues in home page

  Background:
    Given user is logged

  Scenario Outline: Search using invalid filter
    When user enters "<issue>"
    Then system shows an error "<message>"

    Examples:
    | issue        | message                           |
    | ""           | A number was expected for bug_id. |
    | 000          | Issue 0 not found.                |
    | 1000000000   | Issue 1000000000 not found.       |

  Scenario: Search using valid filter
    When user enters valid issue number
    Then system shows issue details
    And searched issue is placed in Recently visited

  Scenario: Search issue for a given project
    Given project has one or more issues
    When user selects a project
    Then project's issues are listed