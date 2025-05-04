Feature:  Navigation
  Scenario: user log in and go to another page
    Given user is on the home page
    When user click on the link in in the menu
    Then user is redirected on the credits page
