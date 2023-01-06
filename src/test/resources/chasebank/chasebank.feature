Feature: Chase Bank Feature Test

  @chasebank @bank
  Scenario Outline: Chase Bank Signup for Checking Acct
    Given User is in home chase home page "<home>" in "<browser>"
    And User clicks Premium option
    And User clicks Open Now
    And User clicks No in existing customer
    And User clicks Next button
    Examples:
      | home                                         | browser |
      | https://personal.chase.com/personal/checking | chrome  |