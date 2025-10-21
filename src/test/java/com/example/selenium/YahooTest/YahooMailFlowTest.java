package com.example.selenium.YahooTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class YahooMailFlowTest extends BaseUiTest {

    @Test
    @DisplayName("Login and send an email from Yahoo Mail")
    void loginAndSendEmail() throws InterruptedException
    {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.SignIn();

        UsernamePage usernamePage = new UsernamePage(driver);
        usernamePage.enterEmail("faaizali133");

        PasswordPage passwordPage = new PasswordPage(driver);
        passwordPage.enterPassword("YahooPlease1.");

        LoggedInPage loggedInPage = new LoggedInPage(driver);
        loggedInPage.clickMailButton();

        InboxPage inboxPage = new InboxPage(driver);
        inboxPage.switchToInboxTab();
        inboxPage.sendEmail("faaizali124@gmail.com", "test email", "this is a test email");
        assertTrue(driver.getTitle().contains("Mail"), "Failed to open Yahoo Mail page");
        
    }

}
