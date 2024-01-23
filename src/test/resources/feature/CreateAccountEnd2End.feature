@US_1 @Regression @Smoke
Feature: Create Account End to end Testing

  Scenario Outline: Create Account create Credentials and Login
    When click on "Create Primary Account" link
    Then validate section title to be "Create Primary Account Holder"
    When fill up create account form
      | email            | random             |
      | firstName        | <firstName>        |
      | lastName         | <lastName>         |
      | prefix           | <prefix>           |
      | gender           | <gender>           |
      | maritalStatus    | <maritalStatus>    |
      | employmentStatus | Software Developer |
      | dob              | <dob>              |
    When click on "Create Account" button
    Then validate section title to be "Sign up your account"
    Then validate created fullName and email
    When send text "random" to "Username" field
    When send text "<password>" to "Password" field
    When send text "<password>" to "Confirm Password" field
    When click on "Submit" button
    Given wait 5 second
    Then validate section title to be "Sign in to your Account"
    When send text "random" to "Username" field
    When send text "<password>" to "Password" field
    When click on "Sign In" button
    Then validate application title "Primary Account Portal"
    Examples:
      | firstName | lastName  | gender | maritalStatus | prefix | password | dob        |
      | Shafagh   | Razaghi   | Female | Married       | Mrs.   | Tek$2024 | 01/01/1989 |
      | Murtaza   | Heidary   | Male   | Single        | Mr.    | Tek@2310 | 12/21/1999 |
      | Mohammad  | Shokriyan | Male   | Divorced      | Mr.    | Tek@2023 | 12/27/1987 |