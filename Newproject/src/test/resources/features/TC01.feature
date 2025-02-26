Feature: OrangeHRM Login and Navigate to Admin > Qualifications

  Scenario: Successful login and navigation to Admin > Qualifications
    Given I am on the OrangeHRM login page
    When I enter valid credentials with username "Admin" and password "admin123"
    And I click on the "Login" button
    Then I should be logged in successfully
    And I should see the dashboard
    When I click on "Admin" from the menu
    Then I should be on the "Admin" page
    When I click on the "Qualifications" tab
    Then I should be able to view the "Qualifications" page

  

