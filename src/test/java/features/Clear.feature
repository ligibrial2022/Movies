Feature: ClearMovies

  Scenario: ClearMovies


    And the user create a list for
      |name       |description|language|
      | s         |a          | en     |

    When the user wants to clear list
      |name       |description|language|
      | s         |a          | en     |

    Then verify the movie was added