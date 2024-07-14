Feature: Get a PayPal access Token

  Scenario : Get Access Token using client id and client secret
    Given  I want to get access token from PayPal api
    Then I have PayPal client id and client secret
    Then I should receive a response with status code 200
    And the response should contain an access token
