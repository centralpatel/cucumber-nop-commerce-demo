package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(css = ".ico-logout")
    WebElement logOutLink;

//    @FindBy(xpath = "//a[contains(text(),'Log out')]")
//    WebElement logOutLink;


    public String getWelcomeText() {
        String message = getTextFromElement(welcomeText);
        log.info("Getting text from : " + welcomeText.toString());
        return message;
    }

    public void enterEmailId(String email) {
        sendTextToElement(emailField, email);
        log.info("Sending text to email field : " + emailField.toString());
    }

    public void enterPassword(String password) {
        sendTextToElement(passwordField, password);
        log.info("Sending text to password field : " + passwordField.toString());
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
        log.info("Clicking on login link : " + loginButton.toString());
    }

    public String getErrorMessage() {
        String message = getTextFromElement(errorMessage);
        log.info("Getting text from : " + errorMessage.toString());
        return message;
    }

    public void loginToApplication(String email, String password) {
        enterEmailId(email);
        enterPassword(password);
        clickOnLoginButton();
        log.info("Getting text from : " + errorMessage.toString());
    }
//    public String verifySignOutLink(){
//        log.info("verify sign Out Link "+ logOutLink.toString());
//        verifyThatElementIsDisplayed(logOutLink);
//        return getTextFromElement(logOutLink);
//    }

    public boolean verifySignOutLink () {
        log.info("Check log out link is displayed : " + logOutLink.toString());
        return logOutLink.isDisplayed();
    }
}
