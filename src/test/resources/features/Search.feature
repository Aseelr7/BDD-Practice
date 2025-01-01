Feature: Searching for products through search bar

  Scenario: Searching for the Harry Potter Book
    Given I am on the Flipkart homepage
    When I type "Harry Potter" into the search bar
    And I click on the search button
    Then I should be navigated to a page with Harry Potter Search Results