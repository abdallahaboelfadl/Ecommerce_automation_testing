@smoke
Feature: F05_hoverCategories |  User hover on one of main categories

  Scenario:  user could select category and then hover and select sub category
    When user hover random category
    And user select sub category
    Then subCategory page appears