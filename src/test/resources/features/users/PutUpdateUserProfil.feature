Feature: PUT Update User Profil
  @Test @PositiveCase @Users
  Scenario: Put update user profil with valid token and valid body should success then return 200 response code
    Given Put update user profil with valid token
    When Send request put update user profil
    Then Should return status code 200
    And Response body message contain "<message>"
    And Validate json schema update user profil with valid parameter and valid body

  @Test @NegativeCase @Users
  Scenario: Put update user profil with valid body and wrong token should failed then return 401 response code
    Given update user profil with valid body and wrong token
    When Send request put update user profil
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Put update user profil with invalid body and valid token should failed then return 400 response code
    Given update user profil with invalid body and valid token
    When Send request put update user profil
    Then Should return status code 400

  @Test @NegativeCase @Users
  Scenario: Put update user profil with valid token and blank body should failed then return 400 response code
    Given update user profil with valid token and blank body
    When Send request put update user profil
    Then Should return status code 400

  @Test @NegativeCase @Users
  Scenario: Put update user profil with blank token and valid body should failed then return 401 response code
    Given update user profil with blank token and valid body
    When Send request put update user profil
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Put update user profil with blank token and blank body should failed then return 401 response code
    Given update user profil with blank token and blank body
    When Send request put update user profil
    Then Should return status code 401