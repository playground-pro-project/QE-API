Feature : Put Reservations
Scenario Outline: Put Update reservation with valid parameter id and valid reqbody
  Given Put update reservation with valid json reqbody and valid id "<id>" also token from credential email "<email>" and password "<password>"
  When Send put update reservation
  Then Should return status code 200
  Examples:
    | id | email | password |
    | a  | b     | c        |

  Scenario Outline: Put Update reservation with valid parameter id and valid reqbody
    Given Put update reservation without json reqbody and valid id "<id>" also token from credential email "<email>" and password "<password>"
    When Send put update reservation
    Then Should return status code 400
    Examples:
      | id | email | password |
      | a  | b     | c        |

