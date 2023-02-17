@smoke
Feature: F08_Wishlist | user could add items to wishlist
  Scenario: user select an item to add to wishlist
    When user clicks on AddToCard button on this product
    Then this product is added successfully

  Scenario: user select  item to add to wishlist and verify quantity
    When user clicks on wishlist button on this product
    And clicks on wishlist link
    Then verify the product is added successfully and product quantity is more than zero