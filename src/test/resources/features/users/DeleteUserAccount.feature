Feature: DELETE User Account
  @Test @PositiveCase
  Scenario Outline: Delete user account with valid token should success then return 200 response code
    Given Add user with "<nama>" as full name, "<email>" as email, "<phone>" as phone, and "<password>" as password
    When Send request post delete user account
    Given Delete user account with valid token
    When Send request delete user account
    Then Should return status code 200
    And Response body message contain "<message>"
    Examples:
      | nama | email | phone | password | message |
      |      |       |       |          |         |

  @Test @NegativeCase
  Scenario: Delete user account with wrong token should failed then return 401 response code
    Given Delete user account with wrong token
    When Send request delete user account
    Then Should return status code 401

  @Test @NegativeCase
  Scenario: Delete user account without token should failed then return 401 response code
    Given Delete single data murid without token
    When Send request delete user account
    Then Should return status code 401