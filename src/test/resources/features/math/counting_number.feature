@math @android
Feature: Calculator feature

  Background:
    Given user is on login page
    And user input username "admin"
    And user input password "admin"
    And user click button login

  @positive
  Scenario Outline: Counting number
    When user input number "one" is <angka1>
    And user choose operator "<operator>"
    And user input number "two" is <angka2>
    And user click equals button
    Then the total should be <result>
    Examples:
    | angka1 | operator | angka2 | result |
    | 1      | +        | 2      | 3      |
    | 2      | -        | 1      | 1      |
    | 3      | *        | 2      | 6      |
    | 4      | /        | 2      | 2      |


  @negative
  # this is bug
  Scenario: user input field 1 using alphabet
    When user input number "one" is "luv"
    Then field "one" can't be input with alphabet

  @negative
  # this is bug
  Scenario: user input field 2 using alphabet
    When user input number "two" is "luv"
    Then field "two" can't be input with alphabet

  @negative
  # this is bug
  Scenario: user click equals button with not filling in fields 1 and 2
    When user not filling all fields
    Then Button equals not active
