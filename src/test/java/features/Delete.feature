Feature: DeleteList

  Scenario: DeleteList


    And the user create a list for
      |name       |description|language|
      | s         |a          | en     |

    When the user wants to delete list

    Then verify the movie was added