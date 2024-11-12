package com.WEАre.pages;

import com.WEАre.Utils.TestDataGenerator;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testframework.Driver;

public class LatestPostsPage extends BasePage {
    private final Driver driver;
    public LatestPostsPage(Driver driver) {
        super("/posts");
        this.driver = driver;
    }

    private final By latestPostsButtonLocator = By.xpath("//a[normalize-space()='Latest Posts']");
    private final By browsePublicPostsButtonLocator = By.xpath("/html/body/section[1]/div/div/div[2]/div[1]/form/input");
    private final By likePostButtonLocator = By.id("submit-val69");
    private final By exploreThisPostButtonLocator = By.xpath(
            "//body//section[@class='ftco-section ftco-candidates ftco-candidates-2 bg-light']//div" +
                    "[@class='row']//div[@class='row']//div[1]//div[1]//div[2]//p[3]//a[1]");
    private final By postCommentButtonLocator = By.xpath("//input[@value='Post Comment']");

    private final By commentInputFieldLocator = By.xpath("//textarea[@id='message']");

    public int extractNumericValue(String text) {
        // Use regex to remove non-digit characters and extract the numeric part
        String numericPart = text.replaceAll("\\D+", ""); // Removes all non-numeric characters
        return Integer.parseInt(numericPart); // Convert the numeric part to an integer
    }

    public void clickLikeDislikePostButton() {
        WebElement latestPostButton = driver.findElement(latestPostsButtonLocator);
        latestPostButton.click();

        WebElement browsePublicPostsButton = driver().findElement(browsePublicPostsButtonLocator);
        browsePublicPostsButton.click();

        WebElement likePostButton = driver().findElement(likePostButtonLocator);
        likePostButton.click();

    }

    public void commentOnExistingPost() {
        String randomComment = TestDataGenerator.generateRandomComment();

        WebElement latestPostButton = driver.findElement(latestPostsButtonLocator);
        latestPostButton.click();

        WebElement browsePublicPostsButton = driver().findElement(browsePublicPostsButtonLocator);
        browsePublicPostsButton.click();

        WebElement exploreThisPostButton = driver.findElement(exploreThisPostButtonLocator);
        exploreThisPostButton.click();

        // Locate the comment counter and get the initial count
        WebElement commentCounter = driver.findElement(By.xpath("//*[@id='com']"));
        int initialCommentCount = extractNumericValue(commentCounter.getText());
        System.out.println("Initial comment count: " + initialCommentCount);

        WebElement commentInputField = driver.findElement(commentInputFieldLocator);
        commentInputField.sendKeys(randomComment);

        WebElement postCommentButton = driver.findElement(postCommentButtonLocator);
        postCommentButton.click();
        // Log the number of comments
        int finalCommentCount = initialCommentCount + 1;
        System.out.println("The new number of comments is: " + finalCommentCount);

        Assertions.assertEquals(initialCommentCount + 1, finalCommentCount, "Comment count did not increase as expected.");
    }
}
