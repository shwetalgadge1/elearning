package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Base.TestBase;
import com.pom.WelcomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WelcomePageTest extends TestBase {

    private WelcomePage homePage;

    public WelcomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        navigateToHomePage("https://yourwebsite.com");
        homePage = new WelcomePage(driver);
    }

    private void navigateToHomePage(String string) {
		// TODO Auto-generated method stub
		
	}

	@Test
    public void testClickHome() {
        homePage.clickHome();
        assertEquals("https://yourwebsite.com/home", driver.getCurrentUrl());
    }

    @Test
    public void testClickServices() {
        homePage.clickServices();
        assertEquals("https://yourwebsite.com/services", driver.getCurrentUrl());
    }

    @Test
    public void testClickLogin() {
        homePage.clickLogin();
        assertEquals("https://yourwebsite.com/login", driver.getCurrentUrl());
    }

    @Test
    public void testClickCreateAccount() {
        homePage.clickCreateAccount();
        assertEquals("https://yourwebsite.com/create-account", driver.getCurrentUrl());
    }

    @Test
    public void testClickAboutUs() {
        homePage.clickAboutUs();
        assertEquals("https://yourwebsite.com/about-us", driver.getCurrentUrl());
    }

    @Test
    public void testClickReferAndEarn() {
        homePage.clickReferAndEarn();
        assertEquals("https://yourwebsite.com/refer-and-earn", driver.getCurrentUrl());
    }

    @Test
    public void testClickJobs() {
        homePage.clickJobs();
        assertEquals("https://yourwebsite.com/jobs", driver.getCurrentUrl());
    }

    @Test
    public void testClickPlacement() {
        homePage.clickPlacement();
        assertEquals("https://yourwebsite.com/placement", driver.getCurrentUrl());
    }

    @Test
    public void testClickFacebook() {
        homePage.clickFacebook();
        assertEquals("https://www.facebook.com/yourpage", driver.getCurrentUrl());
    }

    @Test
    public void testClickTwitter() {
        homePage.clickTwitter();
        assertEquals("https://www.twitter.com/yourpage", driver.getCurrentUrl());
    }

    @Test
    public void testClickInstagram() {
        homePage.clickInstagram();
        assertEquals("https://www.instagram.com/yourpage", driver.getCurrentUrl());
    }

    @Test
    public void testClickHireFromUs() {
        homePage.clickHireFromUs();
        assertEquals("https://yourwebsite.com/hire-from-us", driver.getCurrentUrl());
    }

    @Test
    public void testClickReviews() {
        homePage.clickReviews();
        assertEquals("https://yourwebsite.com/reviews", driver.getCurrentUrl());
    }

    @Test
    public void testClickCompanyLocation() {
        homePage.clickCompanyLocation();
        assertEquals("https://yourwebsite.com/company-location", driver.getCurrentUrl());
    }

    @Test
    public void testClickPrivacyPolicy() {
        homePage.clickPrivacyPolicy();
        assertEquals("https://yourwebsite.com/privacy-policy", driver.getCurrentUrl());
    }

    @Test
    public void testClickTermsAndConditions() {
        homePage.clickTermsAndConditions();
        assertEquals("https://yourwebsite.com/terms-and-conditions", driver.getCurrentUrl());
    }

    @Test
    public void testClickEvents() {
        homePage.clickEvents();
        assertEquals("https://yourwebsite.com/events", driver.getCurrentUrl());
    }

    @Test
    public void testClickContactUs() {
        homePage.clickContactUs();
        assertEquals("https://yourwebsite.com/contact-us", driver.getCurrentUrl());
    }

    // Add tests for the new elements
    @Test
    public void testClickSlideBar() {
        homePage.clickSlideBar();
        // Add assertion to verify the slide bar functionality if applicable
        // For now, you might not have any URL change to assert
        assertTrue(homePage.isLogoDisplayed(), "Slide bar clicked and logo is displayed.");
    }

    @Test
    public void testClickLogoutButton() {
        homePage.clickLogoutButton();
        // Add assertion to verify the logout functionality, e.g., redirected to login page
        assertEquals("https://yourwebsite.com/login", driver.getCurrentUrl());
    }

    @Test
    public void testTechBrilanceLogoDisplayed() {
        assertTrue(homePage.isLogoDisplayed(), "TechBrilance logo should be displayed");
    }

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

    private void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
