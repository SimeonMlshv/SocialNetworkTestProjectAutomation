package com.WEАre.pages;

import com.WEАre.Utils.TestDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testframework.Driver;

public class CreateNewPost extends BasePage {
    private final Driver driver;

    private final By createPostButtonLocator = By.xpath("//a[normalize-space()='Create Post']");
    private final By postTitleFieldLocator = By.xpath("//input[@name='post_title']");
    private final By postBodyFieldLocator = By.xpath("//textarea[@name='post_body']");
    private final By submitPostButtonLocator = By.xpath("//button[@type='submit'][normalize-space()='Submit Post']");
    private final By postConfirmationMessageLocator = By.xpath("//div[@class='confirmation-message']");
    private final By newlyCreatedPostLocator = By.xpath("//div[@class='post-title'][normalize-space()]"); // This is an example XPath for the newly created post title

    public CreateNewPost(Driver driver) {
        super("/create-post");
        this.driver = driver;
    }

    public void createNewPost() {
        String randomTitle = TestDataGenerator.generateRandomTitle();
        String randomBody = TestDataGenerator.generateRandomBody();

        WebElement createPostButton = driver.findElement(createPostButtonLocator);
        createPostButton.click();

        WebElement postTitleField = driver.findElement(postTitleFieldLocator);
        postTitleField.sendKeys(randomTitle);

        WebElement postBodyField = driver.findElement(postBodyFieldLocator);
        postBodyField.sendKeys(randomBody);

        WebElement submitPostButton = driver.findElement(submitPostButtonLocator);
        submitPostButton.click();

        WebElement confirmationMessage = driver.findElement(postConfirmationMessageLocator);
        Assertions.assertTrue(confirmationMessage.isDisplayed(), "Post creation failed.");

        System.out.println("Post created successfully: " + randomTitle);

        WebElement newlyCreatedPost = driver.findElement(newlyCreatedPostLocator);
        Assertions.assertEquals(randomTitle, newlyCreatedPost.getText(), "Newly created post title does not match.");
        System.out.println("The post with title \"" + randomTitle + "\" has been created successfully.");
    }
}
