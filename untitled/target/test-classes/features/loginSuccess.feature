Feature:  Login
  Scenario: Login with correct credentials
    Given user is on the home page
    When user fill the login input with "bee"
    And user fill the password input with "bug"
    Then user click on the login button
    And user should be redirected to portal page
