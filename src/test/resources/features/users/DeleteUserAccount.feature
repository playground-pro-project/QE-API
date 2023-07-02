Feature: DELETE User Account
  @Test @PositiveCase @Users
  Scenario: Delete user account with valid token should success then return 200 response code
    Given Delete user account with valid token
    When Send request delete user account
    Then Should return status code 200
    And Response body message contain "User account deleted successfully"

  @Test @NegativeCase @Users
  Scenario: Delete user account with wrong token should failed then return 401 response code
    Given Delete user account with wrong token
    When Send request delete user account
    Then Should return status code 401

  @Test @NegativeCase @Users
  Scenario: Delete user account without token should failed then return 401 response code
    Given Delete single data user without token
    When Send request delete user account
    Then Should return status code 401