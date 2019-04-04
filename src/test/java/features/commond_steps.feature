Feature: Common steps for Application

  Scenario: WebElement commons steps
  #I - ACTION STEPS: input, click, select, getText....
  #01 - Textbox (Customer Name/ City/ State
  Given I input to dynamic textbox "name" with data "Automation Testing"
  And I input to dynamic textbox "city" with data "Sai GOn"
  And I input to dynamic textbox "state" with data "Thu Duc"
  
  And I input to dynamic textbox "" with random data ""
  #02 - Text Area
  And I input to dynamic textarea "address" with data "Xo viet nghe tinh"
  
  #03 - Radio button
  
  #04 - Checkbox
  
  #05 - Dropdown List
  
  #06 - Button
  And I click to dynamic button "Login"
  And I click to dynamic button "Submit"
  And I click to dynamic button "Reset"
  
  #07 - Link
   And I click to dynamic link with name ""
   And I input first Account ID
   And I input second Account ID
   
  #II - VERIFY STEPS: verify true/false/equals....
  And  Verify data at "Customer Name" field matching with expected data "Automation Testing"
  And  Verify data at "City" field matching with expected data "Sai GOn"
  And  Verify data at "State" field matching with expected data "Thu Duc"
  And  Verify dynamic page or message display with text ="Welcome To Manager's Page of Guru99 Bank"
  And  Verify dynamic page or message display with text ="Customer Registered Successfully!!!"
  #III - WAIT STEPS: wait 5s, 10s,...
  And Wait some second "5"
  And Wait some second "10"
  And Wait some second "30"

 