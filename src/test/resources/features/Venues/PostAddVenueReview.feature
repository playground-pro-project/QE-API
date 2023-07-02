Feature: Post Add Venue Review

  @Test
  Scenario Outline: Post add venue review valid body
    Given Post add venue review valid body with id "<id>"
    When Send post add venue review
    Then Should return status code 201
    Examples:
    |id |
    |VNE-NDA0A2CF|

    @Test
    Scenario Outline: Post add venue review invalid body
      Given Post add venue review invalid body with id "<id>"
      When Send post add venue review
      Then Should return status code 400
      Examples:
        |id |
        |VNE-NDA0A2CF|

