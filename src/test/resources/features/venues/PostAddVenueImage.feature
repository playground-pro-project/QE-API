Feature: POST Add Venue Image
  @Test @PositiveCase @Venues
  Scenario: Post add venue image with valid parameter, valid body, and valid token should success then return 200 response code
    Given Post add venue image with "VNE-M3PEOV0V" valid parameter, valid body, and valid token
    When Send request post add venue image
    Then Should return status code 200
    And Response body message contain "venue image added successfully"
    And Validate json schema post add venue image

  @Test @NegativeCase @Venues
  Scenario: Post add venue image with valid parameter, valid body, and wrong token should failed then return 401 response code
    Given Post add venue image with "VNE-M3PEOV0V" valid parameter, valid body, and wrong token
    When Send request post add venue image
    Then Should return status code 401

  @Test @NegativeCase @Venues
  Scenario: Post add venue image with invalid parameter, valid body, and valid token should failed then return 404 response code
    Given Post add venue image with "shark" invalid parameter, valid body, and valid token
    When Send request post add venue image
    Then Should return status code 404

  @Test @NegativeCase @Venues
  Scenario: Post add venue image with blank parameter, blank body, and wrong token should failed then return 404 response code
    Given Post add venue image with "" blank parameter, blank body, and wrong token
    When Send request post add venue image
    Then Should return status code 404