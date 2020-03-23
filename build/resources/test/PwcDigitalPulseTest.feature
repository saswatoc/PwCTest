Feature: Testing PwC Digital Pulse website

  Scenario: Verifying carousel navigation on Pwc Digital Pulse website
    Given I navigate to the PwC Digital Pulse website
    When I am viewing the ‘Home’ page
    Then I am presented with a carousel displaying 3 featured articles
    And Clicking the ‘Next’ button on the carousel will load the next 3 featured articles
    And Clicking the ‘Previous’ button on the carousel will load the previous 3 featured articles


    Scenario: Verifying search feature on Digital Pulse website
    Given I navigate to the PwC Digital Pulse website
    When I click on the ‘Magnifying glass’ icon to perform a search And I enter the text ‘Single page applications’
    And I submit the search
    Then I am taken to the search results page
    And I am presented with at least 1 search result

