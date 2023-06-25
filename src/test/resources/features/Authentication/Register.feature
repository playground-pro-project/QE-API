Feature: Post Register

  @Test
  Scenario Outline: Post Create account with valid form data
    Given Post Create account with valid form data name "<name>" email "<email>" phone "<phone>" password "<password>"
    When Send post create account
    And Response body message contain "User registered successfully"
    Then Should return status code 201

    Examples:
      | name        | email | phone | password |
      | Derin Malsa |       |       |          |

  @Test
  Scenario Outline: Post Create account with invalid form data
    Given Post Create account with invalid form data name "<name>" email <email> phone "<phone>" password "<password>"
    When Send post create account
    And Response body message contain "User registered unsuccessful"
    Then Should return status code 400
        Examples:
      | name        | email | phone | password |
      | Derin Malsa | 1     |       |          |



