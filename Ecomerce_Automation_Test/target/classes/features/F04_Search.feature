@smoke
Feature: F04_Search | user could search for product

  Scenario Outline: user could search using product name
    When user click on search field
    And user enter product name "<product name>"

    Then user find all related products "<product name>"


    Examples:
      | product name |
      | book         |
      | laptop       |
      | nike         |

  Scenario Outline: user could search for product using sku
    When user click on search field
    And user enter product sku"<product sku>" and click on search button
    Then user will find all related products by "<product sku>"

    Examples:
      | product sku |
      | SCI_FAITH   |
      | APPLE_CAM   |
      | SF_PRO_11   |