Feature: Testing create user reqres API
  @Latihan #Positive Case
  Scenario: Post create new user with valid json file
    Given Create new user with valid json
    When Send request post create user
    Then Status code should be 201 Created
    And Response body name should be "riski ferdian" and job is "QA engineer"
    And And Validate new user json schema

  @Tugas #Negative Case
  Scenario: Post create new user with empty json file
    Given Create new user with invalid data
    When Send request post create user
    Then Status code should be 400 Bad Request