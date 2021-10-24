# new feature
# Tags: optional

Feature: A post can be created by POST request.

  Scenario Outline: A post is created with valid title, body and userId.
    Given there is an user has "Delphine" username
    And "<title>" title is entered for the post
    And "<body>" body is entered for the post
    And test userId is entered for the post
    When POST request is send with the post
    Then post is created successfully
    Examples:
      | title | body |
      | foo   | bar  |