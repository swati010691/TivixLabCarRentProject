Feature:  Test Car Rent Webpage Functionalty

Background:
		Given Launch the browser
	  And  Enter URL
  Scenario Outline: A user should be able to search for a car in a specific country/city
    
    And  Select specific Country "<Country>" and City "<City>"
    And Enter Car "<CarModel>" Model
    And  Select both  Pick-up and Drop-Off date
    Then Click on Search button
    And  Brower close sucessfully
  
  Examples:
    | Country| City |CarModel|
    | Poland | Wroclaw|Maruti|
    | France |Paris |Mahindra|
    |Germainy|Berlin|Hyundai|
    | Poland | Cracow|TATA|
   
 
 Scenario Outline: To rent a car, the user needs to provide dates
    
    And  Select specific Country "<Country>" and City "<City>"
    And Enter Car "<CarModel>" Model
    And Select Pick-up date "<Pick-Up date>"
    And Select Drop-Off date "<Drop-off date>"
    Then Click on Search button
    And  Brower close sucessfully
  
  Examples:
    | Country| City |CarModel|Pick-Up date|Drop-off date|
    | Poland | Wroclaw|Maruti|08/23/2022|08/27/2022|
    | France | Wroclaw|Maruti|08/24/2022|08/28/2022|
    
     Scenario Outline: The user should be able to see car details after clicking "Rent” button
    
    And  Select specific Country "<Country>" and City "<City>"
    And Enter Car "<CarModel>" Model
    And Select Pick-up date "<Pick-Up date>"
    And Select Drop-Off date "<Drop-off date>"
    Then Click on Search button
    And Click on Rent button for selected car model "<CarModel>" 
    And  Brower close sucessfully
  
  Examples:
    | Country| City |CarModel|Pick-Up date|Drop-off date|
    | Poland | Wroclaw|Mazda 6|08/23/2022|08/27/2022|
    
    Scenario Outline: The user should be able to provide personal data in the rent form
    
    And  Select specific Country "<Country>" and City "<City>"
    And Enter Car "<CarModel>" Model
    And Select Pick-up date "<Pick-Up date>"
    And Select Drop-Off date "<Drop-off date>"
    Then Click on Search button
    And Click on Rent button for selected car model "<CarModel>" 
    And Click on Rent button.
    And Fill personal data
    And click on Rent button to submit
    And  Brower close sucessfully
  
  Examples:
    | Country| City |CarModel|Pick-Up date|Drop-off date|
    | Poland | Wroclaw|Mazda 6|08/23/2022|08/27/2022|