@login_register
Feature: Register and login
	As a PO
	I want to login to application
	So that verify function work well
	
Scenario: Register to application
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
			