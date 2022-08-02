import files.Payload;
import files.ReuseableMethod;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Basic {

    public static void main(String[] arg) {
        // given - All input details
        // when - Submit the API
        // then - validate response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        // Post
//        String response = given().log().all().queryParam("key", "qaclick123")
//                .header("Content-Type", "application/json")
//                .body(Payload.addPlace("29, side layout, Pakistan")).when().post("/maps/api/place/add/json")
//                .then().assertThat().statusCode(200)
//                .body("scope", equalTo("APP"))
//                .header("Server", equalTo("Apache/2.4.41 (Ubuntu)"))
//                .extract().response().asString();
//        System.out.println("response " + response);
//
//        JsonPath jsonPath = new JsonPath(response);
//        String PlaceId = jsonPath.getString("place_id");
//        System.out.println("PlaceId " + PlaceId);
//      Update - Put
//        String address = "Nisum Lahore, Pakistan";
//        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
//                .body("{\n" +
//                        "\"place_id\":\"" + PlaceId + "\",\n" +
//                        "\"address\":\"" + address + "\",\n" +
//                        "\"key\":\"qaclick123\"\n" +
//                        "}")
//                .when().put("maps/api/place/update/json")
//                .then().assertThat().statusCode(200).log().all()
//                .body("msg", equalTo("Address successfully updated"));
//      Get Place
//        String getPlaceRes = given().log().all()
//                .queryParam("key", "qaclick123")
//                .queryParam("place_id", PlaceId)
//                .when().get("maps/api/place/get/json")
//                .then().assertThat().statusCode(200).log().all()
//                .extract().response().asString();
//        JsonPath jsonPath1 = ReuseableMethod.rawToJson(getPlaceRes);
//        String actualResult = jsonPath1.getString("address");
//        System.out.println(actualResult);
//        Assert.assertEquals(address, actualResult);
    }
}
