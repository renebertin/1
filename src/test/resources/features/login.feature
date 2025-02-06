Feature: User Login

  Scenario: Login User with correct email and password
    Given the user launches the browser
    When the user navigates to URL "http://automationexercise.com"
    Then the home page should be visible successfully
    When the user clicks on the 'Signup Login' button
    Then the 'Login to your account' section should be visible
    When the user enters the correct email address and password
    And clicks the 'login' button
    Then the message 'Logged in as username' should be visible
    When the user clicks on the 'Logout' button
    Then the message 'Login to your account' should be visible


