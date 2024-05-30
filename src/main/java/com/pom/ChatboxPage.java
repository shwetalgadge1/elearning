package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.TestBase;

public class ChatboxPage extends TestBase {
    private WebDriver driver;

    // Using @FindBy annotation for web elements
    @FindBy(id = "chatbox-toggle")
    private WebElement chatboxToggle;

    @FindBy(id = "chat-input")
    private WebElement chatInputField;

    @FindBy(id = "send-button")
    private WebElement sendButton;

    @FindBy(id = "chat-messages")
    private WebElement chatMessages;

    public ChatboxPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openChatbox() {
        chatboxToggle.click();
    }

    public void sendMessage(String message) {
        chatInputField.sendKeys(message);
        sendButton.click();
    }

    public boolean isMessageDisplayed(String message) {
        return chatMessages.getText().contains(message);
    }
}
