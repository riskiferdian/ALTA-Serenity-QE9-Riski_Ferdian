Feature: Testing get single user reqres API
  @Tugas #Positive Case
  Scenario: get single user with valid parameter
    Given Get single user with valid 2
    When Send request get single user
    Then Status code should be 200 OK
    And Response body id should be 2
    And Validate list single user json schema

  @Tugas #Negative Case
  Scenario: get single user not found or invalid parameter
    Given Get single user with invalid parameter 23
    When Send request get single user
    Then Status code should be 404 Not Found