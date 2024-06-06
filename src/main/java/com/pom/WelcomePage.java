package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;

public class WelcomePage extends TestBase {
    private WebDriver driver;

    // Locators for existing elements
    @FindBy(id = "home")
    private WebElement homeButton;

    @FindBy(id = "services")
    private WebElement servicesButton;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(id = "createAccount")
    private WebElement createAccountButton;

    @FindBy(id = "aboutUs")
    private WebElement aboutUsButton;

    @FindBy(id = "referAndEarn")
    private WebElement referAndEarnButton;

    @FindBy(id = "jobs")
    private WebElement jobsButton;

    @FindBy(id = "placement")
    private WebElement placementButton;

    @FindBy(id = "facebook")
    private WebElement facebookButton;

    @FindBy(id = "twitter")
    private WebElement twitterButton;

    @FindBy(id = "instagram")
    private WebElement instagramButton;

    @FindBy(id = "hireFromUs")
    private WebElement hireFromUsButton;

    @FindBy(id = "reviews")
    private WebElement reviewsButton;

    @FindBy(id = "companyLocation")
    private WebElement companyLocationButton;

    @FindBy(id = "privacyPolicy")
    private WebElement privacyPolicyButton;

    @FindBy(id = "termsAndConditions")
    private WebElement termsAndConditionsButton;

    @FindBy(id = "events")
    private WebElement eventsButton;

    @FindBy(id = "contactUs")
    private WebElement contactUsButton;

    // Locators for new elements
    @FindBy(id = "slideBar")
    private WebElement slideBar;  // Update the selector as per your actual HTML

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;  // Update the selector as per your actual HTML

    @FindBy(id = "techBrilanceLogo")
    private WebElement techBrilanceLogo;  // Update the selector as per your actual HTML

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Methods for existing elements
    public void clickHome() {
        homeButton.click();
    }

    public void clickServices() {
        servicesButton.click();
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void clickCreateAccount() {
        createAccountButton.click();
    }

    public void clickAboutUs() {
        aboutUsButton.click();
    }

    public void clickReferAndEarn() {
        referAndEarnButton.click();
    }

    public void clickJobs() {
        jobsButton.click();
    }

    public void clickPlacement() {
        placementButton.click();
    }

    public void clickFacebook() {
        facebookButton.click();
    }

    public void clickTwitter() {
        twitterButton.click();
    }

    public void clickInstagram() {
        instagramButton.click();
    }

    public void clickHireFromUs() {
        hireFromUsButton.click();
    }

    public void clickReviews() {
        reviewsButton.click();
    }

    public void clickCompanyLocation() {
        companyLocationButton.click();
    }

    public void clickPrivacyPolicy() {
        privacyPolicyButton.click();
    }

    public void clickTermsAndConditions() {
        termsAndConditionsButton.click();
    }

    public void clickEvents() {
        eventsButton.click();
    }

    public void clickContactUs() {
        contactUsButton.click();
    }

    // Methods for new elements
    public void clickSlideBar() {
        slideBar.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public boolean isLogoDisplayed() {
        return techBrilanceLogo.isDisplayed();
    }
}
