package com.WEАre.pages;

import com.WEАre.Utils.TestDataGenerator;
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
    private final By registerButtonLocator = By.xpath(
            "//li[@class='nav-item cta mr-md-1']//a[@class='nav-link'][normalize-space()='REGISTER']");
    private final By usernameInputLocator = By.xpath("//input[@id='name']");
    private final By passwordInputLocator = By.xpath("//input[@id='password']");
    private final By emailInputLocator = By.xpath("//input[@id='email']");
    private final By confirmPasswordInputLocator = By.xpath("//input[@id='confirm']");
    private final By submitRegisterButtonLocator = By.xpath("//input[@value='Register']");

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

    public void createNewUser() {
        String uniqueUsername = TestDataGenerator.generateUniqueUsername();

        WebElement registerButton = driver().findElement(registerButtonLocator);
        registerButton.click();

        WebElement usernameInput = driver().findElement(usernameInputLocator);
        usernameInput.sendKeys(uniqueUsername);
        WebElement emailInput = driver().findElement(emailInputLocator);
        emailInput.sendKeys("simeonmiloshov@gmail.com");
        WebElement passwordInput = driver().findElement(passwordInputLocator);
        passwordInput.sendKeys("Test123456");
        WebElement repeatPasswordInput = driver().findElement(confirmPasswordInputLocator);
        repeatPasswordInput.sendKeys("Test123456");
        WebElement submitRegisterButton = driver().findElement(submitRegisterButtonLocator);
        submitRegisterButton.click();
        System.out.println("User registered successfully with username: " + uniqueUsername + " and password: " + "Test123456");
    }
}
