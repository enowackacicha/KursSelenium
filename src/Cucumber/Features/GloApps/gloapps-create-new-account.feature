Feature: Glo Apps

  Scenario Outline: Create account

    Given an open browser
    And the browser with "qloapps.coderslab.pl/pl/logowanie"
    When input "email_create" filled with "<e-mail>"
    And button "SubmitCreate" clicked
    And next page "account-creation" opened
    And input "<sex>" clicked
    And next input "customer_firstname" filled with "<firstName>"
    And next input "customer_lastname" filled with "<lastName>"
    And next input "passwd" filled with "<password>"
    And button "submitAccount" clicked
    Then page "moje-konto" opened
    And close browser

    Examples:
      | e-mail           | sex        | firstName  | lastName  | password |
      | my16aa@address.pl | id_gender2 | first name | last name | abc123   |
      | my16b@address.pl  | id_gender1 | first name | last name | abc123   |
      | my17c@address.pl  | id_gender2 | first name | last name | abc123   |