Feature: Latest News

  Background:
    Given User is on the homepage

  Scenario: Each latest news should have an author and an image
    Then Each news has an author
    And Each news has an image

    Scenario: Verify the title and content of a latest news
      When User clicks on a latest news with index number 10
      Then Verify that the title of the page is same with the news title
