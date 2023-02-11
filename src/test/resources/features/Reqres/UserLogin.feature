Feature: Testing user login reqres API
  @Tugas #Positive Case
  Scenario: user login with valid email dan password
    Given User login with valid data
    When Send request post login
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate user login json schema

  @Tugas #Negative Case
  Scenario: User login with valid email and empty password
    Given Send login with empty password
    When Send request post login
    Then Status code should be 400 Bad Request
    And Response body status should be "Missing password"
    And Validate empty password json schema

  @Tugas #Negative Case
  Scenario: User login with empty email and valid password
    Given Send login with empty email
    When Send request post login
    Then Status code should be 400 Bad Request
    And Response body status should be "Missing email or username"
    And Validate empty email json schema
