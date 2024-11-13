package WEaretests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class EditPostTest extends BaseTestSetup {

    private String postId = "12345";

    @Test
    public void editPostTest() {
        String requestBody = "{\n" +
                "  \"content\": \"Updated content\",\n" +
                "  \"picture\": \"UpdatedPicture\",\n" +
                "  \"public\": \"true\"\n" +
                "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .queryParam("postId", postId)
                .when()
                .put("/api/post/auth/editor")
                .then()
                .statusCode(200)
                .extract()
                .response();

        response.then().statusCode(200);
        response.then().body("content", equalTo("Updated content"));
        response.then().body("picture", equalTo("UpdatedPicture"));
        response.then().body("public", equalTo("true"));

        System.out.println("Response Body: " + response.body().asString());
    }
}
