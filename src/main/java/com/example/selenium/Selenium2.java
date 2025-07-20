package com.example.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Selenium2 {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://www.yahoo.com");
        driver.manage().window().maximize();

        // Step 1: Search for "donald trump"
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#ybar-sbq")));
        searchBox.sendKeys("donald trump");
        driver.findElement(By.id("ybar-search")).click();

        // Step 2: Wait for "Images" link to appear
        Thread.sleep(3000);  // Let Yahoo load everything
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 300);");  // Bring "Images" into view

        WebElement imagesLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Images']")));
        imagesLink.click();

        // Step 3: Wait for images to load
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("img.s-img")));
        List<WebElement> images = driver.findElements(By.cssSelector("img.s-img"));

        if (!images.isEmpty()) {
            images.get(0).click();
            System.out.println("Clicked first image.");
        } else {
            System.out.println("No images found.");
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
