Feature: Create a new post

  Scenario Outline: Create post with valid JSON and verify response
    Given the API endpoint is "https://jsonplaceholder.typicode.com/posts"
    When I send a POST request with:
      | title  | <title>  |
      | body   | <body>   |
      | userId | <userId> |
    Then the response status code should be <statusCode>
    And the response should contain:
      | title  | <title>  |
      | body   | <body>   |
      | userId | <userId> |

    Examples:
      | title        | body          | userId | statusCode |
      | sunt aut facere repellat provident occaecati excepturi optio reprehenderit    | quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto      | 1      | 201        |
      | hello world  | test content  | 5      | 201        |
