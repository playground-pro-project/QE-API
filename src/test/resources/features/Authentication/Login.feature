Feature: Login

  @Test
  Scenario: Post Login with valid json reqbody
    Given Post login with valid json reqbody
    When Send post login
    Then Should return status code 200
    And Response body message contain "Login success"


  @Test
   Scenario: Login with wrong email or password
    Given Post login with wrong email or password
    When Send post login
    Then Should return status code 400
    And Response body message contain "Bad request, invalid email and password"
    


  @Test
  Scenario: Post Login with invalid json reqbody
    Given Post login with invalid json reqbody
    When Send post login
    Then Should return status code 400
    And Response body message contain "Bad requestcode=400, message=Unmarshal type error: expected=string, got=number, field=password, offset=55, internal=json: cannot unmarshal number into Go struct field LoginRequest.password of type string"
