Feature: Make post, comment on post and list of users

  Scenario: Make a post
    When User sends a post request to jsonplaceholder api
    Then Verify status code is 201
    And Verify userId, title and body are matched with request body
