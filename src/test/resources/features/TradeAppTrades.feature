@Regression
Feature: AS a user, I am able to perform Trade app Add trade functions
  I want to add, delete and update trades

  @AddTrade @SmokeTests
  Scenario: As a user, I want to add a trade
    Given I am on the Trade App login page
    When I enter username "Ahmad" password "SuperAhmad123!"
    And I click on Trade Sign in button
    Then I should be on Trade home page
    When I click on Add Trade button
    Then I should be on Add Trade page
    When I select "Buy to Open" and I enter symbol "Jira" entryDate "04/04/2020" entryPrice "300" exitDate "01/11/2023" exitPrice "400"
    And I click Save button
    Then The trade is displayed on the trade table
    And The data is deleted on the Database

  @AddTradeWithDataTable @SmokeTests
  Scenario: As a user, I want to add a trade
    Given I am on the Trade App login page
    When I enter username "Ahmad" password "SuperAhmad123!"
    And I click on Trade Sign in button
    Then I should be on Trade home page
    When I click on Add Trade button
    Then I should be on Add Trade page
    When I enter the following data
      | Buy to Open | Jira | 04/04/2020 | 300 | 01/11/2023 | 400 |
    And I click Save button
    Then The trade is displayed on the trade table
    And The data is deleted on the Database
    
    
    @AddTradeAndValidate @SmokeTests
  Scenario: As a user, I want to add a trade
    Given I am on the Trade App login page
    When I enter username "Ahmad" password "SuperAhmad123!"
    And I click on Trade Sign in button
    Then I should be on Trade home page
    When I click on Add Trade button
    Then I should be on Add Trade page
    When I enter the following data
      | Buy to Open | Jira | 04/04/2020 | 300.0 | 01/11/2023 | 400.0 |
    And I click Save button
    Then The trade is displayed on the trade table
    And The trade data resides in database correctly
    And The data is deleted on the Database
    
    @InsertDB @SmokeTests
    Scenario: As a user, I am able to insert a trade to Database
    Given I executed Insert query with the following data to Database
    |'25'|'2'|'0'|'Jiraa'|'2021-02-10'|'700.0'|'2024-12-30'|'900.0'|'0'|
    Given I am on the Trade App login page
    When I enter username "Ahmad" password "SuperAhmad123!"
    And I click on Trade Sign in button
    Then I should be on Trade home page
    When I serach the "Jiraa" 
    And I click the Serach button
    Then The trade input displayed on the trade table
    And The data is deleted on the Database
    
    
