package WEaretests.api;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RegistrationTests.class,
        LoginTest.class,
        PostCreationTest.class,
        EditPostTest.class,
        FindAllPostsTest.class
})
public class ApiTestSuite {
}
