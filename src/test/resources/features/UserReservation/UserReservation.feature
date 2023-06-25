Feature: User Reservations

  @Test
  Scenario Outline: Get users reservation with valid token
    Given Get users reservation with valid token from credential email "<email>" password "<password>"
    When Send get users reservation
    Then Should return status code 200
    And Validate json schema get users reservation
    Examples:
      | email | password |
    |       |          |

    @Test
    Scenario: Get users reservation with invalid token
      Given Get users reservation with invalid token
      When Send get users reservation
      Then Should return status code 401