@Customer
Feature: Create New Customer
  As a PO
  I want to login to application
  So that verify function work well

  Scenario Outline: Register and login to application
    Given I get Login page Url
    And I click to here link
    And I input to email textbox with data "automation"
    And I click to submit button at Register page
    Then I get userID infor
    And I get Password infor
    When I open Login page again
    And Input to Username textbox
    And I input to Password textbox
    And I click to Login button at Login page
    Then Verify Home Page displayed with message "Welcome To Manager's Page of Guru99 Bank"
    Given I open New Customer page
    When Input to New Customer form with data
      | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <Name> | m      | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |
    And I click to Submit button at New Customer page
    Then Verify message displayed with data "Customer Registered Successfully"
    And I verify all above infomation created success
      | Name   | Gender | DateOfBirth   | Address   | City   | State   | Pin   | Phone   | Email   | Password   |
      | <Name> | male   | <DateOfBirth> | <Address> | <City> | <State> | <Pin> | <Phone> | <Email> | <Password> |

    Examples: New Customer info
      | Name      | DateOfBirth | Address    | City        | State   | Pin    | Phone      | Email    | Password |                         
      | Auto Test | 1999-01-01  | 123 Le Loi | Ho Chi Minh | Thu Duc | 123456 | 0987654321 | autotest |   123123 |  
