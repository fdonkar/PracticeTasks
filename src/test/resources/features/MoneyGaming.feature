Feature: Sign up function

  @wip
  Scenario: Verify that the user have to fill out required fields
    Given User navigates to the main page
    And User clicks on the join now button to open registration page
    When User selects a title
    And User enters first name and last name
    And User clicks on checkbox to accept terms and conditions
    And User clicks on join now button to submit the form
    Then This field is required message should be displayed under the date of birth box

