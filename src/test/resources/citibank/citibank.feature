Feature: Citi Bank Feature Testing

  @citibank
  Scenario Outline: Citi Bank Registration
    Given When user is in citi home page "<homepage>" in "<browser>" browser
    When User clicks register account link
    And User selects brokerage account option
    And User enters "<brokerageAcctNumber>"
    And User clicks continue button
    And User enters "<ssn>" in SSN field
    And User enters "<dob>" in DOB field
    Then verify user sees no errors

    Examples:
      | homepage             | browser | brokerageAcctNumber | ssn       | dob        |
  #!@#@CITIBANK
      | https://citibank.com | edge    | 352                 | 635448952 | 11/12/1992 |
      | https://citibank.com | chrome  | 352                 | 635448952 | 11/12/1992 |
      | https://citibank.com | firefox | 985                 | 448569254 | 10/10/1995 |