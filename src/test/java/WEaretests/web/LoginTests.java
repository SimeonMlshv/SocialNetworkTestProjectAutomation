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

public class LoginTests extends WEAreBaseWebTest {

    @Test
    @Label("JIRA SNT-16")
    public void userAuthenticated_when_validCredentialsProvided(){
        // Submit login form
        loginPage.submitLoginForm(
                WEAreTestData.STANDARD_USER_USERNAME.getValue(),
                WEAreTestData.STANDARD_USER_PASSWORD.getValue()
        );

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[normalize-space()='LOGOUT']")));

        if (logoutButton.isDisplayed()) {
            System.out.println("Logout button is visible after login.");
        }
        Assertions.assertTrue(logoutButton.isDisplayed(),
                "Expected the logout button to be displayed, but it is not.");
    }

    @Test
    @Label("JIRA SNT-21")
    public void register_newUser_when_validCredentialsProvided(){
        loginPage.createNewUser();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/div[1]/div[2]/div/div/h1")));
        Assertions.assertTrue(successMessage.isDisplayed(), "Registration success message is not displayed.");
        Assertions.assertEquals("Welcome to our community.", successMessage.getText(),
                "Success message text does not match.");
    }
}
