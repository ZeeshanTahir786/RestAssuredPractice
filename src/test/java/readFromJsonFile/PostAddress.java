package readFromJsonFile;

import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostAddress {
    @Test
    public void postAdd() throws IOException {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        // Post
        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(new String(Files.readAllBytes(Paths.get("src/test/java/readFromJsonFile/addPlace.json")))).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", equalTo("Apache/2.4.41 (Ubuntu)"))
                .extract().response().asString();
        System.out.println("response " + response);

        JsonPath jsonPath = new JsonPath(response);
        String PlaceId = jsonPath.getString("place_id");
        System.out.println("PlaceId " + PlaceId);
    }
}


