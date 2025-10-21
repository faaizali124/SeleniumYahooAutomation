package com.example.selenium.YahooTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UsernamePage extends BasePage {

    private final By emailField = By.id("login-username");
    private final By signInButton = By.id("login-signin");

    public UsernamePage(WebDriver driver) {
        super(driver);
    }


    public void enterEmail(String email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(emailField));
        emailInput.clear();
        emailInput.sendKeys(email);
        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        nextBtn.click();
}
}
