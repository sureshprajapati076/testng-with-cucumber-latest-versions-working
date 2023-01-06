Feature: Retry Feature 2023

  @Retry
  Scenario: Retry Demo1
    Given User is in somewhere1
    When User clicks somewhere1
    Then verify something1

  @Retry
  Scenario: Retry Demo2
    Given User is in somewhere2
    When User clicks somewhere2
    Then verify something2