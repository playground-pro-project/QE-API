Feature: Get single vanues availbility
  @Test
  Scenario Outline: Get single vanues with valid vanues id
    Given Get single vanues availbility with valid parameter id "<id>"
    When Send Get single vanues availbility
    Then Should return status code 200
    And Validate Json Schema Get single Vanues availbility
    Examples:
    |id|
    |VNE-JSZ9BU6M|


  @Test
  Scenario Outline: Get single vanues with invalid vanues id
    Given Get single vanues availbility with invalid parameter id "<id>"
    When Send Get single vanues availbility
    Then Should return status code 404
    Examples:
      | id |
      | @  |


