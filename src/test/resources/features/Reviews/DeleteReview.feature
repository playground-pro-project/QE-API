Feature: Delete Reviews
  @Test
  Scenario: Send Delete Reviews Valid Id
    Given Delete review with valid id
    When Send delete reviews
    Then Should return status code 200
    And Response body message contain "Review deleted successfully"

  @Test
  Scenario: Send Delete Reviews Invalid Id
    Given Delete review with invalid id
    When Send delete reviews
    Then Should return status code 400

