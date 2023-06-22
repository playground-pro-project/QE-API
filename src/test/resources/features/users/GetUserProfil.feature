Feature: GET User Profil
  @Test @PositiveCase @Users
  Scenario Outline: Get user profil with valid path should success then return 200 response code
    Given Get user profil with valid path
    When Send request get user profil
    Then Should return status code 200
    And Response body message contain "<message>"
    And Validate json schema get user profil with valid path
    Examples:
      | message |
      |         |

  @Test @NegativeCase @Users
  Scenario: Get user profil with invalid path should failed then return 404 response code
    Given Get user profil with invalid path
    When Send request get user profil
    Then Should return status code 404

  @Test @NegativeCase @Users
  Scenario: Get user profil with valid path and wrong token should failed then return 401 response code
    Given Get user profil with valid path and wrong token
    When Send request get user profil
    Then Should return status code 401