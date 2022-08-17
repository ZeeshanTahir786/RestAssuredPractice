package HCC.login;

import HCC.dashboard.Dashboard;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;


public class Login {
    @Test
    public void login() throws IOException {

        RestAssured.baseURI = "https://qa-hcc.mynisum.com/api/v1";

        AddLoginBody addLoginBody = new AddLoginBody();
        addLoginBody.setUsername("anaeem@nisum.com");
        addLoginBody.setPassword("nisum123");

        LoginResponse res = given().log().all()
                .relaxedHTTPSValidation()
                .header("Content-Type", "application/json")
                .body(addLoginBody)
                .when().post("/auth/login")
                .then().log().all()
                .assertThat().statusCode(200)
                .header("Content-Type", "application/json")
                .header("Connection", "keep-alive")
                .extract().response().as(LoginResponse.class);


        System.out.println(res.getObjectData().getAccessToken());
        String accessToken = res.getObjectData().getAccessToken();
        int employeeId = res.getObjectData().getEmployeeId();

        Dashboard.getDashboard(accessToken);

//        String departments = given().log().all()
//                .relaxedHTTPSValidation()
//                .header("Authorization", "Bearer " + accessToken)
//                .when().get("/general/departments")
//                .then().log().all()
//                .extract().response().asString();
//
//        String userInfo = given().log().all()
//                .relaxedHTTPSValidation()
//                .header("Authorization", "Bearer " + accessToken)
//                .when().get("/auth/userInfo")
//                .then().log().all()
//                .extract().response().asString();
    }
}
