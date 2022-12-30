Feature: Date Picker Feature Experian

  @experian
  Scenario Outline: Date Picker Test Experian
    Given When user is in experian home page "<homepage>" in "<browser>" browser
    When User press ESC key to hide login modal
    And User clicks checkin date
    And User selects "<checkInDate>" and "<checkOutDate>"
    Then User clicks ok button


    Examples:
      | homepage                | browser | checkInDate  | checkOutDate   |
      | https://www.expedia.com | chrome  | May 02, 2024   | May 9, 2024  |
#      | https://www.expedia.com | chrome  | May 02, 2024   | May 11, 2024 |
#      | https://www.expedia.com | chrome  | May 2, 2024    | May 8, 2024  |
#      | https://www.expedia.com | chrome  | May 2, 2024    | May 09, 2024 |
      | https://www.expedia.com | chrome  | April 29, 2024 | May 09, 2024 |