package com.example.selenium.YahooTest;

import org.openqa.selenium.*;

public class MainPage extends BasePage {

    private static final String LOGIN_URL = "https://www.yahoo.com";

    private final By signInButton = By.linkText("Sign in");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(LOGIN_URL);
        driver.manage().window().maximize();
        handles.add(driver.getWindowHandle());
    }

    public void SignIn() throws InterruptedException {
        driver.findElement(signInButton).click();
        Thread.sleep(2000);
    }
}
