@smoke
Feature: user could create new accounts with valid credentials

  #POSTIVE Scenario:
  Scenario: user register new account successfully
    Given user go to register page
    When user select gender type
    When user enter First & last name
    And user enter Date of birth
    And user enter  valid email "noha75@gmail.com"
    And user enter Company name
    And user enter Password & Confirm password
    And user click on register button
    Then user created account successfully

     #Negative Scenario:
  Scenario: user couldn't register with invalid email
    Given user go to register page
    When user select gender type
    When user enter First & last name
    And user enter Date of birth
    And user enter  valid email "nohagmail.com"
    And user enter Company name
    And user enter Password & Confirm password
    And user click on register button
    Then user could not create new account





