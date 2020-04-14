Feature: Application login
  Scenario: Home page default login
    Given User is on NetBanking landing page
    When User login into application with username "Hasan"  and password "1234"
    Then Home page is populated
    And Cards are displayed

  Scenario Outline: Home page default login
    Given User is on NetBanking landing page
    When User login into application with username <username>  and <password>
    Then Home page is populated
    And Cards are NOT displayed

    Examples:
    |username       |password    |
    |storemanager85 |UserUser123 |
    |user16         |UserUser123 |

