Feature: SecurePay - Contact Us Form

  Scenario: Verify Contact-us form on SecurePay webpage
    Given I launch chrome browser
    And I open "google.com" webpage
    When I search for SecurePay website
    And I click navigate to "Contact Us" page on SecurePay website
    Then Contact Us page is successfully loaded






