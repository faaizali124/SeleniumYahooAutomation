package com.example.selenium.YahooTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

import java.time.Duration;

public abstract class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    List<String> handles = new ArrayList<String>();

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(180));
}
    
    protected void scrollBy(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public void switchToNewPage(WebDriver driver, List<String> handles) {
        for (String handle : driver.getWindowHandles()) {
            if(!handles.contains(handle)) {
                driver.switchTo().window(handle);
                System.out.println(driver.getTitle());
            }
        }
    }
}


