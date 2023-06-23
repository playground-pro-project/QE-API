Feature: PUT Change User Password
  @Test @PositiveCase @Users
  Scenario Outline: Put change user password with valid token and valid body should success then return 200 response code
    Given Add user with "<nama>" as full name, "<email>" as email, "<phone>" as phone, and "<password>" as password
    When Send request post change user password
    Given Put change user password with valid token and valid body
    When Send request put change user password
    Then Should return status code 200
    And Response body message contain "<message>"
    And Validate json schema change user password with valid token and valid body
    Examples:
      | nama | email | phone | password |
      |      |       |       |          |

  @Test @NegativeCase @Users
  Scenario: Put change user password with wrong token and valid body should failed then return 401 response code
    Given Put change user password with wrong token and valid body
    When Send request put change user password
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Put change user password with valid token and invalid body json should failed then return 400 response code
    Given Put change user password with valid token and invalid body
    When Send request put change user password
    Then Should return status code 400

  @Test @NegativeCase @Users
  Scenario: Put change user password with valid token and blank body should failed then return 400 response code
    Given Put change user password with valid token and blank body
    When Send request put change user password
    Then Should return status code 400

  @Test @NegativeCase @Users
  Scenario: Put change user password with blank token and valid body should failed then return 401 response code
    Given Put change user password with blank token and valid body
    When Send request put change user password
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Put change user password with blank token and blank body should failed then return 401 response code
    Given Put change user password with blank token and blank body
    When Send request put change user password
    Then Should return status code 401