@US_1 @Regression @Smoke
Feature: Create Account End to end Testing

  Scenario: Create Account create Credentials and Login
    When click on "Create Primary Account" link
    Then validate section title to be "Create Primary Account Holder"
