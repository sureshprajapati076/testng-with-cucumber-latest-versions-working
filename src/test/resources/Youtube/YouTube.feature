Feature: YouTube Feature Dec 2022

  @youtube @test
  Scenario Outline: Search text Automation in youtube
    Given User is in youtube "<homepage>" homepage
    When User enters text "<searchText>" in search box
    And User Click search Button
    Then Verify user sees results

    Examples:
      | homepage            | searchText  |
      #@#@GOLD
      | https://youtube.com | Electronics |


  @youtube
  Scenario Outline: Search text Automation in youtube Ditital
    Given User is in youtube "<homepage>" homepage
    When User enters text "<searchText>" in search box
    And User Click search Button
    Then Verify user sees results

    Examples:
      | homepage            | searchText |
      | https://youtube.com | Digital    |