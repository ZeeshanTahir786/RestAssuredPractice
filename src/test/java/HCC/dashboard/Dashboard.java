package HCC.dashboard;

import static io.restassured.RestAssured.given;

public class Dashboard {

    public static void getDashboard(String accessToken){

        DashboardResponse dashboard = given().log().all()
                .relaxedHTTPSValidation()
                .header("Authorization", "Bearer " + accessToken)
                .when().get("/ess/dashboard/profile")
                .then().log().all()
                .extract().response().as(DashboardResponse.class);
        System.out.println(dashboard.getDescription());
    }
}
