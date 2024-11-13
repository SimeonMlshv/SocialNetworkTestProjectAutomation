package WEaretests.api;

import com.WEАre.Utils.LoginHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostCreationTest extends BaseTestSetup {

    @Test
    public void createPostTest() {
        String username = "randomUsername";
        String password = "randomPassword";
        String sessionCookie = LoginHelper.login(username, password);

        // Define the body of the POST request
        String requestBody = "{\n" +
                "  \"content\": \"{{$randomStreetAddress}}\",\n" +
                "  \"picture\": \"<string>\",\n" +
                "  \"public\": \"true\"\n" +
                "}";

        Response response = given()
                .cookie("JSESSIONID", sessionCookie)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/api/post/auth/creator")
                .then()
                .statusCode(200)
                .body("postId", notNullValue())
                .extract()
                .response();


        String postId = response.jsonPath().getString("postId");
        System.out.println("Created Post ID: " + postId);
    }
}
