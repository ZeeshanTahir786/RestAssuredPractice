
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.Matchers.*;

public class Outh {
    public static void main(String[] arg) throws InterruptedException {

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

        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AdQt8qij1R149xIQ2Smnq0FeTP03Trxei9R_kTzjsWK8_tw-txCPf5J2sib0aB2bSEn7Hw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=3&prompt=consent";
//        String url = driver.getCurrentUrl();
        String partialCode = url.split("code=")[1];
        String code = partialCode.split("&scope")[0];
        System.out.println(code);


        String accessTokenString = given().urlEncodingEnabled(false)
                .queryParam("code,", "")
                .queryParam("code", code)
                .queryParam("client_id", "733802194440-7jv6iec4ou126q6mkp4kuncoimblggqf.apps.googleusercontent.com")
                .queryParam("client_secret", "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")
                .queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
                .queryParam("grant_type", "authorization_code")
                .when().log().all()
                .post("https://www.googleapis.com/oauth2/v4/token").asString();

        JsonPath jsonPath = new JsonPath(accessTokenString);
        String accessToken = jsonPath.getString("access_token");
        System.out.println(accessToken);


        String res = given().queryParam("access_token", accessToken)
                .when().log().all()
                .get("https://rahulshettyacademy.com/getCourse.php")
                .asString();
        System.out.println(res);
    }
}
