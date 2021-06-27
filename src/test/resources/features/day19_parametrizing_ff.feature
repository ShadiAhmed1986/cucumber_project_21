@wip @regression
Feature: Finding product on google search
  Background: user navigates to google page
    Given user is on google page

# Test data = iphone. "" will parametrize this data
# This means this parameter can be any test data
  Scenario: TC01_iphone_search
    Given user search for "iPhone"
    Then verify the result has "iPhone"
    Then close the application

  Scenario: TC02_bmw_search
    Given user search for "bmw"
    Then verify the result has "bmw"
    Then close the application

  Scenario: TC03_tesla_search
    Given user search for "tesla"
    Then verify the result has "tesla"
    Then close the application