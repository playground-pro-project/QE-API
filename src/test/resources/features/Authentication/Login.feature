Feature: Login

  @Test
  Scenario Outline: Post Login with valid form data
    Given Post login with valid form data email "<email>" password "<password>"
    When Send post login
    And Response body message contain "Login successful"
    Then Should return status code 200
       Examples:
         | email | password |
         |       |          |

  @Test
  Scenario Outline: Post Login with invalid form data
    Given Post login with invalid form data email <email> password "<password>"
    When Send post login
    And Response body message contain "User login unsuccessful"
    Then Should return status code 400
        Examples:
      | email | password |
      | 1     | password |