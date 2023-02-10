Feature: Testing register
  @Tugas
  Scenario: Register user
    Given Register user with valid json
    When Send request register user
    Then Status code should be 200 OK
    And Response body id should be 4 and token "QpwL5tke4Pnpja7X4"
    And Validate register user json schema