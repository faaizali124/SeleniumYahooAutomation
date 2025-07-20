package com.example.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class MiniProject {

    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        WebDriver driver = new ChromeDriver(options);
        List<String> handles = new ArrayList<String>();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.yahoo.com");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());

        handles.add(driver.getWindowHandle());

        //search input
        driver.findElement(By.xpath("//input[@id='ybar-sbq']")).sendKeys("donald trump");
        Thread.sleep(2000);
        //search button
        driver.findElement(By.xpath("//button[@id = 'ybar-search']")).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        switchToNewPage(driver, handles);
        handles.add(driver.getWindowHandle());

        //click Images tab
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ac-refresh-black-blue-imp fz-20 lh-m fw-l ls-027']"))).click();
        Thread.sleep(2000);

        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        switchToNewPage(driver, handles);
        handles.add(driver.getWindowHandle());

        //click the first Image
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src = 'https://tse4.mm.bing.net/th/id/OIP.B63o7mIMw2J_YdeqmAQpbAHaJS?pid=Api&P=0&h=220']/ancestor::a"))).click();
        Thread.sleep(10000);

        String imageTitle = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@id='resitem-0']"))).getText();

        //print the title of the image
        System.out.println(imageTitle);


        driver.quit();
    }

    public static void switchToNewPage(WebDriver driver, List<String> handles) {
        for (String handle : driver.getWindowHandles()) {
            if(!handles.contains(handle)) {
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
            }
        }
    }
}
