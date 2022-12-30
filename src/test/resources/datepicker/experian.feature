Feature: Date Picker Feature Experian

  @experian
  Scenario Outline: Date Picker Test Experian
    Given When user is in experian home page "<homepage>" in "<browser>" browser
    When User press ESC key to hide login modal
    And User clicks checkin date
    And User selects "<departureDate>" and "<returnDate>"
    Then User clicks ok button


    Examples:
      | homepage                | browser | departureDate  | returnDate        |
      | https://www.expedia.com | chrome  | March 28, 2023 | December 21, 2023 |