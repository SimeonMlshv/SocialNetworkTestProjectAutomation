package WEaretests.api;

import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PostCreationTest extends BaseTestSetup {

    private static String sessionCookie;

    @Before
    public void setUp() {
        // Retrieve session cookie from SessionManager (ensures synchronization with login test)
        sessionCookie = LoginTest.sessionCookie;

        System.out.println("Session Cookie: " + sessionCookie);
        assertThat(sessionCookie, notNullValue());
        assertThat(sessionCookie, not(emptyString()));
    }

    @Test
    public void createPostTest() {
        // Create request body for the post
        String requestBody = "{\n" +
                "  \"content\": \"Random content\",\n" +
                "  \"picture\": \"string\",\n" +
                "  \"public\": \"true\"\n" +
                "}";

        // Send POST request to create a new post with the session cookie
        Response response = given()
                .cookie("JSESSIONID", sessionCookie)
                .header("Content-Type", "application/json")
                .header("Accept", "*/*")
                .body(requestBody)
                .when()
                .post("/api/post/auth/creator")
                .then()
                .log().ifError()
                .statusCode(200)
                .body("postId", notNullValue())
                .extract()
                .response();

        // Extract and print the postId from the response
        String postId = response.jsonPath().getString("postId");
        assertThat(postId, notNullValue());
        assertThat(postId, not(emptyString()));
        System.out.println("Created Post ID: " + postId);
    }
}
