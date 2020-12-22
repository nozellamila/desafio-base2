Feature: Report issues

  Background:
    Given user is logged
    And user goes to report issue

  Scenario Outline: Report issue with empty required fields
    When user fills "<category>", "<summary>" and "<description>"
    Then system shows an message: "<message>"

    Examples:
    | category | summary | description   | message                                                                |
    |          |         |               | A necessary field "Summary" was empty. Please recheck your inputs.     |
    |          | Teste   |               | A necessary field "Description" was empty. Please recheck your inputs. |
    |          | Teste   | Description   | A necessary field "Category" was empty. Please recheck your inputs.    |

  Scenario: Report issue successfully
    When user submits new issue
    Then system shows successfull message