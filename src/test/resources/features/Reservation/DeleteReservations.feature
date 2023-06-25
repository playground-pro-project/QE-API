Feature: Delete Reservations
  @Test
  Scenario Outline: Delete reservation with valid parameter id
    Given Delete reservation with valid id "<id>" with valid token from credential email "<email>" and password "<password>"
    When Send delete reservation
    Then Should return status code 200
    Examples:
      | id | email |  | password |
      |    |       |  |          |

  Scenario Outline: Delete reservation with invalid parameter id
    Given Delete reservation with invalid id "<id>" with valid token from credential email "<email>" and password "<password>"
    When Send delete reservation
    Then Should return status code 400
    Examples:
      | id | email | password |
      |    |       |          |