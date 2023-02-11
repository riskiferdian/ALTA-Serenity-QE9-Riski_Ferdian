Feature: Patch user testing reqres API
  @Tugas #Positive Case
  Scenario: Patch user dengan valid parameter id
    Given Patch user with valid id 2
    When Send request patch user
    Then Status code should be 200 OK
    And Response body name should be "riski ferdian" and job is "QA engineer"
    And Validate patch user json schema

  @Tugas #Negative Case
  Scenario: Patch user dengan invalid parameter id
    Given Patch user with invalid id "xyz" and valid json
    When Send request patch user
    Then Status code should be 400 Bad Request

  @Tugas #Negative Case
  Scenario: Patch user dengan invalid file json
    Given Patch user with invalid json and valid id 2
    When Send request patch user
    Then Status code should be 400 Bad Request