
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;


public class GoRestApi {
    @Test
    public void crud() throws IOException {
        RestAssured.baseURI = "https://reqres.in/api";

        given().log().all()
                .when().get("/users")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract()
                .response().asString();
//        POST

        String res = given().log().all()
                .body("{\n" +
                        "    \"name\": \"jskjs\",\n" +
                        "    \"job\": \"hafz\"\n" +
                        "}")
                .when().post("/users")
                .then().log().all()
                .assertThat().statusCode(201)
                .extract().response().asString();

        JsonPath jsonPath = new JsonPath(res);

        String id = jsonPath.get("id");
        System.out.println(id);

//        PUT

        given().log().all()
                .body("{\n" +
                        "    \"name\": \"Saleem\",\n" +
                        "    \"job\": \"hafiz\"\n" +
                        "}")
                .when().put("/users/" + id + "")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response().asString();

//        given().log().all()
//                .when().get("/users/" + id + "")
//                .then().log().all()
//                .assertThat().statusCode(200)
//                .extract()
//                .response().asString();
//      Delete

        given().log().all()
                .when().delete("/users/" + id + "")
                .then().log().all()
                .assertThat().statusCode(204)
                .extract().response().asString();
    }
}
