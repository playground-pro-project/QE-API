Feature: PUT Change User Profile Picture
  @Test @PositiveCase @Users
  Scenario Outline: Put change user profile picture with valid token and valid body should success then return 200 response code
    Given Add user with "<nama>" as full name, "<email>" as email, "<phone>" as phone, and "<password>" as password
    When Send request post change user profile picture
    Given Change user profile picture with valid token and valid body
    When Send request put change user profile picture
    Then Should return status code 200
    And Response body message contain "<message>"
    And Validate json schema change user profile picture with valid token and valid body
    Examples:
      | nama | email | phone | password |
      |      |       |       |          |

  @Test @NegativeCase @Users
  Scenario: Put change user profile picture with wrong token and valid body should failed then return 401 response code
    Given Change user profile picture with wrong token and valid body
    When Send request put change user profile picture
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Put change user profile picture with valid token and invalid body json should failed then return 400 response code
    Given Change user profile picture with valid token and invalid body json
    When Send request put change user profile picture
    Then Should return status code 400

  @Test @NegativeCase @Users
  Scenario: Put change user profile picture with valid token and blank body should failed then return 400 response code
    Given Change user profile picture with valid token and blank body
    When Send request put change user profile picture
    Then Should return status code 400

  @Test @NegativeCase @Users
  Scenario: Put change user profile picture with blank token and invalid body should failed then return 401 response code
    Given Change user profile picture with blank token and invalid body
    When Send request put change user profile picture
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Put change user profile picture with blank token and blank body should failed then return 401 response code
    Given Change user profile picture with blank token and blank body
    When Send request put change user profile picture
    Then Should return status code 401