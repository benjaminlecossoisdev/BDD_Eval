Feature:  Password change
  Scenario: User is logged and change his password
    Given user is logged on the portal page
    And user click on the change password button on the menu
    When user is redirected to the password change page
    And user fill the first input with his old password
    And user fill the second input with his new password
    And user fill the third input with his new password again
    Then user click on the save button
    And user can see a confirmation message on the screen