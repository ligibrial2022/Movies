Feature: AddMovie

  Scenario: AddMovie with API


    And the user create a list for
      |name       |description|language|
      | s         |a          | en     |

    When the user add movie with
    | media_id|
    |  13     |


    Then verify the movie was added