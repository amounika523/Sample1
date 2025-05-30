# features/query.feature
Feature: Oracle DB connectivity

  Scenario: Query employees table
    Given the database is up
    When I query the "EMPLOYEES" table
    Then I should see at least 1 row

  Scenario: Query employees table
    Given the database is up
    When I try to insert a record to the "EMPLOYEES" table with "Name" column as "Mounika"
    And I query the "EMPLOYEES" table
    Then I should see at least 2 row

