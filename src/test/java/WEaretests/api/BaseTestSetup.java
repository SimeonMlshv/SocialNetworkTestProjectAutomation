package WEaretests.api;

import com.WEАre.Utils.LoginHelper;
import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class BaseTestSetup {

    @BeforeClass
    public static void setupClass() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;

    }
}
