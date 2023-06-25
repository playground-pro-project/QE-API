Feature: Post Reservations
  Scenario Outline: Post create reservation with valid reqbody json
    Given Post Create reservation with valid json reqbody and valid token from credential email "<email>" and password "<password>"
    When Send post Create reservation
    Then Should return status code 201
    Examples:
      | email | password |
      | a     | w        |

    Scenario Outline: Post create reservation with invalid reqbody json
      Given Post Create reservation with invalid json reqbody and valid token from credential email "<email>" and password "<password>"
      When Send post Create reservation
      Then Should return status code 400
      Examples:
        | email | password |
        | a     | w        |