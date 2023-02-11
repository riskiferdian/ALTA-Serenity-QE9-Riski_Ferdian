Feature: Delayed response testing reqres API
  @Tugas #Positive Case
  Scenario: Testing delayed response
    Given User get delayed response with valid data 3
    When Send request delayed response
    Then Status code should be 200 OK
    And Response body page should be 1
    And Validate delayed response json schema