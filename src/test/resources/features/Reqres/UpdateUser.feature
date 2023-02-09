Feature: Testing update user reqres API
  @Latihan
  Scenario: Put update user with valid json and valid parameter id
    Given Update user with valid json and parameter id 2
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name should be "riski ferdian" and job is "QA engineer"