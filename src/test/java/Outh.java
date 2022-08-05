
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import pojo.deSerialization.Api;
import pojo.deSerialization.GetCourse;
import pojo.deSerialization.WebAutomation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Outh {

    public static void main(String[] arg) throws InterruptedException {
        String[] expectedWebCourses = {"Selenium Webdriver Java", "Cypress", "Protractor"};

//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=733802194440-7jv6iec4ou126q6mkp4kuncoimblggqf.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
//        driver.findElement(By.cssSelector("input[type='email']")).sendKeys("zeeshantahir881@gmail.com");
//        driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
//        Thread.sleep(3000);
//
//        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("090078601");
//        driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
//        Thread.sleep(3000);

        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AdQt8qhCxH1-IlEY6FvDhv5blpAsYDvKCFMOkzPV0s-7LbsNi2v36aEgw00iQ8jtAicfrQ&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=0&prompt=none";//        String url = driver.getCurrentUrl();
        String partialCode = url.split("code=")[1];
        String code = partialCode.split("&scope")[0];
        System.out.println(code);


        String accessTokenString = given().urlEncodingEnabled(false)
                .queryParam("code", code)
                .queryParam("client_id", "733802194440-vdtr6ue1bap29d9gchd4i4cobuineg14.apps.googleusercontent.com")
                .queryParam("client_secret", "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")
                .queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .queryParam("grant_type", "authorization_code")
                .queryParam("response_type", "code")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath jsonPath = new JsonPath(accessTokenString);
        String accessToken = jsonPath.getString("access_token");
        System.out.println(accessToken);


        GetCourse res = given().queryParam("access_token", accessToken)
                .expect().defaultParser(Parser.JSON)
                .when()
                .get("https://rahulshettyacademy.com/getCourse.php")
                .as(GetCourse.class);

//        Deserialization

        System.out.println(res.getLinkedIn());
        System.out.println(res.getInstructor());
        System.out.println(res.getCourses().getWebAutomation().get(1).getCourseTitle());
        List<WebAutomation> webCourses = res.getCourses().getWebAutomation();

//      Get the course price of webcourse whose title is Cypress
        for (int i = 0; i < webCourses.size(); i++) {
            if (webCourses.get(i).getCourseTitle().equalsIgnoreCase("Cypress")) {
                System.out.println(webCourses.get(i).getPrice());
            }
        }
//      Compare actual result vs expected result of course title of web courses
        ArrayList<String> actualResult = new ArrayList<String>();
        for (int i = 0; i < webCourses.size(); i++) {
            actualResult.add(webCourses.get(i).getCourseTitle());
        }
        List<String> expectedWebCoursesList = Arrays.asList(expectedWebCourses);

        Assert.assertEquals(expectedWebCoursesList, actualResult);

//        Get course titles of api courses
        List<Api> apiCourses = res.getCourses().getApi();
        for (int i = 0; i < apiCourses.size(); i++) {
            System.out.println(apiCourses.get(i).getCourseTitle());
        }

    }
}
