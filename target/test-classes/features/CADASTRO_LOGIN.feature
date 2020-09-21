Feature: Create Account and Sign in

  Background: Access Home Page
    Given I Access the page "http://automationpractice.com/index.php"
    And click on Sign In


  Scenario: Sign In Attempts
    And I fill user email
    And fill the password
    And I click on Sign In button
    And I got the message Error


  @TEST
  Scenario: Create account And Complete Purchase
    When I fill email to create account
    And I click on Button Create Account
    When I fill all data on form
    And I submit the form
    Then account has been created with success
    Given I click on T-SHIRT Menu Category
    And add item to cart
    And I Proceed to Checkout
    And  I Confirm Order on History