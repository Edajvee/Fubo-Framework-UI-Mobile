Feature:
  Background:
    Given user is on "https://www.fubo.tv/welcome"
@login
  Scenario: Test Login functionality
    Given user clicks "sign in" button
    When user enters correct credentials
    And if needed user chooses a profile under "https://www.fubo.tv/profiles"
    Then user should be logged into their account under "https://www.fubo.tv/home"