Feature: DELETE Venue
  @Test @PositiveCase @Venues
  Scenario: Delete venue with valid parameter and valid token should success then return 200 response code
    Given Delete venue with "VNE-ELVZWZ5T" valid parameter and valid token
    When Send request delete venue
    Then Should return status code 200
    And Response body message contain "Successfully deleted a venue"

  @Test @NegativeCase @Venues
  Scenario: Delete venue with valid parameter and wrong token should failed then return 401 response code
    Given Delete venue with "VNE-ELVZWZ5T" valid parameter and wrong token
    When Send request delete venue
    Then Should return status code 401

  @Test @NegativeCase @Venues
  Scenario: Delete venue with invalid parameter and valid token should failed then return 404 response code
    Given Delete venue with "shark" invalid parameter and valid token
    When Send request delete venue
    Then Should return status code 404

  @Test @NegativeCase @Venues
  Scenario: Delete venue with blank parameter and wrong token should failed then return 404 response code
    Given Delete venue with "" blank parameter and wrong token
    When Send request delete venue
    Then Should return status code 404