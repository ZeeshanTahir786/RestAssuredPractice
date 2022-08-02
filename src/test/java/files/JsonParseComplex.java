package files;

import io.restassured.path.json.JsonPath;
import org.testng.Assert;

public class JsonParseComplex {
    /* 1. Print No of courses returned by API

2.Print Purchase Amount

3. Print Title of the first course

4. Print All course titles and their respective Prices

5. Print no of copies sold by RPA Course

6. Verify if Sum of all Course prices matches with Purchase Amount */
    public static void main(String[] arg) {
        JsonPath jsonPath = new JsonPath(Payload.coursePrice());
//        Print No of courses returned by API
        int coursesSize = jsonPath.getInt("courses.size()");
        System.out.println(coursesSize);
//        Print Purchase Amount
        int purchaseAmount = jsonPath.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

//        Print Title of the first course
        String firstTitle = jsonPath.get("courses[0].title");
        System.out.println(firstTitle);

//        Print All course titles and their respective Prices
//        for (int i = 0; i < coursesSize; i++) {
//            String title = jsonPath.get("courses[" + i + "].title");
//            System.out.println(title);
//            System.out.println(jsonPath.get("courses[" + i + "].price").toString());
//        }
//        Print All course titles and their respective Prices
        for (int i = 0; i < coursesSize; i++) {
            String title = jsonPath.get("courses[" + i + "].title");
            if (title.equalsIgnoreCase("RPA")) {
                int copies = jsonPath.get("courses[" + i + "].copies");
                System.out.println("PRA sold " + copies + " copies");
                break;
            }
        }

//        Verify if Sum of all Course prices matches with Purchase Amount
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
}
