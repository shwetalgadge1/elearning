package com.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import com.Base.TestBase;
import com.pom.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.assertEquals;

public class HomePageTest extends TestBase {

    private HomePage homePage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        navigateToHomePage("https://yourwebsite.com");
        homePage = new HomePage(driver);
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

    @AfterMethod
    public void tearDown() {
        quitDriver();
    }

	private void quitDriver() {
		// TODO Auto-generated method stub
		
	}
}
