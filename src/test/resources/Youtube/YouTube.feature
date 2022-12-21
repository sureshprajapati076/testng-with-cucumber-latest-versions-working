Feature: YouTube Feature Dec 2022

  @youtube91
  Scenario Outline: Search text Automation in youtube Ditital
    Given User is in youtube "<homepage>" homepage
    When User enters text "<searchText>" in search box
    And User Click search Button
    Then Verify user sees results

    Examples:
      | homepage | searchText |
      #@#@GOLD
      |https://youtube.com|Electronics|
      #|https://youtube.com|Electronics|

  @youtube91
  Scenario Outline: Search text Automation in youtube Ditital
    Given User is in youtube "<homepage>" homepage
    When User enters text "<searchText>" in search box
    And User Click search Button
    Then Verify user sees results

    Examples:
      | homepage | searchText |
      #@#@GOLD
|https://youtube.com|Electronics|

  @youtube90
  Scenario Outline: Search text Automation in youtube
    Given User is in youtube "<homepage>" homepage
    When User enters text "<searchText>" in search box
    And User Click search Button
    Then Verify user sees results

    Examples:
      | homepage | searchText |
      #@#@GOLD
      |https://youtube.com|Automation|
      |https://youtube.com|lastRow|