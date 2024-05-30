package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.Base.TestBase;

public class HomePage extends TestBase {

    // Define elements using @FindBy annotation
    @FindBy(linkText = "Home")
    private WebElement homeLink;

    @FindBy(linkText = "Services")
    private WebElement servicesLink;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(linkText = "Create Account")
    private WebElement createAccountLink;

    @FindBy(linkText = "About Us")
    private WebElement aboutUsLink;

    @FindBy(linkText = "Refer and Earn")
    private WebElement referAndEarnLink;

    @FindBy(linkText = "Jobs")
    private WebElement jobsLink;

    @FindBy(linkText = "Placement")
    private WebElement placementLink;

    @FindBy(linkText = "Facebook")
    private WebElement facebookLink;

    @FindBy(linkText = "Twitter")
    private WebElement twitterLink;

    @FindBy(linkText = "Instagram")
    private WebElement instagramLink;

    @FindBy(linkText = "Hire from Us")
    private WebElement hireFromUsLink;

    @FindBy(linkText = "Reviews")
    private WebElement reviewsLink;

    @FindBy(linkText = "Company Location")
    private WebElement companyLocationLink;

    @FindBy(linkText = "Privacy Policy")
    private WebElement privacyPolicyLink;

    @FindBy(linkText = "Terms and Conditions")
    private WebElement termsAndConditionsLink;

    @FindBy(linkText = "Events")
    private WebElement eventsLink;

    @FindBy(linkText = "Contact Us")
    private WebElement contactUsLink;

    // Constructor to initialize elements
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Methods to interact with elements
    public void clickHome() {
        homeLink.click();
    }

    public void clickServices() {
        servicesLink.click();
    }

    public void clickLogin() {
        loginLink.click();
    }

    public void clickCreateAccount() {
        createAccountLink.click();
    }

    public void clickAboutUs() {
        aboutUsLink.click();
    }

    public void clickReferAndEarn() {
        referAndEarnLink.click();
    }

    public void clickJobs() {
        jobsLink.click();
    }

    public void clickPlacement() {
        placementLink.click();
    }

    public void clickFacebook() {
        facebookLink.click();
    }

    public void clickTwitter() {
        twitterLink.click();
    }

    public void clickInstagram() {
        instagramLink.click();
    }

    public void clickHireFromUs() {
        hireFromUsLink.click();
    }

    public void clickReviews() {
        reviewsLink.click();
    }

    public void clickCompanyLocation() {
        companyLocationLink.click();
    }

    public void clickPrivacyPolicy() {
        privacyPolicyLink.click();
    }

    public void clickTermsAndConditions() {
        termsAndConditionsLink.click();
    }

    public void clickEvents() {
        eventsLink.click();
    }

    public void clickContactUs() {
        contactUsLink.click();
    }
}
