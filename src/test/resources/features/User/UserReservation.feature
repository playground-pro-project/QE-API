Feature: User Reservations

  @Test
  Scenario: Get users reservation with valid token
    Given Get users reservation with valid token
    When Send get users reservation
    Then Should return status code 200
    And Response body message contain "Successful Operation"

    @Test
    Scenario: Get users reservation with invalid token
      Given Get users reservation with invalid token
      When Send get users reservation
      Then Should return status code 401
        And Response body message contain "missing or malformed jwt"

  @Test
  Scenario: Get users reservation has not reservation
    Given Get users reservation has not reservation
    When Send get users reservation
    Then Should return status code 404
    And Response body message contain "The requested resource was not found"