package WEaretests.web;

import WEaretests.core.WEAreBaseWebTest;
import com.WEАre.pages.CreateNewPost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static testframework.DriverManager.driver;
import org.junit.jupiter.api.Assertions;

public class CreateNewPostTest extends WEAreBaseWebTest {

    private CreateNewPost createNewPostPage;

    @BeforeEach
    @Override
    public void beforeTests() {
        super.beforeTests();
        authenticateWithUser();  // Log in before running the test
        createNewPostPage = new CreateNewPost(driver);
    }

    @Test
    public void testCreateNewPost() {
        // Create a new post
        createNewPostPage.createNewPost();

        // Add a wait to ensure the post is created and the page reloads
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement postConfirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(text(), 'Post created successfully')]")));  // Update the XPath based on your app's message

        // Assert that the post creation confirmation message is visible
        Assertions.assertTrue(postConfirmationMessage.isDisplayed(), "Post creation confirmation message is not displayed.");

        // Optionally, you can verify the newly created post appears in the posts feed
        WebElement newlyCreatedPost = driver.findElement(By.xpath("//div[@class='post-title'][normalize-space()]"));
        Assertions.assertNotNull(newlyCreatedPost, "Newly created post is not displayed in the feed.");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
