Feature: Date Picker Feature Testing

  @datepicker
  Scenario Outline: Date Picker Test
    Given When user is in makemytrip home page "<homepage>" in "<browser>" browser
    When User clicks login modal to hide modal
    And User clicks round-trip option
    And User clicks departure date option
    And User enters "<departureDate>" and "<returnDate>"
    Then User clicks search button


    Examples:
      | homepage                           | browser | departureDate | returnDate        |
      | https://www.makemytrip.com/flights | chrome  | 31 March 2023  | 22 June 2023 |
