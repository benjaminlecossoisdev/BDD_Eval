
Feature:  Create a new user
  Scenario: User is logged and create a new user
    Given user is logged on the portal page
    And user click on the create user button on the menu
    When user is redirected to the new page
    And user fill the first input with his login
    And user fill the second input with his email
    And user fill the third input with his password
    And user fill the fourth input with his password confirmation
    And user fill the fifth input with his secret
    Then user click on the submit button
    And user stay on the same page with a confirmation message on the screen