@smoke
Feature: F01_Register | users could register with new accounts

  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user select gender type
    And user enter first name "automation" and last name "tester"
    And user enter date of birth  Step
    And user enter email "a.aboelfadel1@gmail.com" field
    And user fills Password fields "P@ssw0rd" "P@ssw0rd"
    And clicks on register button
    Then success message is displayed