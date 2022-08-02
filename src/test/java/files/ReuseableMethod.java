package files;

import io.restassured.path.json.JsonPath;

public class ReuseableMethod {
    public static JsonPath rawToJson(String res) {
        JsonPath jsonPath = new JsonPath(res);
        return jsonPath;
    }
}
