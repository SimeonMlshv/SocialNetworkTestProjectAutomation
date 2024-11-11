package WEaretests.web;

import WEaretests.core.WEAreBaseWebTest;
import com.WEАre.pages.LatestPostsPage;
import jdk.jfr.Label;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static testframework.DriverManager.driver;

public class LatestPostsTests extends WEAreBaseWebTest {
    private final By dislikePostButtonLocator = By.xpath("//input[@id='submit-val69']");
    private LatestPostsPage latestPostsPage;

    @BeforeEach
    @Override
    public void beforeTests() {
        super.beforeTests();
        authenticateWithUser();
        // Instantiate the main navigation page with the custom Driver instance
        latestPostsPage = new LatestPostsPage(driver);
    }
    @Test
    @Label("JIRA SNT-20")
    public void LikeDislikePost() {
        latestPostsPage.clickLikeDislikePostButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dislikeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@id='submit-val69']")));
        // Assert that the button is displayed
        Assertions.assertTrue(dislikeButton.isDisplayed(), "Dislike button is not displayed");
        // Assert that total likes is now 1
        WebElement likeCountElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id='like-count69']")));
        // Get the like count as text
        String likeCountText = likeCountElement.getText();
        // Assert that the like count is now 1
        Assertions.assertEquals("Likes: 2", likeCountText,
                "The like count should be 2 after liking the comment.");
        // Assert that the button's value is "Dislike"
        String buttonText = dislikeButton.getAttribute("value");
        Assertions.assertEquals("Dislike", buttonText, "Button does not show 'Dislike'");
        // If all assertions pass, print a success message
        System.out.println("The post has been liked successfully.");
        System.out.println("The post now has 2 likes.");

        WebElement dislikePostButton = driver().findElement(dislikePostButtonLocator);
        dislikePostButton.click();
    }
    @Test
    @Label("JIRA SNT-22")
    public void writeCommentToExistingPost() {
        latestPostsPage.commentOnExistingPost();

    }
}
