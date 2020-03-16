Feature: SecurePay - Contact Us Form

  Scenario: Verify Contact-us form on SecurePay webpage
    Given I launch chrome browser
    And I open google.com webpage and search for SecurePay
    When I clicks through to SecurePay website
    And I navigate to "Contact Us" page on SecurePay website
    Then Contact Us page is successfully loaded
    And I should be able to view and fill up the contact us form






