Feature: DELETE Venue Image
  @Test @PositiveCase @Venues
  Scenario: Delete venue image with valid parameter venue_id, valid parameter image_id, and valid token should success then return 200 response code
    Given Delete venue image with valid "VNE-M3PEOV0V" parameter venue_id, valid "IMG-BJIFU5P6" parameter image_id, and valid token
    When Send request delete venue image
    Then Should return status code 200
    And Response body message contain "venue image deleted successfully"

  @Test @NegativeCase @Venues
  Scenario: Delete venue image with valid parameter venue_id, valid parameter image_id, and wrong token should failed then return 401 response code
    Given Delete venue image with valid "VNE-M3PEOV0V" parameter venue_id, valid "IMG-BJIFU5P6" parameter image_id, and wrong token
    When Send request delete venue image
    Then Should return status code 401

  @Test @NegativeCase @Venues
  Scenario: Delete venue image with invalid parameter venue_id, valid parameter image_id, and valid token should failed then return 404 response code
    Given Delete venue image with invalid "shark" parameter venue_id, valid "IMG-BJIFU5P6" parameter image_id, and valid token
    When Send request delete venue image
    Then Should return status code 404

  @Test @NegativeCase @Venues
  Scenario: Delete venue image with valid parameter venue_id, invalid parameter image_id, and valid token should failed then return 404 response code
    Given Delete venue image with valid "VNE-M3PEOV0V" parameter venue_id, invalid "shark" parameter image_id, and valid token
    When Send request delete venue image
    Then Should return status code 404

  @Test @NegativeCase @Venues
  Scenario: Delete venue image with invalid parameter venue_id, valid parameter image_id, and wrong token should failed then return 401 response code
    Given Delete venue image with invalid "shark" parameter venue_id, valid "IMG-BJIFU5P6" parameter image_id, and wrong token
    When Send request delete venue image
    Then Should return status code 401

  @Test @NegativeCase @Venues
  Scenario: Delete venue image with invalid parameter venue_id, invalid parameter image_id, and wrong token should failed then return 401 response code
    Given Delete venue image with invalid "shark" parameter venue_id, invalid "shark" parameter image_id, and wrong token
    When Send request delete venue image
    Then Should return status code 401