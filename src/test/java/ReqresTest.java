import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ReqresTest {

    @Test
    @Description("Description bla")
    @Severity(SeverityLevel.CRITICAL)
    public void getUsersTest(){
        List<UserData> users = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .when().get("/api/users").then()
                .log().all().statusCode(200).extract().body().jsonPath().getList("data",UserData.class);

        Assert.assertEquals(users.size(), 6);
    }

    @Test
    @Description("Description FAILED")
    @Severity(SeverityLevel.MINOR)
    public void getUsersFailTest(){
        List<UserData> users = given()
                .baseUri("https://reqres.in")
                .contentType(ContentType.JSON)
                .when().get("/api/users").then()
                .log().all().statusCode(200).extract().body().jsonPath().getList("data",UserData.class);

        Assert.assertEquals(users.size(), 7);
    }
}
