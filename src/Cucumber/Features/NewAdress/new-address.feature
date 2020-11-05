Feature: Change user adress after login

  Scenario: Create new user adress
    Given User is logged in to CodersLab shop
    When User goes to UserAccount
    And User goes to Address
    And User creates new adress "address", "city", "00-000"
    And User saves details
    Then User sees "Address successfully added!"
