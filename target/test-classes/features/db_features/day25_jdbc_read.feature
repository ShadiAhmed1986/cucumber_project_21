@db_read
Feature:Read_database_data
  Scenario: Read_hotel_reservation
    Given user connects to the database
#    column = Price   table name = tHOTELROOM
#    NOTE: column and table name must be accurate
#    SCHEMA has all information about the database.
#    So we use SCHEMA to to write the correct names
    And user gets "Price" from "tHOTELROOM" table
    And user reads all rows in the "Price" column