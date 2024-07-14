Feature: Validate Create Order feature

  Scenario Outline: Validate Create Order Feature with valid details
    Given I want to get access token from PayPal api
    And the response should contain an access token
    When I set reference id "<reference_id>" and currency code as  "<CurrencyCode>" and value as "<CurrencyValue>"
    And I verify the status code 200
    Examples:
      | reference_id                         | CurrencyCode | CurrencyValue |
      | d9f80740-38f0-11e8-b467-0ed5f89f718b | USD          | 100.00        |

