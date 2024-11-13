package WEaretests.api;

import io.restassured.RestAssured;
import org.junit.Before;

public class BaseTestSetup {

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8081;
    }
}
