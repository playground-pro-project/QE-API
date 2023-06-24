Feature: PUT Change User Profile Picture
  @Test @PositiveCase @Users
  Scenario: Put change user profile picture with valid token and valid body should success then return 200 response code
    Given Change user profile picture with valid token and valid body
    When Send request put change user profile picture
    Then Should return status code 200
    And Response body message contain "<message>"
    And Validate json schema change user profile picture with valid token and valid body

  @Test @NegativeCase @Users
  Scenario: Put change user profile picture with wrong token and valid body should failed then return 401 response code
    Given Change user profile picture with wrong token and valid body
    When Send request put change user profile picture
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Put change user profile picture with valid token and invalid body should failed then return 400 response code
    Given Change user profile picture with valid token and invalid body
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