Feature: Testing list single resource reqres API
  @Tugas #Positive Case
  Scenario: Get list single resource
    Given Get list single resource 2
    When Send request single resource
    Then Status code should be 200 OK
    And Validate list single resource

  @Tugas #Negative Case
  Scenario: Get list single resource with invalid parameter id
    Given Get list single resource "xyz"
    When Send request single resource
    Then Status code should be 404 Not Found
