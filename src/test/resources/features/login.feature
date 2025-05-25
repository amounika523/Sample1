Feature: Login functionality
  In order to access the application
  As a user
  I want to log in with my credentials

  Scenario Outline: Try to log in with various credentials
    Given the user is on the login page
    When  the user logs in with username "<username>" and password "<password>"
    Then  the login should <outcome>

    Examples:
      | username | password     | outcome  |
      | admin    | password123  | succeed  |
      | admin    | wrongPass    | fail     |
      | bob      | password123  | fail     |
      |          | password123  | fail     |
      | admin    |              | fail     |
      | null     |              | fail     |
      |          | null         | fail     |
