package com.nopcommerce.demo.cucumber.steps;

import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ComputerSteps {
    @When("^I click on Computer tab$")
    public void iClickOnComputerTab() {
        new HomePage().clickOnMenuTab("Computers");
    }

    @Then("^I verify \"([^\"]*)\" text$")
    public void iVerifyText(String errorMessage) {
        Assert.assertEquals("Error message not displayed", errorMessage, new ComputerPage().getPageTitleText());

    }

    @When("^I click on Desktops link$")
    public void iClickOnDesktopsLink() {
        new ComputerPage().clickOnSubMenu("Desktops");
    }

    @Then("^I click on product name \"([^\"]*)\"$")
    public void iClickOnProductName(String productName) {
        new DesktopsPage().selectProduct(productName);
    }

    @Then("^I select processor \"([^\"]*)\"$")
    public void iSelectProcessor(String processorName) {
        new BuildYourOwnComputerPage().selectProcessor(processorName);
    }

    @And("^I select RAM \"([^\"]*)\"$")
    public void iSelectRAM(String  ramGB){
        new BuildYourOwnComputerPage().selectRam(ramGB);
    }

    @And("^I select HDD \"([^\"]*)\"$")
    public void iSelectHDD(String hDdGB) {
        new BuildYourOwnComputerPage().selectHDD(hDdGB);

    }

    @And("^I select OS \"([^\"]*)\"$")
    public void iSelectOS(String oSName) {
        new BuildYourOwnComputerPage().selectOS(oSName);
    }

    @And("^I select Software \"([^\"]*)\"$")
    public void iSelectSoftware(String softwareName) {
        new BuildYourOwnComputerPage().selectSoftware(softwareName);
    }

    @And("^I click on \"([^\"]*)\" Button$")
    public void iClickOnButton(String addToCart) {
        new BuildYourOwnComputerPage().clickOnAddToCartButton();
    }

    @And("^I verify the message \"([^\"]*)\"$")
    public void iVerifyTheMessage(String verifyProductMessage) {
        Assert.assertEquals("Product cart message not dispaly", "The product has been added to your shopping cart", new BuildYourOwnComputerPage().getProductAddedMessage());

    }
}
