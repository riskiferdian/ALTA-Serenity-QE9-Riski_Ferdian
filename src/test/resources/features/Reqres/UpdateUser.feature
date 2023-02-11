Feature: Testing update user reqres API
  @Latihan #Positive Case
  Scenario: Put update user with valid json and valid parameter id
    Given Update user with valid json and parameter id 2
    When Send request put update user
    Then Status code should be 200 OK
    And Response body name should be "riski ferdian" and job is "QA engineer"
    And Validate update user json schema

  @Tugas #Negative Case
  Scenario: Put update user with valid json and invalid parameter id
    Given Update user with invalid parameter id "xyz"
    When Send request put update user
    Then Status code should be 400 Bad Request

  @Tugas #Negative Case
  Scenario: Put update user with invalid file json and valid id
    Given Update user with invalid file json and valid id 2
    When Send request put update user
    Then Status code should be 400 Bad Request