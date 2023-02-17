@smoke
Feature: F03_Currencies | User could switch currency between Dollar and Euro

  Scenario: user could Select Euro currency
    When user select currency type and select Euro
    Then verify Euro Symbol (€) is shown on the four products displayed in Home page
