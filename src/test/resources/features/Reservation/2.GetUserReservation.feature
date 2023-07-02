Feature: Get user reservation
  @Test
  Scenario: Get single user reservation with valid id
    Given Get single user reservation with valid id
    When Send get single user reservation
    Then Should return status code 200
    And Response body message contain "Successful Operation"


  @Test
  Scenario: Get single user reservation with invalid id
    Given Get single user reservation with invalid id
    When Send get single user reservation
    Then Should return status code 404
    And Response body message contain "The requested resource was not found"

