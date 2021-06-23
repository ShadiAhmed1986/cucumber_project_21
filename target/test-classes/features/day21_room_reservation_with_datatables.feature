@data_tables
Feature: room reservation with data tables
  Scenario: TC01_user should be able log in with manager credentials
    Given user is on the application_login page
    And user enters manager_username and manager_password
    |manager|Manager1!|
    And clicks on login button
    And verify login "manager" is displayed
    And user navigates to create_room_reservation_page

  Scenario: TC02_user_should_be_able_to_make_room_reservation
    Given user enters all required fields
      |IdUser|IDHotel|Price|date_start|date_end  |adult_amount|children_amount|contact_name|contact_phone |contact_email    |notes |
      |manager|Sierra|1000 |09/12/2021|09/25/2021|3           |2              |Ekrem       |(321) 111-2233|myemail@gmail.com|test 1|
    And user clicks on the approved checkbox
    And user clicks on the is_paid checkbox
    And user clicks on the save_button
    Then user verifies the success_message
    Then capture the screeenshot
    Then close the application