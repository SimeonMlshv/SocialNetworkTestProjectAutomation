package WEaretests.api;

import com.WEАre.Utils.LoginHelper;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseTestSetup {

    public static String sessionCookie;

    private static final String RANDOM_USERNAME = "generatedUsername"; // Replace with actual random username or generated data
    private static final String USER_PASSWORD = "generatedPassword"; // Replace with actual random password or generated data

    @Test
    public void loginTest() {
        sessionCookie = LoginHelper.login(RANDOM_USERNAME, USER_PASSWORD);

        System.out.println("Session Cookie: " + sessionCookie);
        assertThat(sessionCookie, notNullValue());
        assertThat(sessionCookie, not(emptyString()));
    }
}