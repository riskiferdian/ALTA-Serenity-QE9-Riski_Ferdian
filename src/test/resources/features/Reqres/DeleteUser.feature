Feature: Testing delete user reqres API
  @Latihan #Positive Case
  Scenario Outline: Delete user with valid parameter id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204 No Content

    Examples:
      | id |
      | 1  |
      | 2  |

  @Tugas #Negative Case
  Scenario: Delete user with invalid parameter id
    Given Delete user with invalid id "xyz"
    When Send request delete user
    Then Status code should be 400 Bad Request