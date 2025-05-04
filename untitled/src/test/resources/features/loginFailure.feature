Feature:  Login - failure
  Scenario: Login with wrong credentials
    Given user is on the home page
    When user fill the login input with "bees"
    And user fill the password input with "bugs"
    Then user click on the login button
    And user should not be redirected to portal page
    And user should see an error message
