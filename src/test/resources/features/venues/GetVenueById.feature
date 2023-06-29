Feature: GET Venue By Id
  @Test @PositiveCase @Venues
  Scenario Outline: Get venue by id with valid parameter and valid token should success then return 200 response code
    Given Get venue by id with valid "VNE-M3PEOV0V" parameter and valid token
    When Send request get venue by id
    Then Should return status code 200
    And Response body message contain "<message>"
    And Validate json schema get venue by id with valid parameter
    Examples:
      | message                 |
      | Successfully operation. |

  @Test @NegativeCase @Venues
  Scenario: Get venue by id with valid parameter and wrong token should success then return 401 response code
    Given Get venue by id with valid "VNE-M3PEOV0V" parameter and wrong token
    When Send request get venue by id
    Then Should return status code 401

  @Test @NegativeCase @Venues
  Scenario: Get venue by id with invalid parameter and valid token should failed then return 404 response code
    Given Get venue by id with invalid "shark" parameter and valid token
    When Send request get venue by id
    Then Should return status code 404

  @Test @NegativeCase @Venues
  Scenario: Get venue by id with invalid parameter and blank token should failed then return 401 response code
    Given Get venue by id with invalid "shark" parameter and blank token
    When Send request get venue by id
    Then Should return status code 401