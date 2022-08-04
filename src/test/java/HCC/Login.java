package HCC;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Login {
    @Test
    public void login() throws IOException {

        RestAssured.baseURI = "https://qa-hcc.mynisum.com/api/v1";

        String res = given().log().all()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .body(new String(Files.readAllBytes(Paths.get("src/test/java/HCC/loginCredential.json"))))
                .when().post("/auth/login")
                .then().log().all()
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(res);
        String accessToken = jsonPath.get("objectData.accessToken");
        System.out.println(accessToken);

        String dashboard = given().log().all()
                .relaxedHTTPSValidation()
                .header("Authorization", "Bearer " + accessToken)
                .when().get("/ess/dashboard/profile")
                .then().log().all()
                .extract().response().asString();

        String departments = given().log().all()
                .relaxedHTTPSValidation()
                .header("Authorization", "Bearer " + accessToken)
                .when().get("/general/departments")
                .then().log().all()
                .extract().response().asString();

        String userInfo = given().log().all()
                .relaxedHTTPSValidation()
                .header("Authorization", "Bearer " + accessToken)
                .when().get("/auth/userInfo")
                .then().log().all()
                .extract().response().asString();
    }
}
