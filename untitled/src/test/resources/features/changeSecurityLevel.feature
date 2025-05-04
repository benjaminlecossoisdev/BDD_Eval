Feature:  Change security level
  Scenario: user is on home page, navigate to a new page and select a new option for the security level
    Given user is logged in and on the home page
    When user click on the link in the menu bar
    And user is redirected to a new page
    Then user click on the dropdown to select a new option
    And user click on the  button
    And security level is now updated
