Feature: Post Register

  @Test
  Scenario: Post Create account with json reqbody
    Given Post Create account with valid json reqbody
    When Send post create account
    Then Should return status code 201
    And Response body message contain "Check OTP number sent to your email"

  @Test
  Scenario: Post Create account with invalid form data
    Given Post Create account with invalid json reqbody
    When Send post create account
    And Error message should be "Invalid request payload"
    Then Should return status code 400

    @Test
    Scenario: Post Create account with registered email
        Given Post Create account with valid json reqbody
        When Send post create account
        And Error message should be "error insert data, duplicated"
        Then Should return status code 400




