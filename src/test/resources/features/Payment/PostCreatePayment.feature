Feature: Payment
  Scenario Outline: Post create payment with valid reqbody json
    Given Post Create payment with valid json reqbody and valid token from credential email "<email>" and password "<password>"
    When Send post create payment
    Then Should return status code 200
    Examples:
      | email | password |
    | a     | w        |

  Scenario Outline: Post create payment with invalid reqbody json
    Given Post Create payment with valid json reqbody and valid token from credential email "<email>" and password "<password>"
    When Send post create payment
    Then Should return status code 400
    Examples:
      | email | password |
      | a     | w        |

