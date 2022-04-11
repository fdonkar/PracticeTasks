Feature: Test create, update and delete functionalities of Pet Store
  @wip
  Scenario: Test all functionalities
    When User creates a new dog which name is "Cotton"
    And User update name of the dog as "FurReal"
    And User deletes created dog "FurReal"
    Then Verify the dog is deleted
