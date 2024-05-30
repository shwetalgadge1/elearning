package com.test;

import com.Base.TestBase;


	

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import com.pom.AdminPage;
	import io.github.bonigarcia.wdm.WebDriverManager;

	
		public class AdminPageTest extends TestBase{

	    public AdminPageTest(WebDriver driver2) {
				super(driver2);
				// TODO Auto-generated constructor stub
			}

		private WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	    }

	    @Test
	    public void testAdminLogin() {
	        driver.get("https://example.com/admin");

	        AdminPage adminPage = new AdminPage(driver);
	        adminPage.login("admin_username", "admin_password");

	        Assert.assertTrue(adminPage.isDashboardDisplayed(), "Login failed");
	    }

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


