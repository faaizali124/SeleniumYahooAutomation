package com.example.selenium.YahooTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class LoggedInPage extends BasePage {

    private final By mailButton = By.id("ybarMailLink");

    public LoggedInPage(WebDriver driver) {
        super(driver);
    }

    public void clickMailButton()
    {
    WebElement mailBtn = wait.until(ExpectedConditions.elementToBeClickable(mailButton));
    mailBtn.click();
    }

    public void switchContext()
    {
        switchToNewPage(driver, null);
    }

}
