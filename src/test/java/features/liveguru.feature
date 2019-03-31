@liveguru
Feature: Register and login
  As a PO
  I want to login to application
  So that verify function work well

  Scenario Outline: Register to application
    Given I open live guru login page
    When I input to username textbox with data "<User>"
    And I input to password textbox with data "<Password>"
    And I click login button
    Then I quit browser

    Examples: Test for login
      | User                   | Password |
      | auto_test_01@gmail.com | Pass111  |
      | auto_test_02@gmail.com | Pass111  |
      | auto_test_03@gmail.com | Pass111  |

    Examples: Test for login invalid
      | User                   | Password | Verify                                                                |
      | auto_test_01@g         | Pass111  | Please enter a valid email address. For example johndoe@domain.com.   |
      | auto_test_04@gmail.com | Pass111  | Invalid login or password.                                            |
      | auto_test_03@gmail.com | Pass     | Please enter 6 or more characters without leading or trailing spaces. |
