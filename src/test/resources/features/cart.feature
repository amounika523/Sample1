
Feature: Shopping cart positive scenario
  Add items from a cart, maintain state, and calculate total.

  Scenario: Add and remove items from cart, calculate total with positive scenario
    Given the cart is empty
    When user add "apple" with price 1.5
    And user add "banana" with price 2.0
    And user add "pineapple" with price 4.87
    And user remove "banana" with price 2.0
    Then total price is 6.37
