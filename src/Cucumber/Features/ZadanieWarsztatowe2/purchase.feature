Feature: Purchase after login

  Scenario Outline: Make new purchase by existing user
    Given User is logged in to CodersLab shop
    When User selects Hummingbird printed sweater
    And input "group[1]" filled with "<size>"
    And next input "quantity_wanted" filled with "<quantity>"
    #And User selects size L
    #And User selects quantity 5
    And User adds items to cart
    And User confirms Proceed to checkout in 2 places
    And User selects and confirms Address
    And User selects shipping method pick up in store
    And User selects payment method Pay by Check
    And User confirms order I agree to the terms of service and will adhere to them unconditionally. Order with an obligation to pay
    Then Order confirmation is shown

    Examples:

      | size | quantity |
      | L    | 2        |
