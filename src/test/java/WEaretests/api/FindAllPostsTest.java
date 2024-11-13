package WEaretests.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FindAllPostsTest extends BaseTestSetup {

    @Test
    public void findAllPostsTest() {
        Response response = given()
                .header("Accept", "*/*")
                .when()
                .get("/api/post/")
                .then()
                .statusCode(200)
                .extract()
                .response();

        response.then().body("$", is(not(empty())));

        response.then().body("each { it.containsKey('postId') }", is(true));
        response.then().body("each { it.containsKey('content') }", is(true));
        response.then().body("each { it.containsKey('picture') }", is(true));
        response.then().body("each { it.containsKey('date') }", is(true));
        response.then().body("each { it.containsKey('likes') }", is(true));
        response.then().body("each { it.containsKey('comments') }", is(true));
        response.then().body("each { it.containsKey('rank') }", is(true));
        response.then().body("each { it.containsKey('liked') }", is(true));
        response.then().body("each { it.containsKey('public') }", is(true));
        response.then().body("each { it.containsKey('category') }", is(true));

        System.out.println("Response Body: " + response.body().asString());
    }
}

