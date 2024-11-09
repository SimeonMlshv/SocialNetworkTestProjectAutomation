package com.WEАre.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WEAreLoginPage extends WEAreBasePage {

    public WEAreLoginPage() {
        super("/");
    }

    // Locators
    private final By signInButtonLocator = By.xpath("//*[@id=\"ftco-nav\"]/ul/li[2]/a");
    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By loginButtonLocator = By.xpath("/html/body/section[1]/div/div/div[2]/form/input[3]");

    // Actions
    public void submitLoginForm(String username, String pass) {
        WebElement signInButton = driver().findElement(signInButtonLocator);
        signInButton.click();

        WebElement usernameInput = driver().findElement(usernameLocator);
        usernameInput.sendKeys(username);

        WebElement password = driver().findElement(passwordLocator);
        password.sendKeys(pass);

        WebElement loginButton = driver().findElement(loginButtonLocator);
        loginButton.click();
    }
}
