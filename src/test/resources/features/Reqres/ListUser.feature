Feature: Testing get list user reqres API
  @Latihan #Positive Case
  Scenario Outline: Get list users with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user json schema
    Examples:
      | page |
      | 1    |
      | 2    |

  @Tugas #Negative Case
  Scenario: Get list users with invalid parameter page
    Given Get list parameter with invalid page "x"
    When Send request get list users
    Then Status code should be 404 Not Found