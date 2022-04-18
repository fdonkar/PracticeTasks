Feature: Recently viewed function

  @wip
  Scenario: Verify "Recently Viewed" function on the cart is working as expected
    Given User is on the login page of HepsiBurada
    And User logins with valid credentials
    When User searches "Macbook Air" using search box
    And User selects the 1 product on the page
    When User searches "iphone 11" using search box
    And User selects the 1 product on the page
    When User searches "samsung watch" using search box
    And User selects the 1 product on the page
    When User navigates to the cart
    Then User sees all viewed products under the Recently Viewed section

