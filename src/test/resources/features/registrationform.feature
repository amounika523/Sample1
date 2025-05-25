
Feature: Registration form
  As a user to register successfully need to enter name, email and password correctly
  the details should be validate

  Scenario Outline: Try to validate with correct details
    Given User is on the registration page
    When user register with name "<name>", email "<email>", and password "<password>"
    Then validation is <outcome>

    Examples:
      | name       | email                  | password     |  outcome |
      | Mounika    | Amounika523@gmail.com  | password123  |  success |
      | admin      | wrongPass              | preetham     |  fail    |



