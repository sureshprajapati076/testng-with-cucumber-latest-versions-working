Feature: Facebook Feature Dec 2022

  @signup
  Scenario Outline: signup for fb
    Given User is in facebook "<homepage>" homepage in "<browser>"
    And User clicks signup button
    Then Verify user sees signup page

    Examples:
      | homepage       | browser |
      | https://fb.com | chrome  |

  @signup
  Scenario Outline: signup for fb
    Given User is in facebook "<homepage>" homepage in "<browser>"
    And User clicks signup button
    Then Verify user sees signup page

    Examples:
      | homepage       | browser |
      | https://fb.com | edge    |