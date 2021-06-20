@scenario_outline_1
Feature: Multiple_google_search
  Background: user navigates to google page
    Given user is on google page

  Scenario Outline: searching_word_capitals
    Given user search for "<world_capitol>"
    Then verify the result has "<world_capitol>"
    Then close the application

    Examples: capitals
      |world_capitol|
      |paris        |
      |london       |
      |berlin       |
      |ankara       |
      |baku         |