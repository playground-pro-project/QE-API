Feature: Post Reservations
  @Test
  Scenario: Post create reservation with valid reqbody json
    Given Post Create reservation with valid json reqbody
    When Send post Create reservation
    Then Should return status code 201
    And Response body message contain "Successfully operation"

  @Test
    Scenario: Post create reservation with invalid reqbody json
      Given Post Create reservation with invalid json reqbody
      When Send post Create reservation
      Then Should return status code 400
      And Response body message contain "Bad request"
