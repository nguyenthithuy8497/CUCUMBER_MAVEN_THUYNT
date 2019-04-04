@Customer_Dynamic
Feature: Create New Customer
  As a PO
  I want to login to application
  So that verify function work well

  Scenario Outline: Register and login to application
    Given I input to dynamic textbox "uid" with data "mngr187633"
    When I input to dynamic textbox "password" with data "evebagE"
    And I click to dynamic button "LOGIN"
  	Then Verify dynamic page or message display with text ="Welcome To Manager's Page of Guru99 Bank"
    When I click to dynamic link with name "New Customer"
   	And I input to dynamic textbox "name" with data "<Name>"
   	And I input to dynamic textbox "dob" with data "<DateOfBirth>"
   	And I input to dynamic textarea "addr" with data "<Address>"
   	And I input to dynamic textbox "city" with data "<City>"
   	And I input to dynamic textbox "state" with data "<State>"
   	And I input to dynamic textbox "pinno" with data "<Pin>"
   	And I input to dynamic textbox "telephoneno" with data "<Phone>"
   	And I input to dynamic textbox "emailid" with random data "<Email>"
   	And I input to dynamic textbox "password" with data "<Password>"
   	And Wait some second "5"
    And I click to dynamic button "Submit"  
    Then Verify message displayed with data "Customer Registered Successfully"
    And  Verify data at "Customer Name" field matching with expected data "<Name>"
    And  Verify data at "Address" field matching with expected data "<Address>"
    And  Verify data at "City" field matching with expected data "<City>"
    And  Verify data at "State" field matching with expected data "<State>"
    And  Verify data at "Pin" field matching with expected data "<Pin>"
    And  Verify data at "Mobile No." field matching with expected data "<Phone>"
     
   
    Examples: New Customer info
      | Name      | DateOfBirth | Address    | City        | State   | Pin    | Phone      | Email    | Password |                         
      | Auto Test | 1999-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987654321 | autotest |   123123 |  
