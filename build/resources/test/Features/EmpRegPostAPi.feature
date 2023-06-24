Feature: Register Registration
  @smoke
  Scenario Outline: check register registration successful or not
    Given register has the api  '<path>'
    When register hit '<email>' and '<password>'
    And call the api with body
    Then it will return token

    Examples:
    |path    |email             |password|
    |register|eve.holt@reqres.in|123456|


