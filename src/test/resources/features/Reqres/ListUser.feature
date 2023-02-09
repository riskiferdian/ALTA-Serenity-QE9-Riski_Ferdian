Feature: Testing get list user reqres API
  @Latihan
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |