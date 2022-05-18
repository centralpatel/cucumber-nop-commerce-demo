Feature: ComputerPageTest
  As a user I want to buy computer

  @smoke @sanity @regression
  Scenario: Verify User Should Navigate To Computer Page Successfully
    Given I am on homepage
    When I click on Computer tab
    Then I verify "Computers" text

  @smoke @regression
  Scenario: Verify User Should Navigate To Desktops Page Successfully
    Given I am on homepage
    Given I click on Computer tab
    When I click on Desktops link
    Then I verify "Desktops" text

  @regression
  Scenario Outline: Verify That User Should Build You Own Computer And Add Them To Cart Successfully
    Given I am on homepage
    Given I click on Computer tab
    When I click on Desktops link
    Then I click on product name "Build your own computer"
    Then I select processor "<processor>"
    And I select RAM "<ram>"
    And I select HDD "<hdd>"
    And I select OS "<os>"
    And I select Software "<software>"
    And I click on "ADD TO CART" Button
    And I verify the message "The product has been added to your shopping cart"
    Examples:
      | processor                                       | ram           | hdd               | os                      | software                   |
      | 2.2 GHz Intel Pentium Dual-Core E2200           | 2 GB          | 320 GB            | Vista Home [+$50.00]    | Microsoft Office [+$50.00] |
      | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 4GB [+$20.00] | 400 GB [+$100.00] | Vista Premium [+$60.00] | Acrobat Reader [+$10.00]   |
      | 2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00] | 8GB [+$60.00] | 320 GB            | Vista Home [+$50.00]    | Total Commander [+$5.00]   |