Feature: POST Add a Review
  @Test @PositiveCase @Reviews
  Scenario: Post add a review with valid token and valid body should success then return 201 response code
    Given Post add a review with valid token and valid body
    When Send request post add a review
    Then Should return status code 201
    And Response body message contain "berhasil menambahkan ulasan"
    And Validate json schema post add a review

  @Test @NegativeCase @Reviews
  Scenario: Post add a review with wrong token and valid body should failed then return 401 response code
    Given Post add a review with wrong token and valid body
    When Send request post add a review
    Then Should return status code 401

  @Test @NegativeCase @Reviews
  Scenario: Post add a review with valid token and blank body should failed then return 400 response code
    Given Post add a review with valid token and blank body
    When Send request post add a review
    Then Should return status code 400

  @Test @NegativeCase @Reviews
  Scenario: Post add a review with blank token and blank body should failed then return 401 response code
    Given Post add a review with blank token and blank body
    When Send request post add a review
    Then Should return status code 401