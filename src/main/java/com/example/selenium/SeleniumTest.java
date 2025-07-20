package com.example.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        //System.out.println(driver.getPageSource());
        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Poco F1");
        //driver.findElement(By.id("nav-search-submit-button")).click();
        //Thread.sleep(2000);

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
//        WebElement link = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("About Our Ads")));
//        wait.until(ExpectedConditions.elementToBeClickable(link)).click();
//        Thread.sleep(2000);
//        driver.navigate().to("https://www.google.com");
//        Thread.sleep(2000);
//        driver.navigate().back();

        //driver.findElement(By.cssSelector("#ybar-sbq")).sendKeys("donald trump");
        //driver.findElement(By.cssSelector(".rapid-noclick-resp._yb_xm1rg8 ")).click();
        //wait.until(ExpectedConditions.elementToBeClickable(By.linkText("News"))).click();
        //driver.findElement(By.cssSelector("#web > ol > li:nth-child(3) >  div > ul > li:nth-child(1) > a")).click();

        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("donald trump");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight);");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='btnK']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//form[@id='captcha-form']")))).submit();
        Thread.sleep(10000);
        driver.quit();
    }
}


