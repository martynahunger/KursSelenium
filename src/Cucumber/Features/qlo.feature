Feature: Qlo Registration
  Scenario: create account with proper data

    Given user is on authentication page
    When user inputs email address and click create an account button
    When user inputs first name, last name and password
    And user clicks Register
    Then user is registered