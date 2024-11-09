package WEaretests.web;

import WEaretests.core.WEAreBaseWebTest;
import WEaretests.enums.WEAreTestData;
import com.WEАre.pages.WEAreMainNavigationPage;
import jdk.jfr.Label;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static testframework.DriverManager.driver;

public class WEAreMainNavigationTests extends WEAreBaseWebTest {

    private WEAreMainNavigationPage mainNavigationPage;

    @BeforeEach
    @Override
    public void beforeTests() {
        super.beforeTests();
        authenticateWithUser();
        // Instantiate the main navigation page with the custom Driver instance
        mainNavigationPage = new WEAreMainNavigationPage(driver);
    }

    @Test
    @Label("Jira SNT-19")
    public void createNewPost() {
        // Use the Main Navigation Page to create a new post
        // Unique message
        String message = WEAreTestData.NEW_POST_MESSAGE.getValue() + " - " + System.currentTimeMillis() / (1000 * 60);
        mainNavigationPage.submitMessageToANewPost(message);

        // Wait until the new post is visible using custom Driver's wait
        driver.getDriverWait().until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//*[contains(text(), '" + message + "')])[last()]")
        ));

        // Find the element containing the newly created post message
        WebElement newPostElement = mainNavigationPage.findElementByMessage(message);
        // Add an assertion to verify post creation
        assertNotNull(newPostElement, "The new post element should not be null.");
        assertEquals(message, newPostElement.getText(), "The post message should match the expected value.");
        System.out.println("New post created successfully with message: " + message);
    }
}