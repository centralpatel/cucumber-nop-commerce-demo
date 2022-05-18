package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends Utility {
    private static final Logger log = LogManager.getLogger(HomePage.class.getName());

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement logo;

    @CacheLookup
    @FindBy(xpath = "//a[@class='ico-account']")
    WebElement myAccountLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logOutLink;
    @CacheLookup
    @FindBy(xpath = "//div[@class='header-menu']/child::ul[1]/li/a")
    List<WebElement> topMenuList;

    public void clickOnLoginLink() {
        log.info("Clicking on login link " + loginLink.getText() + "<br>");
        clickOnElement(loginLink);
    }


    public void clickOnRegisterLink() {
        clickOnElement(registerLink);
        log.info("Clicking on register link : " + registerLink.toString());
    }

    public void clickOnMyAccountLink() {
        clickOnElement(myAccountLink);
       log.info("Clicking on myAccountLink : " + myAccountLink.toString());

    }

    public HomePage clickOnLogOutLink() {
       log.info("Clicking on logOutLink : " + logOutLink.toString());
        clickOnElement(logOutLink);
        return new HomePage();
    }

    public boolean isLogOutLinkDisplay() {
        boolean b = logOutLink.isDisplayed();
       log.info("Checking is logOutLink displayed : " + logOutLink.toString());
        return b;
    }

    public boolean isLogoDisplayed() {
        boolean b = logo.isDisplayed();
       log.info("Checking logo is Displayed <br>");
        return b;
    }

    public void clickOnMenuTab(String tab) {
        for (WebElement menu : topMenuList) {
            if (menu.getText().contains(tab)) {
                clickOnElement(menu);
                break;
            }
        }
    }

}
