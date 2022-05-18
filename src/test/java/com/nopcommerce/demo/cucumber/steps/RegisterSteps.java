package com.nopcommerce.demo.cucumber.steps;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RegisterSteps {
    @When("^I click on Register Link$")
    public void iClickOnRegisterLink() {
        new HomePage().clickOnRegisterLink();
    }

    @And("^I Verify Register text$")
    public void iVerifyRegisterText() {
        String expectedMessage = "Register";
        String actualMessage =   new RegisterPage().getRegisterText();
        Assert.assertEquals("message not displayed",expectedMessage, actualMessage);
        new RegisterPage().getRegisterText();
    }

    @Then("^I click on REGISTER button$")
    public void iClickOnREGISTERButton() {
        new RegisterPage().clickOnRegisterButton();
    }

    @And("^I verify the error message \"([^\"]*)\"$")
    public void iVerifyTheErrorMessage(String errorMessage ) {
        new RegisterPage().getValidationErrorMessageForField(errorMessage);
    }

    @And("^I select gender \"([^\"]*)\"$")
    public void iSelectGender(String gender)  {
       new RegisterPage().selectGender("Female");
    }

    @And("^I enter firstname$")
    public void iEnterFirstname() {
        new RegisterPage().enterFirstName("Nehal");
    }

    @And("^I enter lastname$")
    public void iEnterLastname() {
        new RegisterPage().enterLastName("Patel");
    }

    @And("^I select Date of Birth$")
    public void iSelectDay() {
        new RegisterPage().selectDateOfBirth("5", "June", "1985");
    }

    @And("^I enter Confirm Password \"([^\"]*)\"$")
    public void iEnterConfirmPassword(String confPassword) {
        new RegisterPage().enterConfirmPassword(confPassword);
    }

    @And("^I verify message \"([^\"]*)\"$")
    public void iVerifyMessage(String getYourRegCompletedText) {
        new RegisterPage().getYourRegCompletedText();
    }



}
