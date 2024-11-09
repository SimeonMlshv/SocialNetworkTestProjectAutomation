package WEaretests.web;

import WEaretests.core.WEAreBaseWebTest;
import WEaretests.enums.WEAreTestData;
import jdk.jfr.Label;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static testframework.DriverManager.driver;

public class WEAreLoginTests extends WEAreBaseWebTest {

    @Test
    @Label("SNT-16")
    public void userAuthenticated_when_validCredentialsProvided(){
        // Navigate to Login Page
        loginPage.navigate();
        // Submit login form
        loginPage.submitLoginForm(
                WEAreTestData.STANDARD_USER_USERNAME.getValue(),
                WEAreTestData.STANDARD_USER_PASSWORD.getValue()
        );
        // Assert expected page navigated TODO
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[normalize-space()='LOGOUT']")));

        if (logoutButton.isDisplayed()) {
            System.out.println("Logout button is visible after login");
        }
        Assertions.assertTrue(logoutButton.isDisplayed(), "Expected the logout button to be displayed, but it is not.");
    }
}
