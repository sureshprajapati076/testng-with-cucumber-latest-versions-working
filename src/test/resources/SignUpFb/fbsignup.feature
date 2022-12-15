Feature: Facebook Feature Dec 2022

  @signup
  Scenario Outline: signup for fb
    Given User is in facebook "<homepage>" homepage
    And User clicks signup button
    Then Verify user sees signup page

    Examples:
      | homepage       | searchText  |
      | https://fb.com | Automation1 |