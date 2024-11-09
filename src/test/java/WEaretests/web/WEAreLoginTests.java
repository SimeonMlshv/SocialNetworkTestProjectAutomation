package WEaretests.web;

import WEaretests.core.WEAreBaseWebTest;
import WEaretests.enums.WEAreTestData;
import org.junit.jupiter.api.Test;

public class WEAreLoginTests extends WEAreBaseWebTest {

    @Test
    public void userAuthenticated_when_validCredentialsProvided(){
        // Navigate to Login Page
        loginPage.navigate();

        // Submit login form
        loginPage.submitLoginForm(
                WEAreTestData.STANDARD_USER_USERNAME.getValue(),
                WEAreTestData.STANDARD_USER_PASSWORD.getValue()
        );
        // Assert expected page navigated
    }
}
