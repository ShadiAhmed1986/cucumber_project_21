@selenium_grid
  Feature: verify application title
    Scenario: verify title on chrome
      Given user is on the application_login page with chrome
      Then verify the title includes Resortsline