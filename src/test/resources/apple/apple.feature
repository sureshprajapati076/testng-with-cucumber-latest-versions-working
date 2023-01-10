Feature: Apple page Feature
  @apple
  Scenario Outline: Apple purchase for iPad
    Given User is in apple home page "<homepage>"
    When User clicks iPad link in banner
    And User clicks buy button
    And User selects color "<color>"
    And User selects storage "<storage>"
    And User selects connectivity "<connectivity>"
    And User selects no engraving
    And User selects no apple Pen
    And User selects no USB C
    And User selects no Keyboard
    And User selects no trade in
    And User selects buy
    And User selects no apple care
    And User selects Add to bag button
    Then Verify ipad is added to bag
    Examples:
      | homepage          | color | storage | connectivity |
      | https://apple.com |grey   |512      |wifi          |
