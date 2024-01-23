@US_2 @Regression
Feature: Testing CSR Primary Account Section

  Background: Login with CSR Credentials
    When click on "Login" link
    When send text "supervisor11" to "Username" field
    When send text "tek_supervisor" to "Password" field
    When click on "Sign In" button

  Scenario: Validate Primary Account Table
    When click on "Accounts" link
    Then validate card title to be "Primary Accounts"
    Then validate table row count to be 5
    When change items par page to "10"
    Then validate table row count to be 10
    When change items par page to "25"
    Then validate table row count to be 25
    When change items par page to "50"
    Then validate table row count to be 50