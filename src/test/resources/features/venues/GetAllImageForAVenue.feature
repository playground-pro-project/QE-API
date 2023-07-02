Feature: GET All Image for a Venue
  @Test @PositiveCase @Venues
  Scenario Outline: Get all images for a venue with valid parameter and valid token should success then return 200 response code
    Given Get all images for a venue with valid "VNE-M3PEOV0V" parameter and valid token
    When Send request get all images for a venue
    Then Should return status code 200
    And Response body message contain "<message>"
    And Validate json schema get all images for a venue
    Examples:
      | message                            |
      | venue image retrieved successfully |

  @Test @NegativeCase @Venues
  Scenario: Get all images for a venue with valid parameter and wrong token should failed then return 401 response code
    Given Get all images for a venue with valid "VNE-M3PEOV0V" parameter and wrong token
    When Send request get all images for a venue
    Then Should return status code 401

  @Test @NegativeCase @Venues
  Scenario: Get all images for a venue with invalid parameter and valid token should failed then return 404 response code
    Given Get all images for a venue with invalid "shark" parameter and valid token
    When Send request get all images for a venue
    Then Should return status code 404

  @Test @NegativeCase @Venues
  Scenario: Get all images for a venue with invalid parameter and blank token should failed then return 401 response code
    Given Get all images for a venue with invalid "shark" parameter and blank token
    When Send request get all images for a venue
    Then Should return status code 401