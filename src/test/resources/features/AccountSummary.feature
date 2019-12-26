@acct
Feature: Account Summary

  @acct1
  Scenario: Account summary page title verification
    Given user is on home page
    When user enters "username" and "password" and clicks Sign in button
    Then title should be "Zero - Account Summary"
    And close browser


  @acct2
  Scenario: Account summary page account types
    Given user is on home page
    When user enters "username" and "password" and clicks Sign in button
    Then following account types should be displayed
      | Cash Accounts | Investment Accounts | Credit Accounts | Loan Accounts |
    And close browser

  @acct3
  Scenario: Account summary page account types
    Given user is on home page
    When user enters "username" and "password" and clicks Sign in button
    Then following columns should be displayed on Credit Accounts table
      | Account | Credit Card | Balance |
    And close browser