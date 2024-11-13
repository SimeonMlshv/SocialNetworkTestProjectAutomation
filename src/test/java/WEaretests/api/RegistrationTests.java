package WEaretests.api;

import WEaretests.api.BaseTestSetup;
import com.WEАre.Utils.TestDataGenerator;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RegistrationTests extends BaseTestSetup {

    @Test
    public void registrationTest() {
        // Generate random user data
        String randomUsername = TestDataGenerator.generateUniqueUsername();
        String randomEmail = TestDataGenerator.generateRandomEmail();
        String randomPassword = TestDataGenerator.generateRandomPassword();

        String registrationPayload = "{\n" +
                "    \"username\": \"" + randomUsername + "\",\n" +
                "    \"email\": \"" + randomEmail + "\",\n" +
                "    \"password\": \"" + randomPassword + "\",\n" +
                "    \"confirmPassword\": \"" + randomPassword + "\",\n" +
                "    \"category\": { \"id\": 157 },\n" +
                "    \"authorities\": [\"ROLE_USER\"]\n" +
                "}";

        // Perform user registration
        Response response = given()
                .header("Content-Type", "application/json")
                .body(registrationPayload)
                .when()
                .post("/api/users/")  // Replace with your actual registration endpoint
                .then()
                .statusCode(200) // Expected status code for successful registration
                .extract().response();

        String sessionCookie = response.getCookie("JSESSIONID");
        System.out.println("Session Cookie: " + sessionCookie);

        // Store the session cookie in the System or a global variable if needed
        // (Not recommended to store it globally unless it's part of a shared class in real-world scenarios)
    }
}
