Feature: POST Upgrade User Role
  @Test @PositiveCase @Reviews
  Scenario Outline: Delete a review with valid parameter and valid token should success then return 200 response code
    Given Delete a review with "<review_id>" as id and valid token
    When Send request delete a review
    Then Should return status code 200
    And Response body message contain "berhasil menghapus ulasan"
    Examples:
      | review_id |
      |           |

  @Test @NegativeCase @Reviews
  Scenario Outline: Delete a review with valid parameter and wrong token should failed then return 401 response code
    Given Delete a review with "<review_id>" as id and wrong token
    When Send request delete a review
    Then Should return status code 401
    Examples:
      | review_id |
      |           |

  @Test @NegativeCase @Reviews
  Scenario Outline: Delete a review with invalid parameter should failed then return 404 response code
    Given Delete a review with "<review_id>" as id
    When Send request delete a review
    Then Should return status code 404
    Examples:
      | review_id |
      | shark     |

  @Test @NegativeCase @Reviews
  Scenario Outline: Delete a review with blank parameter should failed then return 404 response code
    Given Delete a review with "<review_id>"
    When Send request delete a review
    Then Should return status code 404
    Examples:
      | review_id |
      |           |