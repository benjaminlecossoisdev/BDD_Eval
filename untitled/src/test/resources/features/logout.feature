Feature:  Logout
  Scenario: Logging out of the application
    Given user is logged on the portal page
    When user click on the logout button
    Then user click is redirected to login page
