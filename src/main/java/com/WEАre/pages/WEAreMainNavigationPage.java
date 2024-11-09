package com.WEАre.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import testframework.Driver;

public class WEAreMainNavigationPage extends WEAreBasePage {
    private final Driver driver;  // Custom Driver instance

    // Locators
    private final By addNewPostButtonLocator = By.xpath("//*[@id=\"ftco-nav\"]/ul/li[8]/a");
    private final By messageFieldLocator = By.id("message");
    private final By savePostButtonLocator = By.xpath("/html/body/section[1]/div/div/div/div/ul/div/form/div[3]/input");

    // Constructor that accepts custom Driver instance
    public WEAreMainNavigationPage(Driver driver) {
        super("/");  // Calls the constructor of WEAreBasePage with the page URL
        this.driver = driver;  // Assign the passed custom Driver to the class-level variable
    }

    // Method to submit a message to a new post
    public void submitMessageToANewPost(String message) {
        try {
            // Find and click the "Add New Post" button
            WebElement addNewPostButton = driver.findElement(addNewPostButtonLocator);
            addNewPostButton.click();

            // Find and fill in the message field
            WebElement messageField = driver.findElement(messageFieldLocator);
            messageField.sendKeys(message);

            // Find and click the "Save Post" button
            WebElement savePostButton = driver.findElement(savePostButtonLocator);
            savePostButton.click();
        } catch (NoSuchElementException e) {
            // Log the error if any element is not found
            System.err.println("An element was not found during submitting the new post: " + e.getMessage());
        }
    }

    // Method to find an element by the given message
    public WebElement findElementByMessage(String message) {
        try {
            // Locate an element that contains the exact text of the message
            return driver.findElement(By.xpath("//*[contains(text(), '" + message + "')]"));
        } catch (NoSuchElementException e) {
            // Return null or handle exception if no element is found
            System.err.println("Could not find an element with the message: " + message);
            return null;
        }
    }
}
