Feature: User Registration, Signup, Login, and Account Deletion

  Scenario: Register User
    Given I launch the browser
    When I navigate to the URL "https://automationexercise.com/"
    Then I should see the home page successfully
    When I click on "Signup Login" button
    Then I verify "New User Signup" is visible
    When I enter "John Doe" as name and "john.doe@example3.com" as email address
    And I click "Signup" button
    Then I verify that "ENTER ACCOUNT INFORMATION" is visible
    When I fill in the following details:
      | Field              | Value                 |
      | Title              | Mr.                   |
      | Name               | John Doe              |
      | Password           | Password123           |
      | Date of birth      | 01/01/1990            |
    And I select the checkbox "Sign up for our newsletter!"
    And I select the checkbox "Receive special offers from our partners!"
    And I fill in the following address details:
      | Field        | Value                  |
      | First name   | John                   |
      | Last name    | Doe                    |
      | Company      | Acme Corp              |
      | Address      | 123 Main St            |
      | Address2     | Apt 4B                 |
      | Country      | United States          |
      | State        | California             |
      | City         | Los Angeles            |
      | Zipcode      | 90001                  |
      | Mobile Number| 123-4567-890           |
    And I click the "Create Account" button
    Then I verify "ACCOUNT CREATED!" is visible
    When I click the "Continue" button
    Then I verify "Logged in as John Doe" is visible
    When I click the "Delete Account" button
    Then I verify "ACCOUNT DELETED!" is visible
    When I click the "Continue" button after account deletion