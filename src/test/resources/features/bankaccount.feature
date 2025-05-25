
Feature: Bank account operations
  User performs deposit, withdrawal and balance checks in the bank account

  @smoke @positive
  Scenario: Deposit money into the account
    Given my current account balance is 1000
    When I deposit amount 1000.0 into my account
    Then my account balance should be 2000
@smoke @positive
  Scenario: Withdraw money from account
    Given my current account balance is 2000
    When I withdraw amount 1000 from my account
    Then my account balance should be 1000
@regression @negative
  Scenario: If withdraw amount is greater than account current balance
    Given my current account balance is 1000
    When I withdraw amount 1500 from my account
    Then the withdraw should declined
    And my account balance should be 1000