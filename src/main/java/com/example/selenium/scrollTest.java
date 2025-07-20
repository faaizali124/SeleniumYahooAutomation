package com.example.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class scrollTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.amazon.in");
        driver.manage().window().maximize();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollHeight);");
        Thread.sleep(2000);
        driver.quit();
    }
    }


