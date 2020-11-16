Feature: adding new address

  Scenario: add new shipping address with proper data
    Given logged in user
    When user goes to New Address Page
    When user fills address, city and zip
    And user clicks Save button
    Then "Address successfully added!" message appears