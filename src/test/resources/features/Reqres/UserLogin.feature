Feature: Testing user login reqres API
  @Tugas
  Scenario: user login with valid email dan password
    Given User login with valid data
    When Send request post login
    Then Status code should be 200 OK
    And Response body token should be "QpwL5tke4Pnpja7X4"
    And Validate user login json schema
