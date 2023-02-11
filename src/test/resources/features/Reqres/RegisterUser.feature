Feature: Testing register reqres API
  @Tugas #Positive Case
  Scenario: Register user with valid data
    Given Register user with valid json
    When Send request register user
    Then Status code should be 200 OK
    And Response body id should be 4 and token "QpwL5tke4Pnpja7X4"
    And Validate register user json schema

  @Tugas #Negative Case
  Scenario: Register user with valid email and empty password
    Given User register with empty password
    When Send request register user
    Then Status code should be 400 Bad Request
    And Response body status should be "Missing password"
    And Validate register empty password json schema

  @Tugas #Negative Case
  Scenario: Register user with valid password and empty email
    Given User register with empty email
    When Send request register user
    Then Status code should be 400 Bad Request
    And Response body status should be "Missing email or username"
    And Validate register empty email json schema
