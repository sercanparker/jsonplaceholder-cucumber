Feature: Comments which are entered by the Users can be retrieved via API.

  Scenario Outline: There are posts written by user who has <username> username. All email formats are correct in the comments for the posts.
    Given there is an user has "<username>" username
    And there are posts written by test user
    When all comments are retrieved for each post
    Then e-mail formats are correct in the comments
    Examples:
      | username |
      | Delphine |

  Scenario Outline: There are posts written by user who has <username> username. Email values are correct in the comments for the posts.
    Given there is an user has "<username>" username
    And there are posts written by test user
    When all comments are retrieved for each post
    Then e-mail values are matched with the users in the comments
    Examples:
      | username |
      | Delphine |

  Scenario Outline: There are posts written by user who has <username> username. Name fields are not empty in the comments for the posts.
    Given there is an user has "<username>" username
    And there are posts written by test user
    When all comments are retrieved for each post
    Then name values are not empty in the comments
    Examples:
      | username |
      | Delphine |

  Scenario Outline: There are posts written by user who has <username> username. Body fields are not empty in the comments for the posts.
    Given there is an user has "<username>" username
    And there are posts written by test user
    When all comments are retrieved for each post
    Then name values are not empty in the comments
    Examples:
      | username |
      | Delphine |

  Scenario Outline: There are posts written by user who has <username> username. All ids are different from each other in the comments for the posts.
    Given there is an user has "<username>" username
    And there are posts written by test user
    When all comments are retrieved for each post
    Then all id values are different from each other in the comments
    Examples:
      | username |
      | Delphine |

  Scenario Outline: There are posts written by user who has <username> username. All postIds are same and match with the post in the comments.
    Given there is an user has "<username>" username
    And there are posts written by test user
    When all comments are retrieved for each post
    Then all postId values are same and matched with the post in the comments
    Examples:
      | username |
      | Delphine |




