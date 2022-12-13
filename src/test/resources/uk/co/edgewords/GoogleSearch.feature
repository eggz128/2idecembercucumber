@RunThis
Feature: Searching Google for Edgewords
  In order to get more business Tom wants us to be top on common search terms


  Scenario: Search Google for Edgewords
    Given i am on GOOGle
    When I search for "edgewords"
    Then 'edgewords' is the top result

  Scenario Outline: Search Google for various things
    Given I have visited Google
    When I search for "<searchTerm>"
    Then '<searchTerm>' is the top result
    Examples:
      | searchTerm |
      | Edgewords  |
      | Cucumber   |
      | BBC        |

  Scenario: Verify edgewords results
    Given I have visited Google
    When I search for "edgewords"
    Then I see in the results
      | title                                                    | url                                 |
      | Edgewords Training - Automated Software Testing Training | https://www.edgewordstraining.co.uk |
      | Edgewords - Twitter                                      | https://twitter.com › edgewords     |


