Feature: POST Upgrade User Role
  @Test @PositiveCase @Users
  Scenario: Post upgrade user role from 'user' to 'owner' with valid token and valid body should success then return 201 response code
    Given Post upgrade user role from user to owner with valid token and valid body
    When Send request post upgrade user role from 'user' to 'owner'
    Then Should return status code 200
    And Response body message contain "File added successfully"
    And Validate json schema post upgrade user role from 'user' to 'owner'

  @Test @NegativeCase @Users
  Scenario: Post upgrade user role from 'user' to 'owner' with wrong token and valid body should failed then return 401 response code
    Given Post upgrade user role from 'user' to 'owner' with wrong token and valid body
    When Send request post upgrade user role from 'user' to 'owner'
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Post upgrade user role from 'user' to 'owner' with valid token and blank body should failed then return 400 response code
    Given Post upgrade user role from 'user' to 'owner' with valid token and blank body
    When Send request post upgrade user role from 'user' to 'owner'
    Then Should return status code 400

  @Test @NegativeCase @Users
  Scenario: Post upgrade user role from 'user' to 'owner' with blank token and blank body should failed then return 401 response code
    Given Post upgrade user role from 'user' to 'owner' with blank token and blank body
    When Send request post upgrade user role from 'user' to 'owner'
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Post upgrade user role from 'user' to 'owner' with valid token and invalid body should success then return 400 response code
    Given Post upgrade user role from 'user' to 'owner' with valid token and invalid body
    When Send request post upgrade user role from 'user' to 'owner'
    Then Should return status code 400