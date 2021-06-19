Feature: Search Functionality
  Scenario: Search for teapots
    Given user is on google page
    When user search for teapots
    Then verify user can see results