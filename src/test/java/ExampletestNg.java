import files.Payload;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ExampletestNg {

    @Test
    public void verifyAmount() {
        JsonPath jsonPath = new JsonPath(Payload.coursePrice());
        int coursesSize = jsonPath.getInt("courses.size()");
        int sum = 0;
        for (int i = 0; i < coursesSize; i++) {
            int price = jsonPath.get("courses[" + i + "].price");
            int copies = jsonPath.get("courses[" + i + "].copies");
            int ammount = price * copies;
            sum = sum + ammount;
        }
        System.out.println(sum);
        int purchaseAmount1 = jsonPath.get("dashboard.purchaseAmount");
        Assert.assertEquals(sum, purchaseAmount1);
    }

    @Test(dataProvider = "setNameAddress")
    public void postAddress(String address, String name) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";
        // Post
        String response = given().log().all().queryParam("key", "qaclick123")
                .header("Content-Type", "application/json")
                .body(Payload.addPlace(address, name)).when().post("/maps/api/place/add/json")
                .then().assertThat().statusCode(200)
                .body("scope", equalTo("APP"))
                .header("Server", equalTo("Apache/2.4.41 (Ubuntu)"))
                .extract().response().asString();
        System.out.println("response " + response);

        JsonPath jsonPath = new JsonPath(response);
        String PlaceId = jsonPath.getString("place_id");
        System.out.println("PlaceId " + PlaceId);
    }

    @DataProvider(name = "setNameAddress")
    public Object[][] getData() {
        return new Object[][]{{"29, side layout, Pakistan", "Jon Doe"}, {"Nisum", "Hafiz"}, {"Lahore", "Zeeshan"}};
    }
}
