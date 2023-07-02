Feature: Get user venues
  @Test
  Scenario: Get user vanues with valid token
    Given Get users venues with valid token
    When Send get users venues
    Then Should return status code 200
    And Response body message contain "Successful Operation"


  @Test
  Scenario: Get user vanues with invalid token
    Given Get users venues with invalid token
    When Send get users venues
    Then Should return status code 401
    And Response body message contain "invalid or expired jwt"