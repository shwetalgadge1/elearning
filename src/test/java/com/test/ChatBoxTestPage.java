package com.test;

import com.Base.TestBase;
import com.pom.ChatboxPage;
import com.pom.LoginPage;
import com.pom.UserDashboardPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChatBoxTestPage extends TestBase {
    private ChatboxPage chatboxPage;
    private UserDashboardPage userDashboardPage;

    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setup method from TestBase
        driver.get("https://www.elearningplatform.com"); // replace with actual URL

        // Login to access user dashboard
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsUser("user@example.com", "password"); // replace with actual login details

        userDashboardPage = new UserDashboardPage(driver);
        Assert.assertTrue(userDashboardPage.isWelcomeMessageDisplayed());

        chatboxPage = new ChatboxPage(driver);
    }

    @Test
    public void testSendMessage() {
        chatboxPage.openChatbox();
        String testMessage = "Hello, this is a test message!";
        chatboxPage.sendMessage(testMessage);

        Assert.assertTrue(chatboxPage.isMessageDisplayed(testMessage), "Test message was not displayed in the chatbox.");
    }
}
