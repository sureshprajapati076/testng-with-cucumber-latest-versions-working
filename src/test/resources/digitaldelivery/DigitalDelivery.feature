Feature: Digital Delivery

  @DigitalDelivery
  Scenario Outline: User should be able to see card details
    Given When user clicks vanity url "<vanityurl>"
    When User provides valid "<ssn>" and clicks Next
    And User clicks Send Code
    And User enters valid otp "<otp>" and clicks Next
    Then User sees Credit Card Details


    Examples:
      | vanityurl                                                               | ssn  | otp    |
      | https://dit39.online.citi.com/US/ag/cards/instant-card?token=9876543210 | 4325 | 123432 |