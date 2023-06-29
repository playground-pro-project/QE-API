Feature: POST Add New Venue
  @Test @PositiveCase @Venues
  Scenario: Post add new venue with valid token and valid body should success then return 201 response code
    Given Post add new venue with valid token and valid body
    When Send request post add new venue
    Then Should return status code 201
    And Response body message contain "Successfully operation"
    And Validate json schema post add new venue

  @Test @NegativeCase @Venues
  Scenario: Post add new venue with wrong token and valid body should failed then return 401 response code
    Given Post add new venue with wrong token and valid body
    When Send request post add new venue
    Then Should return status code 401

  @Test @NegativeCase @Venues
  Scenario: Post add new venue with valid token and blank body should failed then return 400 response code
    Given Post add new venue with valid token and blank body
    When Send request post add new venue
    Then Should return status code 400

  @Test @NegativeCase @Venues
  Scenario: Post add new venue with blank token and blank body should failed then return 401 response code
    Given Post add new venue with blank token and blank body
    When Send request post add new venue
    Then Should return status code 401