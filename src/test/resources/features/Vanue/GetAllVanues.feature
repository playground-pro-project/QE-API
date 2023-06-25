Feature: Get All Vanues

  @Test
  Scenario Outline: Get All Vanues with valid query parameters
    Given Get all vanues with valid token from credential email "<email>" password "<password>" and valid query parameters
    When Send Get All Vanues
    Then Should return status code 200
    And Validate Json Schema Get All Vanues
    Examples:
      | email | password |
      |       |          |


    @Test
    Scenario Outline: Get All Vanues with invalid query parameters
      Given Get all vanues with valid token from credential email "<email>" password "<password>" and invalid query parameters
      When Send Get All Vanues
      Then Should return status code 400
      Examples:
        | email | password |
        |       |          |
