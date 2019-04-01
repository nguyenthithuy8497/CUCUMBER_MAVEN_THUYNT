Feature: Common steps for Application

  Scenario: WebElement commons steps
  #I - ACTION STEPS: input, click, select, getText....
  #01 - Textbox (Customer Name/ City/ State
  Given I input to dynamic textbox "name" with data "Automation Testing"
  And I input to dynamic textbox "city" with data "Sai GOn"
  And I input to dynamic textbox "state" with data "Thu Duc"
  
  #02 - Text Area
  And I input to dynamic textarea "address" with data "Xo viet nghe tinh"
  
  #03 - Radio button
  
  #04 - Checkbox
  
  #05 - Dropdown List
  
  #06 - Button
  
  #07 - Link
  
  #II - VERIFY STEPS: verify true/false/equals....
  And  Verify data at "Customer Name" field matching with expected data "Automation Testing"
  And  Verify data at "City" field matching with expected data "Sai GOn"
  And  Verify data at "State" field matching with expected data "Thu Duc"
  
  #III - WAIT STEPS: wait 5s, 10s,...

 