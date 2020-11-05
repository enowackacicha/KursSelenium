Feature: Change user adress after login

  Scenario Outline: Create new user adress
    Given User is logged in to CodersLab shop
    When User goes to UserAccount
    And User goes to Address
    And input "alias" filled with "<alias>"
    And next input "address1" filled with "<address>"
    And next input "city" filled with "<city>"
    And next input "postcode" filled with "<postalCode>"
    And next input "id_country" filled with "<country>"
    And next input "phone" filled with "<phone>"
    And User saves details
    Then User sees "Address successfully added!"

    Examples:
      | alias | address     | city      | postalCode | country        | phone   |
      | Mrs   | Jesionowa 1 | Wieliczka | 30-333     | United Kingdom | 1234567 |

