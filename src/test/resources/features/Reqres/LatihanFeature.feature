Feature: Latihan membuat sendiri
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    Examples:
      | page |
      | 1    |
      | 2    |

  Scenario: Post create user with valid json file
    Given Post create new user with valid json
    When Send request post create new user
    Then Status code should be 201 Created
    And Response body name should be "riski ferdian" and job "QA engineer"

  Scenario: Put update user with valid json file
    Given Update user with valid id 2 json
    When Send update user
    Then Status code should be 200 OK
    And Response body name should be "steven" and job "magang"

  Scenario Outline: Delete user
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content
    Examples:
      | id |
      | 1  |