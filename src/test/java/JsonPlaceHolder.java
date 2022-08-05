import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.deSerialization.WebAutomation;

import java.util.List;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolder {
    @Test
    public void crud() {
        RestAssured.baseURI = "http://localhost:3000";

//        Get posts
//        String res = given().log().all()
//                .when().get("/posts")
//                .then().log().all().assertThat().statusCode(200)
//                .extract().response().asString();
//
//        JsonPath jsonPath = new JsonPath(res);
//        int size = jsonPath.get("object.size()");
//        System.out.println(size);
//        Assert.assertEquals(size, 100);

//      Post
//        String uid = "108";
        String Id = "108";

        given().log().all()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"userId\": 11,\n" +
                        "    \"id\": " + Id + ",\n" +
                        "    \"title\": \"Pakistan \",\n" +
                        "    \"body\": \"happy  day\"\n" +
                        "}")
                .when().post("/posts")
                .then()
                .log().all().extract().response().asString();

//        Get
        String res = given().log().all()
                .when().get("/posts")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();


//        Update (PUT)

        given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", Id)
                .body("{\n" +
                        "    \"title\": \"quas fugiat ut perspiciatis vero provident\",\n" +
                        "    \"body\": \"eum non blanditiis soluta porro quibusdam voluptas\\nvel voluptatem qui placeat dolores qui velit aut\\nvel inventore aut cumque culpa explicabo aliquid at\\nperspiciatis est et voluptatem dignissimos dolor itaque sit nam\"\n" +
                        "  }")
                .when().put("/posts/{id}")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();

//        Delete
        given().log().all()
                .header("Content-Type", "application/json")
                .pathParam("id", Id)
                .when().delete("/posts/{id}")
                .then().log().all()
                .assertThat().statusCode(200)
                .extract().response();
    }
}
