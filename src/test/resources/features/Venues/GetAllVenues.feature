Feature: Get All Vanues

  @Test
  Scenario: Get All Venues with valid query parameters
    Given Get all venues with valid token
    When Send Get All Vanues
    Then Should return status code 200
    And Response body message contain "Successful Operation"


  @Test
    Scenario: Get All Venues with invalid query parameters
      Given Get all venues with invalid query parameters
      When Send Get All Vanues
      Then Should return status code 404
    And Response body message contain "The requested resource was not found"


