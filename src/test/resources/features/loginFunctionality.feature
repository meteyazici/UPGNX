Feature: Upgenix Login Functionality feature

  User Story :

  As a user, I should be able to log in so that I can land on homepage.


  Background: User is expected to login page
    Given User is on the login page
    Then  User should see in title and it should contains "Login"

  @UPGN-727
  Scenario Outline: Salesmanager can log in with valid credentials
    When salesmanager enters "<valid username>" to to email input
    And salesmanager enter "<valid password>" to password input
    And user clicks login button
    Then salesmanager should see the #Inbox - Odoo as title
    Examples:
      | valid username           | valid password |
      | salesmanager6@info.com   | salesmanager   |
      | salesmanager47@info.com  | salesmanager   |
      | salesmanager104@info.com | salesmanager   |

  @UPGN-728
  Scenario Outline: Posmanager can log in with valid credentials
    When posmanager enters "<valid username>" to to email input
    And posmanager enter "<valid password>" to password input
    And user clicks login button
    Then posmanager should see the #Inbox - Odoo as title
    Examples:
      | valid username         | valid password |
      | posmanager10@info.com  | posmanager     |
      | posmanager99@info.com  | posmanager     |
      | posmanager155@info.com | posmanager     |

  @UPGN-729
  Scenario Outline: Salesmanager can't log in with invalid credentials
    When salesmanager enters "<valid username>" to to email input
    And salesmanager enter "<invalid password>" to password input
    And user clicks login button
    Then salesmanager should see the "Wrong login/password" alert
    Examples:
      | valid username         | invalid password  |
      | salesmanager6@info.com | salesmanager12345 |

  @UPGN-730
  Scenario Outline: Salesmanager can't log in with invalid credentials
    When salesmanager enters "<invalid username>" to to email input
    And salesmanager enter "<valid password>" to password input
    And user clicks login button
    Then salesmanager should see the "Wrong login/password" alert
    Examples:
      | invalid username         | valid password |
      | salesmanager@info.com    | salesmanager   |
      | salesmanager4@info.com   | salesmanager   |
      | salesmanager106@info.com | salesmanager   |

  @UPGN-731
  Scenario Outline: Salesmanager can't log in with invalid credentials
    When posmanager enters "<valid username>" to to email input
    And posmanager enter "<invalid password>" to password input
    And user clicks login button
    Then posmanager should see the "Wrong login/password" alert
    Examples:
      | valid username        | invalid password |
      | posmanager10@info.com | posmanager12345  |


  @UPGN-732
  Scenario Outline: posmanager can't log in with invalid credentials
    When posmanager enters "<invalid username>" to to email input
    And posmanager enter "<valid password>" to password input
    And user clicks login button
    Then posmanager should see the "Wrong login/password" alert
    Examples:
      | invalid username       | valid password |
      | posmanager@info.com    | posmanager     |
      | posmanager4@info.com   | posmanager     |
      | posmanager156@info.com | posmanager     |

  @UPGN-733
    Scenario Outline: User should't be able to login with empty information
    When user enters "<valid username>" to to email input
    And user enters "<valid password>" to to email input
    And User click to Log in button
    Then User should see message "Lütfen bu alanı doldurun." under the email box
    Examples:
      | valid username      | valid password |
      |                     |                |
      | posmanager@info.com |                |
      |                     | posmanager     |

  @UPGN-734
  Scenario Outline: Salesmanager can log by enter button in with valid credentials
    When user enters "<valid username>" to to email input
    And user enter "<valid password>" to password input
    And user clicks enter button
    Then user should see the #Inbox - Odoo as title
    Examples:
      | valid username         | valid password |
      | salesmanager6@info.com | salesmanager   |
      | posmanager10@info.com  | posmanager     |



