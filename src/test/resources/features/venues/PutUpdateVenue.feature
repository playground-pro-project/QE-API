Feature: PUT Update Venue
  @Test @PositiveCase @Venues
  Scenario: Put update venue with valid parameter, valid body, and valid token should success then return 200 response code
    Given Put update venue with "VNE-ELVZWZ5T" valid parameter, valid body, and valid token
    When Send request put update venue
    Then Should return status code 200
    And Response body message contain "Venue updated successfully"
    And Validate json schema update venue with valid parameter, valid body, and valid token

  @Test @NegativeCase @Venues
  Scenario: Put update venue with valid parameter, valid body, and wrong token should failed then return 401 response code
    Given Put update venue with "VNE-ELVZWZ5T" valid parameter, valid body, and wrong token
    When Send request put update venue
    Then Should return status code 401

  @Test @NegativeCase @Venues
  Scenario: Put update venue with invalid parameter, valid body, and valid token should failed then return 404 response code
    Given Put update venue with "shark" invalid parameter, valid body, and valid token
    When Send request put update venue
    Then Should return status code 404

  @Test @NegativeCase @Venues
  Scenario: Put update venue with valid parameter, blank body, and wrong token should failed then return 401 response code
    Given Put update venue with "VNE-ELVZWZ5T" valid parameter, blank body, and wrong token
    When Send request put update venue
    Then Should return status code 401
