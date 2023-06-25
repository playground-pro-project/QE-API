Feature: Get single vanues
  @Test
  Scenario Outline: Get single vanues with valid vanues id
    Given Get single vanues with valid parameter id <id> from credentials email "<email>" and password "<password>"
    When Send Get single vanues
    Then Should return status code 200
    And Validate Json Schema Get single Vanues
    Examples:
      | email | password | id |
      | a     | v        | 1  |


  @Test
  Scenario Outline: Get single vanues with invalid vanues id
    Given Get single vanues with invalid parameter id "<id>" from credentials email "<email>" and password "<password>"
    When Send Get single vanues
    Then Should return status code 400
    Examples:
      | email | password | id |
      | a     | v        | @  |


