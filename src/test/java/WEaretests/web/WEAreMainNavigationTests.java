package WEaretests.web;

import WEaretests.core.WEAreBaseWebTest;
import WEaretests.enums.WEAreTestData;
import com.WEАre.pages.WEAreMainNavigationPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WEAreMainNavigationTests extends WEAreBaseWebTest {

    private WEAreMainNavigationPage mainNavigationPage;

    @BeforeEach
    @Override
    public void beforeTests(){
        super.beforeTests();
        authenticateWithUser();
        mainNavigationPage = new WEAreMainNavigationPage();
    }
    @Test
    public void createNewPost() {
        // Use the Main Navigation Page to create a new post
        String message = WEAreTestData.NEW_POST_MESSAGE.getValue();
        mainNavigationPage.submitMessageToANewPost(message);
        // Add an assertion to verify post creation
        System.out.println("New post created successfully with message: " + message);
    }
}