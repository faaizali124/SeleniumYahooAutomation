package com.example.selenium.YahooTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class InboxPage extends BasePage {

    private final By composeBtn = By.cssSelector("[data-test-id='left-rail-Compose-icon']");
    private final By toField = By.id("message-to-field");
    private final By subjectField = By.id("compose-subject-input");
    private final By messageField = By.cssSelector("div[data-test-id='rte']");
    private final By sendButton = By.cssSelector("button[data-test-id='compose-send-button']");

    public InboxPage(WebDriver driver)
    {
        super(driver);
    }
    public void switchToInboxTab()
    {
        switchToNewPage(driver, handles);
    }

    public void sendEmail(String to, String subject, String message) throws InterruptedException
    {
        WebElement clickButton = wait.until(ExpectedConditions.elementToBeClickable(composeBtn));
        clickButton.click();

        WebElement inputTo = wait.until(ExpectedConditions.presenceOfElementLocated(toField));
        inputTo.sendKeys(to);

        driver.findElement(subjectField).sendKeys(subject);
        driver.findElement(messageField).sendKeys(message);
        Thread.sleep(2000);
        driver.findElement(sendButton).click();
    }
        
}
