Feature: Validation otp
  @Test
  Scenario: Post validation with valid otp
    Given Post validation with valid otp
    When Send Post Validation
    Then Should return status code 200
    And Response body message contain "Verification success"

  @Test
    Scenario: Post validation with wrong otp
        Given Post validation with wrong otp
        When Send Post Validation
        Then Should return status code 400
        And Response body message contain "OTP has been expired"

  @Test
    Scenario: Post Resend otp with valid json reqbody
        Given Post resend otp with valid json reqbody
        When Send Post Resend otp
        Then Should return status code 201
        And Response body message contain "Check OTP number sent to your email"


  @Test
    Scenario: Post Resend otp with invalid json reqbody
        Given Post resend otp with invalid json reqbody
        When Send Post Resend otp
        Then Should return status code 400

    @Test
    Scenario: Post Resend otp with invalid email
        Given Post resend otp with invalid email
        When Send Post Resend otp
        Then Should return status code 404