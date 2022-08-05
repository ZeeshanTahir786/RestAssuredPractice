package pojo.serialization;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.List;

public class Base {
    public static void main(String[] arg) {
        RestAssured.baseURI = "https://rahulshettyacademy.com";

        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress("29, side layout, Nisum Lahore");
        addPlace.setLanguage("English");
        addPlace.setName("Frontline house");
        addPlace.setPhone_number("(+92) 320 893 3937");
        addPlace.setWebsite("http://google.com");
//
        List<String> myListTypes = new ArrayList<String>();
        myListTypes.add("shoe park");
        myListTypes.add("shop");
        addPlace.setTypes(myListTypes);
//
        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        addPlace.setLocation(location);

        given().log().all()
                .queryParam("key","qaclick123")
                .body(addPlace)
                .when().post("/maps/api/place/add/json")
                .then().log().all()
                .extract().response().asString();

    }
}
