package WEaretests.core;

import WEaretests.enums.WEAreTestData;
import com.WEАre.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import testframework.PropertiesManager;
import testframework.core.BaseWebTest;

public class WEAreBaseWebTest extends BaseWebTest {

    protected LoginPage loginPage;

    @BeforeEach
    public void beforeTests() {
        // perform some code before each test starts
        loginPage = new LoginPage();
        // Navigate to base page
        driver().get(PropertiesManager.getConfigProperties().getProperty("WEAreBaseUrl"));

    }
    public void authenticateWithUser() {
        // Retrieve username and password from the enum
        String username = WEAreTestData.STANDARD_USER_USERNAME.getValue();
        String password = WEAreTestData.STANDARD_USER_PASSWORD.getValue();

        // Perform the login
        LoginPage loginPage = new LoginPage();
        loginPage.submitLoginForm(username, password);
    }
}
