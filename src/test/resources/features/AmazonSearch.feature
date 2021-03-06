Feature: Amazon Search
  		 As a user, I should be able to search an item
  		 and the searched item should be relevant to search criteria
  		 
	@amazonSearch @SmokeTests
  Scenario Outline: User is able to search multiple data set
    Given I am on Amazon home page
    When I search item "<items>"
    And I click search button
    Then searched item "<items>" should be displayed in the search bar

    Examples: items
      | items             |
      | Coffee mug        |
      | Pretty coffee mug |
      | Cool coffee mug   |
      | Cute coffee mug   |
      | Ugly coffee mug   |
