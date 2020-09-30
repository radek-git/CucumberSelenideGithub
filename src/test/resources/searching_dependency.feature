Feature: Searching for dependency
  Scenario Outline: Should find dependency for given input
    Given User opens page
    And User inputs <dependency> dependency name and clicks Enter
    And User selects <language> language
    And User selects first dependency
    And User clicks Branch dropdown
    When User saves visible branches
    And User saves all folders and filenames
    Then Branches and folders and filenames are saved
    Examples:
      | dependency | language |
      | "Lombok"   | "Java"   |
      | "Faker"    | "Python" |
      | "Selenide" | "JavaScript" |


