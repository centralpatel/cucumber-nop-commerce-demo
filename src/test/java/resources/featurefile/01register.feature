Feature: Register Test
  As a user I want to register to nopcommerce website

  @smoke @sanity @regression
  Scenario: Verify User Should Navigate To Register Page Successfully
    Given I am on homepage
    When I click on Register Link
    And I Verify Register text

  @smoke @regression
  Scenario Outline: Verify That First Name LastName Email Password And Confirm Password Fields Are Mandatory
    Given I am on homepage
    When I click on Register Link
    Then I click on REGISTER button
    And I verify the error message "<errorMessage>"
    And I verify the error message "<errorMessage>"
    And I verify the error message "<errorMessage>"
    And I verify the error message "<errorMessage>"
    And I verify the error message "<errorMessage>"
    Examples:
      | errorMessage            |
      | First name is required. |
      | Last name is required.  |
      | Email is required.      |
      | Password is required.   |
      | Password is required.   |

  @regression
  Scenario: Verify That User Should Create Account Successfully
    Given I am on homepage
    When I click on Register Link
    And I select gender "Female"
    And I enter firstname
    And I enter lastname
    And I select Date of Birth
    And I enter email "ras17@gmail.com"
    And I enter password "abc123"
    And I enter Confirm Password "abc123"
    Then I click on REGISTER button
    And I verify message "Your registration completed"