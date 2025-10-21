package com.example.selenium.YahooTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswordPage extends BasePage {

    private final By passwordField = By.id("login-passwd");
    private final By signInButton = By.id("login-signin");

    public PasswordPage(WebDriver driver) {
        super(driver);
    }

    public void enterPassword(String password) {
        WebElement passInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passInput.clear();
        passInput.sendKeys(password);
        WebElement signIn = wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signIn.click();
    }
}
