@db_create
  Feature: Create_hotel_room
    Scenario: Creating_hotel_room_test
      Given user connects to the database
      When user creates new hotel with a "'5500', 'Jumping Beans', 'Beans Street','4564545','seleniumomrumuyedin@gmail.com'"
      Then verify the hotel is created successfully
      Then close the connection