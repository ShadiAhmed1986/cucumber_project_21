@db_read2
Feature:Read_database_data
  Scenario: Read_hotel_reservation
    Given user connects to the database
    And user gets "Name" from "tHOTELROOM" table
    And user reads all rows in the "Name" column
    And users gets the value in row 6 in "Name" column and verifies the value is "Twin room"

  Scenario: Read_hotel_reservation
    Given user connects to the database
    And user gets "Name" from "tHOTEL" table
    And user reads all rows in the "Name" column
    And users gets the value in row 3 in "Name" column and verifies the value is "wergywe"